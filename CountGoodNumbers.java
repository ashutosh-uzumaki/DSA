public class CountGoodNumbers {
    private final int MOD = (int)(1e9 + 7);

    public int countGoodNumbers(long n) {
        long evenDigits = (n + 1) / 2;
        long oddDigits = n / 2;

        long count = (pow(5, evenDigits) * pow(4, oddDigits)) % MOD;
        return (int) count;
    }

    private long pow(long x, long n) {
        if (n == 0) return 1;

        long half = pow(x, n / 2);

        long result = (half * half) % MOD;

        if (n % 2 == 1) {
            result = (result * x) % MOD;
        }

        return result;
    }
}

// Hint:
// If leading zero is not allowed,
// handle index 0 separately (since it's an even index):
// - index 0 → 4 choices (2,4,6,8)
// - remaining even positions → 5 choices
// - odd positions → 4 choices
//
// So multiply the result by 4 once,
// and reduce even count by 1.

//long evenDigits = (n + 1) / 2 - 1;
//long result = (4 * pow(5, evenDigits)) % MOD;
