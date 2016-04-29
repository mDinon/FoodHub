package hr.mc2.foodhub;


import java.lang.reflect.Array;

/**
 * Created by Matija on 27.4.2016..
 */
public class FoodListPodaci{


    private String imeProizvoda;
    private String cijena;
    //Zasad su sastojci u Stringovima, kasnije će biti u String[]
    private String sastojci="sastojak1, sastojak2, sastojak3...";

    public FoodListPodaci(String imeProizvoda, String cijena){
        this.imeProizvoda = imeProizvoda;
        this.cijena = cijena;
    }

    public void FoodListPodaci(String imeProizvoda, String cijena, String sastojci){
        this.imeProizvoda = imeProizvoda;
        this.cijena = cijena;
        this.sastojci = sastojci;
    }

    public void setSastojke(String sastojci) {
        this.sastojci = sastojci;
    }

   /* public StringBuilder appendSastojke(String[] sastojci) {

    }*/

    public String getSastojke() {
        return this.sastojci;
    }

    public String getImeProizvoda() {
        return this.imeProizvoda;
    }

    public String getCijena(){
        return this.cijena;
    }

}
