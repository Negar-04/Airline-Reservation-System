import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {
    Admins admins = new Admins();
    Passengers passengers = new Passengers();
    Flights flights = new Flights();
    Tickets tickets = new Tickets();

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public boolean checkLetters(String str){
        boolean test;
        char[] str2 = str.toCharArray();
        if (str2[0]>= 'a' && str2[0]<= 'z')
            return false;
        for (int i = 1; i < str.length(); i++) {
            if ((str2[i] >= 'a' && str2[i] <= 'z'))
                test = true;
            else
                test = false;
            if (!test)
                return false;
        }
        return true;
    }
    public boolean checkTime(String str){
        Matcher matcher = Pattern.compile("\\d{2}:\\d{2}").matcher(str);
        matcher.useAnchoringBounds(true);
        if (matcher.find()){
            String[] digits = str.split(":");
            int[] convertedDigits = new int[digits.length];

            for (int i = 0; i < digits.length; i++)
                convertedDigits[i] = Integer.parseInt(digits[i]);

            boolean hourCheck = convertedDigits[0] >=0 && convertedDigits[0] <=23;
            boolean minuteCheck = convertedDigits[1] >=0 && convertedDigits[1] <=59;

            return hourCheck && minuteCheck;
        }
        return false;
    }
    public boolean checkDate(String str){

        Matcher matcher = Pattern.compile("\\d{4}/\\d{2}/\\d{2}").matcher(str);

        matcher.useAnchoringBounds(true);
        if (matcher.find()) {
            String[] digits = str.split("/");
            int[] convertedDigits = new int[digits.length];

            for (int i = 0; i < digits.length; i++)
                convertedDigits[i] = Integer.parseInt(digits[i]);

            boolean yearCheck = convertedDigits[0] > 0 && convertedDigits[0] <10000;
            boolean monthCheck = convertedDigits[1] > 0 && convertedDigits[1] < 13;
            boolean dayCheck;

            if (convertedDigits[1] > 0 && convertedDigits[1] <=6)
                dayCheck = convertedDigits[2] > 0 && convertedDigits[2] <=32;
            else if (convertedDigits[1] == 12)
                dayCheck = convertedDigits[2] >0 && convertedDigits[2] <=29;
            else
                dayCheck = convertedDigits[2] >0 && convertedDigits[2] <=30;

            return monthCheck && dayCheck && yearCheck;

        } else
            return false;
    }
}
