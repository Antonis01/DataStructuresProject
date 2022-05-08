import java.util.ArrayList;

public class BinarySearch {

    public static String binarySearch(String date){

        //getting the arrayList data from the Main class
        int left = 0, right = Main.dataOcean.size()-1;

        while(right>=left){
            for(var i: Main.dataOcean) {
                int mid = (left + right)/2;
                if(date.compareTo(i.getDate().displayDate()) == 0)
                    return "Temperature in Celsius: " + Float.toString(i.getT_degC()) + ", Phosphate: " + Float.toString(i.getPO4uM());
                else if(date.compareTo(i.getDate().displayDate()) > 0)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return "Date not found";
    }
}
