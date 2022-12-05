package DynamicProgramming;

public class Fib {
    public int fibMemoized(int num, int[] memo){
        if(memo[num] != 0) return memo[num];
        if(num<=2) return 1;
        int result = fibMemoized(num-1,memo)+fibMemoized(num-2,memo);
        memo[num]=result;
        return result;
    }

    public int fibRegular(int num){
        if(num<=2) return 1;
        return fibRegular(num-1)+fibRegular(num-2);
    }

    public static void main(String args[]){
        Fib fib = new Fib();
        int num = 45;
        int[] arr = new int[num+1];
        System.out.println("using memoized fib to get the result "+fib.fibMemoized(num,arr));
        System.out.println("using regular fib to get the result "+fib.fibRegular(45));

    }
}
