package com.korgutlova.controller;

import com.korgutlova.model.Chat;
import com.korgutlova.model.Message;
import com.korgutlova.model.User;
import com.korgutlova.service.ChatService;
import com.korgutlova.service.MessageService;
import com.korgutlova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;


@Controller
@RequestMapping(value = "/home")
public class MessageController {
    private final ChatService chatService;
    private final MessageService messageService;
    private final UserService userService;

    @Autowired
    public MessageController(ChatService chatService, MessageService messageService, UserService userService) {
        this.chatService = chatService;
        this.messageService = messageService;
        this.userService = userService;
    }

    @RequestMapping(value = "/messages")
    public String messages(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("chats", chatService.getChats(user));
        model.addAttribute("user", user);
        return "messages";
    }

    @RequestMapping(value = "/message/{chat}")
    public String message(@PathVariable(name = "chat") String chat, Model model) {
        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("messages", messageService.getMessages(chatService.getChat(Long.valueOf(chat))));
        model.addAttribute("chat", chat);
        return "message";
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public RedirectView addMessage(@RequestParam(name = "text") String text,
                                   @RequestParam(name = "chat") String chat) {
        Message message = new Message();
        message.setText(text);
        message.setDate(new Date(System.currentTimeMillis()));
        message.setChat(chatService.getChat(Long.valueOf(chat)));
        message.setSender((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        messageService.addMessage(message);
        return new RedirectView("/home/message/" + chat);
    }

    @RequestMapping(value = "/message/{user_id}", method = RequestMethod.POST)
    public RedirectView getChat(@PathVariable(name = "user_id") String userId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userOpponent = userService.getUser(Long.valueOf(userId));
        Chat chat;
        if (chatService.existsChat(user, userOpponent) == 0){
            chat = new Chat();
            chat.setUserOne(user);
            chat.setUserTwo(userOpponent);
            chatService.addChat(chat);
        }
        chat = chatService.getChat(user, userOpponent);
        String chatId = String.valueOf(chat.getId());
        return new RedirectView("/home/message/" + chatId);
    }
}
