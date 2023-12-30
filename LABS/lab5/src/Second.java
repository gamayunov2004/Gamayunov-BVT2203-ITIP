import java.util.regex.*;

public class Second {
    public static void main(String[] args) {
        System.out.println(validate("Qwerty123"));
        System.out.println(validate("qwerty1234"));
        System.out.println(validate("qwertyyyyy"));
        System.out.println(validate("123123123123"));
        System.out.println(validate("qWe12"));
    }
    public static boolean validate(String pass) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        if (pass.matches(regex)) {
            return true;
        }
        else{
            return false;
        }
    }
}
