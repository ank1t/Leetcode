class CheckIfStringIsPalindrome {
    public static void main(String[] args) {
        System.out.println(checkIfStringIsPalindrome(""));
    }

    public static boolean checkIfStringIsPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1) { return true; }
        if(s.length() == 2) { return s.charAt(0) == s.charAt(1); }
        return performPalindromeCheck(s, 0);
    }

    private static boolean performPalindromeCheck(String s, int n) {
        if(n >= s.length()/2) { return true; }

        if(s.charAt(n) != s.charAt(s.length() - 1 - n)) { return false; }

        return performPalindromeCheck(s, n + 1);
    }
}