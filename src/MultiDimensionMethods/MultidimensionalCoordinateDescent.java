package MultiDimensionMethods;

import functionalInterfaces.FunctionND;

import java.util.Arrays;

public class MultidimensionalCoordinateDescent {
    public static double[] minimizeCoordinateDescent(double[] startPoint, double stepSize, int maxIterations, double tolerance, FunctionND function) {
        double[] currentPoint = startPoint.clone();
        double[] prevPoint = startPoint.clone();
        boolean converged = false;
        int iterations = 0;

        while (!converged && iterations < maxIterations) {
            for (int i = 0; i < currentPoint.length; i++) {
                double[] nextPoint = currentPoint.clone();
                nextPoint[i] -= stepSize;
                if (function.evaluate(nextPoint) < function.evaluate(currentPoint)) {
                    currentPoint = nextPoint;
                } else {
                    double[] left = currentPoint.clone();
                    double[] right = nextPoint.clone();
                    double[] result = MultidimensionalBisection.minimizeBisect(function, left, right, false);
                    if (function.evaluate(result) < function.evaluate(currentPoint)) {
                        currentPoint = result;
                    }
                }
            }

            converged = hasConverged(currentPoint, prevPoint, tolerance);
            prevPoint = currentPoint.clone();
            iterations++;
        }

        System.out.println("Количество итераций: " + iterations);
        System.out.println("Точка минимума: " + (Arrays.toString(currentPoint)));

        return currentPoint;
    }

    private static boolean hasConverged(double[] currentPoint, double[] prevPoint, double tolerance) {
        for (int i = 0; i < currentPoint.length; i++) {
            if (Math.abs(currentPoint[i] - prevPoint[i]) > tolerance) {
                return false;
            }
        }
        return true;
    }
}