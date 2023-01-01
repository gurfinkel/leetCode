class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] result = new int[] {-1, -1};
        int first = isPrime(left) ? left : nextPrime(left);
        int second = nextPrime(first);

        while (right >= second) {
            if (left <= first && right >= second && first != second) {
                if (result[0] == result[1] || result[1] - result[0] > second - first) {
                    result[0] = first;
                    result[1] = second;
                }
            }

            first = second;
            second = nextPrime(second);
        }

        return result;
    }

    boolean isPrime(int n) {
        if (1 == n) {
            return false;
        }

        for (int i = 2; n >= i * i; ++i) {
            if (0 == n % i) {
                return false;
            }
        }

        return true;
    }

    int nextPrime(int n) {
        int idx = n + 1;

        while (true) {
            boolean isPrime = true;

            for (int divisor = 2; divisor * divisor <= idx; divisor++) {
                if (0 == idx % divisor) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                break;
            }

            ++idx;
        }

        return idx;
    }
}
