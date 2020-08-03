package com.twu.refactoring;

public class NumberCruncher {
    private final  int CONDITION_ODD = 0;
    private final  int CONDITION_EVEN = 1;
    private final  int CONDITION_POSITIVE = 2;
    private final  int CONDITION_NEGATIVE = 3;
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countInCondition(CONDITION_EVEN);
    }

    public int countOdd() {
        return countInCondition(CONDITION_ODD);
    }

    public int countPositive() {
        return countInCondition(CONDITION_POSITIVE);
    }

    public int countNegative() {
        return countInCondition(CONDITION_NEGATIVE);
    }

    public int countInCondition(int conditon) {
        int count = 0;
        for (int number : numbers) {
            if (conditon == CONDITION_EVEN && number % 2 == 0) count++;
            if (conditon == CONDITION_ODD && number % 2 == 1) count++;
            if (conditon == CONDITION_POSITIVE && number >= 0) count++;
            if (conditon == CONDITION_NEGATIVE && number < 0) count++;
        }
        return count;
    }
}
