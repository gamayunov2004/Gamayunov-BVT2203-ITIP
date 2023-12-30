import java.util.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("1-----------------------------");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("2-----------------------------");
        System.out.println(collect("intercontinentalisationalism", 6) );
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        System.out.println("3-----------------------------");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println("4-----------------------------");
        System.out.println(twoProduct(new int[] {1, 2, 3, 9, 4, 5, 15}, 45));
        System.out.println(twoProduct(new int[] {1, 2, 3, 9, 4, 15, 3, 15}, 45));
        System.out.println(twoProduct(new int[] {1, 2, -1, 4, 5, 6, 10, 7}, 20));
        System.out.println(twoProduct(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println(twoProduct(new int[] {100, 12, 4, 1, 2}, 15));
        System.out.println("5-----------------------------");
        System.out.println(isExact(6));
        System.out.println(isExact(24));
        System.out.println(isExact(125));
        System.out.println(isExact(720));
        System.out.println(isExact(1024));
        System.out.println(isExact(40320));
        System.out.println("6-----------------------------");
        //System.out.println(fractions("0.(6)"));
        //System.out.println(fractions("1.(1)"));
        //System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println("7-----------------------------");
        System.out.println(pilish_string("333144"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println("8-----------------------------");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)")); // Выводит -17
        System.out.println(generateNonconsecutive("6 – 18 / (-1 + 4)"));
        System.out.println("9-----------------------------");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println("10-----------------------------");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
    }

    public static String hiddenAnagram(String s1, String s2) {
        s1 = s1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        s2 = s2.replaceAll("[^a-zA-Z]", "").toLowerCase();
        char[] s2Char = s2.toCharArray();
        Arrays.sort(s2Char);
        String sortS2 = new String(s2Char);
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            String currs = s1.substring(i, i + s2.length());
            char[] currchar = currs.toCharArray();
            Arrays.sort(currchar);
            String sortcur = new String(currchar);

            if (sortcur.equals(sortS2)) {
                return currs;
            }
        }
        return "notfound";
    }

    public static ArrayList collect(String word, int n) {
        if (word.length() <= n) {
            ArrayList list = new ArrayList<>();
            return list;
        }
        String currs = word.substring(0, n);
        ArrayList list = collect(word.substring(n), n);
        list.add(currs);
        Collections.sort(list);
        return list;
    }
    public static String nicoCipher(String message, String key) {
        int messageLength = message.length();
        int keyLength = key.length();
        int rows = (int) (messageLength / keyLength) + 1;
        char[][] grid = new char[rows][keyLength];
        String result = "";
// Заполняем знач
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (index < messageLength) {
                    grid[i][j] = message.charAt(index);
                    index++;
                } else {
                    grid[i][j] = ' ';
                }
            }
        } //System.out.println(Arrays.deepToString(grid));
//  массив индексов ключевого слова
        int[] keyOrder = new int[keyLength];
        char[] sortedKey = getSortedKey(key);
//   знач столбцов в исходной строке
        for (int i = 0; i < keyLength; i++) {
            char currentKeyChar = sortedKey[i];
            int indexInKey = key.indexOf(currentKeyChar);
            keyOrder[i] = indexInKey;
        }
// Расшифровываем сообщение
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyLength; j++) {
                result += grid[i][keyOrder[j]];
            }
        }
        return result;
    }
    // Метод для сортировки символов ключа
    public static char[] getSortedKey(String key) {
        char[] sortedKey = key.toCharArray();
        Arrays.sort(sortedKey);
        return sortedKey;
    }
    public static String twoProduct(int[] arr, int n) {
        HashMap chMap = new HashMap<>();
        int[] meow = new int[2];
        for (int i : arr) {
            if (n % i == 0 && chMap.containsKey(n / i)) {
                meow[0] = (n/i);
                meow[1] = i;
                return Arrays.toString(meow);
            }
            chMap.put(i, i);
        }
        return null;
    }
    public static String isExact(int n) {
        return FindKot(n, 1, 1);
    }

    public static String FindKot(int n, int f, int lim) {
        int[] kotya = new int[2];
        if (lim == n) {
            kotya[0] = lim;
            kotya[1] = f;
            return Arrays.toString(kotya);
        } else if (lim > n) {
            int[] list = new int[0];
            return Arrays.toString(list);
        } else {
            return FindKot(n, f + 1, lim * (f + 1));
        }
    }
    public static String fractions(String n) {
//        String[] n = new String[2];
//        n = decimal.split("\\.");
//        String s1 = n[0];
        int start = n.indexOf("(");
        int end = n.indexOf(".");
        String numb = n.substring(0, end);
        String per = n.substring(start + 1, n.length() - 1);
        if (n.length() == (numb.length() + per.length() - 3)) {
            int numb1 = numb.isEmpty() ? 0 : Integer.parseInt(numb);
            int per1 = Integer.parseInt(per);
            int chisl = per1;
            int znam = (int)Math.pow(10, per.length()) - 1;
            chisl += numb1 * znam;

            int nod = nodFind(chisl, znam);
            return (chisl / nod) + "/" + (znam / nod);
        }
        int start2 = n.indexOf("(");
        int end2 = n.indexOf(".");
        String numb2 = n.substring(0, end2);
        String numper = n.substring(end2+1, start2);
        String per2 = n.substring(start2+1, n.length()-1);
        String all = numper + per2;
        int numb3 = numb2.isEmpty() ? 0 : Integer.parseInt(numb2);
        int all2 = Integer.parseInt(all);
        int chisl2 = all2 - Integer.parseInt(numper);
        int znam2 = (int) (Math.pow(10, all.length()) - Math.pow(10, numper.length()));
        chisl2 += numb3 * znam2;

        int nod = nodFind(chisl2, znam2);
        return (chisl2 / nod) + "/" + (znam2 / nod);
    }

    public static int nodFind(int a, int b) {
        return b == 0 ? a : nodFind(b, a % b);
    }
    public static String pilish_string(String txt) {
        // Задаем значение числа Пи в строковом формате
        String pi = "314159265358979";
        // Создаем StringBuilder для сохранения результата
        StringBuilder res = new StringBuilder();
        // Инициализируем переменную индекса для обхода строки txt
        int index = 0;
        // Проходимся по каждой цифре числа Пи и каждому символу в строке txt
        for (int i = 0; i < pi.length() && index < txt.length(); i++) {
            // Получаем числовое значение текущей цифры числа Пи
            int pipilen = Character.getNumericValue(pi.charAt(i));
            // Проверяем, достаточно ли символов осталось в строке txt, чтобы сформировать слово длиной pipilen
            if (index + pipilen <= txt.length()) {
                // Если достаточно символов, добавляем слово в результат и увеличиваем индекс
                res.append(txt, index, index + pipilen).append(' ');
                index += pipilen;
            } else {
                // Если осталось меньше символов, чем нужно для слова, формируем последнее слово
                int how = pipilen - (txt.length()-index);
                // Получаем символ, который будет повторяться в последнем слове
                String ch = txt.substring(index, index+1);
                // Добавляем оставшиеся символы в результат
                res.append(txt, index, txt.length());
                // Повторяем символ how раз и добавляем к результату
                String add = ch.repeat(how);
                res.append(add);
                // Завершаем цикл, так как все символы обработаны
                break;
            }
        }
        // Возвращаем результат в виде строки
        return res.toString();
    }
    public static String generateNonconsecutive(String txt) {
        Pattern pattern = Pattern.compile("(\\(*-?\\d+(\\.\\d+)?\\)* [+\\-*/] )*\\(*-?\\d+(\\.\\d+)?\\)*");
        if (!pattern.matcher(txt).matches()) {
            return "no correct";
        }
        txt = txt.replaceAll("\\(", "( ");
        txt = txt.replaceAll("\\)", " )");
        LinkedList<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        for (String elem : txt.split(" ")) {
            try {
                double num = Double.parseDouble(elem);
                queue.add(Double.toString(num));
            } catch (NumberFormatException ignore) {
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    stack.push(elem);
                } else if ((elem.equals("*") || elem.equals("/")) && (stack.peek().equals("+") || stack.peek().equals("-"))) {
                    stack.push(elem);
                } else if (elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/")) {
                    while (true) {
                        String top = stack.peek();
                        if (top.equals("(") || ((elem.equals("*") || elem.equals("/")) && (top.equals("+") || top.equals("-")))) {
                            break;
                        }
                        queue.add(stack.pop());
                    }
                    stack.push(elem);
                } else if (elem.equals("(")) {
                    stack.push(elem);
                } else if (elem.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        queue.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    System.out.println(elem);
                    return "no correct";
                }
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        Stack<Double> result = new Stack<>();
        while (!queue.isEmpty()) {
            String elem = queue.removeFirst();
            try {
                double num = Double.parseDouble(elem);
                result.push(num);
            } catch (NumberFormatException e) {
                switch (elem) {
                    case "+":
                        result.push(result.pop() + result.pop());
                        break;
                    case "-":
                        result.push(-result.pop() + result.pop());
                        break;
                    case "*":
                        result.push(result.pop() * result.pop());
                        break;
                    case "/":
                        double num1 = result.pop();
                        double num2 = result.pop();
                        if (num1 == 0) {
                            return "ZeroDiv";
                        }
                        result.push(num2 / num1);
                }
            }
        }
        return Double.toString(result.pop());
    }
    public static String isValid(String text) {
        // Создаем HashMap<Character, Integer> с именем map для хранения количества вхождений каждого символа
        HashMap<Character, Integer> map = new HashMap<>();

        // Проходим по каждому символу в строке text
        for (char ch : text.toCharArray()) {
            // Если символ ch не содержится в map, добавляем его в map с начальным значением 1
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                // Если символ ch уже содержится в map, увеличиваем его количество на 1
                map.put(ch, map.get(ch) + 1);
            }
        }

        // Получаем коллекцию значений из map
        var values = map.values();

        // Находим максимальное количество вхождений символа в строке
        int max = Collections.max(values);

        // Считаем количество символов с максимальным количеством вхождений
        float maxCount = values.stream().filter(x -> x == max).count();

        // Считаем количество символов с количеством вхождений на 1 меньшим, чем максимальное
        float maxCountWithout1 = values.stream().filter(x -> x == max - 1).count();

        // Проверяем, выполняется ли условие для действительной строки
        if (maxCount == values.size() || maxCountWithout1 == values.size() - 1) {
            return "YES";
        }

        // Если условие не выполняется, возвращаем "NO"
        return "NO";
    }
    public static String findLCS(String s1, String s2) {
        String[][] dp = new String[s1.length() + 1][s2.length() + 1];

        // Инициализируем первую строку массива dp пустыми строками
        for (int i = 0; i < s1.length()+1; i++) {
            dp[i][0] = "";
        }

        // Инициализируем первый столбец массива dp пустыми строками
        for (int i = 0; i < s2.length()+1; i++) {
            dp[0][i] = "";
        }

        // Заполняем остальные значения массива dp
        for (int i = 1; i < s1.length()+1; i++) {
            // Получаем символ a из строки s1
            char a = s1.charAt(i - 1);

            for (int j = 1; j < s2.length()+1; j++) {
                // Получаем символ b из строки s2
                char b = s2.charAt(j - 1);

                if (a == b) {
                    // Если символы a и b совпадают, добавляем символ a к наибольшей общей подпоследовательности
                    dp[i][j] = dp[i - 1][j - 1] + a;
                } else {
                    // Если символы a и b не совпадают, выбираем максимальную наибольшую общую подпоследовательность
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }}
        }
        return dp[s1.length()][s2.length()];
    }
}



