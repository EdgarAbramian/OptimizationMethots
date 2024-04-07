package functionalInterfaces;

@FunctionalInterface
public interface IForEachApplyFunction<T>{
    T call(T element);
}