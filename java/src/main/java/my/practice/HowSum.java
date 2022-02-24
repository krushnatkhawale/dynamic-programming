package my.practice;

import java.util.Arrays;
import java.util.HashMap;

public class HowSum {

    private HowSum(){
        //Do nothing constructor
    }

    public static int[] howSum(int targetSum, int[] numbers) {
        return howSum(targetSum, numbers, new HashMap<>());
    }
    public static int[] howSum(int targetSum, int[] numbers, HashMap<Integer, int[]> memo) {

        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum==0) return new int[]{};
        if(targetSum<0) return null;

        for(int number : numbers){
            final int[] newCombo = howSum(targetSum - number, numbers, memo);
            if(newCombo!=null){
                final int[] updatedCombo = Arrays.copyOf(newCombo, newCombo.length+1);
                updatedCombo[newCombo.length] = number;
                memo.put(targetSum, updatedCombo);
                return updatedCombo;
            }
        }

        memo.put(targetSum, null);
        return null;
    }
}