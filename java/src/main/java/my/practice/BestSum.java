package my.practice;

import java.util.Arrays;
import java.util.HashMap;

public class BestSum {
    public static int[] bestSum(int targetSum, int[] numbers) {
        return bestSum(targetSum, numbers, new HashMap<Integer, int[]>());
    }
    public static int[] bestSum(int targetSum, int[] numbers, HashMap<Integer, int[]> memo) {

        if(memo.containsKey(targetSum))
            return memo.get(targetSum);

        if(targetSum==0) return new int[]{};
        if(targetSum<0) return null;

        int[] bestSum = null;

        for (int number : numbers){
            final int[] aBestSum = bestSum(targetSum - number, numbers, memo);
            if(aBestSum!=null){
                int[] updatedSum = Arrays.copyOf(aBestSum, aBestSum.length + 1);
                updatedSum[aBestSum.length] = number;

                if(bestSum == null || updatedSum.length < bestSum.length){
                    bestSum = updatedSum;
                }
            }
        }

        memo.put(targetSum, bestSum);
        return bestSum;
    }
}
