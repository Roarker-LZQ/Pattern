package com.lzq.pattern.simplefactory.demo01;

import java.util.Objects;

/**
 *简单工厂
 */
public class SimpleFactoryClient01 {
    public static void main(String[] args) {
        //静态方法  使用类直接调用
        IProduct iProduct = SimpleFactory.makeProduct(1);
        if (null!=iProduct) {
            iProduct.doSomething();

        }

        //非静态方法  对象调用
        IProduct iProduct1 = new SimpleFactory().makeProduct01(0);
        if (null != iProduct1) {
            iProduct1.doSomething();

        }

        //Objects.requireNonNull 判断是空 抛出异常
        //静态方法  使用类直接调用
        Objects.requireNonNull(SimpleFactory.makeProduct(6)).doSomething();
        //非静态方法  对象调用
        Objects.requireNonNull(new SimpleFactory().makeProduct01(5)).doSomething();

    }

    /**
     * 抽象产品
     */
    public interface IProduct {
        void doSomething();
    }

    /**
     * 具体产品A
     */
    static class ProductA implements IProduct {
        @Override
        public void doSomething() {
            System.out.println("I am Product A");

        }
    }

    /**
     * 具体产品B
     */
    static class ProductB implements IProduct {
        @Override
        public void doSomething() {
            System.out.println("I am Product B");
        }
    }

    /**
     * 具体产品C
     */
    static class ProductC implements IProduct{
        @Override
        public void doSomething() {
            System.out.println("I am Product C");
        }
    }

    /**
     * 产品类型
     */
    final class ProductType{
        static final int PRODUCT_TYPE_A = 0;
        static final int PRODUCT_TYPE_B = 1;
        static final int PRODUCT_TYPE_C = 3;
    }

    static class SimpleFactory {
        /**
         * 静态方法 类直接调用
         * @param type
         * @return
         */
        public static IProduct makeProduct(int type) {
            return getIProduct(type);
        }

        private static IProduct getIProduct(int type) {
            switch (type) {
                case ProductType.PRODUCT_TYPE_A:
                    return new ProductA();
                case ProductType.PRODUCT_TYPE_B:
                    return new ProductB();
                case ProductType.PRODUCT_TYPE_C:
                    return new ProductC();
                default:
                    return null;
            }
        }

        /**
         * 非静态方法  对象调用
         * @param type
         * @return
         */
        public  IProduct makeProduct01(int type) {
            return getIProduct(type);
        }
    }

}
