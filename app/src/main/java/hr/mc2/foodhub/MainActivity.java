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

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    public ArrayList<ItemListPodaci> Restorani = new ArrayList<>();

    ItemListPodaci objekt1 = new ItemListPodaci("Mlinar", "Pekara", 50, R.drawable.logo);
    ItemListPodaci objekt2 = new ItemListPodaci("Samoborska pekara", "Pekara", 40, R.drawable.logo);
    ItemListPodaci objekt3 = new ItemListPodaci("Slastičarnica Nebi", "Slastičarnica", 30, R.drawable.logo);
    ItemListPodaci objekt4 = new ItemListPodaci("Rubelj", "Pečenjara", 20, R.drawable.logo);
    ItemListPodaci objekt5 = new ItemListPodaci("Šabarić", "Pečenjara", 10, R.drawable.logo);
    ItemListPodaci objekt6 = new ItemListPodaci("Napoli", "Pizzeria", 100, R.drawable.logo);
    ItemListPodaci objekt7 = new ItemListPodaci("Pizzeria Buldog", "Pizzeria", 90 , R.drawable.logo);
    ItemListPodaci objekt8 = new ItemListPodaci("Irish pub Scout", "Pub", 80, R.drawable.logo);
    ItemListPodaci objekt9 = new ItemListPodaci("Havanna", "Caffe bar", 70, R.drawable.logo);
    ItemListPodaci objekt10 = new ItemListPodaci("Ara", "Caffe bar", 60, R.drawable.logo);

    ItemListPodaci objekt11 = new ItemListPodaci("Aaa", "Caffe bar", 60, R.drawable.logo);
    ItemListPodaci objekt12 = new ItemListPodaci("Abb", "Caffe bar", 60, R.drawable.logo);
    ItemListPodaci objekt13 = new ItemListPodaci("Aba", "Caffe bar", 60, R.drawable.logo);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Restorani.add(objekt1);
        Restorani.add(objekt2);
        Restorani.add(objekt3);
        Restorani.add(objekt4);
        Restorani.add(objekt5);
        Restorani.add(objekt6);
        Restorani.add(objekt7);
        Restorani.add(objekt8);
        Restorani.add(objekt9);
        Restorani.add(objekt10);
        Restorani.add(objekt11);
        Restorani.add(objekt12);
        Restorani.add(objekt13);

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
        //handle presses on the action bar items
        // Kreiranje adaptera koji konvertira polje u view
        ItemListAdapter adapter = new ItemListAdapter(this,Restorani);
        // Postavljanje adaptera u listview
        ListView listView = (ListView) findViewById(R.id.listView2);

        switch (item.getItemId()) {

            case R.id.sortDescRating:
                bubbleSrtRatingDesc(Restorani);
                listView.setAdapter(adapter);
                return true;

            case R.id.sortDescAlpha:
                bubbleSrtImeDesc(Restorani);
                listView.setAdapter(adapter);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public static void bubbleSrtRatingDesc(ArrayList<ItemListPodaci> podaci) {
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
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void bubbleSrtImeDesc(ArrayList<ItemListPodaci> podaci) {
        int n = podaci.size();
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (podaci.get(i).getImeObjekta().valueOf(podaci.get(i).getImeObjekta().charAt(0)).toLowerCase().
                        compareTo(podaci.get(k).getImeObjekta().valueOf(podaci.get(k).getImeObjekta().charAt(0)).toLowerCase()) > 0) {
                    swapNumbers(i, k, podaci);
                }
            }
        }
    }

}
