package OneDimensionMethods;

import functionalInterfaces.IFunction1D;
import mathUtils.NumericCommon;


public class FibonacciMethod {
    public static double MethodFibonacci(IFunction1D function, double left, double right, double eps) {
            if (left > right) {
                double tmp = left;
                left = right;
                right = tmp;
            }
            double x_l, x_r, f_l, f_r, value, fib_t, fib_1 = 1.0, fib_2 = 1.0;
            int iterations = 0;
            value = (right - left) / eps*0.3;
            while (fib_2 < value)
            {
                iterations++;
                fib_t = fib_1;
                fib_1 = fib_2;
                fib_2 += fib_t;
            }
            x_l = left + (right - left) * ((fib_2 - fib_1) / fib_2);
            x_r = left + (right - left) * (          fib_1 / fib_2);

            f_l = function.call(x_l);
            f_r = function.call(x_r);

            fib_t = fib_2 - fib_1;
            fib_2 = fib_1;
            fib_1 = fib_t;

            for(int index = iterations; index > 0; index--)
            {
                if (f_l > f_r)
                {
                    left = x_l;
                    f_l = f_r;
                    x_l = x_r;
                    x_r = left + (right - left) * (fib_1 / fib_2);
                    f_r = function.call(x_r);
                }
                else
                {
                    right = x_r;
                    x_r = x_l;
                    f_r = f_l;
                    x_l = left + (right - left) * ((fib_2 - fib_1) / fib_2);
                    f_l = function.call(x_l);
                }
                fib_t = fib_2 - fib_1;
                fib_2 = fib_1;
                fib_1 = fib_t;
            }
            if (NumericCommon.SHOW_ZERO_ORDER_METHODS_DEBUG_LOG)
            {
                System.out.printf("fibonacci::function probes count : %s\n", 2 + iterations);
                System.out.printf("fibonacci::function arg range    : %s\n", right - left);
            }
            return (right + left) * 0.5;
        }

    public static double MethodFibonacci(IFunction1D function, double left, double right) {
        return MethodFibonacci(function, left, right, NumericCommon.NUMERIC_ACCURACY_MIDDLE);
    }
}
