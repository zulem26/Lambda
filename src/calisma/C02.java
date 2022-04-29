package calisma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C02 {
    public static void main(String[] args) {


        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftKarePrint(sayi);
        System.out.println("\n       ******       ");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n       ******       ");
        elmnlrinCiftKarekokPrint(sayi);
        System.out.println("\n       ******       ");
        maxEnBykElmnBul(sayi);
        System.out.println("\n       ******       ");
        ciftKareMaxBul(sayi);
        System.out.println("\n       ******       ");
        elTopla(sayi);
        System.out.println("\n       ******       ");
        ciftCarp(sayi);

    }
    //Task : Functional programing ile list te cift elemanlarin karelerini ayni satirda aralarinda bosluk birakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.stream().filter(C01::ciftBul).map(t->t*t).forEach(C01::yazdir);
    }
    //Task : Functional programing ile listin tek elemanlarinin kuplerinin bir fazlasini ayni satirda aralarinda bosluk birakarak print ediniz

    public static void tekKupBirFazlaPrint(List<Integer> sayi){

        sayi.
                stream().//sayilar akisa alindi
                filter(t->t%2!=0).//tek elemanlar filtrelendi
                map(t-> (t*t*t)+1).//tek elemanlari kuplerini 1 fazlasi update edildi
                forEach(C01::yazdir);//print edildi

    }
    //Task : Functional programing ile listin cift elemanlarinin karekoklerini ayni satirda aralarinda bosluk birakarak yazdiriniz

    public static void elmnlrinCiftKarekokPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(C01::ciftBul).
                map(Math::sqrt).//method ref
                //forEach(C01::yazdir)-->yazdir() method int. calistigi icin map den cikan datalari calistirmaz
                forEach(t->System.out.print(t+" "));
    }
    //Task : list in en buyuk elemanini yazdiriniz

    public static void maxEnBykElmnBul(List<Integer> sayi){
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max);//akisa giren elemanlarin aksiyon sonrasi tek eleman haline getirir
        System.out.println(maxSayi);
        System.out.println("diger yazim:" + sayi.stream().reduce(Math::max));
    }
    //Task : List in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxBul(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(C01::ciftBul).
                map(t -> t * t).
                reduce(Math::max));

        System.out.println(sayi.
                stream().
                filter(C01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));//specific class daha hizli run olur
    }
    //Task : List teki tum elemanlarin toplamini yazdiriniz
        //Lambda Expression...
    public static void elTopla(List<Integer> sayi){
        int toplam = sayi.stream().reduce(0, (a,b) -> a+b);
        /*
        a ilk degerini her zaman atanan degerden (identity) alir
        b degerini her zaman stream()dan akisdan alir
        a ilk degerinden sonraki her degeri action(islem) dan alir
         */

        System.out.println("Lambda exp. :" + toplam);
        //Method ref...
        Optional<Integer> topla = sayi.stream().reduce(Integer::sum);
        System.out.println("method ref :" + sayi.stream().reduce(Integer::sum));//method ref

    }
    //Task : List teki cift elemanlarin carpimini yazdiriniz
    public static void ciftCarp(List<Integer> sayi){
        //Method ref...
        System.out.println("Method ref." +sayi.
                stream().
                filter(C01::ciftBul).
                reduce(Math::multiplyExact));

        //Lambda Expression...
        System.out.println("Lambda Expression " + sayi.
                stream().
                filter(C01::ciftBul).
                reduce(1, (a, b) -> (a * b)));
    }

}
