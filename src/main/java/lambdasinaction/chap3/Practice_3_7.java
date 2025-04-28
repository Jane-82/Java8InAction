package lambdasinaction.chap3;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 3.6.2 构造函数引用
 */
public class Practice_3_7 {
    public static void main(String[] args) {
        // 零个参数
        zeroMethodReference();

        // 一个参数
        oneMethodReference();

        // 两个参数
        biMethodReference();

        // 三个参数
        triMethodReference();
    }

    /**
     * 零个参数的构造函数转变为构造函数引用
     * 构造函数 Apple()
     * 函数式接口 () -> T
     */
    public static void zeroMethodReference() {
        // 构造函数的方法引用
        Supplier<Apple> c0 = Apple::new;
        Apple apple = c0.get();

        // 等价于
        Supplier<Apple> c0Lambda = () -> new Apple();
        Apple appleLambda = c0Lambda.get();
    }

    /**
     * 一个参数的构造函数转变为构造函数引用
     * 构造函数 Apple(int)
     * 函数式接口 T -> R
     */
    public static void oneMethodReference() {
        // 构造函数的方法引用
        Function<Integer, Apple> c1 = Apple::new;
        Apple apple = c1.apply(110);

        // 等价于
        Function<Integer, Apple> c1Lambda = (weight) -> new Apple(weight);
        Apple appleLambda = c1Lambda.apply(110);
    }

    /**
     * 两个参数的构造函数转变为构造函数引用
     * 构造函数 Apple(int, String)
     * 函数式接口 (T, U) -> R
     */
    public static void biMethodReference() {
        // 构造函数的方法引用
        BiFunction<String, Integer, Apple> c2 = Apple::new;
        Apple apple = c2.apply("green", 110);

        // 等价于
        BiFunction<String, Integer, Apple> c2Lambda =
                (color, weight) -> new Apple(color, weight);
        Apple appleLambda = c2Lambda.apply("green", 110);
    }

    public static class Apple {
        private String color = "";
        private int weight = 0;

        public Apple(){}

        public Apple(int weight){
            this.weight = weight;
        }

        public Apple(String color, int weight){
            this.color = color;
            this.weight = weight;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }


    /**
     * 三个参数的构造函数转变为构造函数引用
     * 构造函数 Color(int, int, int)
     * 函数式接口 (T, U, V) -> R
     */
    public static void triMethodReference() {
        // 构造函数的方法引用
        TriFunction<Integer, Integer, Integer, Color>  c3 = Color::new;
        Color color = c3.apply(1, 2, 3);

        // 等价于
        TriFunction<Integer, Integer, Integer, Color> c3Lambda =
                (red, green, blue) -> new Color(red, green, blue);
        Color colorLambda = c3Lambda.apply(1, 2, 3);
    }

    // 没有三个参数的函数式接口，自己定义
    @FunctionalInterface
    public interface TriFunction<T, U, V, R>{
        // 签名：(T, U, V) -> R
        R apply(T t, U u, V v);
    }

    public static class Color {
        private int red = 0;
        private int green = 0;
        private int blue = 0;

        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }
}
