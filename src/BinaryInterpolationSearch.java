import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.lang.Math;

public class BinaryInterpolationSearch {

    public static String binaryInterpolationSearch(String date){

        String[] tempDateString;
        String splitBy = "/",  tempDate = "";
        int[] oceanDates = new int[Main.dataOcean.size()];

        //taking the String format date from the user, removing the '/' and changing it's type from String to int
        tempDateString = date.split(splitBy);

        for(int i=0; i<tempDateString.length; i++)
            tempDate += tempDateString[i];

        int intDate = Integer.parseInt(tempDate); //intDate is what we are Searching

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

        //Start of Binary Interpolation Search
        int i;
        int left = 0;
        int right = Main.dataOcean.size()-1;
        float size = right - left + 1;
        float next = ( size * (((float)intDate-oceanDates[left])/(oceanDates[right]-oceanDates[left])) ) +1;

        while(intDate!=oceanDates[(int)next]){
            i=0;
            size=right-left+1;

            //APEFTHIAS--------
            if(size<=50){
                if(intDate >= oceanDates[(int)next]){
                    while (true){
                        if (intDate == oceanDates[(int) next]){
                            return "Temperature in Celsius: " + Main.dataOcean.get((int) next).getT_degC() + " Phosphate: "+ Main.dataOcean.get((int)next).getPO4uM();
                        }
                            next++;
                        }
                    }
                else if(intDate < oceanDates[(int)next]){
                    while (true) {
                        if (intDate == oceanDates[(int) next]) {
                            return "Temperature in Celsius: " + Main.dataOcean.get((int) next).getT_degC() + " Phosphate: "+ Main.dataOcean.get((int)next).getPO4uM();
                        }
                        next--;
                    }
                }
            }
            //APEFTHIAS--------

            if(intDate >= oceanDates[(int)next]){
                while (intDate > oceanDates[(int)(next+(i*Math.sqrt((double)size)))-1]){
                    i++;
                }
                right =(int)(next + i*Math.sqrt((double)size));
                left =(int)(next + (i-1)*Math.sqrt((double)size));
            }
            else if(intDate < oceanDates[(int)next]){
                while (intDate < oceanDates[(int)(next-(i*Math.sqrt((double)size)))+1]){
                    i++;
                }
            }

            next = left + ( (float)(right-left+1)*((float)intDate-oceanDates[left])/(oceanDates[right]-oceanDates[left]) ) -1;
        }

        if(intDate == oceanDates[(int)next]){
            return "Temperature in Celsius: " + Main.dataOcean.get((int) next).getT_degC() + " Phosphate: "+ Main.dataOcean.get((int)next).getPO4uM();
        }
        else return "Not Found";
    }
}
