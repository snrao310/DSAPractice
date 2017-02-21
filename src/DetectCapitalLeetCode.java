/**
 * Created by S N Rao on 2/21/2017.
 * <p>
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class DetectCapitalLeetCode {

    public static boolean detectCapitalUse(String word) {
        if (word.length() <= 1) return true;
        boolean firstCap = (Character.isUpperCase(word.charAt(0)));
        boolean secondCap = (Character.isUpperCase(word.charAt(1)));
        if (!firstCap && secondCap) return false;

        for (int i = 2; i < word.length(); i++) {
            char c = word.charAt(i);
            if (firstCap && secondCap) {
                if (Character.isLowerCase(c)) return false;
            }
            else if (Character.isUpperCase(c)) return false;
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("gOogle"));
    }
}
