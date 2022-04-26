package test;
import org.junit.Test;
import sms.Sms;

import static org.junit.Assert.*;

public class RegisterTest {
    public static Sms sms = new Sms();

    @Test
    public void testRegisterEmpty() {
        String message = "";
        assertFalse(sms.register(message));
    }

    @Test
    public void testRegisterNull() {
        String message = null;
        assertFalse(sms.register(message));
    }

    @Test
    public void testRegisterAllUpperCase() {
        String message = "REGISTER";
        assertTrue(sms.register(message));
    }

    @Test
    public void testRegisterAllLowerCase() {
        String message = "register";
        assertTrue(sms.register(message));
    }

    @Test
    public void testRegisterMixedCase() {
        String message = "ReGisTeR";
        assertTrue(sms.register(message));
    }

    @Test
    public void testRegisterJejemon() {
        String message = "R3g15T3r";
        assertFalse(sms.register(message));
    }

    @Test
    public void testRegisterRandomCharacters() {
        String message = "asdfasdfadf";
        assertFalse(sms.register(message));
    }

    @Test
    public void testRegisterRegex() {
        String message = "Reg-ist!er";
        assertFalse(sms.register(message));
    }

    @Test
    public void testRegisterReverse() {
        String message = "retsiger";
        assertFalse(sms.register(message));
    }

}
