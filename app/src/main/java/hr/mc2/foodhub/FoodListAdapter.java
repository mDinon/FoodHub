package hr.mc2.foodhub;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matija on 27.4.2016..
 */
public class FoodListAdapter extends ArrayAdapter<FoodListPodaci> {

    public FoodListAdapter(Context context, int fragment_food, ArrayList<FoodListPodaci> podaci) {
        super(context,0,podaci);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Dohvaćanje podataka na ovoj poziciji
        FoodListPodaci noviPodaci = getItem(position);
        // Provjera da li je postojeci view ponovo iskorišten
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_liste_hrane, parent, false);
        }
        // Dohvaćanje view-ova za populaciju podacima
        TextView imeProizvoda = (TextView) convertView.findViewById(R.id.imeProizvoda);
        TextView cijenaProizvoda = (TextView) convertView.findViewById(R.id.cijenaProizvoda);

        // Populacija podataka u dohvaćene view-ove
        imeProizvoda.setText(noviPodaci.getImeProizvoda());
        cijenaProizvoda.setText(noviPodaci.getCijena()+"kn");

        // Vraćanje završenog view-a kako bi se prikazao na ekranu
        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.LTGRAY);
        }
        return convertView;
    }

}
