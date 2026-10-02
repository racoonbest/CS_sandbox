import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ExerciseTests {
    private static int checks;

    public static void main(String[] args) {
        for (int value : new int[] {Integer.MIN_VALUE, -1, 0, 1, 4, 49, 121, 2147395600}) {
            check(!Exercise06_10.isPrime(value), "Not prime: " + value);
        }
        for (int value : new int[] {2, 3, 5, 97, 9973, Integer.MAX_VALUE}) {
            check(Exercise06_10.isPrime(value), "Prime: " + value);
        }
        for (int limit : new int[] {Integer.MIN_VALUE, -1, 0, 4}) {
            check(Exercise06_10.pairPrime(limit) == 0, "No twin primes through " + limit);
        }
        check(Exercise06_10.pairPrime(5) == 1, "First twin-prime pair");
        check(Exercise06_10.pairPrime(7) == 2, "Inclusive upper limit");
        check(Exercise06_10.pairPrime(100) == 8, "Twin primes through 100");
        check(Exercise06_10.pairPrime(1000) == 35, "Twin primes through 1000");
        int count = 0;
        for (int value = 2; value < 10000; value++) {
            if (Exercise06_10.isPrime(value)) count++;
        }
        check(count == 1229, "Primes below 10000");
        check(pattern(0).isEmpty(), "Zero rows");
        check(pattern(-3).isEmpty(), "Negative rows");
        check(pattern(1).equals("1 \n"), "One row");
        check(pattern(3).equals("    1 \n  2 1 \n3 2 1 \n"), "Three aligned rows");
        System.out.println(checks + " checks passed");
    }

    private static String pattern(int rows) {
        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (PrintStream capture = new PrintStream(output)) {
            System.setOut(capture);
            Exercise06_06.displayPattern(rows);
        } finally {
            System.setOut(original);
        }
        return output.toString().replace("\r\n", "\n");
    }

    private static void check(boolean condition, String description) {
        checks++;
        if (!condition) throw new AssertionError(description);
    }
}
