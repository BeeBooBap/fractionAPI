package fraction;

public class UseOfFractionImpl {
    public static void main(String[] args) {
        Fraction c = new FractionImpl(1, -6);
        Fraction e = new FractionImpl(3, 4);
        Fraction f = new FractionImpl(5, 4);

        System.out.println("c prior to arithmetic operations:   " + c);

        c = c.add(e).subtract(f);
        c = c.negate();

        for (int i = 0; i < 3; i++){ c = c.multiply(c); }

        Fraction d = new FractionImpl("6561");

        d = c.multiply(d);

        System.out.println("d after multiplication:             " + d);
        System.out.println("---------------------------------------------------");

        c = new FractionImpl(-1024);

        System.out.println("c after new value input:            " + c);

        d = d.divide(c);

        System.out.println("d after division by c:              " + d);
        System.out.println("---------------------------------------------------");

        d = d.negate().inverse();
        c = c.abs();

        System.out.println("c bigger than d:                    " + c.compareTo(d));

        while (!c.equals(d)) { c = c.divide(d); }

        System.out.println("c == d after while loop?:           " + c.equals(d));
        System.out.println("Using compareTo() function:         " + c.compareTo(d));
    }


}
