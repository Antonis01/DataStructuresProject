import java.util.ArrayList;
public class HeapSort {
    public void HeapSort(ArrayList<oceanEntries> dataOcean) {
        int Size_Array = dataOcean.size();

        // Build heap (rearrange array)
        for (int i = Size_Array / 2 - 1; i >= 0; i--)
            Rearrange_Array(dataOcean, Size_Array, i);


        for (int i = Size_Array - 1; i > 0; i--) {
            // Move current root to end
            int temp = dataOcean.get(0);
            dataOcean.get(0) = dataOcean.get(i);
            dataOcean.get(i) = temp;

            // call max heapify on the reduced heap
            Rearrange_Array(dataOcean, i, 0);

        }
    }

    void Rearrange_Array(int arr[], int Size_Array, int i) {
        int largest = i; // Initialize largest as root
        int leftwing = 2 * i + 1; // left = 2*i + 1
        int rightwing = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (leftwing < Size_Array && arr[leftwing] > arr[largest])
            largest = leftwing;

        // If right child is larger than largest so far
        if (rightwing < Size_Array && arr[rightwing] > arr[largest])
            largest = rightwing;

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            Rearrange_Array(arr, Size_Array, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printHeapSort(int array[]) {
        int Size_Array = array.length;
        for (int i = 0; i < Size_Array; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}

