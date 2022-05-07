import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class loadCSV {

    public static void load_CSV_file() {
        String readLine = "", splitBy = ",", splitBy2 = "/";
        ArrayList<oceanEntries> oceanArray = new ArrayList<oceanEntries>();
        String[] tempString= new String[8];
        String[] tempDateString = new String[3];
        int tempTime;

        try {

            BufferedReader readCSV = new BufferedReader(new FileReader("ocean.csv"));

            readLine = readCSV.readLine();
            System.out.println(readLine + "\n");

            while((readLine = readCSV.readLine())!=null){
                tempString = readLine.split(splitBy);
                tempDateString = tempString[0].split(splitBy2);

                var date = new Date(Integer.parseInt(tempDateString[0]),Integer.parseInt(tempDateString[1]), Integer.parseInt(tempDateString[2]));
                var oceanEn = new oceanEntries(date, Float.parseFloat(tempString[1]), Float.parseFloat(tempString[2]), Float.parseFloat(tempString[3]), Float.parseFloat(tempString[4]), Float.parseFloat(tempString[5]), Float.parseFloat(tempString[6]), Float.parseFloat(tempString[7]));

                oceanArray.add(oceanEn);
            }

           for(var i: oceanArray)
            {
               System.out.println(i.getDate().displayDate() + " "+ i.getNO2uM());

            }

        }catch (IOException e){
            e.printStackTrace();
        }
}
}
