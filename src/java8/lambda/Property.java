package java8.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by liuchong on 2017/8/11.
 */
// 店铺属性
public class Property {

    String name;
    // 距离，单位:米
    Integer distance;
    // 销量，月售
    Integer sales;
    // 价格，这里简单起见就写一个级别代表价格段
    Integer priceLevel;

    public Property() {
    }

    public Property(String name, int distance, int sales, int priceLevel) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.priceLevel = priceLevel;
    }
    // getter setter 省略

    public static void main(String[] args) {
        Property p1 = new Property("叫了个鸡", 1000, 500, 2);
        Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
        Property p3 = new Property("永和大王", 580, 3000, 1);
        Property p4 = new Property("肯德基", 6000, 200, 4);
        List<Property> properties = Arrays.asList(p1, p2, p3, p4);
        Collections.sort(properties, (x, y) -> x.distance.compareTo(y.distance));
        String name = properties.get(0).name;
        System.out.println("距离我最近的店铺是:" + name);

        // Stream操作
        String name2 = properties.stream()
                .sorted(Comparator.comparingInt(x -> x.distance))
                .findFirst()
                .get()
                .getName();
        System.out.println("距离我最近的店铺是:" + name);

        int count = 0;
        for (Property property : properties) {
            if (property.sales > 1000) {
                count++;
            }
        }
        System.out.println(count);

        int count1 = 0;
        Iterator<Property> iterator = properties.iterator();
        while (iterator.hasNext()) {
            Property property = iterator.next();
            if (property.sales > 1000) {
                count1++;
            }
        }
        System.out.println(count1);

        long count2 = properties.stream()
                .filter(x -> x.sales > 1000)
                .count();
        System.out.println(count2);

        Stream.of(1, 2, 3);
        try {
            System.out.println("==============================");
            List<String> lines = Files.readAllLines(Paths.get("/tmp/test.txt"));
            lines.stream().forEach(line -> System.out.println(line));
            System.out.println("==============================");
            Files.lines(Paths.get("/tmp/test.txt")).forEach(line -> System.out.println(line));
            System.out.println("==============================");
            lines.forEach(line -> System.out.println(line));
            System.out.println("==============================");
            lines.stream().parallel().forEach(line -> System.out.println(line));
            System.out.println("==============================");
            String content = Files.readAllLines(Paths.get("/tmp/test.txt")).stream()
                    .collect(Collectors.joining("\n"));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squareNums = nums.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        squareNums.forEach(x -> System.out.print(" " + x));
        System.out.println();

        List<String> words = Arrays.asList("aboutjava", "accessibility", "addressing", "addshortcut", "about", "all", "become", "bacteriumparatyphosum");
        // 以a开头的字符串的最大长度
        int max = words.stream()
                .filter(x -> x.startsWith("a"))
                .mapToInt(x -> x.length())
                .max()
                .getAsInt();
        System.out.println("max:" + max);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        integerList.stream().parallel().forEach(x -> System.out.print(x));
        integerList.stream().parallel().forEachOrdered(x -> System.out.print(x));
        System.out.println();

        List<String> stringList = Arrays.asList("Hello", "Hello", "world", "C", "JavaScript", "Java");
        stringList.stream().sorted((s1, s2) -> s1.length() - s2.length()).forEach(x -> System.out.print(" " + x));
        stringList.stream().filter(x -> x.startsWith("J")).forEach(x -> System.out.print(" " + x));
        stringList.stream().limit(3).forEach(x -> System.out.print(" " + x));
        stringList.stream().distinct().forEach(x -> System.out.print(" " + x));
        System.out.println();
        boolean allMatch = stringList.stream().allMatch((s) -> s.startsWith("j"));
        System.out.println(allMatch);
        boolean anyMatch = stringList.stream().anyMatch((s) -> s.startsWith("j"));
        System.out.println(anyMatch);
        boolean noneMatch = stringList.stream().noneMatch((s) -> s.startsWith("j"));
        System.out.println(noneMatch);

        Map<String, List<Property>> propertyByName = properties.stream().collect(Collectors.groupingBy(Property::getName));
        for (Map.Entry<String, List<Property>> entry : propertyByName.entrySet()) {
            System.out.print(entry.getKey() + " ");
            entry.getValue().stream().forEach(x -> System.out.print(x));
            System.out.println();
        }

        System.out.println();
        properties.stream()
                .map(item -> item.name)   //从Item的Stream转变成了String的Stream
                .forEach(x -> System.out.print(" " + x));

        System.out.println();
        Arrays.stream(new String[]{"A", "B,C", "D,E, F"})
                .flatMap(x -> Arrays.stream(x.split(",")))
                .forEach(x -> System.out.print(" " + x));

        System.out.println();
        OptionalInt sum = Arrays.stream(new int[]{1, 2, 10, 3, 7, 5, 6})
                .reduce((left, right) -> left + right);
        System.out.println(sum.orElse(0));
        Property maxmium = properties.stream()
                .reduce(p2, (left, right) -> left.distance > right.distance ? left : right);
        System.out.println(maxmium.getName());

        Optional<Property> min = properties.stream()
                .min(Comparator.comparingInt(x -> x.getDistance()));
        System.out.println(min.get().getName());

        System.out.println();
        Set<String> toMap = properties.stream()
                .map(x -> x.name)
                .collect(Collectors.toSet());
        toMap.stream().forEach(x -> System.out.print(" " + x));
        System.out.println();
        toMap.stream().forEach(x ->
                System.out.print(" " + x));

        System.out.println();
        System.out.println();
        Consumer consumer = (i) -> System.out.print(" |" + i);
        properties.stream().forEach(consumer);
        Function<Property, Property> f = i -> new Property(i.name, i.distance + 2001, i.sales, i.priceLevel);
        Predicate<Property> p = i -> i.distance >= 5000;
        properties.stream().map(f).forEach(consumer);
        System.out.println();
        properties.stream().filter(p).forEach(consumer);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(Integer priceLevel) {
        this.priceLevel = priceLevel;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", sales=" + sales +
                ", priceLevel=" + priceLevel +
                '}';
    }
}


