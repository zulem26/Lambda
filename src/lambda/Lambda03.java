package lambda;

import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilece", "havucDilim",
                "buryan","yaglama", "kokorec", "arabAsi", "guvec","trilece","trilece","trilece"));

        alfBykTekrrsz(menu);
        System.out.println("\n   ***   ");
        chrSayisiTersSirali(menu);
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menu);
        System.out.println("\n   ***   ");
        sonHrfBkSirala(menu);
        System.out.println("\n   ***   ");
        charKaresiCiftElSirala(menu);
        System.out.println("\n   ***   ");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n   ***   ");
        wIleBaslayanElemanKontrol(menu);
        System.out.println("\n   ***   ");
        xIleBitenEnAzBirEl(menu);
        System.out.println("\n   ***   ");
        charSayisiEnBykElPrint(menu);
        System.out.println("\n   ***   ");
        ilkElHaricSonHrfSraliPrint(menu);


    }
        // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.


        public static void alfBykTekrrsz(List<String> yemek){
        yemek.//akis kaynagi
                stream(). //akisa girdi
                //map(t->t.toUpperCase()). //elemanlar buyuk harf update edildi
                map(String::toUpperCase).
                sorted().//alfabetik (natural dogal) sira yapildi
                distinct().//benzersiz tekrarsiz hale getirildi
                forEach(t->System.out.print(t+" "));//print edildi

        }

        // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSirali(List<String> menu){
        menu.
                stream().//akisa alindi
                //map(t->t.length()).
                map(String::length).//elemanlar karakter sayisina update edildi
                sorted(Comparator.reverseOrder()).
                distinct().//benzersiz yapildi
                //forEach(t->System.out.print(t+" "))
                forEach(Lambda01::yazdir);//print edilid

    }

        // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBkSirala(List<String> menu){
        menu.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(t->System.out.print(t+" "));

    }
        // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
        public static void sonHrfBkSirala(List<String> menu){
            menu.
                    stream().
                    sorted(Comparator.comparing(t->t.toString().
                            charAt(t.toString().length()-1)).
                            reversed()).
                    forEach(t->System.out.print(t+" "));

        }

        // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve
        // karelerini tekrarsiz buyukten kucuge sirali  print ediniz..

    public static void charKaresiCiftElSirala(List<String> menu){
        menu.
                stream().//akisa alindi
                map(t->t.length()*t.length()). //akisdaki string elemanlar boyutlarinin karesine update edildi
                filter(Lambda01::ciftBul).//cift elemanlar filtrelendi
                distinct().//tekrarsiz yapildi
                sorted(Comparator.reverseOrder()). //ters b->k sira yapildi
                forEach(Lambda01::yazdir); // print edildi
    }

        // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String> menu){
       boolean kontrol = menu.stream().allMatch(t->t.length()<=7);
        System.out.println("1nci yontem");
       if (kontrol){
           System.out.println("list elemanlari 7 ve daha az harften olusuyor");
       }else{
           System.out.println("list elemanlari 7 harften buyuk ");
       }
        System.out.println(kontrol);
        System.out.println("2nci yontem");
       System.out.println(menu.
               stream().
               allMatch(t-> t.length() <=7) ? "list elmanlari 7ve daha az harften olusuyor" : "list elemanlari 7 harften buyuk");
    }
        // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElemanKontrol(List<String> menu){

        System.out.println(menu.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek var mi vR" : "w ile baslayan yemek olur mu");

    }
        // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBitenEnAzBirEl(List<String> menu){
        System.out.println(menu.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile biten yemekte mi var mis" : "x ile biten yemek olur mu");

    }

        // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiEnBykElPrint(List<String> menu){
        Stream<String> sonIsim = menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                //findFirst());
                limit(3); //limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır
        /*
        sonIsim.toArray() --> limit() method return den dolayi stream type olan sonIsim toArray() method ile
        array type convert edildi
         */
        System.out.println(Arrays.toString(sonIsim.toArray())); // array a cevrilen sonIsim stream print edildi

        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.

        /*
        TRİCK :     Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz. Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
        Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.
         */

        Optional<String> enBykKrEl = menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst(); //ilk eleman alindi

    }
        // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHaricSonHrfSraliPrint(List<String> menu){
        menu.
                stream().//akisa alindi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). //son harfe gore siralandi
                skip(1).//ilk eleman atlandi
                forEach(t->System.out.print(t+" "));//print edildi
        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
// Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
//skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.
    }




}
