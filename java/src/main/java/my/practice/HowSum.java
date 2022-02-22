package my.practice;

import java.util.Arrays;

public class HowSum {

    private HowSum(){
        //Do nothing constructor
    }

    public static int[] howSum(int targetSum, int[] numbers) {

        if(targetSum==0)
            return new int[]{};
        if(targetSum<0)
            return null;

        for(int number : numbers){
            final int[] newCombo = howSum(targetSum - number, numbers);
            if(newCombo!=null){
                final int[] updatedCombo = Arrays.copyOf(newCombo, newCombo.length+1);
                updatedCombo[newCombo.length] = number;
                return updatedCombo;
            }
        }

        return null;
    }
}