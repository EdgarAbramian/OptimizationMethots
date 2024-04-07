package MultiDimensionMethods;


import functionalInterfaces.FunctionND;
import mathUtils.VectorProcedures;

import java.util.Arrays;
import java.util.function.Function;

import static utils.ConstValues.EPSILON;
import static utils.ConstValues.MAX_ITERATIONS;

public class MultidimensionalGoldenRatio {
    public static double[] minimizeGoldenRatio(FunctionND function, double[] left, double[] right, double eps, int maxIterations) {
        double GOLDEN_RATIO_VAL = (Math.sqrt(5) + 1) / 2;

        double[] a = Arrays.copyOf(left, left.length);
        double[] b = Arrays.copyOf(right, right.length);

        double[] c = new double[a.length];
        double[] d = new double[b.length];

        double[] x1 = new double[a.length];
        double[] x2 = new double[b.length];

        double v;
        int iterations = 0;

        for (;iterations < maxIterations; iterations++) {
            for (int i = 0; i < a.length; i++) {
                v = (b[i] - a[i]) / GOLDEN_RATIO_VAL;
                c[i] = b[i] - v;
                d[i] = a[i] + v;
            }

            for (int i = 0; i < a.length; i++) {
                v = (b[i] - a[i]) / GOLDEN_RATIO_VAL;
                x1[i] = c[i] + v;
                x2[i] = d[i] - v;
            }

            if (function.evaluate(x1) < function.evaluate(x2)) {
                b = Arrays.copyOf(d, d.length);
            } else {
                a = Arrays.copyOf(c, c.length);
            }
            if (VectorProcedures.magnitude(VectorProcedures.sub(b, a)) < eps) {
                break;
            }
        }
        System.out.printf("goldenRatio::function arg range    : %s\n", function.evaluate(VectorProcedures.center(a, b)));
        System.out.printf("goldenRatio::function probes count : %s\n", 2 + iterations);
        return VectorProcedures.center(a, b);
    }

    public static double[] minimizeGoldenRatio(FunctionND function, double[] left, double[] right, double eps){
        return minimizeGoldenRatio(function, left, right, eps, MAX_ITERATIONS);
    }

    public static double[] minimizeGoldenRatio(FunctionND function, double[] left, double[] right, int maxIterations){
        return minimizeGoldenRatio(function, left, right, EPSILON, maxIterations);
    }

    public static double[] minimizeGoldenRatio(FunctionND function, double[] left, double[] right){
        return minimizeGoldenRatio(function, left, right, EPSILON, MAX_ITERATIONS);
    }

    public static void main(String[] args) {
        // N-Dimensional Function
        Function<double[], Double> myFunction = (x) -> Math.pow(x[0], 2) + x[1]*x[1] + 1;
        FunctionND func = new FunctionND(myFunction);

        // N-Dimensional Bounds
        double[] left = new double[] { 5, 56 };
        double[] right = new double[] { 10, 10};

        // N-Dimensional Bisect Method
        double[] result = MultidimensionalGoldenRatio.minimizeGoldenRatio(func, left, right, EPSILON, 100000);
        System.out.println(func.evaluate(result));

    }
}
