package hr.mc2.foodhub;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Prikazuje cjenik*/
public class FoodFragment extends Fragment{

    public ArrayList<FoodListPodaci> Hrana = new ArrayList<>();

    FoodListPodaci objekt1 = new FoodListPodaci("Pizza miješana", 35);
    FoodListPodaci objekt2 = new FoodListPodaci("Pizza slavonska", 38);
    FoodListPodaci objekt3 = new FoodListPodaci("Pizza vegetariana", 35);

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

        Hrana.add(objekt1);
        Hrana.add(objekt2);
        Hrana.add(objekt3);

        // Kreiranje array liste custom klase i popunjavanje iste
        ArrayList<FoodListPodaci> objekti = new ArrayList<>();
        for(int i=0; i<Hrana.size();i++){
            objekti.add(Hrana.get(i));
        }

        // Kreiranje adaptera koji konvertira polje u view
        /*ReviewListAdapter adapter = new ItemListAdapter(getActivity(),Recenzije);*/
        FoodListAdapter adapter = (new FoodListAdapter(getActivity(), R.layout.fragment_food, Hrana));
        // Postavljanje adaptera u listview
        ListView listView = (ListView) myInflatedView.findViewById(R.id.listViewFood);
        //listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        /*//Trenutno fiksne vrijednosti liste, TRENUTNO
        final ListView listview = (ListView) myInflatedView.findViewById(R.id.listView);
        String[] values = new String[] { "Pizza", "Hamburger", "Sushi",
                "Suhi beton", "Žganci", "Rudarske greblice", "Kisela ljuta juha", "酸汤素" };

        //Ubaci vrijednosti u ArrayList
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        final StableArrayAdapter adapter = (new StableArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list));
        listview.setAdapter(adapter);*/
        return myInflatedView;
    }

    //Ugnježđena klasa
   /* private class StableArrayAdapter extends ArrayAdapter<String> {

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

    }*/

}
