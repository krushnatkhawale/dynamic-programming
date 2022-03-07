package my.practice;

import java.util.HashMap;

public class CanConstruct {
    public static boolean check(String targetString, String[] wordBank) {

        return canConstruct(targetString, wordBank, new HashMap<>());
    }

    private static boolean canConstruct(String targetString, String[] wordBank, HashMap<String, Boolean> memo) {

        if(memo.containsKey(targetString)) return memo.get(targetString);
        if("".equals(targetString)) return true;

        for (String word : wordBank) {
            if (targetString.indexOf(word) == 0) {
                String suffix = targetString.substring(word.length());
                if (canConstruct(suffix, wordBank, memo)) {
                    memo.put(targetString, true);
                    return true;
                }
            }
        }

        memo.put(targetString, false);
        return false;
    }
}