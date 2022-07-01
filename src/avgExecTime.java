import java.util.ArrayList;

public class avgExecTime {

    public static void avgExecTime(){
        //A method that calculates the average execution time
        //in nanoseconds for each sorting and searching method.

        Long start, end, execution, avgInsertion=0l;

        for(int j=0; j<100000; j++){
            InsertionSort is=new InsertionSort();
            start = System.nanoTime();
            is.insertionSort(0,Main.dataOcean.size()-1);
            end = System.nanoTime();
            execution = (end - start);
            avgInsertion +=execution;
            is.printInsertionSort();
            System.out.println("Execution time of InsertionSort Method is");
            System.out.println(execution + " nanoseconds");
            Main.dataOcean = new ArrayList<>(loadCSV.load_CSV_file());
        }

        Long avgQuick =0l, execution1;
        for(int j=0; j<100000; j++) {
            QuickSort qs = new QuickSort();
            start = System.nanoTime();
            qs.quickSort(0, Main.dataOcean.size() - 1);
            end = System.nanoTime();
            execution1 = (end - start);
            avgQuick += execution1;
            qs.printQuickSort();
            System.out.println("Execution time of Quick Sort Method is");
            System.out.println(execution1 + " nanoseconds");
            Main.dataOcean = new ArrayList<>(loadCSV.load_CSV_file());
        }

        Long avgHeap =0l, execution2;
        for (int j=0; j<100000; j++){
            HeapSort hs = new HeapSort();
            start = System.nanoTime();
            hs.heapSort(Main.dataOcean, 0, Main.dataOcean.size() - 1, false);
            end = System.nanoTime();
            execution2 = (end - start);
            avgHeap +=execution2;
            hs.printHeapSort();
            System.out.println("Execution time of Heap Sort Method is");
            System.out.println(execution2 + " nanoseconds");
            Main.dataOcean = new ArrayList<>(loadCSV.load_CSV_file());
        }

        Long avgCounting =0l, execution3;
        for (int j=0; j<100000; j++){
            CountingSort cs = new CountingSort();
            start = System.nanoTime();
            cs.countingSort(Main.dataOcean,1405, 332);
            end = System.nanoTime();
            execution3 = (end - start);
            avgCounting += execution3;
            cs.printCountingSort();
            System.out.println("Execution time of Counting Sort is");
            System.out.println(execution3 + " nanoseconds");
            Main.dataOcean = new ArrayList<>(loadCSV.load_CSV_file());
        }

        HeapSort hs = new HeapSort();
        hs.heapSort(Main.dataOcean, 0, Main.dataOcean.size() - 1, false);

        Long avgBinary =0l, execution4;
        for (int j=0; j<100000; j++){
            BinarySearch bs = new BinarySearch();
            start = System.nanoTime();
            System.out.println(bs.binarySearch("2000/01/12"));
            end = System.nanoTime();
            execution4 = (end - start);
            avgBinary += execution4;
            System.out.println("Execution time of Binary Search Method is");
            System.out.println(execution4 + " nanoseconds");
            Main.dataOcean = new ArrayList<>(loadCSV.load_CSV_file());
        }

        Long avgInter =0l, execution5;
        for (int j=0; j<100000; j++){
            InterpolationSearch is = new InterpolationSearch();
            start = System.nanoTime();
            System.out.println(is.interpolationSearch("2000/01/12"));
            end = System.nanoTime();
            execution5 = (end - start);
            avgInter += execution5;
            System.out.println("Execution time of Interpolation Method is");
            System.out.println(execution5 + " nanoseconds");
            Main.dataOcean = new ArrayList<>(loadCSV.load_CSV_file());
        }

        Long avgBinInter =0l, execution6;
        for (int j=0; j<100000; j++){
            BinaryInterpolationSearch bis = new BinaryInterpolationSearch();
            start = System.nanoTime();
            System.out.println(bis.binaryInterpolationSearch("2000/01/12"));
            end = System.nanoTime();
            execution6 = (end - start);
            avgBinInter += execution6;
            System.out.println("Execution time of Binary Interpolation Method is");
            System.out.println(execution6 + " nanoseconds");
            Main.dataOcean = new ArrayList<>(loadCSV.load_CSV_file());
        }

        System.out.println("The avg Insertion sort execution time is "+ avgInsertion/100000 + " nanoseconds.");
        System.out.println("The avg Quick sort execution time is "+ avgQuick/100000 + " nanoseconds.");
        System.out.println("The avg Heap sort execution time is "+ avgHeap/100000 + " nanoseconds.");
        System.out.println("The avg Counting sort execution time is "+ avgCounting/100000 + " nanoseconds.");
        System.out.println("The avg Binary search execution time is "+ avgBinary/100000 + " nanoseconds.");
        System.out.println("The avg Interpolation Search execution time is "+ avgInter/100000 + " nanoseconds.");
        System.out.println("The avg Binary Interpolation search execution time is "+ avgBinInter/100000 + " nanoseconds.");
    }
}