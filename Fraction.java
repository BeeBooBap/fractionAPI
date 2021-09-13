package fraction;

/**
 * Representing fractions of the form numerator and denominator
 * The object should be immutable.
 */
public interface Fraction extends Comparable<Fraction> {

    /**
     * Returns a new <pre>Fraction</pre> that is the <em>sum</em> of <pre>this</pre> and the parameter:
     *  <pre>a/b + c/d</pre> is <pre>(ad + bc)/bd</pre>
     *
     * @param f the fraction to add to the current fraction
     * @return the result of the addition
     */
    public Fraction add(Fraction f);

    /**
     * Returns a new <pre>Fraction</pre> that is the <em>difference</em> of <pre>this</pre> minus the parameter
     * <pre>a/b - c/d</pre> is <pre>(ad - bc)/bd</pre>
     *
     * @param f the fraction to subtract from the current fraction
     * @return the result of the subtraction
     */
    public Fraction subtract(Fraction f);

    /**
     * Returns a new <pre>Fraction</pre> that is the <em>product</em> of <pre>this</pre> and the parameter
     * <pre>(a/b) * (c/d)</pre> is <pre>(a*c)/(b*d)</pre>
     *
     * @param f the fraction to multiply with the current fraction
     * @return the result of the multiplication
     */
    public Fraction multiply(Fraction f);

    /**
     * Returns a new <pre>Fraction</pre> that is the <em>quotient</em> of dividing <pre>this</pre> by the parameter
     * <pre>(a/b) / (c/d)</pre> is <pre>(a*d)/(b*c)</pre>
     *
     * @param f the fraction to take part in the division
     * @return the result of the division
     */
    public Fraction divide(Fraction f);

    /**
     * Returns a new <pre>Fraction</pre> that is the <em>absolute value</em> of <pre>this</pre> fraction
     *
     * @return the absolute value of the fraction as a new fraction
     */
    public Fraction abs();

    /**
     * Returns a new <pre>Fraction</pre> that has the same numeric value of <pre>this</pre> fraction,
     * but the opposite sign.
     *
     * @return the newly negated fraction
     */
    public Fraction negate();

    /**
     * The inverse of <pre>a/b</pre> is <pre>b/a</pre>.
     *
     * @return the newly inverted fraction
     */
    public Fraction inverse();

    /**
     * Returns <pre>true</pre> if <pre>o</pre> is a <pre>Fraction</pre> equal to <pre>this</pre>,
     * and <pre>false</pre> in all other cases.
     *
     * @param o the object to compare this one to
     * @return whether the true fractions are equal
     */
    @Override
    public boolean equals(Object o);

    /**
     * Returns:
     * <ul>
     *     <li>A negative <pre>int</pre> if <pre>this</pre> is less than <pre>o</pre>.</li>
     *     <li>Zero if <pre>this</pre> is equal to <pre>o</pre>.</li>
     *     <li>A positive <pre>int</pre> if <pre>this</pre> is greater than <pre>o</pre>.</li>
     * </ul>
     *
     * @param f the fraction to compare <pre>this</pre> to
     * @return the result of the comparison
     */
    @Override
    public int compareTo(Fraction f);

    /**
     * Returns a <pre>String</pre> of the form <pre>n/d</pre>, where <pre>n</pre> is the
     * <em>numerator</em> and <pre>d</pre> is the <em>denominator</em>.
     * However, if <pre>d</pre> is <pre>1</pre>, just return <pre>n</pre> (as a <pre>String</pre>).
     *
     * The returned <pre>String</pre> should not contain any blanks.
     * If the fraction represents a negative number, a minus sign should precede <pre>n</pre>
     *
     * @return the string representation fo the fraction
     */
    @Override
    public String toString();
}