public class Exercise06_10 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println("The number of prime number < 10000 is " + count);
        System.out.println("Pair Primes is: " + pairPrime(1000));
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int divisor = 2; divisor <= number / divisor; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static int pairPrime(int n) {
        if (n < 5) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i <= n - 2; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                count++;
            }
        }
        return count;
    }
}
