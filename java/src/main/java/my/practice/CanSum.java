package my.practice;

import java.util.HashMap;

public class CanSum {

    public static boolean canSum(int targetSum, int[] numbers){
        return check(targetSum, numbers,new HashMap<>());
    }

    private static boolean check(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {

        if( memo.containsKey(targetSum) )
            return memo.get(targetSum);

        if(targetSum==0) return  true;
        if(targetSum<0) return false;

        for(int number : numbers){
            final int remainder = targetSum - number;
            if(check(remainder, numbers, memo))
                memo.put(targetSum, true);
                return true;
        }

        memo.put(targetSum, false);
        return false;
    }
}