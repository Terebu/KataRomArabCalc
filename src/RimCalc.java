import java.util.*;

public class RimCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("аВыберите систему  исчисления, римская/арабская:");
        String RomanArabic = scanner.nextLine();

        ////////////////////////////////////////////////////////////////////////////////////////////
        switch (RomanArabic){
            case "арабская":
        System.out.println("Введите математический оператор: ");
        String num = scanner.nextLine();
        System.out.print("Введи первое арабск число:");
        int a = scanner.nextInt();
        System.out.print("Введи второе арабское число:");
        int b = scanner.nextInt();
        switch (num) {
            case "+":
                int i = a + b;
                System.out.println("Result is:" + i);
                break;
            case "-":
                int i2 = a - b;
                System.out.println("Result is:" + i2);
                break;
            case "*":
                int i3 = a * b;
                System.out.println("Result is:" + i3);
                break;
            case "/":
                int i4 = a / b;
                System.out.println("Result is:" + i4);
                break;
            default:
                System.out.println("null");
                break;
        }          break;
            case "римская":
            System.out.println("Введите первое римское число: ");
            String romanNumeral1 = scanner.nextLine();
            int arabicNumeral1 = toArabic(romanNumeral1);

            System.out.println("Введите второе римское число: ");
            String romanNumeral2 = scanner.nextLine();
            int arabicNumeral2 = toArabic(romanNumeral2);

            System.out.println("Введите математический оператор: ");
            String operator = scanner.nextLine();

            int result = calculate(arabicNumeral1, arabicNumeral2, operator);

            String romanResult = toRoman(result);

            System.out.println("Результат: " + romanResult);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int calculate(int num1, int num2, String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String toRoman(int arabic) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(10, "X");
        map.put(9, "IX");
        map.put(8, "VIII");
        map.put(7, "VII");
        map.put(6, "VI");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(3, "III");
        map.put(2, "II");
        map.put(1, "I");

        String result = "";
        while (arabic > 0) {
            int key = map.floorKey(arabic);
            String roman = map.get(key);
            result += roman;
            arabic -= key;
        }
        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    public static int toArabic(String roman) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);

        int result = 0;
        int i = 0;
        while (i < roman.length()) {
            if (i + 1 < roman.length() && map.containsKey(roman.substring(i, i + 2))) {
                result += map.get(roman.substring(i, i + 2));
                i += 2;
            } else {
                result += map.get(roman.substring(i, i + 1));
                i++;
            }
        }
        return result;
    }
}