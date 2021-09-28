package com.company;

public class Roman {
    private static int[] arab = new int[]{0, 1, 4, 5, 9, 10, 40, 50, 90, 100};
    private static String[] roman = new String[]{"", "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    String Roman_num;
    int Arabic_num;

    public int Roman_to_int(String s) {
        if (s.isEmpty())
        {
            return 0;
        }
        else {
            int n;
            if (s.charAt(0) == 'I') {
                s = s.substring(1);
                if (s.isEmpty()) {
                    return 1;
                }

                if (s.charAt(0) == 'V') {
                    n = 4;
                } else {
                    if (s.charAt(0) != 'X') {
                        return 1 + this.Roman_to_int(s);
                    }

                    n = 9;
                }
            } else if (s.charAt(0) == 'V') {
                n = 5;
            } else {
                n = 10;
            }

            s = s.substring(1);
            return n + this.Roman_to_int(s);
        }
    }

    public static int findi(int n, int first, int last) {
        if (first == last) {
            return first;
        } else if (arab[first] == n) {
            return first;
        } else if (arab[last] == n) {
            return last;
        } else {
            int m = (first + last) / 2;
            if (arab[m] == n) {
                return m;
            } else if (first == m) {
                return first;
            } else {
                return n > arab[m] ? findi(n, m, last) : findi(n, first, m);
            }
        }
    }

    private static String toRoman(int n) {
        int i = findi(n, 0, arab.length - 1);
        if (n == arab[i]) {
            return roman[i];
        } else {
            String var10000 = roman[i];
            return var10000 + toRoman(n - arab[i]);
        }
    }

    public String toRoman() {
        int i = findi(this.Arabic_num, 0, arab.length - 1);
        if (this.Arabic_num == arab[i]) {
            return roman[i];
        } else {
            String var10000 = roman[i];
            return var10000 + toRoman(this.Arabic_num - arab[i]);
        }
    }
}