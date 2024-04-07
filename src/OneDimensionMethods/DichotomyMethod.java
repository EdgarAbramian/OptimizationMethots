package OneDimensionMethods;

import functionalInterfaces.IFunction1D;

import static utils.ConstValues.EPSILON;
import static utils.ConstValues.MAX_ITERATIONS;

public class DichotomyMethod {
    public static double Dichotomy(IFunction1D func, double left, double right)
    {
        return Dichotomy(func, left, right, MAX_ITERATIONS, EPSILON);
    }

    public static double Dichotomy(IFunction1D func, double left, double right, int maxIterations)
    {
        return Dichotomy(func, left, right, maxIterations, EPSILON);
    }
    public static double Dichotomy(IFunction1D func, double left, double right, int maxIterations, double epsilon) {
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
        System.out.printf("Dichotomy::function probes count : %s\n", counter * 2);
        System.out.printf("Dichotomy::function arg range    : %s\n", right - left);
        return (right + left) / 2;
    }
}