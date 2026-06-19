import java.util.Vector;
import java.util.Collections;

/*
    1s compliment - flip digits of Binary representation
    2s compliment - 1s compliment + 1

    AND - All 1 -> 1 otherwise 0
    OR - 1 T -> T. Both F -> F
    XOR - no of 1s odd -> 1, no of 1s even -> 0
    Right shift >> == divide by 2 i.e n/2^k
    Left shift << == multiply by 2 i.e n * 2^k

    31st bit reserved for sign

    NOT - 1. Flip digits
          2. IF -ve -> 2's compliment else STOP

    -ve number is stored as 2s compliment.



 */

class BitManipulation {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.convertDecimalToBinary(10));
//        System.out.println(sol.convertDecimalToBinary("1010"));
        //sol.swap2Numbers(5,6);
//        sol.clearIthBit(98, 2);

        System.out.println(sol.countTheNumberOfSetBits1(2 ^ 30));
        System.out.println(sol.countTheNumberOfSetBits2(2 ^ 30));
    }
}

class Solution {
    String convertDecimalToBinary(int n) {
        StringBuilder str = new StringBuilder();

        while(n > 0) {
            str.append(n % 2);
            n /= 2;
        }
        return str.reverse().toString();
    }

    int convertDecimalToBinary(String s) {
        int decimal = 0;
        int multiple = 1;

        for(int i = s.length() - 1;i >= 0;i--) {
            decimal += (s.charAt(i) - '0') * multiple;
            multiple *= 2;
        }
        return decimal;
    }

    void swap2Numbers(int a, int b) {
        System.out.println(a);
        System.out.println(b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }

    boolean checkIfIthBitIsSet(int n, int k) {
        return (n & (1 << k)) != 0;
        //return ((n >> k) & 1) == 1;
    }

    void setIthBit(int n, int k) {
        /*
        (n | 1 << k);
         */
    }

    void clearIthBit(int n, int i) {
        System.out.println(n & ~(1 << i));
    }

    void toggleTheIthBit(int n, int i) {
        //(n ^ (1 << i))
    }

    void removeTheLastSetBit(int n, int i) {
        //n & (n - 1)
    }

    void checkIfTheNumberIsPowerOf2(int n) {
        //n & (n - 1) == 0;
    }

    //Worst time complexity O(31) or O(num of set bits)
    int countTheNumberOfSetBits1(int n) {
        int count = 0;
        while(n > 0) {
            count += (n & 1) == 1 ? 1 : 0;
            n = n >> 1;
        }
        return count;
    }

    int countTheNumberOfSetBits2(int n) {
        int count = 0;
        while(n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}