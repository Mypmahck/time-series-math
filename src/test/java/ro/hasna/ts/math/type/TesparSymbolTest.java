package ro.hasna.ts.math.type;

import org.apache.commons.math3.exception.NotPositiveException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ro.hasna.ts.math.util.TimeSeriesPrecision;

/**
 * @since 1.0
 */
public class TesparSymbolTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testConstructorException() throws Exception {
        thrown.expect(NotPositiveException.class);
        thrown.expectMessage("-5.5 is smaller than the minimum (0)");

        new TesparSymbol(10, 3, -5.5);
    }

    @Test
    public void testGetters() throws Exception {
        TesparSymbol symbol = new TesparSymbol(10, 3, 5.5);

        Assert.assertEquals(10, symbol.getDuration());
        Assert.assertEquals(3, symbol.getShape());
        Assert.assertEquals(5.5, symbol.getAmplitude(), TimeSeriesPrecision.EPSILON);
        Assert.assertEquals("[10, 3, 5.5]", symbol.toString());
    }

    @Test
    public void testEquals() throws Exception {
        TesparSymbol symbol = new TesparSymbol(10, 3, 5.5);

        Assert.assertEquals(false, symbol.equals(null));
        Assert.assertEquals(true, symbol.equals(symbol));
        Assert.assertEquals(true, symbol.equals(new TesparSymbol(10, 3, 5.5)));
        Assert.assertEquals(false, symbol.equals(new TesparSymbol(10, 4, 5.5)));
    }

}