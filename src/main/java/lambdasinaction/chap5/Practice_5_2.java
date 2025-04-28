package lambdasinaction.chap5;

import org.apache.commons.math3.util.Pair;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Practice_5_2 {

    public static void main(String ... args) {
        // （1）给定一个数字列表，返回一个由每个数的平方构成的列表
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> numbersSquare = numbers.stream()
                .map(n -> n * n)
                .collect(toList());

        System.out.println(numbersSquare);


        // （2）给定两个数字列表，返回所有的数对
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);

        // Pair<>
        List<Pair<Integer, Integer>> numPair =
                num1.stream()
                    .flatMap(n -> num2.stream()
                                             .map(m -> new Pair<>(n, m)))
                    .collect(toList());
        // Pair<> 映射成字符串打印
        List<String> numStrings =
                numPair.stream()
                       .map(pair -> "(" + pair.getFirst() + "," + pair.getSecond() + ")")
                       .collect(toList());
        System.out.println(numStrings);

        // int[]
        List<int[]> numPair2 =
                num1.stream()
                    .flatMap(n -> num2.stream()
                                             .map(m -> new int[]{n, m}))
                    .collect(toList());

        // int[] 映射成字符串打印
        numPair2.forEach(pair -> System.out.println(Arrays.toString(pair)));


        // （3）扩展（2），返回总和能被3整除的数对
        List<Pair<Integer, Integer>> numPairExtend =
                num1.stream()
                    .flatMap(n -> num2.stream()
                                             .filter(m -> (n + m) % 3 == 0)
                                             .map(m -> new Pair<>(n, m)))
                    .collect(toList());

        List<String> numPairExtendString =
                numPairExtend.stream()
                             .map(pair -> "(" + pair.getFirst() + "," + pair.getSecond() + ")")
                             .collect(toList());
        System.out.println(numPairExtendString);
    }
}
