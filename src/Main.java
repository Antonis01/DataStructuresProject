import java.util.ArrayList;

public class Main {

    public static ArrayList<oceanEntries> dataOcean = new ArrayList<>(loadCSV.load_CSV_file());

    public static void main(String[] args) {

        Menu m=new Menu();
        m.menu();

    }
}