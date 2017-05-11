package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by fan on 2017/4/29.
 */
public class TestLambda {

     List<Emp> emps = Arrays.asList(
            new Emp("aa",23,8000.0),
            new Emp("bb",50,8555.0),
            new Emp("cc",70,9000.0),
            new Emp("dd",18,10000.0)

    );

    @Test
    public void test1(){

        String[] aa = {"11","22"};

        for (int i = 0; i < aa.length; i++) {
            String s = aa[i];
            System.out.printf(s);

        }

    }

    public List<Emp> filter(List<Emp> empList,filtetI<Emp> filtetI) {
        List<Emp> list = new ArrayList<>();
        for (Emp emp : empList) {
            if (emp.getSal() > 8000){
                list.add(emp);
            }
        }
        return list;
    }

    @Test
//    public void test2(){
//        List<java8.Emp> filter = filter(emps);
//        for (Iterator<java8.Emp> iterator = filter.iterator(); iterator.hasNext(); ) {
//            java8.Emp next =  iterator.next();
//            System.out.println(next);
//        }
//    }

    public void test3(){
        filter(emps, new filtetI<Emp>() {
            @Override
            public List<Emp> filter(Emp emp) {
                return null;
            }
        });
    }

    @Test
    public void test4(){
        emps.stream()
                .filter((e) -> e.getSal() > 8000)
                .limit(2)
                .forEach(System.out::print);
    }

    @Test
    public void test5(){
        Function<Integer,Integer[]> function = x -> new Integer[x];

        Function<Integer,String[]> function1 = String[]::new;
        function1.apply(10);

        Integer[] apply = function.apply(10);
        System.out.println(apply.length);

        int j = 0;
        for (int i = 0; i < apply.length; i++) {
            apply[i] =j;
            j++;
        }

        for (int i = 0; i < apply.length; i++) {
            System.out.println(apply[i]);
        }
    }

    @Test
    public void test6(){
        System.out.printf(String.valueOf("aaa".length()));
    }

}
