import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

public class InterpolationSearch {

    public static String interpolationSearch(String date){
        String[] tempDateString;
        String splitBy = "/",  tempDate = "";
        int[] oceanDates = new int[Main.dataOcean.size()];


        //taking the String format date from the user, removing the '/' and changing it's type from String to int
        tempDateString = date.split(splitBy);

        for(int i=0; i<tempDateString.length; i++)
            tempDate += tempDateString[i];

        int intDate = Integer.parseInt(tempDate);

        //taking the ArrayList with the data from the csv file, removing the '/' and changing the format of the date from Date to int.
        //then adding all the new dates to an int type Array
        try {
                int j=0;
                for(var i: Main.dataOcean){
                    tempDateString = i.getDate().displayDate().split(splitBy);
                    oceanDates[j] = Integer.parseInt(tempDateString[0] + tempDateString[1] + tempDateString[2]);
                    j++;
                }

        }catch (NumberFormatException e){
            System.out.println(e);
        }

        //the start of the interpolationSearch
        int left = 0, right = Main.dataOcean.size()-1;
        double check = left + (((intDate-oceanDates[left])*(right-left))/(oceanDates[right]-oceanDates[left]));

        try{
        while(left<=right){
                if(intDate == oceanDates[(int)check])
                    return "Temperature in Celsius: " + Main.dataOcean.get((int) check).getT_degC() + ", Phosphate: " + Main.dataOcean.get((int) check).getPO4uM();
                else {
                    check = left + (((intDate-oceanDates[left])*(right-left))/(oceanDates[right]-oceanDates[left]));
                    left +=1;
                }

        }
        }catch (ArithmeticException a){
            System.out.println(a);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

        return "Date not found";
    }
}