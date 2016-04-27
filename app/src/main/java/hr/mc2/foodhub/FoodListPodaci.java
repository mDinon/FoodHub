package hr.mc2.foodhub;

/**
 * Created by Matija on 27.4.2016..
 */
public class FoodListPodaci {
    private String imeProizvoda;
    private Integer cijena;

    public FoodListPodaci(String imeProizvoda, Integer cijena){
        this.imeProizvoda = imeProizvoda;
        this.cijena = cijena;
    }

    public String getImeProizvoda() {
        return this.imeProizvoda;
    }

    public String getCijena(){
        return this.cijena.toString();
    }
}
