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


        for(int j=1; j<=1405; j++){
            tempDateString = Main.dataOcean.get(j).getDate().displayDate().split(splitBy);
            oceanDates[j] = Integer.parseInt(tempDateString[0] + tempDateString[1] + tempDateString[2]);
        }

        int i;
        int left = 0;
        int right = Main.dataOcean.size()-1;
        double size = right - left + 1;
        int next = (((intDate - oceanDates[left]) / (oceanDates[right]-oceanDates[left]) )*(int)size) + 1;

        //Start of Binary Interpolation Search

        while(intDate != oceanDates[next]){
            i=0;
            size = right - left + 1;

            if(size <= 10){  //Apefthias Anazitisi
                while(intDate != oceanDates[next]){
                    if(intDate == oceanDates[next]){
                        return "Temperature in Celsius: "+ Main.dataOcean.get(next).getT_degC() + ", Phosphate: " + Main.dataOcean.get(next).getPO4uM();
                    }
                    next++;
                    if(next == 1405){
                        return "Date Not Found";
                    }
                }
            }

            if(intDate >= oceanDates[next]){
                while (intDate > oceanDates[(int) (next+(i*Math.sqrt(size) - 1))]){
                    i = i + 1;
                }
                right =(int) (next + i*Math.sqrt(size));
                left =(int) (next + (i-1)*Math.sqrt(size));
            }
            else if(intDate < oceanDates[next]){
                while (intDate < oceanDates[(int) (next-(i*Math.sqrt(size) + 1))]){
                    i = i + 1;
                }
                right =(int) (next - (i-1)*Math.sqrt(size));
                left =(int) (next - i*Math.sqrt(size));
            }
            next = left + ((right - left + 1) * ((intDate-oceanDates[left])/(oceanDates[right]-oceanDates[left]))) - 1;
        }
        if(intDate == oceanDates[next]){
            return "Temperature in Celsius: "+ Main.dataOcean.get(next).getT_degC() + ", Phosphate: " + Main.dataOcean.get(next).getPO4uM();
        }
        return  "Date Not Found";
    }

}
