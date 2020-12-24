/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

import java.text.Collator;
import java.util.*;

/**
 * @author Marcelo
 */
public class Generala {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        int total = 0;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
    }

    // '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
    //es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
    public static int generala(int... dice) {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 1) sum++;
        if (d2 == 1) sum++;
        if (d3 == 1) sum++;
        if (d4 == 1) sum++;
        if (d5 == 1)
            sum++;

        return sum;
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 2) sum += 2;
        if (d2 == 2) sum += 2;
        if (d3 == 2) sum += 2;
        if (d4 == 2) sum += 2;
        if (d5 == 2) sum += 2;
        return sum;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int s;
        s = 0;
        if (d1 == 3) s += 3;
        if (d2 == 3) s += 3;
        if (d3 == 3) s += 3;
        if (d4 == 3) s += 3;
        if (d5 == 3) s += 3;
        return s;
    }

    private static Dice dice;

    public Generala(int num1, int num2, int num3, int num4, int num5) {
        dice = new Dice(num1, num2, num3, num4, num5);
    }

    public int fours() {
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice.getNums()[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives() {
        int s = 0;
        int i;
        for (i = 0; i < dice.getNums().length; i++)
            if (dice.getNums()[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes() {
        int sum = 0;
        for (int at = 0; at < dice.getNums().length; at++)
            if (dice.getNums()[at] == 6)
                sum = sum + 6;
        return sum;
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    private static boolean isPair(Integer[] array) {
        int frequency = 0;
        if (getRepeatedTimes(array) >= 2) {
            frequency++;
        }
        return frequency == 1;
    }

    private static boolean isTwoPairs(Integer[] array) {
        boolean notSorted = isPair(array);
        Arrays.sort(array, Collections.reverseOrder());
        boolean sorted = isPair(array);
        return notSorted && sorted;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        Integer[] dice = new Integer[]{d1, d2, d3, d4, d5};
        if (isTwoPairs(dice)) {
            int sumA = getRepeatedSum(dice);
            Arrays.sort(dice, Collections.reverseOrder());
            int sumB = getRepeatedNumber(dice) * 2;
            return sumA + sumB;
        } else {
            return 0;
        }
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        Integer[] dice = new Integer[]{d1, d2, d3, d4, d5};
        if (getRepeatedTimes(dice) > 4) {
            return getRepeatedSum(dice) - getRepeatedNumber(dice) * 2;
        } else if (isFourOfKind(dice)) {
            return getRepeatedSum(dice);
        } else {
            return 0;
        }
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        Integer[] dice = new Integer[]{d1, d2, d3, d4, d5};
        if (getRepeatedTimes(dice) > 3) {
            return getRepeatedSum(dice) - getRepeatedNumber(dice);
        } else {
            return getRepeatedSum(dice);
        }
    }

    private static boolean containsNumber(Integer[] array, int number) {
        for (int x : array) {
            if (x == number) {
                return true;
            }
        }
        return false;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        Integer[] dice = new Integer[]{d1, d2, d3, d4, d5};
        if (containsNumber(dice, 1)
                && containsNumber(dice, 2)
                && containsNumber(dice, 3)
                && containsNumber(dice, 4)
                && containsNumber(dice, 5)) {
            return 15;
        } else {
            return 0;
        }
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        Integer[] dice = new Integer[]{d1, d2, d3, d4, d5};
        if (containsNumber(dice, 2)
                && containsNumber(dice, 3)
                && containsNumber(dice, 4)
                && containsNumber(dice, 5)
                && containsNumber(dice, 6)) {
            return 20;
        } else {
            return 0;
        }
    }

    private static int getFrequency(Integer[] array, int num) {
        int repeatedTimes = 0;
        for (int j : array) {
            if (num == j) {
                repeatedTimes++;
            }

        }
        return repeatedTimes;
    }

    private static boolean isTwoOfKind(Integer[] dice) {
        boolean conditional = false;
        for (int num : dice) {
            if (getFrequency(dice, num) == 2) {
                conditional = true;
                break;
            }
        }
        return conditional;
    }

    private static boolean isThreeOfKind(Integer[] dice) {
        boolean conditional = false;
        for (int num : dice) {
            if (getFrequency(dice, num) == 3) {
                conditional = true;
                break;
            }
        }
        return conditional;
    }

    private static boolean isFourOfKind(Integer[] dice) {
        boolean conditional = false;
        for (int num : dice) {
            if (getFrequency(dice, num) == 4) {
                conditional = true;
                break;
            }
        }
        return conditional;
    }

    private static int sumAllNumbers(Integer[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    private static int getRepeatedTimes(Integer[] array) {
        int repeatedTimes = 0;
        for (int x : array) {
            if (getFrequency(array, x) > 1) {
                repeatedTimes = getFrequency(array, x);
                break;
            }
        }
        return repeatedTimes;
    }

    private static int getRepeatedNumber(Integer[] array) {
        int num = 0;
        for (int x : array) {
            if (getFrequency(array, x) > 1) {
                num = x;
                break;
            }
        }
        return num;
    }

    private static int getRepeatedSum(Integer[] array) {
        Arrays.sort(array);
        int repeatedTimes = getRepeatedTimes(array);
        int num = getRepeatedNumber(array);
        return num * repeatedTimes;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        Integer[] dice = new Integer[]{d1, d2, d3, d4, d5};
        if (isTwoOfKind(dice) && isThreeOfKind(dice)) {
            return sumAllNumbers(dice);
        } else {
            return 0;
        }
    }

}

