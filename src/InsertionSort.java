import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {

    void insertionSort(int left, int right){
        for(int i = right; i > left; i--){
            if(Main.dataOcean.get(i).getT_degC() < Main.dataOcean.get(i-1).getT_degC()){
                Collections.swap(Main.dataOcean, i, i-1);
            }
        }

        for(int i=left+2; i<=right; i++){
            int j=i;

            while(Main.dataOcean.get(j).getT_degC() < Main.dataOcean.get(j-1).getT_degC()){
                Collections.swap(Main.dataOcean, j,j-1);
                j--;
            }
        }
    }

    static void printInsertionSort() {
        int Size_Array = Main.dataOcean.size();
        for (int i = 0; i < Size_Array; ++i)
            System.out.println(i + ") " + Main.dataOcean.get(i).getDate().displayDate() + " " + Main.dataOcean.get(i).getT_degC());
        System.out.println();
    }
}