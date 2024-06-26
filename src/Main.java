import MultiDimensionMethods.MultidimensionalBisection;
import MultiDimensionMethods.MultidimensionalFibonacci;
import MultiDimensionMethods.MultidimensionalGoldenRatio;
import MultiDimensionMethods.MultidimensionalCoordinateDescent;

import functionalInterfaces.FunctionND;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        /////////////////////////////
        ///////////1-DIM/////////////
        //////////////////////////////

        // 1-Dimensional Methods
        //functionalInterfaces.IFunction1D func = (x) -> x * x;
        //OneDimensionMethods.DichotomyMethod.Dichotomy(func, 0.5, 1);
        //OneDimensionMethods.FibonacciMethod.MethodFibonacci(func, 0.5, 1);
        //OneDimensionMethods.GoldenRatioMethod.MethodGoldenRatio(func, 0.5, 1);



        /////////////////////////////
        ///////////N-DIM/////////////
        //////////////////////////////

        // N-Dimensional Function
        Function<double[], Double> myFunction = (x) -> Math.pow(x[0], 2) + x[1] + 1;
        FunctionND funcND = new FunctionND(myFunction);

        // N-Dimensional Bounds
        double[] left = new double[] { 5, 56 };
        double[] right = new double[] { 10, 10};

        // N-Dimensional Methods
        System.out.println("<<<MultidimensionalBisection>>>");
        MultidimensionalBisection.minimizeBisect(funcND, left, right, true);
        System.out.println("\n\n<<<MultidimensionalGoldenRatio>>>");
        MultidimensionalGoldenRatio.minimizeGoldenRatio(funcND, left, right);
        System.out.println("\n\n<<<MultidimensionalFibonacci>>>");
        MultidimensionalFibonacci.minimizeFibonacci(funcND, left, right);
        System.out.println("\n\n<<<MultidimensionalCoordinateDescent>>>");
        Function<double[], Double> myFunction1 = (x) -> Math.pow(x[0], 3) + Math.pow(x[1], 2) + x[2];
        FunctionND funcND1 = new FunctionND(myFunction1);
        MultidimensionalCoordinateDescent.minimizeCoordinateDescent(new double[] { 2, 1, 1.2}, 0.01, 1000, 0.0001, funcND1);
    }

}

