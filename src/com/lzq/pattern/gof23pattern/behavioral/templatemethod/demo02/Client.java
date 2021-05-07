package com.lzq.pattern.gof23pattern.behavioral.templatemethod.demo02;

public class Client {
    public static void main(String[] args) {
        System.out.println("=====Java课程====");
        JavaCourse jc = new JavaCourse();
        jc.setNeedCheckHomework(true);
        jc.createCourse();

        try {
            ClassLoader classLoader = JavaCourse.class.getClassLoader();
            String name = classLoader.getClass().getName();
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("====Python课程====");
        PythonCourse pc = new PythonCourse();
        pc.createCourse();

    }
}
