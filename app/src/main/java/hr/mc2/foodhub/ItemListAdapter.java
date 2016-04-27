package hr.mc2.foodhub;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;

import java.util.ArrayList;

/**
 * Klasa koja stvara custom adapter za popunjavanje podataka u cjenik
 * Created by Matija on 6.4.2016..
 */
public class ItemListAdapter extends ArrayAdapter<ItemListPodaci> {

    public ItemListAdapter(Context context, ArrayList<ItemListPodaci> podaci) {
        super(context,0,podaci);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Dohvaćanje podataka na ovoj poziciji
        ItemListPodaci noviPodaci = getItem(position);
        // Provjera da li je postojeci view ponovo iskorišten
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_liste_objekata, parent, false);
        }
        // Dohvaćanje view-ova za populaciju podacima
        TextView textImeObjekta = (TextView) convertView.findViewById(R.id.imeObjekta);
        TextView textVrstaObjekta = (TextView) convertView.findViewById(R.id.vrstaObjekta);
        TextView textRating = (TextView) convertView.findViewById(R.id.rating);
        ImageView imageLogo = (ImageView) convertView.findViewById(R.id.logoObjekta);

        // Populacija podataka u dohvaćene view-ove
        textImeObjekta.setText(noviPodaci.getImeObjekta());
        textVrstaObjekta.setText(noviPodaci.getVrstaObjekta());
        textRating.setText(noviPodaci.getRating());
        imageLogo.setImageResource(noviPodaci.getImageResource());

        // Vraćanje završenog view-a kako bi se prikazao na ekranu
        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.LTGRAY);
            /*float[] a = {216,49,100};
            convertView.setBackgroundColor(Color.HSVToColor(a));*/
            //convertView.textImeObjekta.setTextColor(Color.WHITE);
        }
        return convertView;
    }

}
