import java.util.Arrays;

public class Main
{
    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println("------------");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println("------------");
        System.out.println(differenceEvenOdd(new int[] {44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[] {22, 50, 16, 63, 31, 55}));
        System.out.println("------------");
        System.out.println(equalToAvg(new int[] {1,2,3,4,5}));
        System.out.println(equalToAvg(new int[] {1,2,3,4,5,6}));
        System.out.println("------------");
        System.out.println(indexMult(new int[] {1,2,3}));
        System.out.println(indexMult(new int[] {3,3,-2,408,3,31}));
        System.out.println("------------");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println("------------");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println("------------");
        System.out.println(pseudoCash(5));
        System.out.println(pseudoCash(10));
        System.out.println(pseudoCash(0));
        System.out.println("------------");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println("------------");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
        System.out.println("------------");
    }
    public static boolean duplicateChars(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            for (int j = i+1; j < word.length(); j++) {
                char x = word.charAt(i);
                char y = word.charAt(j);
                if (x==y)
                    return true;
            }
        }
        return false;
    }
    public static String getInitials(String name) {
        String initials = "";
        name = name.replace(" ", "");
        for (int i=0; i < name.length(); i++) {
            char x = Character.toUpperCase(name.charAt(i));
            char y = name.charAt(i);
            if (x==y)
                initials+=x;
        }
        return initials;
    }
    public static int differenceEvenOdd(int[] nums) {
        int even = 0;
        int odd = 0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                even+=nums[i];
            else
                odd+=nums[i];
        }
        return Math.abs(even-odd);
    }
    public static boolean equalToAvg(int[] array) {
        float avg = 0;
        for (int i=0; i<array.length; i++)
            avg+=array[i];
        for (int j=0; j<array.length; j++)
            if (array[j] == avg / array.length)
                return true;
        return false;
    }
    public static String indexMult(int[] massive) {
        int[] res = new int[massive.length];
        for (int i=0; i<massive.length; i++)
            res[i] = i*massive[i];
        return Arrays.toString(res);
    }
    public static String reverse(String straight) {
        String reversed = "";
        for (int i = straight.length() - 1; i>=0; i--)
            reversed += straight.charAt(i);
        return reversed;
    }
    public static int Tribonacci(int num) {
        int[] trib = new int[num];
        trib[0] = trib[1] = 0;
        trib[2] = 1;
        for (int i=3; i<num; i++)
            trib[i] = trib[i-1] + trib[i-2] + trib[i-3];
        return trib[num-1];
    }
    public static String pseudoCash(int n) {
        String alphabet = "abcdef0123456789";
        String cash = "";
        for (int i=0; i<n; i++)
            cash += alphabet.charAt((int)(Math.random()*alphabet.length()));
        return cash;
    }
    public static String botHelper(String message) {
        for (int i=0; i<message.length()-3; i++) {
            message = message.toLowerCase();
            char h=message.charAt(i);
            char e=message.charAt(i+1);
            char l=message.charAt(i+2);
            char p=message.charAt(i+3);
            if (h=='h' && e=='e' && l=='l' && p=='p')
                return "Calling for a staff member";
        }
        return "Keep waiting";
    }
    public static boolean isAnagram(String x, String y) {
        char[] charsX = x.toCharArray();
        char[] charsY = y.toCharArray();
        Arrays.sort(charsX);
        Arrays.sort(charsY);
        String sortedX = new String(charsX);
        String sortedY = new String(charsY);
        return sortedX.equals(sortedY) ? true : false;
    }
}
