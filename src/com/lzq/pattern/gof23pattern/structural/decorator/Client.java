package com.lzq.pattern.gof23pattern.structural.decorator;

/**
 * 装饰器设计模式demo
 */
public class Client {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(c);
        concreteDecoratorA.operation();
        System.out.println("==================");
        Decorator concreteDecoratorB = new ConcreteDecoratorB(c);
        concreteDecoratorB.operation();
        System.out.println("=============");
        ConcreteDecoratorB concreteDecoratorB1 = new ConcreteDecoratorB(concreteDecoratorA);
        concreteDecoratorB1.operation();

    }

    //抽象组件
    static abstract class Component {
        public abstract void operation();
    }

    //具体组件
    static class ConcreteComponent extends Component {
        @Override
        public void operation() {
            System.out.println("处理业务逻辑");
        }
    }

    /**
     * 抽象装饰器
     */
    static abstract class Decorator extends Component {
        protected Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            component.operation();
        }
    }

    /**
     * 具体装饰器A
     */
    static class ConcreteDecoratorA extends Decorator {
        public ConcreteDecoratorA(Component component) {
            super(component);
        }

        private void operationFirst() {
            System.out.println("ConcreteDecoratorA operationFirst");
        }
        private void operationLast() {
            System.out.println("ConcreteDecoratorA operationLast");
        }

        @Override
        public void operation() {
            operationFirst();
            super.operation();
            operationLast();
        }
    }

    /**
     * 具体装饰器B
     */
    static class ConcreteDecoratorB extends Decorator {
        public ConcreteDecoratorB(Component component) {
            super(component);
        }

        private void operationFirst() {
            System.out.println("ConcreteDecoratorB operationFirst");
        }
        private void operationLast() {
            System.out.println("ConcreteDecoratorB operationLast");
        }

        @Override
        public void operation() {
            operationFirst();
            super.operation();
            operationLast();
        }
    }


}
