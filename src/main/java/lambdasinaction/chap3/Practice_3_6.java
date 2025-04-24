package lambdasinaction.chap3;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Practice_3_6 {
    public static void main(String[] args) {
        // 1 Lambda写法
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        // 等效的方法引用：调用静态方法
        Function<String, Integer> stringIntegerFunctionToInteger = Integer::parseInt;

        // 2 Lambda写法：省略Lambda参数类型的写法
        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        // 等效的方法引用：调用任意类型的实例方法
        BiPredicate<List<String>, String> containsBiPredicate = List::contains;
    }
}