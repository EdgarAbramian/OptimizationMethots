package functionalInterfaces;

import java.util.function.Function;

public class FunctionND {
    private Function<double[], Double> func;

    public FunctionND(Function<double[], Double> func) {
        this.func = func;
    }

    public Double evaluate(double[] args) {
        return func.apply(args);
    }

    public double magnitude(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * a[i];
        }
        return Math.sqrt(sum);
    }

    // Example of how to use the NDimensionalFunction class
    public static void main(String[] args) {
        Function<double[], Double> myFunction = (x) -> Math.pow(x[0], 7) + x[1]*x[1] + x[2]*x[2];
        FunctionND nDimFunc = new FunctionND(myFunction);

        double[] input = {2, 2, 3};
        Double result = nDimFunc.evaluate(input);
        System.out.println(result);
    }
}