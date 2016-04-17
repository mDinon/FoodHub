package hr.mc2.foodhub;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Prikazuje cjenik*/
public class FoodFragment extends Fragment{

    Button FoodToAboutButton;
    Button FoodToReviewButton;

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.fragment_food, container,false);

        //Trenutno fiksne vrijednosti liste, TRENUTNO
        final ListView listview = (ListView) myInflatedView.findViewById(R.id.listView);
        String[] values = new String[] { "Pizza", "Hamburger", "Sushi",
                "Suhi beton", "Žganci", "Rudarske greblice", "Kisela ljuta juha", "酸汤素" };

        //Ubaci vrijednosti u ArrayList
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        final StableArrayAdapter adapter = (new StableArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list));
        listview.setAdapter(adapter);

        //gumb za projelaz u AboutFragment
        FoodToAboutButton = (Button) myInflatedView.findViewById(R.id.buttonToAbout);
        FoodToAboutButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Fragment aboutFragment = new AboutFragment();
                Bundle data = new Bundle();

                //dohvaćanje podataka iz bundlea, aboutFragment mora primit te podatke, očekuje ih
                data.putString("name", "Ime_lokala_restorana_cega vec");
                data.putInt("logo", R.drawable.test_logo);
                aboutFragment.setArguments(data);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, aboutFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        //gumb za projelaz u ReviewFragment
        FoodToReviewButton = (Button) myInflatedView.findViewById(R.id.FoodToRev);
        FoodToReviewButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Fragment reviewFragment = new ReviewFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,reviewFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return myInflatedView;
    }

    //Ugnježđena klasa
    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

}
