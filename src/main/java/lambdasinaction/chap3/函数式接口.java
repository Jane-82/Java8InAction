package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 函数式接口 {

    public static void main(String[] args) {
        System.out.println("---callPredicate---");
        callPredicate();

        System.out.println("---callConsumer---");
        callConsumer();

        System.out.println("---callFunction---");
        callFunction();
    }

    /**
     * 签名 T -> boolean
     * 谓词 Predicate<T>    java.util.function.Predicate<T>
     * @param <T>
     */
    @FunctionalInterface
    public interface Predicate<T>{
        boolean test(T t);
    }

    // <T>表示当前方法是一个泛型方法，其参数、返回值可以独立于当前类的泛型参数，不受类泛型的限制
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s: list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    public static void callPredicate() {
        List<String> list = Arrays.asList("apple", "", "dog", "cat");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(list, nonEmptyStringPredicate);

        for (String s: nonEmpty) {
            System.out.println(s);
        }
    }

    /**
     * 签名 T -> void
     * 消费者 Consumer<T>    java.util.function.Consumer<T>
     * @param <T>
     */
    @FunctionalInterface
    public interface Consumer<T>{
        void accept(T t);
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i: list) {
            c.accept(i);
        }
    }

    public static void callConsumer() {
//        List<Integer> list = Arrays.asList(1, 2, 3);
//        Consumer<Integer> printConsumer = (Integer i) -> System.out.println(i);
//        forEach(list, printConsumer);

        // 简化版本
        forEach(Arrays.asList(1, 2, 3), (Integer i) -> System.out.println(i));
    }

    /**
     * 签名 T -> R
     * 函数 Function<T, R>    java.util.function.Function<T, R>
     * 可以实现将输入对象的信息映射到输出（map）
     * @param <T>
     * @param <R>
     */
    @FunctionalInterface
    public interface Function<T, R>{
        R apply(T t);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s: list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static void callFunction() {
//        List<String> list = Arrays.asList("apple", "dog", "cat");
//        Function<String, Integer> getLength = (String s) -> s.length();
//        List<Integer> lengthList = map(list, getLength);

        // 简化版本
        List<Integer> lengthList = map(Arrays.asList("apple", "dog", "cat"), (String s) -> s.length());

        // 输出
        forEach(lengthList, (Integer i) -> System.out.println(i));
    }
}
