package com.korgutlova.helpers;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class HelperRender {
    public static void render(HttpServletRequest request, HttpServletResponse response, String file, HashMap<String, Object> root) throws IOException {
        Template tmpl = Config.getConfig(
                request.getServletContext()
        ).getTemplate(file);
        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}

