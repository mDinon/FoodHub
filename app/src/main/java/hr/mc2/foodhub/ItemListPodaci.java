package hr.mc2.foodhub;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Klasa sadrzi podatke koji se pomocu adaptera ubacuju u listView
 * Created by Matija on 6.4.2016..
 */
public class ItemListPodaci {
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
    public int getRatingInt(){
        return this.rating;
    }

    public int getImageResource(){
        return this.imageResource;
    }

    public static void bubble_srt_rating(ArrayList<ItemListPodaci> podaci) {
        int n = podaci.size();
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (podaci.get(i).getRatingInt() < podaci.get(k).getRatingInt()) {
                    swapNumbers(i, k, podaci);
                }
            }
        }
    }

    private static void swapNumbers(int i, int j, ArrayList<ItemListPodaci> array) {
        ItemListPodaci temp;
        temp = array.get(i);
        //array.get(i) = array.get(j);
        array.set(i, array.get(j));
        //array.get(j) = temp;
        array.set(j, temp);

    }



}

