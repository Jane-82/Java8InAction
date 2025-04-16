package lambdasinaction.chap2;

import java.util.Arrays;
import java.util.List;

/**
 * 测验2.1：编写灵活的prettyPrintApple方法（所在页码-26）
 */
public class Practice_2_1 {

    public static void main(String ... args) {

        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                new Apple("green", 155),
                new Apple("red", 120));

        // 输出苹果重量
        prettyPrintApple(inventory, new PrintAppleWeight());

        // 输出苹果是否重还是轻
        prettyPrintApple(inventory, new PrintAppleHeavyOrLight());
    }

    /**
     * 方法
     * 多种方式，输出苹果信息
     * @param inventory
     * @param applePredicate 行为参数化
     */
    public static void prettyPrintApple(List<Apple> inventory, ApplePredicate applePredicate) {
        for (Apple apple: inventory) {
            String output = applePredicate.test(apple);
            System.out.println(output);
        }
    }

    /**
     * 实体类
     */
    public static class Apple {
        private String color = "";
        private int weight = 0;

        public Apple(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight){
            this.weight = weight;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    /**
     * 谓词 相当于是实体的“行为”
     * 比如：返回 boolean 值时，用于过滤；返回 String 值时，用于格式化；返回 int 值时，用于计算
     */
    // 使用接口，进行标准建模
    interface ApplePredicate {
        String test(Apple apple);
    }

    // 接口实现
    static class PrintAppleWeight implements ApplePredicate {
        public String test(Apple apple) {
            return "Apple Weight: " + apple.getWeight().toString();
        }
    }

    static class PrintAppleHeavyOrLight implements ApplePredicate {
        public String test(Apple apple) {
            return "Apple is " + ((apple.getWeight() > 150) ? "heavy" : "light");
        }
    }
}
