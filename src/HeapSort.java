import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HeapSort {

    static void makeHeap(ArrayList<oceanEntries> dataOcean, int k, int N){

        while(2*k+1 <=N){
            int maxson = 2*k+1;
            if(maxson < N && dataOcean.get(maxson).getPO4uM() < dataOcean.get(maxson+1).getPO4uM())
                maxson++;
            if(dataOcean.get(maxson).getPO4uM() < dataOcean.get(k).getPO4uM())
                break;

            Collections.swap(dataOcean,maxson,k);
            k=maxson;
        }
    }

    static void heapSort(ArrayList<oceanEntries> dataOcean, int left, int right){
        int N= right - left, k=(N%2==0 ? N/2-1 : N/2);
        oceanEntries temp;

        for(; k>=0; k--)
            makeHeap(dataOcean,k,right);

        while(right>left){
            Collections.swap(dataOcean,left,right);
            makeHeap(dataOcean,left, --right);
        }
    }
    /* A utility function to print array of size n */
    static void printHeapSort(ArrayList<oceanEntries> dO) {
        int Size_Array = dO.size();
        for (int i = 0; i < Size_Array; ++i)
            System.out.println(dO.get(i).getDate().displayDate() + " " + dO.get(i).getPO4uM());
        System.out.println();
    }
}

