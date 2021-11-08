package com.gmail.yauhenpro.epam.learning.java.fundamentals.main.task;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
//       1.     Приветствовать любого пользователя при вводе его имени через командную строку.
//       2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.
//       3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
//       4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
//       5.     Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.


    public static void main(String[] args) {
//        1.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input you name: ");
        String name = scanner.nextLine();
        System.out.printf("Hello %s !!!\n", name);
//        2.
        System.out.print("Invert command-line arguments: ");
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
//        3.
        System.out.print("Input quantity randoms numbers for line/column(e.g. 4/7): ");
        String qtyRandomNumbers = scanner.nextLine();
        Pattern pattern = Pattern.compile("^\\d{1,9}/\\d{1,9}$");
        Matcher matcher = pattern.matcher(qtyRandomNumbers);
        while (!matcher.find()) {
            System.out.print("Incorrect input. Try again: ");
            qtyRandomNumbers = scanner.nextLine();
            matcher = pattern.matcher(qtyRandomNumbers);
        }
        Pattern pattern1 = Pattern.compile("\\d+");
        matcher = pattern1.matcher(qtyRandomNumbers);
        matcher.find();
        int qtyLinesNumbers = Integer.parseInt(qtyRandomNumbers.substring(matcher.start(), matcher.end()));
        matcher.find();
        int qtyColumnNumbers = Integer.parseInt(qtyRandomNumbers.substring(matcher.start(), matcher.end()));
        Random random = new Random();
        for (; qtyLinesNumbers != 0; qtyLinesNumbers--) {
            System.out.print(random.nextInt(1000) + " ");
        }
        System.out.println("\n");
        for (; qtyColumnNumbers != 0; qtyColumnNumbers--) {
            System.out.println(random.nextInt(1000) + " ");
        }
//        4.
        Pattern pattern2 = Pattern.compile("^[\\d\\s]+$");
        String argsString = String.join(" ", args);
        matcher = pattern2.matcher(argsString);
        if (matcher.find()) {
            int sumArgs = 0;
            for (String a : args) {
                sumArgs += Integer.parseInt(a);
            }
            System.out.println("Sum of command-line arguments: " + sumArgs);
        } else {
            System.out.println("Command-line arguments isn't integers");
        }
//        5.
        System.out.print("Input integer from 1 to 12: ");
        String monthNumber = scanner.nextLine();
        Pattern pattern3 = Pattern.compile("^1?[1-9]$");
        matcher = pattern3.matcher(monthNumber);
        System.out.println(monthNumber);
        System.out.println(matcher);
        while (!(matcher.find() && Byte.parseByte(monthNumber) <= 12)) {
            System.out.print("Incorrect input. Try again: ");
            monthNumber = scanner.nextLine();
            matcher = pattern3.matcher(monthNumber);
        }
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.println("Your integer matches " + months[Byte.parseByte(monthNumber) - 1]);
        scanner.close();
        System.out.println();
    }


}
