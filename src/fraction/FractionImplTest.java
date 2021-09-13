package fraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionImplTest {

    Fraction f = new FractionImpl(4);
    Fraction a = new FractionImpl(3, 4);
    Fraction k = new FractionImpl("-16/8");
    Fraction m = new FractionImpl("8 /-12");
    Fraction t = new FractionImpl(0, 6);
    Fraction l = new FractionImpl("-80/-5");

    @Test
    void FractionImpl() {
        assertThrows(NumberFormatException.class, () -> new FractionImpl("10 / 4 / 9"));
        assertThrows(NumberFormatException.class, () -> new FractionImpl("1 0 / 4"));
        assertThrows(ArithmeticException.class, () -> new FractionImpl(3, 0));
        assertThrows(NumberFormatException.class, () -> new FractionImpl(" 1 0 45"));
    }

    @Test
    void add() {
        assertEquals(f.add(a).toString(),"19/4" );
        assertEquals(m.add(t).toString(), "-2/3");
        assertEquals(l.add(f).toString(), "20");
        assertEquals(k.add(t).toString(), "-2");
        assertEquals(a.add(m).toString(), "1/12");
    }

    @Test
    void subtract() {
        assertEquals(f.subtract(a).toString(), "13/4");
        assertEquals(a.subtract(k).toString(), "11/4");
        assertEquals(m.subtract(l).toString(), "-50/3");
        assertEquals(m.subtract(m).toString(), "0/1");
        assertEquals(k.subtract(m).toString(), "-4/3");
    }

    @Test
    void multiply() {
        assertEquals(f.multiply(a).toString(), "3");
        assertEquals(m.multiply(t).toString(), "0/1");
        assertEquals(a.multiply(k).toString(), "-3/2");
        assertEquals(a.multiply(a).toString(), "9/16");
        assertEquals(l.multiply(k).toString(), "-32");
    }

    @Test
    void divide() {
        assertEquals(f.divide(a).toString(), "16/3");
        assertEquals(t.divide(a).toString(), "0/1");
        assertThrows(ArithmeticException.class, () -> k.divide(t));
    }

    @Test
    void abs() {
        assertEquals(k.abs().toString(), "2");
        assertNotEquals(m.abs().toString(), "-2/3");
        assertEquals(m.abs().toString(), "2/3");
        assertEquals(t.abs().toString(), "0/1");
    }

    @Test
    void negate() {
        k = k.abs().negate();
        assertEquals(k.toString(), "-2");
        assertEquals(k.negate().toString(), "2");
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testEquals() {
        Integer i = 4;
        Fraction n = new FractionImpl(4);
        Fraction k = new FractionImpl(-2, 3);
        Fraction y = new FractionImpl(0, 5);
        assertFalse(i.equals(f));
        assertTrue(n.equals(f));
        assertTrue(k.equals(m));
        assertTrue(y.equals(t));
    }

    @Test
    void testClone() {
    }

    @Test
    void inverse() {
        assertEquals(a.inverse().toString(), "4/3");
        assertEquals(k.inverse().toString(), "-1/2");
        assertEquals(f.inverse().toString(), "1/4");
        assertThrows(ArithmeticException.class, () -> t.inverse());
    }

    @Test
    void compareTo() {
        Fraction l = new FractionImpl(5, 6);
        assertEquals(a.compareTo(l), -1);
        assertEquals(m.compareTo(t), -1);
        m = m.negate();
        assertEquals(m.compareTo(t), 1);
        Fraction k = new FractionImpl(15, 18);
        assertEquals(k.compareTo(l), 0);
    }

    @Test
    void testToString() {
        assertEquals(a.toString(), "3/4");
        assertEquals(m.toString(), "-2/3");
        assertEquals(t.toString(), "0/1");
        assertEquals(k.toString(), "-2");
    }
}