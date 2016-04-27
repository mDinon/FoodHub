package hr.mc2.foodhub;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/*Prvi fragment koji se otvori
* Sadrži kratak opis objekta, ime i logo.*/
public class AboutFragment extends Fragment {



    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.fragment_about, container,false);
        ImageView logo = (ImageView) myInflatedView.findViewById(R.id.view_logo);
        TextView text = (TextView) myInflatedView.findViewById(R.id.textView);
        TextView textOpis = (TextView) myInflatedView.findViewById(R.id.opis);
        TextView textRating = (TextView) myInflatedView.findViewById(R.id.aboutRating);
        Bundle receivedData = ((FragmentCommunication) getActivity()).transferMessage();
        text.setText(receivedData.getString("name"));
        textOpis.setText(receivedData.getString("opis"));
        logo.setImageResource(receivedData.getInt("logo"));
        textRating.setText(receivedData.getString("rating"));
        return myInflatedView;
    }



}
