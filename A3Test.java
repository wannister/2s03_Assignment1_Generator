import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import cs2s03.A3;
public class A3Test {
    private static A3 tester;
    @BeforeClass
    public static void setUp(){
        tester = new A3();
    } 
    @Test
    public void RecTest() {
        assertEquals("Rec(1) must be 4", 4, tester.Rec(1));
        assertEquals("Rec(2) must be -22", -22, tester.Rec(2));
        assertEquals("Rec(3) must be 80", 80, tester.Rec(3));
        assertEquals("Rec(4) must be -276", -276, tester.Rec(4));
        assertEquals("Rec(5) must be 944", 944, tester.Rec(5));
        assertEquals("Rec(6) must be -3224", -3224, tester.Rec(6));
        assertEquals("Rec(7) must be 11008", 11008, tester.Rec(7));
        assertEquals("Rec(8) must be -37584", -37584, tester.Rec(8));
        assertEquals("Rec(9) must be 128320", 128320, tester.Rec(9));
        assertEquals("Rec(10) must be -438112", -438112, tester.Rec(10));
        assertEquals("Rec(11) must be 1495808", 1495808, tester.Rec(11));
        assertEquals("Rec(12) must be -5107008", -5107008, tester.Rec(12));
        assertEquals("Rec(13) must be 17436416", 17436416, tester.Rec(13));
        assertEquals("Rec(14) must be -59531648", -59531648, tester.Rec(14));
        assertEquals("Rec(15) must be 203253760", 203253760, tester.Rec(15));
        assertEquals("Rec(16) must be -693951744", -693951744, tester.Rec(16));
    }
}
