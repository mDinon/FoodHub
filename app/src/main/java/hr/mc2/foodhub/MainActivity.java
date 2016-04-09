package hr.mc2.foodhub;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<ItemListPodaci> Restorani = new ArrayList<>();

    ItemListPodaci objekt1 = new ItemListPodaci("Ime objekta 1", "Vrsta objekta 1", 100, R.drawable.logo);
    ItemListPodaci objekt2 = new ItemListPodaci("Ime objekta 2", "Vrsta objekta 2", 50, R.drawable.logo);
    ItemListPodaci objekt3 = new ItemListPodaci("Ime objekta 3", "Vrsta objekta 3", 25, R.drawable.logo);
    ItemListPodaci objekt4 = new ItemListPodaci("Ime objekta 4", "Vrsta objekta 4", 100, R.drawable.logo);
    ItemListPodaci objekt5 = new ItemListPodaci("Ime objekta 5", "Vrsta objekta 5", 50, R.drawable.logo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Restorani.add(objekt1);
        Restorani.add(objekt2);
        Restorani.add(objekt3);
        Restorani.add(objekt4);
        Restorani.add(objekt5);
        Restorani.add(objekt1);
        Restorani.add(objekt2);
        Restorani.add(objekt3);
        Restorani.add(objekt4);
        Restorani.add(objekt5);

        // Kreiranje array liste custom klase i popunjavanje iste
        ArrayList<ItemListPodaci> objekti = new ArrayList<>();
        for(int i=0; i<Restorani.size();i++){
            objekti.add(Restorani.get(i));
        }
        // Kreiranje adaptera koji konvertira polje u view
        ItemListAdapter adapter = new ItemListAdapter(this,Restorani);
        // Postavljanje adaptera u listview
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
    }

}
