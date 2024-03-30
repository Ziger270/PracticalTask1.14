/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.task1_14;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author aleksandrbisirov
 */
public class Task1_14 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Бисиров Александр Васильевич. Вариант 3");
        
        boolean normal_values = false;
        List<Double> data_values = null;
        while (!normal_values) {
            System.out.println("Введите числа через запятую с пробелом");
            String str_values = scan.nextLine();
            String[] str_array = str_values.split(", ");
            Stream data_stream = Arrays.stream(str_array);
            try {
                data_values = (List<Double>)(data_stream.map(x->Double.parseDouble(x.toString())).collect(Collectors.toList()));
                normal_values = true;
            }
            catch (NumberFormatException ex) {
                System.out.println("Неверный формат ввода");
                normal_values = false;
            }
        }
        MaxValueFinder maxvfinder = new MaxValueFinder(data_values);
        MinValueFinder minvfinder = new MinValueFinder(data_values);
        maxvfinder.start();
        minvfinder.start();
        try {
            maxvfinder.join();
            minvfinder.join();
            System.out.println("Максимальное значение: " + maxvfinder.GetMaxValue());
            System.out.println("Минимальное значение: " + minvfinder.GetMinValue());
        }
        catch (InterruptedException ex) {
            System.out.println("InterruptedException!");
        }
        catch (NullPointerException ex) {
            System.out.println("Возникла ошибка при вычислении максимального или минимального значения!");
        }
        
    }
}
