import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<oceanEntries> dataOcean = new ArrayList<>(loadCSV.load_CSV_file());
    public static ArrayList<oceanEntries> sorted_array = new ArrayList<oceanEntries>(); //Create empty Sorted Array Object tipou oceanEntities

    private String date;

    public static void main(String[] args) {



        //HeapSort hs=new HeapSort();
        //hs.heapSort(dataOcean, 0,dataOcean.size()-1);
        //hs.printHeapSort(dataOcean);


        //Counting Sort
        CountingSort cs = new CountingSort(); //Create Counting Sort object
        cs.countingSort(dataOcean, sorted_array, 1405, 332); //Call the Counting Sort Function and put in the parameters
        // 1405 = how many entries we have , 332 = the maximum Phosphate registered in our data
        //The Function sorts the dataOcean array inside the sorted_array array
        for (int i = 1; i <= 1405; i++) {
            System.out.println(i + ") " + sorted_array.get(i).getPO4uM() + " " + sorted_array.get(i).getDate().displayDate());
        }



        /*
        Scanner scn = new Scanner(System.in);
        String scnDate;
        System.out.println("Give a date in the (yyyy/mm/dd) form.");
        scnDate = scn.nextLine();
        InterpolationSearch bs = new InterpolationSearch();
        System.out.println(bs.interpolationSearch(scnDate));
        */


        /*
        String[] arr = new String[dataOcean.size()];
        for(int j=0; j<dataOcean.size(); j++){
            for(var i: dataOcean){
                arr[j] = i.getDate().displayDate();

*/

    }



    public Main(String date) {
        this.date = date;
    }
}
