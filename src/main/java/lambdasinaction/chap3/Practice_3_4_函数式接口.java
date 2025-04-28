package lambdasinaction.chap3;

import java.util.Comparator;
import java.util.function.*;

public class Practice_3_4_函数式接口 {

    public static void main(String[] args) {
        /**
         * 布尔表达式
         * T -> boolean
         * Predicate<T>
         */
        Predicate<Integer> predicate = (Integer w) -> w > 10;

        /**
         * 创建对象
         * () -> T
         * Supplier<T>
         */
        Supplier<Apple> supplier = () -> new Apple(20, "green");

        /**
         * 消费对象
         * T -> void
         * Consumer<T>
         */
        Consumer<Apple> consumer = (Apple a) -> System.out.println(a.getColor());

        /**
         * 从一个对象中选择/提取
         * T -> R
         * Function<T, R> 或 ToIntFunction<T>
         *
         */
        Function<Apple, Integer> function = (Apple a) -> a.getWeight();
        ToIntFunction<String> toIntFunction = (String s) -> s.length();

        /**
         * 合并两个值
         * （T, U) -> R
         * BiFunction<T, U, R> 或 IntBinaryOperator
         */
        BiFunction<String, Integer, Integer> biFunction = (String s, Integer i) -> s.length() + i;
        IntBinaryOperator intBinaryOperator = (int a, int b) -> a + b;

        /**
         * 比较两个对象
         * (T, U) -> int  Comparator<T>
         * (T, U) -> R  BiFunction<T, U, R> 或 ToIntBiFunction<T, U>
         */
        Comparator<Apple> comparator = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Apple, Apple, Boolean> appleBiFunction = (Apple a1, Apple a2) -> a1.getColor().equals(a2.getColor());
        ToIntBiFunction<Apple, Apple> toIntBiFunction = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
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
}
