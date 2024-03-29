package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public void longCalculation(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Set<Integer> digitsSet(int number) {
        Set<Integer> result = new HashSet<>();
        String numberString = String.valueOf(number);

        Arrays.stream(numberString.split("")).forEach((elem) -> result.add(Integer.parseInt(elem)));

        return result;
    }
}
