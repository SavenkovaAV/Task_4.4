package ru.vsu.cs.course1.sort;

import java.util.Comparator;



//Сортировка Шелла
public class ShellSort {

    public static <T> void sort(T[] data, Comparator<T> c) {
        int length = data.length;
        for (int step = length / 2; step > 0; step /= 2) {
            for (int i = step; i < length; i++) {
                for (int j = i - step; j >= 0 ; j -= step) {
                    T value = data[j];
                    if (c.compare(data[j], value) > c.compare(data[j + step], value)) {   //data[j] > data[j + step]
                        data[j] = data[j + step];
                        data[j + step] = value;
                    }
                }
            }
        }
    }

    public static <T extends Comparable<T>> void sort(T[] data) {
        sort(data, Comparable::compareTo);
    }
}
