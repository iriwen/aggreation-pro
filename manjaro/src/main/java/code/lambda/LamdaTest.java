package code.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LamdaTest {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        //1 分组
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println("groupBy:" + groupBy);

        /**
         * 2  list转map
         * 需要注意的是：toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  apple1,apple12的id都为1;可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));
        System.out.println(appleMap);
        //3 求和
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalMoney:" + totalMoney);

        //4 求最大最小值
        Optional<Apple> maxDish = appleList.stream().collect(Collectors.maxBy(Comparator.comparing(Apple::getMoney)));
        maxDish.ifPresent(item -> System.out.println(item.getMoney()));
        Optional<Apple> minDish = appleList.stream().collect(Collectors.minBy(Comparator.comparing(Apple::getMoney)));
        //minDish.ifPresent(System.out::println);
        minDish.ifPresent(item -> System.out.println(item.getMoney()));

        //5 根据id去重
        List<Apple> unique = appleList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparingLong(Apple::getId))), ArrayList::new)
        );
        System.out.println("after unique: " + unique.size());
    }
}
