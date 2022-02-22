package my.practice;

import java.util.HashMap;

public class FibonacciSeries {

    private FibonacciSeries(){
        //Do nothing constructor
    }

    public static long getNthTerm(int position) {
        return fib(position, new HashMap<>());
    }

    private static long fib(int n, HashMap<Integer, Long> memo) {

        if(memo.containsKey(n))
            return memo.get(n);

        if(n<=2)
            return 1;

        long nextTerm = fib(n-1, memo) + fib(n-2, memo);

        memo.put(n, nextTerm);

        return nextTerm;
    }
}