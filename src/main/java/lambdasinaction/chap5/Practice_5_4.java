package lambdasinaction.chap5;

import org.apache.commons.math3.util.Pair;

import java.util.stream.Stream;

public class Practice_5_4 {
    public static void main(String ... args) {
        // 斐波那契元组序列
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        // 斐波那契元组序列 打印斐波那契数列
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
    }
}
