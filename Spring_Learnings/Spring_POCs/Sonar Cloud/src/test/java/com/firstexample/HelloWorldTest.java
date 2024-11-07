package com.firstexample;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void testMain() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        HelloWorld.main(new String[]{});

        assertEquals("Hello, World!\n", outputStream.toString());

        System.setOut(originalOut);
    }

    @Test
    public void testGetGreeting() {
        assertEquals("Hello, World!", HelloWorld.getGreeting());
    }

    @Test
    public void testPrintGreeting() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        HelloWorld.printGreeting();

        assertEquals("Hello, World!\n", outputStream.toString());

        System.setOut(originalOut);
    }
}