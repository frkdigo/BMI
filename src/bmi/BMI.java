package bmi;

import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {
        cim("BMI index kiszámítása");
        int tomeg = beker("Kérem adja meg a testtömegét kg-ban [40-150kg]: ",40,150);
        int mag = beker("Kérem adja meg a magasságát cm-ben [100; 200]:",100,200);
        double bmiIndex = bmi(tomeg, mag);
        ertekeles(tomeg, mag, bmiIndex);
    }

    private static void cim(String szoveg) {
        System.out.println(szoveg);
    }

    private static int beker(String szoveg, int szam1,int szam2) {
        Scanner be = new Scanner(System.in);
        System.out.println(szoveg);
        String bekeres = be.nextLine();
        while(!ellenorzes(bekeres, szam1, szam2)){
            bekeres = be.nextLine();
        }
        return Integer.parseInt(bekeres);
    }
    private static boolean ellenorzes(String adat, int szam1, int szam2){
        if(adat.equals("")){
            System.out.println("HIBA:üres mező");
            return false;
        }
        for (int i = 0; i < adat.length(); i++)
            if (!Character.isDigit(adat.charAt(i))){
                System.out.println("HIBA:csak számokat adhat meg");
                return false;}
        if(!(Integer.parseInt(adat) > szam1 && Integer.parseInt(adat) <szam2)){
            System.out.println("HIBA:csak a megadott értékek közül adhat meg számot");
            return false;}
        return true;
    }

    private static double bmi(double tomeg, double mag) {
        double magassag = mag*0.01;
        double bmiIndex = tomeg/(magassag*magassag);
        return bmiIndex;
    }

    private static void ertekeles(int tomeg, int mag, double bmiIndex) {
        String[] tarolo = {"Ön súlyosan sovány!","Ön mérsékelten sovány!","Ön enyhén sovány!","Ön normális testúllyal rendelkezik","Ön túlsúlyos!","Ön I. fokú elhízásban szenved!","Ön II.fokú elhízásban szenved!","Ön III. fokú súlyos elhízásban szenved!"};
        System.out.printf("Ön %d cm magas és %d kg tömegű.\n Így BMI indexe %.2f ",mag, tomeg, bmiIndex);
        if(bmiIndex < 16.0){
            System.out.println(tarolo[0]);
        }else if(bmiIndex >= 16.0 && bmiIndex <=16.99){
            System.out.println(tarolo[1]);
        }else if(bmiIndex >= 17.0 && bmiIndex <=18.49){
            System.out.println(tarolo[2]);
        }else if(bmiIndex >= 18.5 && bmiIndex <=24.99){
            System.out.println(tarolo[3]);
        }else if(bmiIndex >= 25.0 && bmiIndex <=29.99){
            System.out.println(tarolo[4]);
        }else if(bmiIndex >= 30.0 && bmiIndex <=34.99){
            System.out.println(tarolo[5]);
        }else if(bmiIndex >= 35.0 && bmiIndex <=39.99){
            System.out.println(tarolo[6]);
        }else if(bmiIndex >= 40){
            System.out.println(tarolo[7]);
        }
    }
}
