public class Main
{
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println("--------");
        System.out.println(fitCalc(15,1));
        System.out.println(fitCalc(24,2));
        System.out.println(fitCalc(41,3));
        System.out.println("--------");
        System.out.println(containers(3,4,2));
        System.out.println(containers(5,0,2));
        System.out.println(containers(4,1,4));
        System.out.println("--------");
        System.out.println(triangleType(5,5,5));
        System.out.println(triangleType(5,4,5));
        System.out.println(triangleType(3,4,5));
        System.out.println(triangleType(5,1,1));
        System.out.println("--------");
        System.out.println(ternaryEvaluation(8,4));
        System.out.println(ternaryEvaluation(1,11));
        System.out.println(ternaryEvaluation(5,9));
        System.out.println("--------");
        System.out.println(howManyItems(22f, 1.4f, 2f));
        System.out.println(howManyItems(45f, 1.8f, 1.9f));
        System.out.println(howManyItems(100f, 2f, 2f));
        System.out.println("--------");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("--------");
        System.out.println(gcd(48,18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259,28));
        System.out.println("--------");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println("--------");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }
    public static float convert(int x) {
        return x * 3.785f;
    }
    public static int fitCalc(int y, int z) {
        return y * z;
    }
    public static int containers(int x, int y, int z) {
        return 20 * x + 50 * y + 100 * z;
    }
    public static String triangleType(int x, int y, int z) {
        if (((x + y) > z) & ((x + z) > y) & ((z + y) > x)) {
            if (x == y & y == z) {
                return "equilateral";
            }
            if ((x == y && x != z) || (x == z && x != y) || (z == y && z != x)) {
                return "isosceles";
            }
            if (x != y & x != z & y != z) {
                return "different-sided";
            }
        }
        else {
            return "not a triangle";
        }
        return "";
    }
    public static int ternaryEvaluation(int x, int y) {
        return x > y ? x : y;
    }
    public static int howManyItems(float x, float a, float b) {
        return (int) (x / 2 / (a * b));
    }
    public static int factorial(int x) {
        int fact = 1;
        while (x != 0) {
            fact *= x;
            x--;
        }
        return fact;
    }
    public static int gcd(int x, int y) {
        int res = 1;
        int border = x < y ? x : y;
        for (int i=1; i <= border; i++) {
            if (x % i == 0 & y % i == 0) {
                res = i;
            }
        }
        return res;
    }
    public static int ticketSaler(int x, int y) {
        return x * y * 72 / 100;
    }
    public static int tables(int x, int y) {
        return (float) x / 2 > y ? (int) Math.ceil((float) x / 2) - y : 0;
    }
}
