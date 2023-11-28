package com.examples.input;
public class Test1 {
    void test() {
        try{
            throw new CustomException("This is a custom Exception");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}