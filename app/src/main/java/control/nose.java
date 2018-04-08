package control;
import com.example.hdrdr.myapplicationip.MainActivity;

import java.util.ArrayList;
import java.util.ArrayList;
import java.lang.Integer.*;
import static java.lang.Integer.parseInt;

/**
 * Created by HDRDR on 4/7/2018.
 */

public class nose {
     static  ArrayList<Integer> Red = new ArrayList<Integer>();
     static String partHost = "";
     static ArrayList<Integer> ipe = new ArrayList<Integer>();

    //ArrayList<Integer> host = new ArrayList<Integer>();


    public static String obtenerDireccionRed(String ip, String masc) {
        //-----------------------------
        char dot = '.';
        int cont = 3;
        int masca = parseInt(masc);

        String octeDec = "";
        ArrayList<Integer> ipDecimal = new ArrayList<Integer>();


        for (int n = 0; n <= ip.length() - 1; n++) {                                   //
            if (ip.charAt(n) != dot) {
                octeDec += Character.toString(ip.charAt(n));
            }
            if (ip.charAt(n) == dot) {
                ipDecimal.add(Integer.valueOf(octeDec));

                octeDec = "";
            }
        }                                                                           //
        ipDecimal.add(Integer.valueOf(octeDec));
        ipe=ipDecimal;
        //--------------------------------------------
        //int masca = parseInt(masc);
        int suma = 0;
        ArrayList<Integer> mascara = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            //System.out.println("masca "+ masca);
            if (masca > 8) {
                masca -= 8;
                mascara.add(255);
            }
        }
        for (int j = 7; j > 7 - masca; j--) {
            System.out.println("masca " + masca);
            System.out.println("j = " + j);

            suma += (int) Math.pow(2, j);
            System.out.println("potencia " + suma);
        }

        mascara.add(suma);
        mascara.add(0);
        System.out.println("mascara : " + mascara);

        ArrayList<Integer> dirRed = new ArrayList<Integer>();


        for (int i = 0; i < 4; i++) {
            dirRed.add(ipDecimal.get(i)& mascara.get(i));
            System.out.println("broadcast: "+dirRed);
        }

        Red = dirRed; //clonar arreglo para posterior uso



        //----------------------- conversion String

        String octa="";
        for (int i = 0; i < 4; i++) {
            octa += Integer.toString(dirRed.get(i));
            if (i < 3) octa += ".";
        }
        System.out.println("direccion de direccion de red: "+octa );
        return octa;
    }


    public static String obtenerBroadcast (String ip, String masc){
        //-----------------------------
        char dot = '.';
        int cont = 3;
        int masca = parseInt(masc);

        String octeDec = "";
        ArrayList<Integer> ipDecimal = new ArrayList<Integer>();


        for (int n = 0; n <= ip.length() - 1; n++) {                                   //
            if (ip.charAt(n) != dot) {
                octeDec += Character.toString(ip.charAt(n));
            }
            if (ip.charAt(n) == dot) {
                ipDecimal.add(Integer.valueOf(octeDec));

                octeDec = "";
            }
        }                                                                           //
        ipDecimal.add(Integer.valueOf(octeDec));
        //--------------------------------------------
        int suma = 0;
        //int masca = parseInt(masc);

        ArrayList<Integer> mascarainv = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            if (masca > 8) {
                masca -= 8;
                mascarainv.add(0);
            }
        }

        int mascainv = 8-masca;
        for (int j = 0; j <  mascainv; j++) suma += (int) Math.pow(2, j); //obteniendo octeto limite
        mascarainv.add(suma);
        mascarainv.add(255);
        ArrayList<Integer> broadcast = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) broadcast.add(ipDecimal.get(i) | mascarainv.get(i)); // operacion binaria or

        //----------------------- conversion String
            String octa = "";
            for (int i = 0; i < 4; i++) {
                octa += Integer.toString(broadcast.get(i));
                if (i < 3) octa += ".";
            }
            System.out.println("direccion de broadcast: " + octa);
            return octa;

    }

    public static String cortarRed (){
        String partRed = "";

        int as;
        int ass;
        for (int i = 0; i < 4; i++) {
            as=Red.get(i);
            ass=ipe.get(i);
            System.out.println("reddddddddd: "+ Red);
            System.out.println("ipppppppppp: "+ ipe);
            System.out.println("igualllllll: "+ (as==ass));

            if (Red.get(i).equals(ipe.get(i))) {
                partRed += Integer.toString(Red.get(i));
                if (i < 3) partRed += ".";
                ///
            }else{
                partHost += Integer.toString(Red.get(i));
                if (i < 3) partHost += ".";
            }

        }
        return partRed;
    }

    public static String cortarHost (){
        return partHost;
    }



}
