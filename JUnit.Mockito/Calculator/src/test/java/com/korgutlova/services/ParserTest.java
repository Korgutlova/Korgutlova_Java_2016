package com.korgutlova.services;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class ParserTest {
    private static Parser parser;
    private static final String CORRECT_INPUT = "/calculator/4.2+6.0";
    private static final String INVALID_INPUT = "/calculator/4?+6.0";
    private static final Object [] ARRAY = new Object[]{"4.2", "+", "6.0"};

    @BeforeClass
    public static void setUp(){
        parser = new Parser();
    }

    @Test
    public void parseShouldReturnCorrectArray(){
        Assert.assertTrue(Arrays.equals(ARRAY, parser.parse(CORRECT_INPUT)));
    }

    @Test
    public void parseShouldReturnNull(){
        Assert.assertTrue(Arrays.equals(null, parser.parse(INVALID_INPUT)));
    }
}
