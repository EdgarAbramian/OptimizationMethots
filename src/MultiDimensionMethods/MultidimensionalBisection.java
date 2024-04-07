package MultiDimensionMethods;

import functionalInterfaces.FunctionND;
import mathUtils.VectorProcedures;

import java.util.function.Function;

import static utils.ConstValues.EPSILON;
import static utils.ConstValues.MAX_ITERATIONS;

public class MultidimensionalBisection {
    public static double[] minimizeBisect(FunctionND function, double[] left, double[] right, double eps, int maxIterations ) {
        double[] lhs =  left;
        double[] rhs = right;
        double[] center = VectorProcedures.center(lhs, rhs);
        int iterations = 0;

        for (; iterations < maxIterations; iterations++) {
            if (function.magnitude(center) < 2 * eps) {
                    break;
            }
            center = VectorProcedures.center(lhs, rhs);
            if (function.evaluate(lhs) < function.evaluate(rhs)) {
                rhs = center;
            } else {
                lhs = center;
            }
        }
        System.out.printf("biSect::function arg range    : %s\n", function.evaluate(center));
        System.out.printf("biSect::function probes count : %s\n", 2 * iterations);
        return VectorProcedures.center(lhs, rhs);
    }
    public static double[] minimizeBisect(FunctionND function, double[] left, double[] right, double eps) {
        return minimizeBisect(function, left, right, eps, MAX_ITERATIONS);
    }

    public static double[] minimizeBisect(FunctionND function, double[] left, double[] right, int maxIterations) {
        return minimizeBisect(function, left, right, EPSILON, maxIterations);
    }

    public static double[] minimizeBisect(FunctionND function, double[] left, double[] right) {
        return minimizeBisect(function, left, right, EPSILON, MAX_ITERATIONS);
    }



    public static void main(String[] args) {
        // N-Dimensional Function
        Function<double[], Double> myFunction = (x) -> Math.pow(x[0], 2) + x[1]*x[1] + 1;
        FunctionND func = new FunctionND(myFunction);

        // N-Dimensional Bounds
        double[] left = new double[] { 5, 56 };
        double[] right = new double[] { 10, 10};

        // N-Dimensional Bisect Method
        double[] result = MultidimensionalBisection.minimizeBisect(func, left, right);

    }
}















