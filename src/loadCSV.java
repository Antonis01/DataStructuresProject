import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class loadCSV {

    public static ArrayList<oceanEntries> load_CSV_file() {
        String readLine = " ", splitBy = ",", splitBy2 = "/";
        ArrayList<oceanEntries> oceanArray = new ArrayList<>();
        String[] tempString= new String[8];
        String[] tempDateString = new String[3];

        try {

            BufferedReader readCSV = new BufferedReader(new FileReader("ocean.csv"));

            readLine = readCSV.readLine();
            System.out.println(readLine + "\n");

            while((readLine = readCSV.readLine())!=null){
                tempString = readLine.split(splitBy);
                tempDateString = tempString[0].split(splitBy2);

                var date = new Date(tempDateString[2],tempDateString[0], tempDateString[1]);      ///dd
                var oceanEn = new oceanEntries(date, Float.parseFloat(tempString[1]), Float.parseFloat(tempString[2]), Float.parseFloat(tempString[3]), Float.parseFloat(tempString[4]), Float.parseFloat(tempString[5]), Float.parseFloat(tempString[6]), Float.parseFloat(tempString[7]));

                oceanArray.add(oceanEn);
            }


        }catch (IOException e){
            e.printStackTrace();
        }
        return oceanArray;
    }
}