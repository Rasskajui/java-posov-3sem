package ru.spbu.arts.java.collections;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class Collections {
    public static void main(String[] args) throws IOException {
        System.out.println(count(6));
        System.out.println();

        List<String> list1 = List.of("abc", "xyz", "ooo");
        printList(list1);
        System.out.println();

        printListWithIndexes(list1);
        System.out.println();

        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4); //aaa bbb ccc xxx yyy zzz
        System.out.println();

        //созадем изменяемый список list5.
        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        //сначала чистая функция
        List<String> list5rev = reverseList(list5);
        //проверяем, что list5rev перевернутый, а list5 остался без изменений.
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);
        //теперь функция, которая меняет сам список
        reverseListInPlace(list5);
        //проверяем, что список действительно изменился
        System.out.println("list5 = " + list5);
        System.out.println();

        List<Integer> ints = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);

        System.out.println("ints = " + ints);
        //функция должна удалить элементы с четными индексами, т.е. оставить только каждое второе число
        System.out.println("ints no even indices = " + filterEvenIndices(ints)); //["22", "55", "88", "3"]
        //функция должна удалить четные числа
        System.out.println("ints without even = " + filterEven(ints)); //["11", "33", "55", "3"]

        System.out.println(" ============= mutable lists =================== ");
        List<Integer> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts); //[22, 55, 88, 3]

        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts); //[11, 33, 55, 3]
        System.out.println();

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        doReadWordsInFile("src/file.txt", hashSet);
        doReadWordsInFile("src/file.txt", linkedHashSet);
        doReadWordsInFile("src/file.txt", treeSet);

        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
    }

    public static List<Integer> count(int n){
        List<Integer> s = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            s.add(i);
        }
        return s;
    }

    public static void printList(List<String> list){
        System.out.println("На экране элементов: " + list.size());
        list.forEach(System.out::println);
    }

    public static void printListWithIndexes(List<String> list){
        System.out.println("На экране элементов: " + list.size());
        for (int i = 1; i <= list.size(); i++){
            System.out.println(i + ": " + list.get(i-1));
        }
    }

    public static List<String> concatenateLists(List<String> list1, List<String> list2){
        List<String> newList = new ArrayList<>();
        newList.addAll(list1);
        newList.addAll(list2);
        return newList;
    }

    public static List<String> reverseList(List<String> list){
        List<String> newList = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--){
            newList.add(list.get(i));
        }
        return newList;
    }

    public static void reverseListInPlace(List<String> list){
        List<String> newList = reverseList(list);
        for(int i = 0; i < list.size(); i++){
            list.set(i, newList.get(i));
        }
    }

    public static List<Integer> filterEvenIndices(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if ((i + 1) % 2 == 0){
                newList.add(list.get(i));
            }
        }
        return newList;
    }

    public static List<Integer> filterEven(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        for (int el : list) {
            if (el % 2 != 0) {
                newList.add(el);
            }
        }
        return newList;
    }

    public static void mutableFilterEvenIndices(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            if (i % 2 == 0){
                list.set(i, null);
            }
        }
        int i = 0;
        while(i < list.size()){
            if (list.get(i) == null){
                list.remove(i);
            } else
                i++;
        }
    }

    public static void mutableFilterEven(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            if (list.get(i) % 2 == 0){
                list.set(i, null);
            }
        }
        int i = 0;
        while(i < list.size()){
            if (list.get(i) == null){
                list.remove(i);
            } else
                i++;
        }
    }

    public static void doReadWordsInFile(String file, Set<String> set) throws IOException {
        Path txt = Path.of(file);
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            while (in.hasNext()) {
                String word = in.next();
                set.add(word.toLowerCase());
            }
        }
    }
}
