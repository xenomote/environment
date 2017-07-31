package game.description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Description {
    private static final HashMap<Integer, String> onesMap = new HashMap<>();
    private static final HashMap<Integer, String> teensMap;
    private static final HashMap<Integer, String> tensMap;
    private static final String[] powerGroupNames;
    private static final int MAX_DIGITS;

    static {
        onesMap.put(1, "one"); onesMap.put(2, "two"); onesMap.put(3, "three");
        onesMap.put(4, "four"); onesMap.put(5, "five"); onesMap.put(6, "six");
        onesMap.put(7, "seven"); onesMap.put(8, "eight"); onesMap.put(9, "nine");

        teensMap = new HashMap<>(onesMap);
        teensMap.put(3, "thir");
        teensMap.put(5, "fif");
        teensMap.put(8, "eigh");

        tensMap = new HashMap<>(teensMap);
        tensMap.put(2, "twen");
        tensMap.put(4, "for");

        teensMap.replaceAll((i, number) -> number + "teen");
        teensMap.put(1, "eleven");
        teensMap.put(2, "twelve");

        tensMap.replaceAll((i, number) -> number + "ty");
        tensMap.put(1, "ten");

        powerGroupNames = new String[]{
                "thousand", "million", "billion", "trillion", "quadrillion"
        };

        MAX_DIGITS = powerGroupNames.length * 3 + 3;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            System.out.println(numerate("" + i));
        }
    }

    public static String numerate(String number) {
        if (number.length() > MAX_DIGITS) {
            char[] maxNo = new char[MAX_DIGITS];
            Arrays.fill(maxNo, '9');
            throw new IndexOutOfBoundsException("Maximum magnitude describable is " + new String(maxNo) +  ", got " + number);
        }

        int[] hundreds = divideByPowerGroups(number);
        int lowest = hundreds[0];

        int highestPower = number.length();
        int highestPowerGroup = highestPower / 3;
        LinkedList<String> description = new LinkedList<>();

        boolean needsComma = false;
        for (int i = 1; i < highestPowerGroup + 1; i++) {
            if (hundreds[i] != 0) {
                if (needsComma) description.addFirst(", ");
                description.addFirst(" " + powerGroupNames[i - 1]);
                description.addFirst(numerateHundreds(hundreds[i]));
                needsComma = true;
            }
        }

        if (lowest != 0) {
            description.addLast(lowest < 100 ? " and " : ", ");
            description.addLast(numerateHundreds(hundreds[0]));
        }


        return String.join("", description);
    }

    private static int[] divideByPowerGroups(String number) {
        int[] powerGroups = new int[powerGroupNames.length + 1];
        int highestPower = number.length();
        int highestPowerGroup = highestPower / 3;

        for (int i = highestPower, j = i; i >= 0; i--) {
            if (j - i == 3 || i == 0) {
                powerGroups[highestPowerGroup - j/3] = Integer.parseInt(number.substring(i, j));
                j = i;
            }
        }

        return powerGroups;
    }

    private static String numerateHundreds(int number) {
        if (0 < number && number < 1000) {
            String numeration = "";
            if (number / 100 > 0) {
                numeration += onesMap.get(number / 100) + " hundred";

                number %= 100;
                if (number > 0) numeration += " and ";

            }

            if (number / 10 > 0) {
                if (10 < number && number < 20) return numeration + teensMap.get(number % 10);

                numeration += tensMap.get(number / 10);

                number %= 10;
                if (number > 0) numeration += " ";
            }

            if (number > 0) {
                numeration += onesMap.get(number);
            }

            return numeration;
        }

        else if (number == 0) {
            return "zero";
        }

        else if (number < 0) {
            return "minus " + numerateHundreds(-number);
        }

        throw new IndexOutOfBoundsException("Number must be from -999 to 999, got " + number);
    }
}
