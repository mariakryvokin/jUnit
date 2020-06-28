package task2;

import org.apache.commons.math3.primes.Primes;

public class Calculator {
    public int add(int firstArgument, int secondArgument) {
        return firstArgument + secondArgument;
    }

    public double add(double firstArgument, double secondArgument) {
        return firstArgument + secondArgument;
    }

    public double divide(double divided, double divider) {
        checkArgumentsLegitimacy(divided, divider);
        return divided / divider;
    }

    private void checkArgumentsLegitimacy(double divided, double divider) {
        if(divider == 0){
            throw new IllegalArgumentException("Divider should not be 0.");
        }
    }

    public boolean isPrime(int number) {
        return Primes.isPrime(number);
    }

    /**
     * Φ = ( 1 + √5 )/2 = 1.6180339887...
     * Binet's formula:
     * Sn = Φⁿ–(– Φ⁻ⁿ)/√5
     * @param position position in sequence
     * @return
     */
    public int findFibonacciByBinetsFormula(int position){
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5)/2;
        int nthTerm = (int) ((Math.pow(phi, position) - Math.pow(-phi, -position))/squareRootOf5);
        return nthTerm;
    }
}
