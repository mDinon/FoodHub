package hr.mc2.foodhub;


/**
 * Created by Matija on 27.4.2016..
 */
public class FoodListPodaci{


    private String imeProizvoda;
    private String cijena;

    public FoodListPodaci(String imeProizvoda, String cijena){
        this.imeProizvoda = imeProizvoda;
        this.cijena = cijena;
    }

    public String getImeProizvoda() {
        return this.imeProizvoda;
    }

    public String getCijena(){
        return this.cijena;
    }

}
