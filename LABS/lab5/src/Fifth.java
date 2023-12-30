import java.util.regex.*;

public class Fifth {
    public static void main(String[] args) {
        finder("babushka aaaa ssss qwerq Bobik 123", 'b');
    }
    public static void finder(String text, char letter) {
        if (!Character.isLetter(letter)) {
            System.out.println("Incorrect symbol");
            return;
        }
        String regex = "\\b" + "\\b\\p{L}*" + letter;
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
