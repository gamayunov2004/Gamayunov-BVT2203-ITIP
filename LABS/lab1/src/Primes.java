public class Primes {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            int x = i;
            if (isPrime(x) == true)
                System.out.println(x);
        }
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
