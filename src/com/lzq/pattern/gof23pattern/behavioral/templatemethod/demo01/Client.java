package com.lzq.pattern.gof23pattern.behavioral.templatemethod.demo01;

public class Client {
    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMethod();

        abc = new ConcreteClassB();
        abc.templateMethod();
    }
    //抽象模板类
    static abstract class AbstractClass{
        protected void step1() {
            System.out.println("AbstractClass:step1");
        }

        public void step2() {
            System.out.println("AbstractClass:step2");
        }

        private void step3() {
            System.out.println("AbstractClass:step3");
        }

        //声明为final类型的方法，避免子类对其覆写
        public final void templateMethod() {
            this.step1();
            this.step2();
            this.step3();
        }
    }

    static class ConcreteClassA extends AbstractClass {

        @Override
        protected void step1() {
            System.out.println("ConcreteClassA:step1");
        }
    }

    static class ConcreteClassB extends AbstractClass {
        @Override
        public void step2() {
            System.out.println("ConcreteClassB:step2");
        }
    }


}
