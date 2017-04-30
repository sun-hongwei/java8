import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by fan on 2017/4/30.
 */
public class TestStream {

    List<Emp> emps = Arrays.asList(
            new Emp("ee", 23, 8000.0),
            new Emp("aa", 23, 8555.0),
            new Emp("cc", 70, 9000.0),
            new Emp("dd", 18, 10000.0)

    );

    @Test
    public void test1() {
        List<String> stringList = new ArrayList<>();

        stringList.add("1123");

        Stream<String> stream = stringList.stream();

        System.out.println(stream);

        Stream.generate(() -> Math.random() * 10).forEach(System.out::println);
    }

    @Test
    public void test2() {
        //中间操作
        Stream<Emp> empStream = emps.stream()
                .filter((e -> e.getSal() > 8000))
                .limit(2);

        //终止操作
        empStream.forEach(System.out::println);
    }

    @Test
    public void test3() {
        List<String> strings = Arrays.asList("aa", "ss", "dd");
        strings.stream()
                .map((x) -> x.toUpperCase())
                .forEach(System.out::println);

        System.out.println("-------------------------------");

        //排序自然排序
        strings.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("---------------------------");

        emps.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return Integer.compare(e1.getAge(), e2.getAge());
                    }
                })
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        long count = emps.stream()
                .count();

        System.out.println(count);

        System.out.println("-------------------------------------");

        Optional<Double> min = emps.stream()
                .map((e -> e.getSal()))
                .min(Double::compare);

        System.out.println(min.get());

        System.out.println("-------------------------------------");

    }

}
