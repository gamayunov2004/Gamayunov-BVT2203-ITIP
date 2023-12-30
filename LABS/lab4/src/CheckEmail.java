import java.io.FileWriter;
import java.io.IOException;

public class CheckEmail {
    public static void main(String[] args) {
        String email = "artemka123yandex.ru";
        try {
            checkEmail(email);
        }
        catch (CustomEmailFormatException e) {
            System.err.println(e.getMessage());
            updateLog(e);
        }
    }
    public static boolean rightFormat(String email) {
        int atCount = 0;
        int atIndex = 0;
        int dotIndex = 0;
        boolean valid = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                atCount+=1;
                atIndex = i;
            }
            if (email.charAt(i) == '.') {
                dotIndex = i;
            }
        }
        if (atCount == 1 && dotIndex > atIndex && !(email.contains("..")) && !(email.contains(".@"))
                && !(email.contains("@.")) && email.charAt(email.length()-1) != '.' && email.charAt(0) != '.') {
            valid = true;
        }
        return valid;
    }
    public static void checkEmail(String email) throws CustomEmailFormatException {
        if (rightFormat(email))
            System.out.println("Успешно");
        else
            throw new CustomEmailFormatException("Неправильный адрес: " + email);
    }
    public static void updateLog(Exception e) {
        try (FileWriter writer = new FileWriter("D:\\JAVA PROJECTS\\laba4444\\src\\log.txt", true)) {
            writer.write(e.getMessage() + "\n");
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
