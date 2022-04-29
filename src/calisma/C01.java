package calisma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));



        printElmnlariStructured(sayi);
        System.out.println("\n       ******       ");
        printElmnlriFunctional(sayi);
        System.out.println("\n       ******       ");
        printElmnlriFunctional1(sayi);
        System.out.println("\n       ******       ");
        printElmnlriFunctional2(sayi);
        System.out.println("\n       ******       ");
        printCiftElmnlriStructured(sayi);
        System.out.println("\n       ******       ");
        printCiftElmnlriFunctional(sayi);
        System.out.println("\n       ******       ");
        printCiftElmnlriFunctional1(sayi);
        System.out.println("\n       ******       ");
        printElmnlriKckCift(sayi);
        System.out.println("\n       ******       ");
        printElmnlriOtzDrtBykCift(sayi);


    }
    //Task : Structured Programing kullanarak list elemanlarini aralarinda bosluk olacak sekilde print ediniz

    public static void printElmnlariStructured(List<Integer> sayi){
        for (Integer w:sayi){
            System.out.print(w + " ");
        }
    }
    //Task : "functional Programing" Structured Programing kullanarak list elemanlarini aralarinda bosluk olacak sekilde print ediniz

    public static void printElmnlriFunctional(List<Integer> sayi){

        sayi.stream().forEach(t-> System.out.print(t+" "));
    }

    public static void printElmnlriFunctional1(List<Integer> sayi){

        sayi.stream().forEach(System.out::print);//method reference-->System.out yapisinda print methodu refere et

    }

    public static void yazdir(int a){//verilen int degeri ayni satirda bosluk birakarak yazdirma aksiyonu yapan seed(tohum) method create edildi
        System.out.print(a+ " ");
    }

    public static void printElmnlriFunctional2(List<Integer> sayi){

        sayi.stream().forEach(C01::yazdir);//method reference-->System.out yapisinda print methodu refere et

    }

    //structured programing ile list elemanlarinin cift olanlari ayni satirda aralarinda bosluk birakarak print ediniz
    public static void printCiftElmnlriStructured(List<Integer> sayi){
        for (Integer w : sayi) {
            if (w%2==0){
                System.out.print(w + " ");
            }
        }

    }
    //functional programing ile list elemanlarinin cift olanlari ayni satirda aralarinda bosluk birakarak print ediniz

    public static void printCiftElmnlriFunctional(List<Integer> sayi){
        sayi.stream().filter(t->t%2==0).forEach(C01::yazdir);
    }

    public static boolean ciftBul(int a){ //seed(tohum) method kendisine verilen int degerin cift olmasini kontrol eder
        return a%2==0;
    }

    public static void printCiftElmnlriFunctional1(List<Integer> sayi){
        sayi.
                stream().//liste elemanlari akisa alindi
                filter(C01::ciftBul).//cift bul method refere edilerek akisdaki elemanlar filtrelendi
                forEach(C01::yazdir);//filtre den gelen elemanlar yazdir() method refere edilerek print edildi

    }

    //Task : functional programing ile list deki elemanlarin 34 den kucuk cift olanlari ayni satirda aralarinda bosluk birakarak yazdirin

    public static void printElmnlriKckCift(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t<34).
                filter(C01::ciftBul).
                forEach(C01::yazdir);

    }
    //Task : functional programing ile list deki elemanlarin 34 den buyuk veya cift olanlari ayni satirda aralarinda bosluk birakarak yazdirin

    public static void printElmnlriOtzDrtBykCift(List<Integer> sayi){
        sayi.stream().filter(t->t%2==0 || t>34) .forEach(C01::yazdir);
    }



}
