package apps.strings;
/*
 * @author Oleg Rudoi
 * @version 1.1
 * @date 30.07.2022
 */

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // first task
        System.out.println(wordsCount(""));
        System.out.println(wordsCount("   "));
        System.out.println(wordsCount(","));
        System.out.println(wordsCount("Hello world"));
        System.out.println(wordsCount("  Hello   world  "));
        System.out.println(wordsCount("I love java!"));

        // second task
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("  "));
        System.out.println(isPalindrome(","));
        System.out.println(isPalindrome("ERE"));
        System.out.println(isPalindrome("Allo"));
        System.out.println(isPalindrome("Madam, I'm Adam"));
        System.out.println(isPalindrome("  Madam, I'm Adam"));
    }

    /**
     * Method counts the number of words in the String phrase.
     *
     * @param input String with phrase being checked
     * @return the number of words in a phrase
     */
    private static int wordsCount(String input) {
        // for works with more than one divider
        input = input.trim().replaceAll("\\W+", " ");

        if (input.isEmpty() || input.equals(" ")) {
            return 0;
        }

        String[] words = input.split("\\s");
        return words.length;
    }

    /**
     * Method checks the input String phrase is a palindrome
     *
     * @param input String with phrase being checked
     * @return true if so, otherwise - false.
     */
    private static boolean isPalindrome(String input) {
        // for works with more than one divider
        input = input.trim().replaceAll("\\W+", " ");

        if (input.isEmpty() || input.equals(" ")) {
            return false;
        }

        String symbols = input.toLowerCase(Locale.ROOT).replaceAll("\\s", "");

        for (int i = 0; i < symbols.length() / 2; i++) {
            if (symbols.charAt(i) != symbols.charAt(symbols.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}