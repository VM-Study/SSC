public class Main {
    public static void main(String[] args) {

        ComplexNumber a = new ComplexNumber(2, 3);
        ComplexNumber b = new ComplexNumber(-9, -2);
        ComplexNumber c = ComplexNumber.add(a, b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}