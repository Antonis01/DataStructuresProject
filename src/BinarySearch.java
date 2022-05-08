import java.util.ArrayList;

public class BinarySearch {

    public static int binarySearch(String date){

        //getting a string date by the user and changing it's type to integer
        String[] checkDate = new String[3];
        String splitBy = "/";

        checkDate = date.split(splitBy);

        //getting the arrayList data from the Main class
        int left = 0, right = Main.dataOcean.size()-1;

        while(right >= left){
            int middle = (left + right)/2;

            for(var i: Main.dataOcean) {
                if ((Integer.parseInt(checkDate[1]) == i.getDate().getDate()) && (Integer.parseInt(checkDate[0]) == i.getDate().getMonth()) && (Integer.parseInt(checkDate[2]) == i.getDate().getYear())){
                    return middle;
                }
                else if(Integer.parseInt(checkDate[2]) < i.getDate().getYear()){
                    return right = middle-1;
                }
                else if((Integer.parseInt(checkDate[0]) < i.getDate().getMonth()) && (Integer.parseInt(checkDate[2]) == i.getDate().getYear())){
                    return right = middle-1;
                }
                else if ((Integer.parseInt(checkDate[1]) < i.getDate().getDate()) && (Integer.parseInt(checkDate[0]) == i.getDate().getMonth()) && (Integer.parseInt(checkDate[2]) == i.getDate().getYear()) ){
                    return right = middle-1;
                }
                else {
                    left = middle+1;
                }
            }
        }

        return -1;
    }


}
