package hr.mc2.foodhub;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/*Prvi fragment koji se otvori
* Sadrži kratak opis objekta, ime i logo.*/
public class AboutFragment extends Fragment {

    Button myButton;
    Button toMainMenu;

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

        //gumb za povratak u MainActivity
        toMainMenu = (Button) myInflatedView.findViewById(R.id.toMainMenu);
        toMainMenu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });

        //gumb za prijelaz u FoodFragment
        myButton = (Button) myInflatedView.findViewById(R.id.butt);
        myButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Fragment foodFragment = new FoodFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, foodFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        //Ovdje postavlja vrijednosti koje mu je poslala aktivnost putem bundlea
        String name_restaurant = getArguments().getString("name");
        int logo_restaurant = getArguments().getInt("logo");
        text.setText(name_restaurant);
        logo.setImageResource(logo_restaurant);
        return myInflatedView;
    }



}
