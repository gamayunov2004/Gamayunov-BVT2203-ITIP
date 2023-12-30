import java.util.regex.*;

public class Third {
    public static void main(String[] args) {
        String text = "lalalalala asdfasdf www.youtube.com askdfaskdf";
        System.out.println(replacer(text));
    }
    public static String replacer(String s) {
        String regex = "\\b(?:https?://)?(?:www\\.)?([a-zA-Z0-9-]+\\.[a-z]{2,})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String address = matcher.group(1);
            String replacement = "https://" + address;
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
