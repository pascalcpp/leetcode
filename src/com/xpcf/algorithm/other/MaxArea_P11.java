package com.xpcf.algorithm.other;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/18/2021 8:18 PM
 */
public class MaxArea_P11 {


    public static void main(String[] args) {
//        Integer[] array = Integers.random(100, 100, 100);
//        Integers.println(array);


        Person[] array = new Person[] {
                new Person(20, "A"),
                new Person(-13, "B"),
                new Person(17, "C"),
                new Person(12, "D"),
                new Person(-13, "E"),
                new Person(20, "F")
        };
        for (Person person : array) {
            System.out.println(person);
        }
        int max = array[0].age;
        int min = array[0].age;
        for (int i = 0; i < array.length; i++) {
            if (array[i].age < min) {
                min = array[i].age;
            } else if (array[i].age > max) {
                max = array[i].age;
            }

        }
        // 开辟内存空间，存储次数
        int[] counts = new int[max - min + 1];
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i].age - min]++;
        }
        // 累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // 从后往前遍历元素，将它放到有序数组中的合适位置
        Person[] newArray = new Person[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i].age - min]] = array[i];
        }

        // 将有序数组赋值到array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
//        Integers.println(array);
//        System.out.println(Integers.isAscOrder(array));
        System.out.println("==================");
        for (Person person : array) {
            System.out.println(person);
        }
    }

    private static class Person {
        int age;
        String name;
        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        public String toString() {
            return "Person [age=" + age
                    + ", name=" + name + "]";
        }
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int lV = height[l], rV = height[r];
            if (lV < rV) {
                ans = Math.max(ans, (r - l) * lV);
                ++l;
            } else {
                ans = Math.max(ans, (r - l) * rV);
                --r;
            }

        }
        return ans;
    }
}
