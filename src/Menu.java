import java.util.Scanner;

public class Menu {
    public void menu(){
        Scanner scn = new Scanner(System.in);
        String scan;
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
                        is.insertionSort(0,Main.dataOcean.size()-1);
                        is.printInsertionSort();
                        break;
                    case 2:
                        System.out.println("You have selected Quick Sort!");
                        QuickSort is=new QuickSort();
                        is.quickSort(0,Main.dataOcean.size()-1);
                        is.printQuickSort();
                        break;

                    case 3:
                        System.out.println("You have selected Heap Sort!");
                        HeapSort hs = new HeapSort();
                        hs.heapSort(Main.dataOcean, 0, Main.dataOcean.size() - 1, false);
                        hs.printHeapSort();
                        break;

                    case 4:
                        System.out.println("You have selected Counting Sort!");
                        //Counting Sort
                        CountingSort cs = new CountingSort(); //Create Counting Sort object
                        cs.countingSort(Main.dataOcean,1405, 332); //Call the Counting Sort Function and put in the parameters
                        // 1405 = how many entries we have , 332 = the maximum Phosphate registered in our data
                        //The Function sorts the dataOcean array inside the sorted_array array
                        for (int i = 0; i < Main.dataOcean.size(); i++) {
                            System.out.println(i+1 + ") " + Main.dataOcean.get(i).getDate().displayDate() + " " + Main.dataOcean.get(i).getPO4uM());
                        }
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
                        System.out.println(bs.binarySearch(scan2));

                        String[] arr1 = new String[Main.dataOcean.size()];
                        for (int j = 0; j < Main.dataOcean.size(); j++) {
                            for (var i : Main.dataOcean) {
                                arr1[j] = i.getDate().displayDate();
                            }
                        }
                        break;

                    case 2:
                        System.out.println("You have selected Interpolation Search!");
                        System.out.println("Give a date in the (yyyy/mm/dd) format.");
                        scan2 = scn2.nextLine();
                        InterpolationSearch is = new InterpolationSearch();
                        System.out.println(is.interpolationSearch(scan2));


                        String[] arr2 = new String[Main.dataOcean.size()];
                        for (int j = 0; j < Main.dataOcean.size(); j++) {
                            for (var i : Main.dataOcean) {
                                arr2[j] = i.getDate().displayDate();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("You have selected Binary Interpolation Search!");
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