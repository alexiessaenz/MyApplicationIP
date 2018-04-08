package control;
import com.example.hdrdr.myapplicationip.MainActivity;

import java.util.ArrayList;

/**
 * Created by HDRDR on 4/7/2018.
 */

public class nose {

    public static String calcular (String ip, String masc){
        char dot ='.';
        int cont=3;


        String octeDec="";
        ArrayList<Integer> ipDecimal = new ArrayList<Integer>();
        ArrayList<Integer> dirRed = new ArrayList<Integer>();




        for(int n = 0 ; n<=ip.length()-1 ; n++) {                                   //
            if (ip.charAt(n) != dot) {
                octeDec+=Character.toString(ip.charAt(n));
            }
            if (ip.charAt(n) == dot) {
                ipDecimal.add(Integer.valueOf(octeDec));

                octeDec="";
            }
        }                                                                           //
        ipDecimal.add(Integer.valueOf(octeDec));




        ArrayList<Integer> ipBinaria = new ArrayList<Integer>();

        String octa="";
        int num = 0;

        for (int f = 0; f < ipDecimal.size(); f++) {
            octa=(Integer.toString(ipDecimal.get(f))); //error

            int z = Integer.valueOf(octa);
            octa=Integer.toString(z, 2);

            String octaInv="";
            for (int j=octa.length()-1 ; j>=0 ; j--) octaInv = octaInv + octa.charAt(j); //invertir la cadena con el octeto en binario


            for (int i = (8-octaInv.length()); i > 0; i--) octaInv+="0";    //agregar ceros al octeto


            octa="";
            for (int j=octaInv.length()-1 ; j>=0 ; j--) octa = octa + octaInv.charAt(j); //revertir la cadena contenido el octeto con ceros a la izquierda en binario

            for (int i = 0; i < 8; i++) {
                ipBinaria.add(Integer.parseInt(String.valueOf(octa.charAt(i))));
            }

            octa="";
        }

        for (int i = 0; i < Integer.parseInt(masc); i++) {
            dirRed.add(ipBinaria.get(i));

        }



        for (int i = Integer.parseInt(masc); i < 32-1 ; i++) {
            dirRed.add(1);

        }
        dirRed.add(0);


        String UltimoHost = "";
        octa="";
        cont = 0;
        num = 0;
        for (int i = 0; i < 32; i++) {
            cont++;
            octa += Integer.toString(dirRed.get(i));

            if (cont == 8) {
                num++;

                int z = 0;
                z = Integer.parseInt(octa, 2);

                UltimoHost += z;
                if (num<4) UltimoHost += ".";

                cont = 0;
                octa = "";
            }
        }
        System.out.println("direccion de ultimo host: "+UltimoHost );

        return UltimoHost;
    }
}
