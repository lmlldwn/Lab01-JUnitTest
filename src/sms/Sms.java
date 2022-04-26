package sms;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Sms {
    public boolean register(String message) {
        if (message != null) {
            String lowercase = message.toLowerCase();
            if ( lowercase.equals("register") ) {
                return true;
            }
        }
        return false;
    }

    public boolean userInformation(String message) {
        if (message != null) {
            String[] words = message.split(", ");
            // Marco Valmores, 1973-09-10, Marikina City
            if (words.length != 3) {
                return false;
            } else {
                String name = words[0];
                String birthDate = words[1];
                String address = words[2];

                try {
                    Integer.parseInt(name);
                    return false;
                } catch (Exception e) {
                    System.out.println(e);
                }

                try {
                    Integer.parseInt(address);
                    return false;
                } catch (Exception e) {
                    System.out.println(e);
                }

                //Date Checker
                String[] date = birthDate.split("-");

                if (date.length != 3) {
                    return false;
                } else {
                    String year = date[0];
                    String month = date[1];
                    String day = date[2];

                    if ((year.length() != 4) || (month.length() != 2) || (day.length() != 2)) {
                        return false;
                    } else {
                        //check year
                        Integer yearInt = parseInt(date[0]);
                        Integer monthInt = parseInt(date[1]);
                        Integer dayInt = parseInt(date[2]);
                        if (yearInt > 2022 || yearInt <= 0) {
                            return false;
                        }
                        //check month
                        if (monthInt > 12 || monthInt <= 0) {
                            return false;
                        }
                        //check day
                        if (dayInt > 31 || dayInt < 0) {
                            return false;
                        } else {
                            int[] month30Days = {4, 6, 9, 11};

                            List<Integer> month30List = new ArrayList<Integer>();
                            for (int x : month30Days) {
                                month30List.add(x);
                            }

                            boolean leapYear = (yearInt % 4 == 0);

                            if (!leapYear) {
                                if (monthInt == 2 && dayInt > 28) {
                                    return false;
                                }
                            } else {
                                if (monthInt == 2 && dayInt > 29) {
                                    return false;
                                }
                            }

                            if (month30List.contains(monthInt) && dayInt > 30) {
                                return false;
                            }
                        }
                    }
                }
                System.out.println(name + ", " + birthDate + ", " + address); //debug change to logger
                return true;
            }
        }
        return false;
    }
}
