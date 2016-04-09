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

    public ItemListPodaci(String imeObjekta, String vrstaObjekta, int rating){
        this.imeObjekta = imeObjekta;
        this.vrstaObjekta = vrstaObjekta;
        this.rating = rating;
    }

    public String getImeObjekta() {
        return this.imeObjekta;
    }

    public String getVrstaObjekta() {
        return this.vrstaObjekta;
    }

    public int getRating(){
        return this.rating;
    }
}

