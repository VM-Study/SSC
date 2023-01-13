import org.junit.Test;
import static org.junit.Assert.*;

public class ComplexNumberTest {

    @Test
    public void testComplexNumber1() {
        final ComplexNumber a = new ComplexNumber(1, -1);
        final ComplexNumber b = new ComplexNumber(-1, 6);
        final ComplexNumber c = ComplexNumber.add(a, b);
        assertEquals(0, c.getReal());
        assertEquals(5, c.getImage());
    }

    @Test
    public void testComplexNumber2() {
        final ComplexNumber a = new ComplexNumber(8, 7);
        final ComplexNumber b = new ComplexNumber(4, 3);
        final ComplexNumber c = ComplexNumber.add(a, b);
        assertEquals(12, c.getReal());
        assertEquals(10, c.getImage());
    }
}
