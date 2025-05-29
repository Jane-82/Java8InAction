package lambdasinaction.chap5;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Practice_5_5_付诸实践 {

    public static void main(String... args) throws JsonProcessingException {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> transactions2011 = transactions.stream()
                                                         .filter(t -> t.getYear() == 2011)
                                                         .sorted(comparing(Transaction::getValue))
                                                         .collect(toList());
        System.out.println(transactions2011);

        System.out.println("--------------------------");

        // (2) 交易员都在哪些不同的城市工作过？
        List<String> cityList = transactions.stream()
                                            .map(Transaction::getTrader)
                                            .map(Trader::getCity)
                                            .distinct()
                                            .collect(toList());
        System.out.println(cityList);

        Set<String> citySet = transactions.stream()
                                          .map(t -> t.getTrader().getCity())
                                          .collect(toSet());
        System.out.println(citySet);

        System.out.println("--------------------------");

        // (3) 查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> traderFromCambridge = transactions.stream()
                                                       .map(Transaction::getTrader)
                                                       .filter(t -> "Cambridge".equals(t.getCity()))
                                                       .distinct()   // 去除重复交易员
                                                       .sorted(comparing(Trader::getName))
                                                       .collect(toList());
        System.out.println(traderFromCambridge);

        System.out.println("--------------------------");

        // (4) 返回所有交易员的姓名字符串，按字母顺序排序
        String tradersNameString = transactions.stream()
                                               .map(Transaction::getTrader)
                                               .map(Trader::getName)
                                               .distinct()
                                               .sorted()  // 使用 reduce 拼接所有交易员的姓名
                                               .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(tradersNameString);

        String tradersNameString2 = transactions.stream()
                                                .map(transaction -> transaction.getTrader().getName())
                                                .distinct()
                                                .sorted()  // 使用 joining() 拼接更高效
                                                .collect(Collectors.joining());
        System.out.println(tradersNameString2);

        System.out.println("--------------------------");

        // (5) 有没有交易员是在米兰工作的
        boolean isMilanHasTrader = transactions.stream()
                                               .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println(isMilanHasTrader);

        System.out.println("--------------------------");

        // (6) 打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                    .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);  // 打印直接使用forEach

        System.out.println("--------------------------");

        // (7) 所有交易中，最高的交易额是多少
        int highestValue = transactions.stream()
                                       .map(Transaction::getValue)
                                       .reduce(0, Integer::max);
        System.out.println(highestValue);

        Optional<Integer> highestValue2 = transactions.stream()
                                                      .map(Transaction::getValue)
                                                      .max(Integer::compareTo);
        System.out.println(highestValue2);

        System.out.println("--------------------------");

        // (8) 找出交易额最小的交易
        Optional<Transaction> smallestTransaction = transactions.stream()  // 使用 Optional 类型接受可能出现的空值
                                                                .reduce((t1, t2) ->
                                                                        t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(smallestTransaction);

        Optional<Transaction> smallestTransaction2 = transactions.stream()  // 使用 min 方法计算最小值（需要结合Optional使用）
                                                                 .min(comparing(Transaction::getValue));
        System.out.println(smallestTransaction2);
    }
}
