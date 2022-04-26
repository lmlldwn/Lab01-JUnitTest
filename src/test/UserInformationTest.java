package test;
import sms.Sms;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserInformationTest {
    public static Sms sms = new Sms();

    @Test
    public void testUserInformationEmpty() {
        String info = "";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationNull() {
        String info = null;
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationCompleteDetails() {
        String info = "Marco Valmores, 1973-09-10, Marikina City";
        assertTrue(sms.userInformation(info));
    }

    @Test
    public void testUserInformationExcessDetails() {
        String info = "Marco Valmores, 1973-09-10, Marikina City, 09178889999";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationMultipleComma() {
        String info = "Valmores, Marco, 1973-09-10, Marikina, City";
        assertFalse(sms.userInformation(info));
    }


    @Test
    public void testUserInformationNumberName() {
        String info = "12345, 1973-09-10, Marikina";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationNumberAddress() {
        String info = "Marco Valmores, 1973-09-10, 1234231";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationNumberNameAndAddress() {
        String info = "12345, 1973-09-10, 123123123";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationInvalidFourDigitYear() {
        String info = "Marco Valmores, 8888-09-10, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationThreeDigitYear() {
        String info = "Marco Valmores, 123-09-10, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationTwoDigitYear() {
        String info = "Marco Valmores, 13-09-10, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationOneDigitYear() {
        String info = "Marco Valmores, 3-09-10, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationNoYear() {
        String info = "Marco Valmores, -09-10, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationInvalidTwoDigitMonth() {
        String info = "Marco Valmores, 1973-19-10, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationInvalidOneDigitMonth() {
        String info = "Marco Valmores, 1973-1-10, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationNoMonth() {
        String info = "Marco Valmores, 1973--10, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationInvalidDay() {
        String info = "Marco Valmores, 1973-09-99, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationInvalidDay30DayMonths() {
        String info = "Marco Valmores, 1973-09-31, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationInvalidDay28DayMonths() {
        String info = "Marco Valmores, 1973-02-29, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationLeapYear() {
        String info = "Marco Valmores, 2000-02-29, Marikina City";
        assertTrue(sms.userInformation(info));
    }

    @Test
    public void testUserInformationLeapYearInvalidDay() {
        String info = "Marco Valmores, 2000-02-30, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationNoDay() {
        String info = "Marco Valmores, 2000-02-, Marikina City";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationNoAddress() {
        String info = "Marco Valmores, 2000-02-17";
        assertFalse(sms.userInformation(info));
    }

    @Test
    public void testUserInformationNoName() {
        String info = "2000-02-17, Marikina City";
        assertFalse(sms.userInformation(info));
    }



}
