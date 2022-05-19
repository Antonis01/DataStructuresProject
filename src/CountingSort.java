import java.util.ArrayList;

public class CountingSort {

    public static ArrayList B = new ArrayList();
    //METHODS
    public static void countingSort(ArrayList A, int n, int k) {

        ArrayList<Integer> C = new ArrayList<>();

        for (int i = 0; i <= k; i++) { //Arxikopiisi C me 0
            C.add(0); //C[i]<-0
        }

        for (int i = 0; i <= n; i++) { //Arxikopiisi B
            B.add(0);
        }

        oceanEntries temp_entry; //Proetimasia C
        float temp_f_phosphate;
        int temp_i_phosphate;
        for (int j = 0; j < n ; j++) {
            temp_entry = (oceanEntries) A.get(j);
            temp_f_phosphate = temp_entry.getPO4uM() * 100; //*100 Gia na ginoun integers
            temp_i_phosphate = (int) temp_f_phosphate;
            C.set(temp_i_phosphate, C.get(temp_i_phosphate) + 1); //C[A[j]]<-C[A[j]]+1
        }

        for (int i = 1; i <= k; i++) { //C[i]<-C[i]+C[i-1]
            C.set(i, C.get(i) + C.get(i - 1));
        }


        for (int j = n - 1; j >= 0; j--) {
            temp_entry = (oceanEntries) A.get(j);
            temp_f_phosphate = temp_entry.getPO4uM() * 100;
            temp_i_phosphate = (int) temp_f_phosphate; // to temp_i_phosphate ine to A[j] mou

            B.set(C.get(temp_i_phosphate), temp_entry); //B[C[A[j]]]<-A[j]

            C.set(temp_i_phosphate, C.get(temp_i_phosphate) - 1); //C[A[j]]<-C[A[j]]-1

        }


        //Copying B into A
        for(int i = 1; i<=1405; i++){
            A.set(i-1, B.get(i));
        }
    }
}