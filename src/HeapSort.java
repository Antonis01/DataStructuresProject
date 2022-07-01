import java.util.ArrayList;
import java.util.Collections;

public class HeapSort {

    static void makeHeap(int k, int N, boolean checkDate){

        if(checkDate){
            while(2*k+1 <=N){
                int maxSon = 2*k+1;
                if(maxSon < N && Main.dataOcean.get(maxSon).getDate().displayIntDate() < Main.dataOcean.get(maxSon+1).getDate().displayIntDate())
                    maxSon++;
                if(Main.dataOcean.get(maxSon).getDate().displayIntDate() < Main.dataOcean.get(k).getDate().displayIntDate())
                    break;

                Collections.swap(Main.dataOcean,maxSon,k);
                k=maxSon;
            }
        }else {            while(2*k+1 <=N){
                int maxSon = 2*k+1;
                if(maxSon < N && Main.dataOcean.get(maxSon).getPO4uM() < Main.dataOcean.get(maxSon+1).getPO4uM())
                    maxSon++;
                if(Main.dataOcean.get(maxSon).getPO4uM() < Main.dataOcean.get(k).getPO4uM())
                    break;

                Collections.swap(Main.dataOcean,maxSon,k);
                k=maxSon;
            }
        }

    }

    static void heapSort(ArrayList<oceanEntries> dataOcean, int left, int right, boolean checkDate){
        int N= right - left, k=(N%2==0 ? N/2-1 : N/2);

        for(; k>=0; k--)
            makeHeap(k,right,checkDate);

        while(right>left){
            Collections.swap(dataOcean,left,right);
            makeHeap(left, --right,checkDate);
        }
    }
    /* A utility function to print array of size n */
    static void printHeapSort() {
        int Size_Array = Main.dataOcean.size();
        for (int i = 0; i < Size_Array; ++i)
            System.out.println(i + ") " + Main.dataOcean.get(i).getDate().displayDate() + " " + Main.dataOcean.get(i).getPO4uM());
        System.out.println();
    }
}