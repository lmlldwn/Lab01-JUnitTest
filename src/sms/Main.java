package sms;

import sms.Sms;

public class Main {
    public static void main(String[] args) {
        String message = null;
        String info = "Marco Valmores, 1972-03-30, Marikina City";
//        String info = "Marco Valmores, 1972-03-30, 123444";
//        String info = "Valmores, Marco, 1973-09-10, Marikina, City";
        Sms sms = new Sms();
//        System.out.println(sms.register(message)); // change to logger
        System.out.println(sms.userInformation(info)); // change to logger
    }
}
