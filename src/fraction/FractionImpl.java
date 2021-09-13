package fraction;

public class FractionImpl implements Fraction {

    private final int numerator;
    private final int denominator;

    /**
     * To find the Greatest Common Divisor
     * @param n numerator
     * @param d denominator
     * @return gcd
     */
    private static int GCD ( int n, int d ) {
        int gcd = 1;
        for ( int i = 1; i <= Math.abs(n) && i <= Math.abs(d); i++ ){
            if ( n % i == 0 && d % i == 0 ){
                gcd = i;
            }
        }
        return gcd;
    }


    /**
     * To obtain the fractions in reduced form and manipulate the signs
     * @param n numerator
     * @param d denominator
     * @return a list of the two normalised numbers
     */
    private static int[] Normalise ( int n, int d ) {
        int gcd = GCD(n, d);
        n /= gcd; d /=gcd;

        int[] norm = new int[2];

        if ( d < 0 ){ d *= -1; n *= -1; }
        else if ( n == 0 ) d = 1;

        norm[0] = n;
        norm[1] = d;

        return norm;
    }


    /**
     * Creates the fraction with two parameters
     * @param numerator any number, can also be 0
     * @param denominator cannot be 0
     */
    public FractionImpl( int numerator, int denominator ) {
        int[] num = Normalise(numerator, denominator);

        if ( num[1] == 0 ) throw new ArithmeticException("Cannot divide by zero");

        this.numerator = num[0]; this.denominator = num[1];
    }


    /**
     * Creates the fraction with one parameter
     * @param wholeNumber with numerator then set to 1
     */
    public FractionImpl( int wholeNumber ) {
        this( wholeNumber, 1 );
    }


    /**
     * Creates the fraction with a String input
     * @param fraction in String form
     */
    public FractionImpl( String fraction ) {

        String[] f = fraction.split("/");

        if (f.length > 2) throw new NumberFormatException("Invalid string input");

        String num = f[0].trim();

        // wholeNumber
        if (f.length == 1){
            if (num.contains(" ")) throw new NumberFormatException("Invalid string input");
            this.numerator = Integer.parseInt(num);
            this.denominator = 1;
        }

        // fraction
        else {
            String dom = f[1].trim();

            if ((num.contains(" ")) || dom.contains(" ")) throw new NumberFormatException("Invalid string input");
            else {
                int numF = Integer.parseInt(num);
                int domF = Integer.parseInt(dom);

                int[] nums = Normalise(numF, domF);
                if ( nums[1] == 0 ) throw new ArithmeticException("Cannot divide by zero");
                this.numerator = nums[0]; this.denominator = nums[1];
            }

        }

    }


    /**
     * Adding two fractions together
     * @param f the fraction to add to the current fraction
     * @return new fraction.Fraction the sum of this and f
     * a/b + c/d is (ad + bc)/bd
     */
    @Override
    public Fraction add(Fraction f) {
        int fNum = ((FractionImpl) f).numerator; int fDom = ((FractionImpl) f).denominator;
        int numerator = (this.numerator*fDom) + (this.denominator*fNum); // (ad + bc)

        return new FractionImpl(numerator, fDom*this.denominator); // numerator, bd
    }


    /**
     * Subtracting one fraction from the other
     * @param f the fraction to subtract from the current fraction
     * @return new fraction.Fraction the difference of this and f
     * a/b - c/d is (ad - bc)/bd
     */
    @Override
    public Fraction subtract(Fraction f) {
        int fNum = ((FractionImpl) f).numerator; int fDom = ((FractionImpl) f).denominator;
        int numerator = (this.numerator*fDom) - (this.denominator*fNum); // (ad - bc)

        return new FractionImpl(numerator, fDom*this.denominator); // numerator, bd
    }


    /**
     * Multiplying two fractions together
     * @param f the fraction to multiply with the current fraction
     * @return new fraction.Fraction the product of this and f
     * (a/b) * (c/d) is (a*c)/(b*d)
     */
    @Override
    public Fraction multiply(Fraction f) {
        int fNum = ((FractionImpl) f).numerator; int fDom = ((FractionImpl) f).denominator;

        return new FractionImpl(fNum*this.numerator, fDom*this.denominator); // (a*c), (b*d)
    }


    /**
     * Dividing one fraction from the other
     * @param f the fraction to take part in the division
     * @return new fraction.Fraction the quotient of dividing this and f
     * (a/b) / (c/d) is (a*d)/(b*c)
     */
    @Override
    public Fraction divide(Fraction f) {
        int fNum = ((FractionImpl) f).numerator; int fDom = ((FractionImpl) f).denominator;

        return new FractionImpl(this.numerator*fDom, this.denominator*fNum);
    }


    /**
     * @return new fraction.Fraction the absolute value of the fraction
     */
    @Override
    public Fraction abs() {
        int n = numerator;
        if (numerator < 0) n *= -1;
        return new FractionImpl(n, denominator);
    }


    /**
     * @return new fraction.Fraction the opposite sign of the input fraction.Fraction
     */
    @Override
    public Fraction negate() {
        return new FractionImpl(numerator *-1, denominator);
    }


    /**
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }


    /**
     * Checks if the object is equal to this
     * @param obj
     * @return boolean value whether the object equals this
     */
    @Override
    public boolean equals(Object obj) {
        // test if obj is a fraction.Fraction
        if (obj instanceof Fraction){
            return ((((FractionImpl) obj).numerator == this.numerator) &&
                    (((FractionImpl) obj).denominator == this.denominator));
        }
        // if not a fraction.Fraction
        return false;
    }


    /**
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    /**
     * @return new fraction.Fraction with numerator and denominator swapped
     */
    @Override
    public Fraction inverse() {
        return new FractionImpl(denominator, numerator);
    }


    /**
     * Comparing fractions
     * @param o
     * @return positive, negative number or 0 reflecting whether this is greater than 0
     */
    @Override
    public int compareTo(Fraction o) {
        int fNum = ((FractionImpl) o).numerator; int fDom = ((FractionImpl) o).denominator;
        int thisNum = numerator; int thisDom = denominator;

        if (fDom != thisDom) {
            // to equalise the denominators;
            fNum *= thisDom;
            thisNum *= fDom;
        }

        if (thisNum < fNum) return - 1; // a.compareTo(o) -- a less than o
        if (thisNum == fNum) return 0; // a == o
        return 1; // a > o

    }


    /**
     * Converting the object fraction.Fraction into a readable String
     * @return String containing the values numerator and denominator
     */
    @Override
    public String toString() {
        if ( denominator == 1 && numerator != 0 ) return String.format("%d", numerator);
        return String.format("%d", numerator) + "/" + String.format("%d", denominator);
    }
}