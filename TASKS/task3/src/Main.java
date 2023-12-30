import org.apache.commons.collections4.CollectionUtils;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you did this task" +
                " not by yourself, you have to understand every single line of code"));
        System.out.println("-------------------");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("-------------------");
        System.out.println(doesBlockFit(1, 3,5,4,5));
        System.out.println(doesBlockFit(1, 8,1,1,1));
        System.out.println(doesBlockFit(1, 2,2,1,1));
        System.out.println("-------------------");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("-------------------");
        System.out.println(countRoots(new int[] {1,-3,2}));
        System.out.println(countRoots(new int[] {2,5,2}));
        System.out.println(countRoots(new int[] {1,-6,9}));
        System.out.println("-------------------");
        System.out.println(salesData(new String[][] {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}}));
        System.out.println(salesData(new String[][] {{"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}));
        System.out.println("-------------------");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("-------------------");
        System.out.println(waveForm(new int[] {3,1,4,2,7,5}));
        System.out.println(waveForm(new int[] {1,2,3,4,5}));
        System.out.println(waveForm(new int[] {1,2,-6,10,3}));
        System.out.println("-------------------");
        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words."));
        System.out.println("-------------------");
        dataScience(new int[][] {{1,2,3,4,5},
                {6,7,8,9,10},
                {5,5,5,5,5},
                {7,4,3,14,2},
                {1,0,11,10,1}});
        System.out.println("");
        dataScience(new int[][] {{6,4,19,0,0},
                {81,25,3,1,17},
                {48,12,60,32,14},
                {91,47,16,65,217},
                {5,73,0,4,21}});
    }

    public static String replaceVowels(String word) {
        String vovels = "aeyuio";
        for (int i = 0; i < word.length(); i++)
            for (int j = 0; j < vovels.length(); j++)
                if (Character.toLowerCase(word.charAt(i)) == vovels.charAt(j))
                    word = word.replace(word.charAt(i), '*');
        return word;
    }
    public static String stringTransform(String term) {
        String replaced = "";
        for (int i=0; i<term.length(); i++) {
            if (i+1<term.length() && term.charAt(i) == term.charAt(i+1)) {
                replaced += "Double" + Character.toUpperCase(term.charAt(i));
                i++;
            }
            else
                replaced += Character.toString(term.charAt(i));
        }
        return replaced;
    }
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        int[] block = new int[] {a,b,c};
        Arrays.sort(block);
        return Math.min(w,h) >= block[0] && Math.max(w,h) >= block[1];
    }
    public static boolean numCheck(int num) {
        int x = num;
        int res = 0;
        while (x>0) {
            res += (x%10)*(x%10);
            x/=10;
        }
        return num%2 == res%2;
    }
    public static int countRoots(int[] coefs) {
        int a = coefs[0];
        int b = coefs[1];
        int c = coefs[2];
        double D = b*b - 4*a*c;
        int count = 0;
        double x1 = (-b - Math.sqrt(D)) / (2*a);
        double x2 = (-b + Math.sqrt(D)) / (2*a);
        if (x1 == Math.floor(x1))
            count++;
        if (x2 == Math.floor(x2))
            count++;
        if (x1==x2)
            count--;
        return count;
    }
    public static ArrayList<String> salesData(String[][] sales) {
        int maxLen = 0;
        for (int i=0; i<sales.length; i++) {
            maxLen = Math.max(sales[i].length, maxLen);
        }
        ArrayList<String> answer = new ArrayList<>();
        for (int i=0; i<sales.length; i++) {
            if (sales[i].length == maxLen) {
                answer.add(sales[i][0]);
            }
        }
        return answer;
    }


    public static boolean validSplit(String str) {
        String[] words = str.split(" ");

        List<String> wordList = Arrays.asList(words);

        List<List<String>> permutations = new ArrayList<>(CollectionUtils.permutations(wordList));

        String[][] permutationsArray = new String[permutations.size()][wordList.size()];

        for (int i = 0; i < permutations.size(); i++) {
            permutationsArray[i] = permutations.get(i).toArray(new String[0]);
        }

        for (String[] permutation : permutationsArray)
            if (validSplitLogic(permutation))
                return true;
        return false;
    }
    public static boolean validSplitLogic(String[] str) {
        String res = "";
        String string = Arrays.toString(str).replace("[","").replace("]","").replace(",","");
        for (int i=0; i < string.length(); i++)
            if (string.charAt(i) == ' ' && i-1
                    > 0 && i+1 < string.length())
                res += Character.toString(string.charAt(i-1)) + Character.toString(string.charAt(i+1));
        for (int i=0; i < res.length(); i++) {
            if (res.charAt(i) == res.charAt(i+1) && i+1<res.length()) {
                i++;
            }
            else
                return false;
        }
        return true;
    }

    public static boolean waveForm(int[] nums) {
        //3,1,4,2,7,5
        String mask = "";
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i]-nums[i+1]>0)
                mask+="+";
            else
                mask+="-";
        }
        if (mask.length()%2!=0)
            mask+=mask.charAt(mask.length()-2);
        System.out.println(mask);
        String answ = "";
        if (mask.charAt(0) == '+')
            answ = mask.replace("+-", "");
        if (mask.charAt(0) == '-')
            answ = mask.replace("-+", "");
        //System.out.println(answ);
        return answ.length()==0;
    }
    public static char commonVowel(String str) {
        str = str.toLowerCase();
        char[] vowels = {'a','e','y','u','i','o'};
        int[] counts = new int[vowels.length];
        for (int i=0; i<str.length(); i++)
            for (int j=0; j<vowels.length; j++)
                if (str.charAt(i) == vowels[j])
                    counts[j]++;

        int maxIndex = 0;
        int maxValue = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > maxValue) {
                maxValue = counts[i];
                maxIndex = i;
            }
        }
        return vowels[maxIndex];
    }
    public static void dataScience(int[][] matrix) {
        for (int i=0; i<matrix.length;i++) {
            matrix[i][i] = 0;
            for (int j=0; j<matrix.length; j++) {
                if (i != j) {
                    matrix[i][i] += matrix[j][i];
                }
            }
            matrix[i][i] = Math.round(matrix[i][i]/4f);
        }
        for (int[] row: matrix)
            System.out.println(Arrays.toString(row));
    }
}
