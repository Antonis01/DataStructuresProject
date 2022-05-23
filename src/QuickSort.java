import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {
    static void quickSort(int LowIndex, int HighIndex) {
        if (LowIndex>= HighIndex){
            return;
        }
       float pivot= (float) Main.dataOcean.get(HighIndex).getT_degC();
       int leftPointer=LowIndex;
       int rightPointer=HighIndex;

       while(leftPointer<rightPointer){
           while(Main.dataOcean.get(leftPointer).getT_degC()<=pivot && leftPointer<rightPointer ){
               leftPointer++;
           }
           while(Main.dataOcean.get(rightPointer).getT_degC()>=pivot && leftPointer<rightPointer ) {
               rightPointer--;
           }
           swap(leftPointer,rightPointer);
       }
       swap(leftPointer,HighIndex);
       quickSort(LowIndex,leftPointer -1);
       quickSort(leftPointer+1,HighIndex);

    }
    private static void swap (int i, int j){
        Collections.swap(Main.dataOcean, i,j);
    }
    static void printQuickSort() {
        int Size_Array = Main.dataOcean.size();
        for (int i = 0; i < Size_Array; ++i)
            System.out.println(i + ") " + Main.dataOcean.get(i).getDate().displayDate() + " " + Main.dataOcean.get(i).getT_degC());
        System.out.println();
    }
}
