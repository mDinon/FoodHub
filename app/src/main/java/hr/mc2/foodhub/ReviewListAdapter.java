package hr.mc2.foodhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matija on 26.4.2016..
 */
public class ReviewListAdapter extends ArrayAdapter<ReviewListPodaci> {

    public ReviewListAdapter(Context context, int fragment_review, ArrayList<ReviewListPodaci> podaci) {
        super(context,0,podaci);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
// Dohvaćanje podataka na ovoj poziciji
        ReviewListPodaci noviPodaci = getItem(position);
        // Provjera da li je postojeci view ponovo iskorišten
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_liste_recenzija, parent, false);
        }
        // Dohvaćanje view-ova za populaciju podacima
        TextView textUsername = (TextView) convertView.findViewById(R.id.Username);
        TextView textReview = (TextView) convertView.findViewById(R.id.review);
        TextView textRating = (TextView) convertView.findViewById(R.id.reviewUserRating);
        ImageView userImage = (ImageView) convertView.findViewById(R.id.userImage);

        // Populacija podataka u dohvaćene view-ove
        textUsername.setText(noviPodaci.getUsername());
        textReview.setText(noviPodaci.getReview());
        textRating.setText(noviPodaci.getRating());
        userImage.setImageResource(noviPodaci.getImageResource());

        // Vraćanje završenog view-a kako bi se prikazao na ekranu
       /* if(position % 2 == 0){
            convertView.setBackgroundColor(Color.LTGRAY);
        }*/
        return convertView;
    }
    }
