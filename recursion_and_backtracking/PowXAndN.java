package recursion_and_backtracking;

public class PowXAndN {
    public double myPow(double x, int n) {
        if(n > 0){
            return helper(x, n);
        }
        return 1 / helper(x, -n);
    }

    private double helper(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        double halfAns = helper(x, n / 2);
        if(n % 2 != 0){
            return x * halfAns * halfAns;
        }
        return halfAns * halfAns;
    }
}
