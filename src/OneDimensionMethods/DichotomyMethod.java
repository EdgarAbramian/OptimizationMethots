package OneDimensionMethods;

import functionalInterfaces.IFunction1D;

import static mathUtils.NumericCommon.SHOW_DEBUG_LOG;
import static utils.ConstValues.EPSILON;
import static utils.ConstValues.MAX_ITERATIONS;

public class DichotomyMethod {
    public static double Dichotomy(IFunction1D func, double left, double right, boolean showDebugLog)
    {
        return Dichotomy(func, left, right, MAX_ITERATIONS, EPSILON, showDebugLog);
    }

    public static double Dichotomy(IFunction1D func, double left, double right, int maxIterations, boolean showDebugLog)
    {
        return Dichotomy(func, left, right, maxIterations, EPSILON, showDebugLog);
    }
    public static double Dichotomy(IFunction1D func, double left, double right, int maxIterations, double epsilon, boolean showDebugLog) {
        int counter = 0;
        double xc;

        for (; counter != maxIterations; counter++) {
            xc = (right + left) * 0.5;
            if (func.call(xc + epsilon) < func.call(xc - epsilon)) {
                right = xc;
            }
            else {
                left = xc;
            }

            if (Math.abs(right - left) < 2 * epsilon) {
                break;
            }
        }

        if (showDebugLog == SHOW_DEBUG_LOG) {
            System.out.printf("Dichotomy::function probes count : %s\n", counter * 2);
            System.out.printf("Dichotomy::function arg range    : %s\n", right - left);
        }
        return (right + left) / 2;
    }
}