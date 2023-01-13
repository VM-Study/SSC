//: POI/ExportConfig

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The class represents a complex number
 * @author Vladimir Maximov
 * @version 1.0.0
 * @since 18
 */
public class ComplexNumber {


    /**
     * variables real part of complex number
     */
    int real;
    /**
     * variables imaginary part of complex number
     */
    int image;


    /**
     * @param real variables real part of complex number
     * @param image variables imaginary part of complex number
     */
    public ComplexNumber(int real, int image) {
        this.real = real;
        this.image = image;
    }

    /**
     * @return variables real part of complex number
     */
    public int getReal() {
        return real;
    }

    /**
     * @param real variables real part of complex number
     */
    public void setReal(int real) {
        this.real = real;
    }

    /**
     * @return variables imaginary part of complex number
     */
    public int getImage() {
        return image;
    }

    /**
     * @param image variables imaginary part of complex number
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * @param a first ComplexNumber
     * @param b second ComplexNumber
     * @return ComplexNumber being the sum first and second
     */
    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = new ComplexNumber(0,0);
        result.setReal(a.getReal() + b.getReal());
        result.setImage(a.getImage() + b.getImage());

        return result;
    }

    /**
     * @return String values of ComplexNumber
     */
    @Override
    public String toString() {
        return "ComplexNumber{" +
                "real:" + real +
                ", image:" + image +
                '}';
    }
}///:~
