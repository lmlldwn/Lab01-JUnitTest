package sms;

import sms.Sms;

public class Main {
    public static void main(String[] args) {
        String message = "Register";
        String info = "Marco Valmores, 1972-03-30, Marikina City";
        Sms sms = new Sms();
        System.out.println(sms.register(message)); // change to logger
        System.out.println(sms.userInformation(info)); // change to logger
    }
}
