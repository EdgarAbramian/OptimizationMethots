public class Main {
    public static void main(String[] args) {
        functionalInterfaces.IFunction1D func = (x) -> x * x;
        OneDimensionMethods.DichotomyMethod.Dichotomy(func, 0.5, 1);
        OneDimensionMethods.FibonacciMethod.MethodFibonacci(func, 0.5, 1);
        OneDimensionMethods.GoldenRatioMethod.MethodGoldenRatio(func, 0.5, 1);
        }
    }

