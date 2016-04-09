package hr.mc2.foodhub;

import java.io.Serializable;

/**
 * Klasa sadrzi podatke koji se pomocu adaptera ubacuju u listView
 * Created by Matija on 6.4.2016..
 */
public class ItemListPodaci implements Serializable {
    private String imeObjekta;
    private String vrstaObjekta;
    private int rating;
    private int imageResource;

    public ItemListPodaci(String imeObjekta, String vrstaObjekta, int rating, int imageResource){
        this.imeObjekta = imeObjekta;
        this.vrstaObjekta = vrstaObjekta;
        this.rating = rating;
        this.imageResource = imageResource;
    }

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

    public int getImageResource(){
        return this.imageResource;
    }
}

