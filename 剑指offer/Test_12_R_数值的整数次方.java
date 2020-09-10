/*

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0

 */

public class Test_12_R_数值的整数次方 {
    public double Power(double base, int exponent) {
        double result = 1,curr = base;
        int n = exponent;
        if (base == 0){
            return 0;
        }else if (exponent == 0){
            return 1;
        }else if (exponent < 0){
            n = -n;
        }

        while (n != 0){
            if ((n&1) == 1)
                result *= curr;
            curr *= curr;
            n = n >> 1;
        }
        return exponent>0?result:(1/result);
    }
}
