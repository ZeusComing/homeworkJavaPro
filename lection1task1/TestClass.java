public class TestClass {

    @MyAnnotation(a = 5, b = 7)
    public static int sum(int a, int b) {
        return a + b;
    }

    @MyAnnotation(a = 3, b = 1)
    public static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    @MyAnnotation(a = 5, b = 5)
    public static int multiply(int a, int b) {
        return a * b;
    }
}
