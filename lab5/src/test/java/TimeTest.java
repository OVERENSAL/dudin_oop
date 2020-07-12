import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {

    @Test
    public void isValid() {
        Time time = new Time(01, 23, 21);
        assertTrue(time.isValid(time));
    }

    @Test
    public void nonValid() {
        Time time = new Time(31, 23, 21);
        assertFalse(time.isValid(time));
    }

    @Test
    public void borderValid() {
        Time time = new Time(23, 00, 59);
        assertTrue(time.isValid(time));
    }

    @Test
    public void prefixInc() {
        Time time = new Time(23, 00, 59);
        time.prefixInc();
        assertEquals(23, time.getHour());
        assertEquals(01, time.getMinute());
        assertEquals(00, time.getSecond());
    }

    @Test
    public void borderInc() {
        Time time = new Time(23, 59, 59);
        time.prefixInc();
        assertEquals(00, time.getHour());
        assertEquals(00, time.getMinute());
        assertEquals(00, time.getSecond());
    }

    @Test
    public void postfixInc() {
        Time time = new Time(23, 59, 59);
        Time oldTime = time.postfixInc();
        assertEquals(23, oldTime.getHour());
        assertEquals(59, oldTime.getMinute());
        assertEquals(59, oldTime.getSecond());

        assertEquals(00, time.getHour());
        assertEquals(00, time.getMinute());
        assertEquals(00, time.getSecond());
    }

    @Test
    public void sumTime() {
        Time time = new Time(00, 00, 00);
        Time time2 = new Time(00, 00, 00);
        time.sumTime(time, time2);
        assertEquals(00, time.getHour());
        assertEquals(00, time.getMinute());
        assertEquals(00, time.getSecond());
    }

    @Test
    public void sumBorderTime() {
        Time time = new Time(14, 30, 59);
        Time time2 = new Time(23, 30, 59);
        time = time.sumTime(time, time2);
        assertEquals(14, time.getHour());
        assertEquals(01, time.getMinute());
        assertEquals(58, time.getSecond());
    }

    @Test
    public void subtractTime() {
        Time time = new Time(23, 30, 59);
        Time time2 = new Time(23, 30, 59);
        time = time.subtractTime(time, time2);
        assertEquals(00, time.getHour());
        assertEquals(00, time.getMinute());
        assertEquals(00, time.getSecond());
    }

    @Test
    public void subtractLessTime() {
        Time time = new Time(22, 23, 45);
        Time time2 = new Time(23, 30, 59);
        time = time.subtractTime(time, time2);
        assertEquals(22, time.getHour());
        assertEquals(52, time.getMinute());
        assertEquals(46, time.getSecond());
    }

    @Test
    public void subtractBorderTime() {
        Time time = new Time(00, 00, 00);
        Time time2 = new Time(23, 30, 59);
        time = time.subtractTime(time, time2);
        assertEquals(00, time.getHour());
        assertEquals(29, time.getMinute());
        assertEquals(01, time.getSecond());
    }

    @Test
    public void subtractTime2() {
        Time time = new Time(14, 30, 25);
        Time time2 = new Time(03, 18, 44);
        time = time.subtractTime(time, time2);
        assertEquals(11, time.getHour());
        assertEquals(11, time.getMinute());
        assertEquals(41, time.getSecond());
    }

    @Test
    public void prefSumTime() {
        Time time = new Time(14, 30, 25);
        Time time2 = new Time(03, 18, 44);
        time.prefSumTime(time2);
        assertEquals(17, time.getHour());
        assertEquals(49, time.getMinute());
        assertEquals(9, time.getSecond());
    }

    @Test
    public void prefSubtractTime() {
        Time time = new Time(14, 30, 25);
        Time time2 = new Time(03, 18, 44);
        time.prefSubtractTime(time2);
        assertEquals(11, time.getHour());
        assertEquals(11, time.getMinute());
        assertEquals(41, time.getSecond());
    }

    @Test
    public void multiplicationTime() {
        Time time = new Time (11, 12, 23);
        int multiplier = 3;
        time = time.multiplicationTime(time, multiplier);
        assertEquals(9, time.getHour());
        assertEquals(36 + 1, time.getMinute());
        assertEquals(9, time.getSecond());
    }

    @Test
    public void multiplicationTime2() {
        Time time = new Time (23, 12, 23);
        int multiplier = 7;
        time = time.multiplicationTime(time, multiplier);
        assertEquals(18, time.getHour());
        assertEquals(24 + 2, time.getMinute());
        assertEquals(41, time.getSecond());
    }

    @Test
    public void divisionTime() {
        Time time = new Time(23, 59 ,59);
        time = time.divisionTime(time, 3);
        assertEquals(7, time.getHour());
        assertEquals( 19, time.getMinute());
        assertEquals(19, time.getSecond());
    }

    @Test
    public void divisionTime2() {
        Time time = new Time(23, 59 ,59);
        time = time.divisionTime(time, 100);
        assertEquals(0, time.getHour());
        assertEquals( 0, time.getMinute());
        assertEquals(0, time.getSecond());
    }

    @Test
    public void divisionTimeOnTime() {
        Time time = new Time(23, 59 ,59);
        Time time2 = new Time(11, 01 ,19);
        time = time.divisionTimeOnTime(time, time2);
        assertEquals(2, time.getHour());
        assertEquals(59, time.getMinute());
        assertEquals(3, time.getSecond());
    }

    @Test
    public void divisionTimeOnTime2() {
        Time time = new Time(23, 59 ,59);
        Time time2 = new Time(23, 59 ,59);
        time = time.divisionTimeOnTime(time, time2);
        assertEquals(1, time.getHour());
        assertEquals(1, time.getMinute());
        assertEquals(1, time.getSecond());
    }

    @Test
    public void prefMultiplicationTime() {
        Time time = new Time(23, 59 ,59);
        int multiplier = 22;
        time.prefMultiplicationTime(multiplier);
        assertEquals(23, time.getHour());
        assertEquals(59, time.getMinute());
        assertEquals(38, time.getSecond());
    }

    @Test
    public void prefDivisionTime() {
        Time time = new Time(11, 23, 43);
        int divider = 5;
        time.prefDivisionTime(divider);
        assertEquals(2, time.getHour());
        assertEquals(4, time.getMinute());
        assertEquals(8, time.getSecond());
    }

    @Test
    public void timesAreEqual() {
        Time time = new Time(14, 30, 59);
        Time time2 = new Time(23, 30, 59);
        assertFalse(time.timesAreEqual(time, time2));
    }

    @Test
    public void timesAreEqual2() {
        Time time = new Time(23, 30, 59);
        Time time2 = new Time(23, 30, 59);
        assertTrue(time.timesAreEqual(time, time2));
    }

    @Test
    public void firstIsStrictlyGreaterThenSecond() {
        Time time1 = new Time(00, 00, 00);
        Time time2 = new Time(00, 00, 00);
        assertFalse(time1.firstIsStrictlyGreaterThenSecond(time1, time2));
    }

    @Test
    public void firstIsStrictlyGreaterThenSecond2() {
        Time time1 = new Time(10, 00, 00);
        Time time2 = new Time(00, 00, 00);
        assertTrue(time1.firstIsStrictlyGreaterThenSecond(time1, time2));
    }

    @Test
    public void firstIsStrictlyGreaterThenSecond3() {
        Time time1 = new Time(00, 01, 00);
        Time time2 = new Time(00, 00, 59);
        assertTrue(time1.firstIsStrictlyGreaterThenSecond(time1, time2));
    }

    @Test
    public void firstIsStrictlyGreaterThenSecond4() {
        Time time1 = new Time(9, 10, 11);
        Time time2 = new Time(10, 10, 10);
        assertFalse(time1.firstIsStrictlyGreaterThenSecond(time1, time2));
    }

    @Test
    public void firstIsStrictlyLessThenSecond() {
        Time time1 = new Time(10, 10, 9);
        Time time2 = new Time(10, 10, 10);
        assertTrue(time1.firstIsStrictlyLessThenSecond(time1, time2));
    }

    @Test
    public void firstIsStrictlyLessThenSecond2() {
        Time time1 = new Time(00, 10, 11);
        Time time2 = new Time(10, 10, 10);
        assertTrue(time1.firstIsStrictlyLessThenSecond(time1, time2));
    }

    @Test
    public void firstIsStrictlyLessThenSecond3() {
        Time time1 = new Time(00, 9, 11);
        Time time2 = new Time(00, 10, 10);
        assertTrue(time1.firstIsStrictlyLessThenSecond(time1, time2));
    }

    @Test
    public void firstIsStrictlyLessThenSecond4() {
        Time time1 = new Time(11, 10, 10);
        Time time2 = new Time(10, 10, 12);
        assertFalse(time1.firstIsStrictlyLessThenSecond(time1, time2));
    }

    @Test
    public void firstIsNotStrictlyGreaterThenSecond() {
        Time time1 = new Time(10, 10, 10);
        Time time2 = new Time(10, 10, 10);
        assertTrue(time1.firstIsNotStrictlyGreaterThenSecond(time1, time2));
    }

    @Test
    public void firstIsNotStrictlyGreaterThenSecond2() {
        Time time1 = new Time(11, 10, 10);
        Time time2 = new Time(10, 10, 10);
        assertTrue(time1.firstIsNotStrictlyGreaterThenSecond(time1, time2));
    }

    @Test
    public void firstIsNotStrictlyGreaterThenSecond3() {
        Time time1 = new Time(10, 10, 11);
        Time time2 = new Time(10, 10, 10);
        assertTrue(time1.firstIsNotStrictlyGreaterThenSecond(time1, time2));
    }

    @Test
    public void firstIsNotStrictlyGreaterThenSecond4() {
        Time time1 = new Time(9, 10, 11);
        Time time2 = new Time(10, 10, 10);
        assertFalse(time1.firstIsNotStrictlyGreaterThenSecond(time1, time2));
    }

    @Test
    public void firstIsNotStrictlyLessThenSecond() {
        Time time1 = new Time(10, 10, 11);
        Time time2 = new Time(10, 10, 10);
        assertFalse(time1.firstIsNotStrictlyLessThenSecond(time1, time2));
    }

    @Test
    public void firstIsNotStrictlyLessThenSecond2() {
        Time time1 = new Time(10, 10, 10);
        Time time2 = new Time(10, 10, 10);
        assertTrue(time1.firstIsNotStrictlyLessThenSecond(time1, time2));
    }
}