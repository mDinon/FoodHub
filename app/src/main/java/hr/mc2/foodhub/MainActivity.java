package hr.mc2.foodhub;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        //objekt1.bubble_srt_rating(Restorani);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        bubble_srt_rating_desc(Restorani);
        // Kreiranje adaptera koji konvertira polje u view
        ItemListAdapter adapter = new ItemListAdapter(this,Restorani);
        // Postavljanje adaptera u listview
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        return true;
    }


    public static void bubble_srt_rating_desc(ArrayList<ItemListPodaci> podaci) {
        int n = podaci.size();
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (podaci.get(i).getRatingInt() < podaci.get(k).getRatingInt()) {
                    swapNumbers(i, k, podaci);
                }
            }
        }
    }

    private static void swapNumbers(int i, int j, ArrayList<ItemListPodaci> array) {
        ItemListPodaci temp;
        temp = array.get(i);
        //array.get(i) = array.get(j);
        array.set(i, array.get(j));
        //array.get(j) = temp;
        array.set(j, temp);
    }

}
