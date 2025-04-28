package lambdasinaction.chap4;

public class Practice_4_1 {
    public static void main(String[] args) {
        // 终端操作的结果是除 Stream类型 以外的任何类型
        long count = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)  // 中间操作（选取卡路里大于300的菜品）
                .distinct()  // 中间操作（去重）
                .limit(3)  // 中间操作（截断）
                .count();  // 终端操作（因为返回值为long，不是Stream类型。计数）

        // 输出：3
        System.out.println(count);
    }
}
