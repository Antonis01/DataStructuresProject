import java.util.ArrayList;
import java.util.Collections;

public class QuickSort (){
    static void quickSort(int left, int right, int middle) {
       oceanEnties temp;
        if ((Main.dataOcean.get(left).getT_degC()>Main.dataOcean.get(right).getT_degC() && Main.dataOcean.get(left).getT_degC()>Main.dataOcean.get(middle).getT_degC())&&Main.dataOcean.get(right).getT_degC()<Main.dataOcean.get(middle).getT_degC()){
           /*temp=Main.dataOcean.get(right).getT_degC();
            Collections.swap(Main.dataOcean, right ,left);
            Main.dataOcean.get(left).getT_degC()=temp;*/
        } else if ((Main.dataOcean.get(left).getT_degC()>Main.dataOcean.get(right).getT_degC() && Main.dataOcean.get(left).getT_degC()>Main.dataOcean.get(middle).getT_degC())&&Main.dataOcean.get(right).getT_degC()>Main.dataOcean.get(middle).getT_degC()) {
            /*temp=right;
            Main.dataOcean.get(right).getT_degC()=Main.dataOcean.get(left).getT_degC();
            Main.dataOcean.get(left).getT_degC()=Main.dataOcean.get(middle).getT_degC();
            middle=temp;*/
        }else if ((Main.dataOcean.get(middle).getT_degC()
                <Main.dataOcean.get(left).getT_degC() && Main.dataOcean.get(middle).getT_degC()<Main.dataOcean.get(right).getT_degC())&&Main.dataOcean.get(left).getT_degC()<Main.dataOcean.get(right).getT_degC()){
           /* temp=Main.dataOcean.get(middle).getT_degC();
            Main.dataOcean.get(middle).getT_degC()=Main.dataOcean.get(left).getT_degC();
            Main.dataOcean.get(left).getT_degC()=temp;*/
        }else if ((Main.dataOcean.get(left).getT_degC()<Main.dataOcean.get(middle).getT_degC()
                &&Main.dataOcean.get(left).getT_degC()<Main.dataOcean.get(right).getT_degC())&&Main.dataOcean.get(right).getT_degC()<Main.dataOcean.get(right).getT_degC()){
            /*temp=Main.dataOcean.get(right).getT_degC();
            Main.dataOcean.get(right).getT_degC()=Main.dataOcean.get(middle).getT_degC();
            Main.dataOcean.get(middle).getT_degC()=temp;*/
        }else if ((Main.dataOcean.get(middle).getT_degC()
                <Main.dataOcean.get(left).getT_degC()&&Main.dataOcean.get(middle).getT_degC()<Main.dataOcean.get(right).getT_degC())&&Main.dataOcean.get(right).getT_degC()<Main.dataOcean.get(left).getT_degC()){
           /* temp=Main.dataOcean.get(middle).getT_degC();
            Main.dataOcean.get(left).getT_degC()=Main.dataOcean.get(middle).getT_degC();
            Main.dataOcean.get(left).getT_degC()=temp;*/
        }


    }
        }