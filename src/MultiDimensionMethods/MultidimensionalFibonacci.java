package MultiDimensionMethods;


import functionalInterfaces.FunctionND;
import mathUtils.VectorProcedures;

import java.util.Arrays;

import static utils.ConstValues.EPSILON;

public class MultidimensionalFibonacci {
    public static double[] minimizeFibonacci(FunctionND function, double[] left, double[] right, double eps) {
        int iterations = getFibonacciNumberCount(eps);// Max iterations count depends on fibonacci sequence

        double[] a = Arrays.copyOf(left, left.length);
        double[] b = Arrays.copyOf(right, right.length);

        double[] c = new double[a.length];
        double[] d = new double[b.length];

        for (int i = 0; i < iterations - 1; i++) {
            for (int j = 0; j < a.length; j++) {
                c[j] = a[j] + (double) (fibonacci(iterations - i - 2)) / fibonacci(iterations - i) * (b[j] - a[j]);
                d[j] = a[j] + (double) (fibonacci(iterations - i - 1)) / fibonacci(iterations - i) * (b[j] - a[j]);
            }

            if (function.evaluate(c) < function.evaluate(d)) {
                for (int j = 0; j < a.length; j++) {
                    b[j] = d[j];
                }
            } else {
                for (int j = 0; j < a.length; j++) {
                    a[j] = c[j];
                }
            }
        }
        System.out.printf("biSect::function arg range    : %s\n", function.evaluate(VectorProcedures.center(a, b)));
        System.out.printf("biSect::function probes count : %s\n", iterations);
        return VectorProcedures.center(a, b);
    }

    public static double[] minimizeFibonacci(FunctionND function, double[] left, double[] right) {
        return minimizeFibonacci(function, left, right, EPSILON);
    }

    private static int getFibonacciNumberCount(double epsilon) {
        int a = 0;
        int b = 1;
        int count = 1;
        while (fibonacci(count + 1) < 1 / epsilon) {
            int next = a + b;
            a = b;
            b = next;
            count++;
        }
        return count;
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
