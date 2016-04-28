package hr.mc2.foodhub;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/*Prikazuje cjenik*/
public class FoodFragment extends Fragment{

    private ArrayList<FoodListPodaci> populateFoodList(String[] imena, String[] cijene){
        ArrayList<FoodListPodaci> foodListtoPopulate = new ArrayList<>();
        for(int i = 0;i<imena.length;i++){
            foodListtoPopulate.add(new FoodListPodaci(imena[i], cijene[i]));
        }
        return foodListtoPopulate;
    }

    public ArrayList<FoodListPodaci> Hrana = new ArrayList<>();

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

        Bundle receivedData = ((FragmentCommunicationMenu) getActivity()).transferFoodData();
        String[] imenaProizvoda = receivedData.getStringArray("imenaProizvoda");
        String[] cijeneProizvoda = receivedData.getStringArray("cijeneProizvoda");
        // Kreiranje array liste custom klase i popunjavanje iste
        Hrana = populateFoodList(imenaProizvoda, cijeneProizvoda);

        ArrayList<FoodListPodaci> objekti = new ArrayList<>();

        for(int i=0; i<Hrana.size();i++){
            objekti.add(Hrana.get(i));
        }

        // Kreiranje adaptera koji konvertira polje u view
        FoodListAdapter adapter = (new FoodListAdapter(getActivity(), R.layout.fragment_food, Hrana));
        // Postavljanje adaptera u listview
        ListView listView = (ListView) myInflatedView.findViewById(R.id.listViewFood);
        //listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        return myInflatedView;
    }

}
