import java.net.Inet4Address;
import java.util.ArrayList;

public class HeapSort {
    public void HeapSort(ArrayList<oceanEntries> dataOcean) {
        int Size_Array = dataOcean.size();

      // Build heap (rearrange array)
        for (int i = Size_Array / 2 - 1 ; i >= 0; i--)
            Rearrange_Array(Main.dataOcean.size(), i);


        for (int i = Size_Array - 1; i > 0; i--) {
            // Move current root to end

            try {

                oceanEntries temp = Main.dataOcean.get(i);
                oceanEntries temp2 = Main.dataOcean.get(i++);
                i--;
                Main.dataOcean.set(i++, temp2);
                Main.dataOcean.set(i--, temp);
                i++;

            }catch (IndexOutOfBoundsException e){
                System.out.println(e);
            }

           // temp.equals(Main.dataOcean.get(0));
            //Main.dataOcean.set(0, dataOcean.get(i));
            //Main.dataOcean.get(i).equals(temp);


            //Collections.copy(Main.dataOcean.get(0).getPO4uM() ,dataOcean.get(i).getPO4uM());
            //Main.dataOcean.get(0).getPO4uM().equals(dataOcean.get(i).getPO4uM());


            // call max heapify on the reduced heap
            Rearrange_Array(i, 0);

        }
    }

    void Rearrange_Array(int Size_Array, int i) {
        int largest = i; // Initialize largest as root
        int leftwing = 2 * i + 1; // left = 2*i + 1
        int rightwing = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (leftwing < Size_Array && Main.dataOcean.get(leftwing).equals(Main.dataOcean.get(largest)))
            largest = leftwing;

        // If right child is larger than largest so far
        if (rightwing < Size_Array && Main.dataOcean.get(rightwing).equals(Main.dataOcean.get(largest)))
            largest = rightwing;

        // If largest is not root
        if (largest != i) {
            oceanEntries temp = Main.dataOcean.get(i);
            Main.dataOcean.get(i).equals(Main.dataOcean.get(largest));
            Main.dataOcean.get(largest).equals(temp);

            // Recursively heapify the affected sub-tree
            Rearrange_Array(Size_Array, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printHeapSort(ArrayList<oceanEntries> dO) {
        int Size_Array = dO.size();
        for (int i = 0; i < Size_Array; ++i)
            System.out.println(dO.get(i).getPO4uM());
        System.out.println();
    }
}

