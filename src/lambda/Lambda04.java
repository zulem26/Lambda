package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda04 {
    public static void main(String[] args) {

        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yildiz teknik", "gemi", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici,itu,istanbul,marmara,ytu));

        System.out.println(notOrt74BykUnv(unv));


    }

    //task 01--> notOrt larinin 74 den buyuk olan kontrol eden print create ediniz
    public static boolean notOrt74BykUnv(List<Universite> unv){

        return unv.
                stream().
                allMatch(t->t.getNotOrt()>74);
    }

}
