package lambdasinaction.chap5;
import lambdasinaction.chap4.*;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static lambdasinaction.chap4.Dish.menu;

public class Practice_5_1 {

    public static void main(String ... args) {
        // 筛选前两个荤菜
        List<Dish> twoMeatDishes =
            menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());

        twoMeatDishes.forEach(System.out::println);
    }
}
