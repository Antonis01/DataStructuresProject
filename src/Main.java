import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<oceanEntries> dataOcean = new ArrayList<>(loadCSV.load_CSV_file());
    private String date;

    public static void main(String[] args) {

        HeapSort hs=new HeapSort();
        hs.HeapSort(dataOcean);

        hs.printHeapSort(dataOcean);


        Scanner scn = new Scanner(System.in);
        String scnDate;
        System.out.println("Give a date in the (yyyy/mm/dd) form.");
        scnDate = scn.nextLine();
        BinarySearch bs= new BinarySearch();
        System.out.println(bs.binarySearch(scnDate));
    }

    public Main(String date) {
        this.date = date;
    }
}
