package my.practice;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

    public static int check(String targetString, String[] wordBank) {
        return count(targetString, wordBank, new HashMap<>());
    }

    private static int count(String targetString, String[] wordBank, Map<String, Integer> memo) {

        if(memo.containsKey(targetString)) return memo.get(targetString);
        if("".equals(targetString)) return 1;

        int totalConstructCount = 0;
        for(String word : wordBank){

            if(targetString.indexOf(word)==0){
                final int constructCount = count(targetString.substring(word.length()), wordBank, memo);
                totalConstructCount += constructCount;
            }
        }

        memo.put(targetString, totalConstructCount);
        return totalConstructCount;
    }
}