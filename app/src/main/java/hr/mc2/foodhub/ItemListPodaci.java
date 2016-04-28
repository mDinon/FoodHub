package hr.mc2.foodhub;


import java.util.ArrayList;

/**
 * Klasa sadrzi podatke koji se pomocu adaptera ubacuju u listView
 * Created by Matija on 6.4.2016..
 */
public class ItemListPodaci {
    private String imeObjekta;
    private String vrstaObjekta;
    private String opisObjekta;
    private int rating;
    private int imageResource;
    private ArrayList<FoodListPodaci> menu = new ArrayList<>();

    public ItemListPodaci(String imeObjekta, String vrstaObjekta, int rating, int imageResource){
        this.imeObjekta = imeObjekta;
        this.vrstaObjekta = vrstaObjekta;
        this.rating = rating;
        this.imageResource = imageResource;
        //Stvori defaultni opis, pa se dodatno postavi sa setterom
        opisObjekta = imeObjekta + " OPIS";
    }

    public ArrayList<FoodListPodaci> getMenu(){
    if(menu != null){
        return this.menu;
    }
    else{
        ArrayList<FoodListPodaci> dummy = new ArrayList<>();
        FoodListPodaci dummyPodaci = new FoodListPodaci("dummyHrana","999");
        dummy.add(dummyPodaci);
        return dummy;
    }
    }

    public void setMenu(ArrayList<FoodListPodaci> menu){ this.menu = menu; }

    public String getOpisObjekta(){ return this.opisObjekta;}

    public void setOpisObjekta(String opisObjekta){ this.opisObjekta = opisObjekta;}

    public String getImeObjekta() {
        return this.imeObjekta;
    }

    public String getVrstaObjekta() {
        return this.vrstaObjekta;
    }

    public String getRating(){
        String convertRating = Integer.toString(this.rating);
        return convertRating;
    }
    public int getRatingInt(){
        return this.rating;
    }

    public int getImageResource(){
        return this.imageResource;
    }

}

