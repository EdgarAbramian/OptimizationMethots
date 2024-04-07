package OneDimensionMethods;


import functionalInterfaces.IFunction1D;

import static utils.ConstValues.EPSILON;
import static utils.ConstValues.MAX_ITERATIONS;

public class GoldenRatioMethod {
    public static double MethodGoldenRatio(IFunction1D func, double left, double right, int maxIterations) {
        return MethodGoldenRatio(func,left, right, maxIterations, EPSILON);
    }

    public static double MethodGoldenRatio(IFunction1D func, double left, double right,double epsilon) {
        return MethodGoldenRatio(func,left, right,MAX_ITERATIONS,epsilon);
    }

    public static double MethodGoldenRatio(IFunction1D func, double left, double right) {
        return MethodGoldenRatio(func,left, right,MAX_ITERATIONS,EPSILON);
    }

    public static double MethodGoldenRatio(IFunction1D func, double left, double right, int maxIterations,double epsilon) {
        double phi = 2 / (1 + Math.sqrt(5)) ; // Golden ratio

        double x1 = right - (right - left) * phi;
        double x2 = left + (right - left) * phi;
        double f_left = func.call(x1);
        double f_right = func.call(x2);
        int counter = 0;

        for (; counter != maxIterations; counter++) {
                if (Math.abs(x2 - x1) < epsilon) {
                    break;
                }
                if (f_left <= f_right) {
                    right = x2;
                    x2 = x1;
                    x1 = right - (right - left) * phi;
                    f_right = f_left;
                    f_left = func.call(x1);
                } else {
                    left = x1;
                    x1 = x2;
                    x2 = left + (right - left) * phi;
                    f_left = f_right;
                    f_right = func.call(x2);
                }
            }
        System.out.printf("goldenratio::function probes count : %s\n", counter + 2);
        System.out.printf("goldenratio::function arg range    : %s\n", right - left);
        return (left + right) / 2;
    }

}
