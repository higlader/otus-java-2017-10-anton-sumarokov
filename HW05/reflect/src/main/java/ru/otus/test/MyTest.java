package ru.otus.test;

import myframework.annotations.After;
import myframework.annotations.Before;
import myframework.annotations.Test;

public class MyTest {


    @Before
    public void setUp(){
        System.out.println("        @Before: setUp");
    }

    @After
    public void tearDown(){
        System.out.println("        @After: tearDown");
    }

    @Test
    public void mytest(){
        System.out.println("        @Test: mytest");
    }
}
