package hr.mc2.foodhub;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private ListView ListView2 ;
    private ArrayAdapter<String> ItemListAdapter ;

    ArrayList<ItemListPodaci> restorani = new ArrayList<>();

    ItemListPodaci objekt1 = new ItemListPodaci("Ime objekta1", "Vrsta objekta 1", 100);
    ItemListPodaci objekt2 = new ItemListPodaci("Ime objekta2", "Vrsta Objekta 2", 50);
    ItemListPodaci objekt3 = new ItemListPodaci("Ime objekta3", "Vrsta Objekta 3", 25);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restorani.add(objekt1);
        //restorani.add(objekt2);
        //restorani.add(objekt3);

        //napuniListView();

        ItemListAdapter adapter = new ItemListAdapter(this,restorani);
        // Postavljanje adaptera u listview
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(ItemListAdapter);
    }

    private void napuniListView() {
        // Kreiranje array liste custom klase i popunjavanje iste
        ArrayList<ItemListPodaci> restorani = new ArrayList<>();
        for(int i=0; i<restorani.size();i++){
            restorani.add(restorani.get(i));
        }
        // Kreiranje adaptera koji konvertira polje u view
        ItemListAdapter adapter = new ItemListAdapter(this,restorani);
        // Postavljanje adaptera u listview
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
    }

}
