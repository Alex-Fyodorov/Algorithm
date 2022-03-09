package lesson5;

public class Exponentiation {

    public static int base = 2;
    public static int exp = -2;

    public static void main(String[] args) {

        System.out.println(exponention(base, exp));
    }

    public static double exponention(int base, int exp) {
        double result = base;
        if (exp >= 1) {
            return multiplication(result, 1);
        } else {
            return division (result, 1);
        }
    }

    private static double division(double result, int temp) {
        if (temp == exp) return result;
        result = (double)(result / base);
        return division(result, temp - 1);
    }

    public static double multiplication(double result, int temp) {
        if (temp == exp) return result;
        result = (double)(result * base);
        return multiplication(result, temp + 1);
    }
}
