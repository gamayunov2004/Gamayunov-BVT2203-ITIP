import java.util.regex.*;

public class Fourth {
    public static void main(String[] args) {
        System.out.println(ipCheck("255.255.255.255"));
        System.out.println(ipCheck("192.168.0.1"));
        System.out.println(ipCheck("254.0.000.0"));
    }
    public static boolean ipCheck(String ip) {
        String part = "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)";
        String regex = part + "\\." + part + "\\." + part + "\\." + part;
        if (ip.matches(regex)) {
            return true;
        }
        else {
            return false;
        }
    }
}
