import java.util.Scanner;

public class Menu {
    public void menu(){
        Scanner scn = new Scanner(System.in);
        String scan;
        Long start, end, execution;
        System.out.print("=================\n1) Sort the Data. \n2) Search a Date.\n=================\nPress a number to continue...\n");

        scan = scn.next();
        switch (Integer.parseInt(scan)){
            case 1:
                System.out.println("You have selected sorting!\n\n1) Insertion Sort.\n2) Quick Sort.\n3) Heap Sort.\n4) Counting Sort.\n=================\nPress a number to continue...\n");
                scan = scn.next();

                switch (Integer.parseInt(scan)){

                    case 1:
                        System.out.println("You have selected Insertion Sort!");
                        InsertionSort is=new InsertionSort();
                         start = System.nanoTime();
                        is.insertionSort(0,Main.dataOcean.size()-1);
                        end = System.nanoTime();
                        execution = (end - start);
                        is.printInsertionSort();
                        System.out.println("Execution time of InsertionSort Method is");
                        System.out.println(execution + " nanoseconds");
                        break;
                    case 2:
                        System.out.println("You have selected Quick Sort!");
                        QuickSort qs=new QuickSort();
                        start = System.nanoTime();
                        qs.quickSort(0,Main.dataOcean.size()-1);
                        end = System.nanoTime();
                        execution = (end - start);
                        qs.printQuickSort();
                        System.out.println("Execution time of Quick Sort Method is");
                        System.out.println(execution + " nanoseconds");
                        break;

                    case 3:
                        System.out.println("You have selected Heap Sort!");
                        HeapSort hs = new HeapSort();
                        start = System.nanoTime();
                        hs.heapSort(Main.dataOcean, 0, Main.dataOcean.size() - 1, false);
                        end = System.nanoTime();
                        execution = (end - start);
                        hs.printHeapSort();
                        System.out.println("Execution time of Heap Sort Method is");
                        System.out.println(execution + " nanoseconds");
                        break;

                    case 4:
                        System.out.println("You have selected Counting Sort!");
                        //Counting Sort
                        CountingSort cs = new CountingSort(); //Create Counting Sort object
                        start = System.nanoTime();
                        cs.countingSort(Main.dataOcean,1405, 332); //Call the Counting Sort Function and put in the parameters
                        // 1405 = how many entries we have , 332 = the maximum Phosphate registered in our data
                        //The Function sorts the dataOcean array inside the sorted_array array
                        end = System.nanoTime();
                        execution = (end - start);
                        cs.printCountingSort();
                        System.out.println("Execution time of Counting Sort is");
                        System.out.println(execution + " nanoseconds");
                        break;

                    default:
                        System.out.println("Wrong Input!");
                }
                break;


            case 2:
                HeapSort hs = new HeapSort();
                hs.heapSort(Main.dataOcean, 0, Main.dataOcean.size() - 1, true);
                System.out.println("You have selected searching!\n\n1) Binary Search.\n2) Interpolation Search.\n3) Binary Interpolation Search.\n=================\nPress a number to continue...\n");
                Scanner scn2 = new Scanner(System.in);

                scan = scn.next();


                switch (Integer.parseInt(scan)) {

                    case 1:
                        String scan2;
                        System.out.println("You have selected Binary Search!");
                        System.out.println("Give a date in the (yyyy/mm/dd) format.");
                        scan2 = scn2.nextLine();
                        BinarySearch bs = new BinarySearch();
                        start = System.nanoTime();
                        System.out.println(bs.binarySearch(scan2));
                        end = System.nanoTime();
                        execution = (end - start);
                        String[] arr1 = new String[Main.dataOcean.size()];
                        for (int j = 0; j < Main.dataOcean.size(); j++) {
                            for (var i : Main.dataOcean) {
                                arr1[j] = i.getDate().displayDate();
                            }
                        }
                        System.out.println("Execution time of Binary Search Method is");
                        System.out.println(execution + " nanoseconds");
                        break;

                    case 2:
                        System.out.println("You have selected Interpolation Search!");
                        System.out.println("Give a date in the (yyyy/mm/dd) format.");
                        scan2 = scn2.nextLine();
                        InterpolationSearch is = new InterpolationSearch();
                        start = System.nanoTime();
                        System.out.println(is.interpolationSearch(scan2));
                        end = System.nanoTime();
                        execution = (end - start);
                        String[] arr2 = new String[Main.dataOcean.size()];
                        for (int j = 0; j < Main.dataOcean.size(); j++) {
                            for (var i : Main.dataOcean) {
                                arr2[j] = i.getDate().displayDate();
                            }
                        }
                        System.out.println("Execution time of Interpolation Method is");
                        System.out.println(execution + " nanoseconds");
                        break;

                    case 3:
                        System.out.println("You have selected Binary Interpolation Search!");
                        System.out.println("Give a date in the (yyyy/mm/dd) format.");
                        scan2 = scn2.nextLine();
                        BinaryInterpolationSearch bis = new BinaryInterpolationSearch();
                        start = System.nanoTime();
                        System.out.println(bis.binaryInterpolationSearch(scan2));
                        end = System.nanoTime();
                        execution = (end - start);
                        System.out.println("Execution time of Binary Interpolation Method is");
                        System.out.println(execution + " nanoseconds");
                        break;


                    default:
                        System.out.println("Wrong Input!");
                        break;
                }
                break;

            default:
                System.out.println("Wrong Input!");
                break;
        }
    }
}