package com.company;

import java.util.Scanner;

public class Main {
    static char ch;

    public static int Expression(int n1, int n2) throws Exception {
        if (ch == '+') {
            return n1 + n2;
        } else if (ch == '-') {
            return n1 - n2;
        } else if (ch == '/') {
            return n1 / n2;
        } else if (ch == '*') {
            return n1 * n2;
        } else {
            throw new Exception("Incorrect sign");
        }
    }

    public static void Numbers(String s1, String s2) throws Exception {
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        if (n1 > 10) {
            throw new Exception("Numbers have to be from 0 to 10");
        } else {
            int n = Expression(n1, n2);
            System.out.println(n);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String n1 = "";
        String n2 = "";
        boolean b = false;
        boolean exp = false;
        s = s.replace(" ", "");

        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (exp) {
                    throw new Exception("Incorrect expression");
                }

                ch = s.charAt(i);
                b = true;
                ++i;
                exp = true;
            }

            if (!b) {
                n1 = n1 + s.charAt(i);
            } else {
                n2 = n2 + s.charAt(i);
            }
        }

        boolean nb2 = false;
        boolean nb1 = false;
        if (n1.charAt(0) >= '0' && n1.charAt(0) <= '9') {
            nb1 = true;
        }

        if (n2.charAt(0) >= '0' && n2.charAt(0) <= '9') {
            nb2 = true;
        }

        if (nb1 != nb2) {
            throw new Exception("Both numbers have to be arabic or roman");
        } else {
            if (nb1) {
                Numbers(n1, n2);
            } else {
                Roman r1 = new Roman();
                Roman r2 = new Roman();
                r1.Roman_num = n1;
                r2.Roman_num = n2;
                int number1 = r1.Roman_to_int(r1.Roman_num);
                int number2 = r2.Roman_to_int(r2.Roman_num);
                int ans_int = Expression(number1, number2);
                if (ans_int < 0) {
                    throw new Exception("Roman numbers can't be negative");
                }

                Roman ans_rom = new Roman();
                ans_rom.Arabic_num = ans_int;
                s = ans_rom.toRoman();
                System.out.println(s);
            }

        }
    }
}