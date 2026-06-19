class SumOfNNumbersRecursion {
    public static void main(String[] args) {
        System.out.println(addNNumbers(100));
    }

    public static int addNNumbers(int n) {
        if(n == 0) { return 0; }
        return n + addNNumbers(n - 1);
    }
}