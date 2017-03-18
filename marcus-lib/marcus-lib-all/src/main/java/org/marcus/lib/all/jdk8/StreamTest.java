package org.marcus.lib.all.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String args[]) {
       List<String> list = new ArrayList<String>();
       list.add("apple");
       list.add("banana");
       list.add("orange");
       
       //过滤list
       
       //旧的写法
       List<String> list1 = new ArrayList<String>();
       for (String str: list) {
           System.out.println(str);
           if (!"banana".equals(str)) {
               list1.add(str);
           }
       }
       
       //新的写法
       List<String> list2 = list.stream()
                               .filter(str -> {
                                   System.out.println(str);
                                   return !"banana".equals(str); 
                               })
                               .collect(Collectors.toList());
       
       //获取数量
       
       //旧的写法
       int count = 0;
       for (String str: list) {
           if (!"banana".equals(str)) {
               count++;
           }
       }
       System.out.println(count);
       
       //新的写法
       int count1 = (int) list.stream()
           .filter(str -> {
               System.out.println(str);
               return !"banana".equals(str); 
           })
           .count();
       System.out.println(count1);
       
       //常用流的操作
       
       //collect
       List<String> collected = Stream.of("a", "b", "c")
                                   .collect(Collectors.toList());
       
       List<String> collected1 = Arrays.asList("a", "b", "c");
       
       //map
       List<String> c1 = new ArrayList<>();
       for (String string: Arrays.asList("a", "b", "hello")) {
           c1.add(string.toUpperCase());
       }
       
       List<String> c2 = Stream.of("a", "b", "hello")
                               .map(string -> string.toUpperCase())
                               .collect(Collectors.toList());
       
       
       //filter
       List<String> beginingWithNumbers = new ArrayList<>();
       for (String value : Arrays.asList("a", "1abc", "abc1")) {
           if (Character.isDigit(value.charAt(0))) {
               beginingWithNumbers.add(value);
           }
       }
       
       List<String> beginingWithNumbers1 = Stream.of("a", "1abc", "abc1")
                                               .filter(value -> Character.isDigit(value.charAt(0)))
                                               .collect(Collectors.toList());
       
       //flatMap操作
       List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                                       .flatMap(numbers -> numbers.stream())
                                       .collect(Collectors.toList());
       
       
       //max和min操作
       String min = Stream.of("abc", "ac", "abcd")
                           .min(Comparator.comparing(string -> string.toString().length()))
                           .get();
       System.out.println(min);
       String max = Stream.of("abc", "ac", "abcd")
               .max(Comparator.comparing(string -> string.toString().length()))
               .get();
       System.out.println(max);   
       
       //reduce操作
       int total = Stream.of(1, 2, 3)
                     .reduce(0, (accumulator, element) -> accumulator + element);
       
       System.out.println(total);
       
    }

}
