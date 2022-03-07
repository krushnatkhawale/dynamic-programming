package my.practice;

public class CanConstruct {
    public static boolean check(String targetString, String[] wordBank) {

        if("".equals(targetString)) return true;

        for (String word : wordBank) {
            if (targetString.indexOf(word) == 0) {
                String suffix = targetString.substring(word.length());
                if (check(suffix, wordBank)) {
                    return true;
                }
            }
        }

        return false;
    }
}