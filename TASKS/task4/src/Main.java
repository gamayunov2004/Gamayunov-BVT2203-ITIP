import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(" 1) --------------------------------------------");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println(" 2) --------------------------------------------");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println(" 3) --------------------------------------------");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println(" 4) --------------------------------------------");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println(" 5) --------------------------------------------");
        System.out.println(sortLength("aaabbcdd"));
        System.out.println(sortLength("vvvvaajaaaaa"));
        System.out.println(" 6) --------------------------------------------");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println(" 7) --------------------------------------------");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println(" 8) --------------------------------------------");
        System.out.println(shortestWay(new int[][] {{1,3,1}, {1,5,1}, {4,2,1}}));
        System.out.println(shortestWay(new int[][] {{2,7,3}, {1,4,8}, {4,5,9}}));
        System.out.println(" 9) --------------------------------------------");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat") );
        System.out.println(" 10) --------------------------------------------");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    public static String nonRepeatable(String s)
    {
        if (s.isEmpty())
            return s;
        if (s.substring(0,s.length()-1).contains(s.substring(s.length()-1)))
            return nonRepeatable(s.substring(0,s.length()-1));
        else
            return nonRepeatable(s.substring(0,s.length()-1)) + s.substring(s.length()-1);
    }

    public static List<String> generateBrackets(int n) {
        List<String> combinations = new ArrayList<>();
        makeCombs(0,0,n, combinations,"");
        return combinations;
    }

    private static void makeCombs(int opened, int closed, int n, List<String> combinations, String comb) {
        if (opened == n && closed == n) {
            combinations.add(comb);
            return;
        }
        if (opened < n) {
            makeCombs(opened+1, closed, n, combinations, comb + "(");
        }
        if (closed < opened) {
            makeCombs(opened, closed+1, n, combinations, comb + ")");
        }
    }

    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        makeBin("", n, result);
        return result;
    }

    private static String makeBin(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return "";
        }

        if (current.isEmpty() || current.charAt(current.length()-1) == '1') {
            makeBin(current + "0", n, result);
        }
        makeBin(current + "1", n, result);
        return "";
    }


    public static String alphabeticRow(String str) {
        String longest = "";
        String current = str.substring(0,1);
        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i - 1);

            if ((currentChar - previousChar == 1 || currentChar - previousChar == -1) && !(current.contains(str.substring(i, i+1))) ) {
                current += currentChar;
            }
            else {
                if (current.length() > longest.length()) {
                    longest = current;
                }
                current = str.substring(i,i+1);
            }
        }

        if (current.length() > longest.length()) {
            longest = current;
        }

        return longest;
    }


    public static String sortLength(String str) {
        int count = 1;
        String result = "";
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                strings.add(str.charAt(i) + String.valueOf(count));
                count = 1;
            }
        }
        strings.add(str.charAt(str.length() - 1) + String.valueOf(count));

        Collections.sort(strings, new Comparator<>() {
            public int compare(String s1, String s2) {
                int num1 = takeNumber(s1);
                int num2 = takeNumber(s2);
                return Integer.compare(num1, num2);
            }

            private int takeNumber(String s) {
                String numberString = "";
                for (int i=0; i<s.length(); i++) {
                    if ("1234567890".contains(s.substring(i,i+1))) {
                        numberString += s.substring(i,i+1);
                    }
                }
                return Integer.parseInt(numberString);
            }
        });
        for (String s : strings) {
            result+=s;
        }

        return result;
    }

    public static int convertToNum(String number) {
        String hNumber = number.replace(" hundred", "*");
        Map<String, Integer> dict = new HashMap<>();
        dict.put("zero", 0);
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        dict.put("four", 4);
        dict.put("five", 5);
        dict.put("six", 6);
        dict.put("seven", 7);
        dict.put("eight", 8);
        dict.put("nine", 9);
        dict.put("ten", 10);
        dict.put("eleven", 11);
        dict.put("twelve", 12);
        dict.put("thirteen", 13);
        dict.put("fourteen", 14);
        dict.put("fifteen", 15);
        dict.put("sixteen", 16);
        dict.put("seventeen", 17);
        dict.put("eighteen", 18);
        dict.put("nineteen", 19);
        dict.put("twenty", 20);
        dict.put("thirty", 30);
        dict.put("forty", 40);
        dict.put("fifty", 50);
        dict.put("sixty", 60);
        dict.put("seventy", 70);
        dict.put("eighty", 80);
        dict.put("ninety", 90);
        String[] words = hNumber.split(" ");
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            if (dict.containsKey(words[i])) {
                result += dict.get(words[i]);
            }
            if (words[i].contains("*")) {
                result += 100 * dict.get(words[i].replace("*", ""));
            }
        }
        return result;
    }

    public static String uniqueSubstring(String str) {
        String result = str.substring(0, 1);
        String bestResult = result;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1) && !(result.contains(str.substring(i, i + 1)))) {
                result += str.substring(i, i + 1);
                if (bestResult.length() < result.length()) {
                    bestResult = result;
                }
            } else {
                result = str.substring(i, i + 1);
            }
        }
        return bestResult;
    }
    public static int shortestWay(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 1; i < rows; i++)
            matrix[0][i] += matrix[0][i-1];
        for (int i = 1; i < columns; i++)
            matrix[i][0] += matrix[i-1][0];
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < columns; c ++) {
                int vertical = matrix[r-1][c];
                int horizon = matrix[r][c-1];
                matrix[r][c] += Math.min(vertical,horizon);
            }
        }
        return matrix[rows-1][columns-1];
    }
    public static String numericOrder(String phrase) {
        String[] stringsArray = phrase.split(" ");
        List<String> strings = Arrays.asList(stringsArray);
        String result = "";
        Collections.sort(strings, new Comparator<>() {
            public int compare(String s1, String s2) {
                int num1 = takeNumber(s1);
                int num2 = takeNumber(s2);
                return Integer.compare(num1, num2);
            }

            private int takeNumber(String s) {
                String numberString = "";
                for (int i=0; i<s.length(); i++) {
                    if ("1234567890".contains(s.substring(i,i+1))) {
                        numberString += s.substring(i,i+1);
                    }
                }
                return Integer.parseInt(numberString);
            }
        });
        for (String s : strings) {
            result+= " " + s;
        }
        result = result.replaceAll("\\d", "");
        return result.substring(1);
    }

    public static int switchNums(int num1, int num2) {
        int[] number1 = takeDigits(num1);
        Arrays.sort(number1);
        int[] number2 = takeDigits(num2);
        int i = number1.length-1;
        int j = 0;
        while (i != 0 && j < number2.length) {
            if (number2[j] < number1[i]) {
                number2[j] = number1[i];
                i--;
            }
            j++;
        }
        return digitsToNumber(number2);
    }
    public static int[] takeDigits(int num) {
        String number = String.valueOf(num);
        int[] digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++)
            digits[i] = Character.getNumericValue(number.charAt(i));
        return digits;
    }
    public static int digitsToNumber(int[] digits) {
        int result = 0;
        for (int i = 0; i < digits.length; i++)
            result += digits[i] * Math.pow(10, digits.length-i-1);
        return result;
    }

}