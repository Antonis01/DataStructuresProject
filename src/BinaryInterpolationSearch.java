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

        double key = (double) intDate;
        double left = 0, right= Main.dataOcean.size()-1, size=right-left+1, i;
        double next = size*((key-oceanDates[(int)left])/(oceanDates[(int)right]-oceanDates[(int)left]));
        if(next<1){next = 1;}
        while (key != oceanDates[(int)next])
        {
            i=0;
            size = right-left+1;

            //Apefthias
            if(size <= 10)
            {
                for(int j = 0; j<4; j++)
                {
                    if(key == oceanDates[(int)next]){return Float.toString(Main.dataOcean.get((int)next).getPO4uM());}
                    next = next+1;
                }

                return "Date Not Found";
            }

            if(key >= oceanDates[(int)next])
            {
                while (key > oceanDates[(int)(next+(i*(Math.sqrt(size)))-1)])
                {
                    i=i+1;
                }
                right = next + (i*Math.sqrt(size));
                left = next + ((i-1)*Math.sqrt(size));
            }
            else if(key < oceanDates[(int)next])
            {
                while (key < oceanDates[(int)(next-(i*Math.sqrt(size))-1)])
                {
                    i=i+1;
                }
                right = next - (i-1)*Math.sqrt(size);
                left = next - i*Math.sqrt(size);
            }
            next= left + ( (right-left+1) * ((key-oceanDates[(int)left])/(oceanDates[(int)right]-oceanDates[(int)left])) ) - 1;

        }
        if(key == oceanDates[(int)next]){return Float.toString(Main.dataOcean.get((int)next).getPO4uM());}
        else return "Date Not Found";
    }
}
