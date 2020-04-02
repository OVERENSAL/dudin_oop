import org.junit.Test;
import static org.junit.Assert.*;

public class NumericTransferTest {

    private NumericTransfer transfer = new NumericTransfer();

    @Test
    public void decimalToBinary0() {
        assertEquals("00000000", transfer.decimalToBinary(0));
    }

    @Test
    public void decimalToBinary1() {
        assertEquals("00000001", transfer.decimalToBinary(1));
    }

    @Test
    public void decimalToBinary6() {
        assertEquals("00000110", transfer.decimalToBinary(6));
    }

    @Test
    public void decimalToBinary255() {
        assertEquals("11111111", transfer.decimalToBinary(255));
    }

    @Test
    public void binaryToDecimal0() {
        assertEquals(0 , transfer.binaryToDecimal("00000000"));
    }

    @Test
    public void binaryToDecimal1() {
        assertEquals(1 , transfer.binaryToDecimal("00000001"));
    }

    @Test
    public void binaryToDecimal6() {
        assertEquals(6 , transfer.binaryToDecimal("00000110"));
    }

    @Test
    public void binaryToDecimal128() { assertEquals(64 , transfer.binaryToDecimal("01000000")); }

    @Test
    public void binaryToDecimal255() {
        assertEquals(255 , transfer.binaryToDecimal("11111111"));
    }
}