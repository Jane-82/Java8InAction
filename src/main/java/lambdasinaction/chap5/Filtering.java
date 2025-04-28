package lambdasinaction.chap5;
import lambdasinaction.chap4.*;

import java.util.*;
import static java.util.stream.Collectors.toList;

import static java.util.stream.Collectors.toSet;
import static lambdasinaction.chap4.Dish.menu;

/**
 * 5.1 筛选和切片
 */
public class Filtering{

    public static void main(String...args){

        // Filtering with predicate 筛选
        List<Dish> vegetarianMenu =
            menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements 去重
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
               .filter(i -> i % 2 == 0)
               .distinct()
               .forEach(System.out::println);

        // Truncating a stream 截断
        List<Dish> dishesLimit3 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());

        dishesLimit3.forEach(System.out::println);

        // Truncating a stream 截断 用于无序流Set
        Set<Dish> dishesLimit3Set =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toSet());

        dishesLimit3Set.forEach(System.out::println);

        // Skipping elements 跳过
        List<Dish> dishesSkip2 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());

        dishesSkip2.forEach(System.out::println);
    }
}
