import java.util.Arrays;
import java.util.Vector;

import static java.lang.Math.max;

class Maths {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.gcd(15, 13));
//
//        System.out.println(Arrays.toString(solution.printAllDivisorsOfANumber(49)));
//        System.out.println(Arrays.toString(solution.printAllDivisorsOfANumber(36)));

//        System.out.println(solution.checkIfNumberIsPrime(2));

//        System.out.println(solution.findPower(3, 9));
//        System.out.println(Arrays.toString(solution.sieveOfEratosthenesOrPrintAllPrimeNumbersUntil(1)));

//        System.out.println(solution.countPrimeInRangeLR(3, 10));
        solution.primeFactorizationOfANumber(99);
    }
}

class Solution {
    int gcd(int a, int b) {
        while(a > 0 && b > 0) {
            if(a > b)a = a % b;
            else b = b % a;
        }
        return max(a,b);
    }

    int[] printAllDivisorsOfANumber(int n) {
        Vector<Integer> list = new Vector<>();

        for(int i = 1;i * i <= n;i++) {
            if(n % i == 0) {
                list.add(i);
                if(n/i != i) list.add(n/i);
            }
        }

        int[] ans = new int[list.size()];
        for(int i = 0;i < list.size();i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    boolean checkIfNumberIsPrime(int n) {
        if(n == 1) return false;
        int count = 2;
        for(int i = 2;i * i <= n;i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    int[] printAllPrimeFactorsOfNumber1(int n) {
        Vector<Integer> vector = new Vector<>();

        for(int i = 1;i * i <= n;i++) {
            if(n % i == 0) {
                if(checkIfNumberIsPrime(i)) vector.add(i);
                if(n/i != i && checkIfNumberIsPrime(n/i)) vector.add(n/i);
            }
        }

        int[] ans = new int[vector.size()];
        for(int i = 0;i < vector.size();i++) {
            ans[i] = vector.get(i);
        }
        return ans;
    }

    int[] printAllPrimeFactors2(int n) {
        Vector<Integer> v = new Vector<>();

        for(int i = 2; i * i <= n;i++) {
            if(n % i == 0) {
                v.add(i);
                while(n % i == 0) n /= i;
            }
        }
        //For a prime number
        if(n != 1) v.add(n);

        int[] ans = new int[v.size()];
        for(int i = 0;i < v.size();i++) {
            ans[i] = v.get(i);
        }
        return ans;
    }

    int findPower(int x, int n) {
        if(n == 1) return x;
        int ans = 1;

        while(n > 0) {
            if(n % 2 == 0) {
                n /= 2;
                x = x * x;
            } else {
                n -= 1;
                ans = ans * x;
            }
        }
        return ans;
    }

    int[] sieveOfEratosthenesOrPrintAllPrimeNumbersUntil(int n) {
        int[] prime = new int[n + 1];

        for(int i = 2; i * i <= n;i++) {
            if(prime[i] == 0) {
                for(int j = i * i; j<= n;j += i) prime[j] = 1;
            }
        }

        Vector<Integer> v = new Vector<>();
        for(int i = 2;i < n;i++) {
            if(prime[i] == 0) v.add(i);
        }

        int[] ans = new int[v.size()];
        for(int i = 0;i< v.size();i++) {
            ans[i] = v.get(i);
        }

        return ans;
    }

    int[] getSieve(int n) {
        int[] prime = new int[n + 1];

        for(int k = 2;k <= n;k++) prime[k] = 1;
        for(int i = 2;i * i <= n;i++) {
            if(prime[i] == 1) {
                for(int j = i * i;j <=n;j+=i) prime[j] = 0;
            }
        }
        return prime;
    }

    int countPrimeInRangeLR(int l, int r) {
        int n = 10000;
        int[] sieve = getSieve(n);
        int count = 0;
        for(int i = 2;i < sieve.length;i++) {
            count = count + sieve[i];
            sieve[i] = count;
        }

        return sieve[r] - sieve[l - 1];
    }

    int[] smallestPrimeFactor(int n) {
        int[] spf = new int[n + 1];

        for(int i=1;i<=n;i++) spf[i] = i;

        for(int i = 2;i * i <= n;i++) {
            if(spf[i] == i) {
                for(int k=i * i;k<=n;k+=i) {
                    if(spf[k] == k) spf[k] = i;
                }
            }
        }
        return spf;
    }

    void primeFactorizationOfANumber(int n) {
        int[] spf = smallestPrimeFa\ctor(100);

        while(n != 1) {
            System.out.println(spf[n]);
            n = n / spf[n];
        }
    }
}