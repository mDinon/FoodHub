package hr.mc2.foodhub;

import java.io.Serializable;

/**
 * Klasa sadrzi podatke koji se pomocu adaptera ubacuju u listView
 * Created by Matija on 6.4.2016..
 */
public class ItemListPodaci implements Serializable {
    public String imeObjekta;
    public String vrstaObjekta;
    public int rating;

    public ItemListPodaci(String imeObjekta, String vrstaObjekta, int rating){
        this.imeObjekta = imeObjekta;
        this.vrstaObjekta = vrstaObjekta;
        this.rating = rating;
    }
}

