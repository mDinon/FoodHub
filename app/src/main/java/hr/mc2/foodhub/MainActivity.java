package hr.mc2.foodhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    public ArrayList<ItemListPodaci> Restorani = new ArrayList<>();
    public ArrayList<FoodListPodaci> Menu = new ArrayList<>();
    public ArrayList<ReviewListPodaci> Recenzije = new ArrayList<>();


    //Dummy podaci
    ReviewListPodaci recenzija1 = new ReviewListPodaci("Marko Dinon","Sve super, još samo da imate rudarske greblice", 9, R.drawable.test_avatar);
    ReviewListPodaci recenzija2 = new ReviewListPodaci("Matija Kršić","Da mi je ovakvav restoran u Brezju", 8, R.drawable.test_avatar);
    ReviewListPodaci recenzija3 = new ReviewListPodaci("Matija Lastovčić","Fenomenalan burek", 9, R.drawable.test_avatar);

    FoodListPodaci proizvod1 = new FoodListPodaci("Hamburger", "35");
    FoodListPodaci proizvod2 = new FoodListPodaci("Pizza", "38");
    FoodListPodaci proizvod3 = new FoodListPodaci("Cevapi", "25");
    FoodListPodaci proizvod4 = new FoodListPodaci("Piva", "15");

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

    //Dummy podaci - kraj

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //Podaci za AboutFragment
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        intent.putExtra("imeObjekta",Restorani.get(position).getImeObjekta());
        intent.putExtra("logoObjekta",Restorani.get(position).getImageResource());
        intent.putExtra("opisObjekta",Restorani.get(position).getOpisObjekta());
        intent.putExtra("ratingObjekta",Restorani.get(position).getRating());
        //Podaci za AboutFragment - kraj

        //Podaci za FoodFragment ( Menu )
        int size = Menu.size();
        String[] imenaProizvoda = new String[size];
        String[] cijeneProizvoda = new String[size];
        String[] sastojciProizvoda = new String[size];
        for(int i=0;i<size;i++){
            imenaProizvoda[i] =  Menu.get(i).getImeProizvoda();
            cijeneProizvoda[i] =  Menu.get(i).getCijena();
            sastojciProizvoda[i] =  Menu.get(i).getSastojke();
        }
        intent.putExtra("imenaProizvoda",imenaProizvoda);
        intent.putExtra("cijeneProizvoda",cijeneProizvoda);
        intent.putExtra("sastojciProizvoda",sastojciProizvoda);
        //Podaci za FoodFragment ( Menu ) - kraj

        //Podaci za ReviewFragment
        size = Recenzije.size();
        String[] korisnici = new String[size];
        String[] recenzije = new String[size];
        int[] ocjene = new int[size];
        int[] avatari = new int[size];
        for(int i=0;i<size;i++){
            korisnici[i] =  Recenzije.get(i).getUsername();
            recenzije[i] =  Recenzije.get(i).getReview();
            ocjene[i] =  Recenzije.get(i).getRatingInt();
            avatari[i] =  Recenzije.get(i).getImageResource();

        }
        intent.putExtra("korisnici",korisnici);
        intent.putExtra("recenzije",recenzije);
        intent.putExtra("ocjene",ocjene);
        intent.putExtra("avatari",avatari);
        //Podaci za ReviewFragment - kraj

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Recenzije.add(recenzija1);
        Recenzije.add(recenzija2);
        Recenzije.add(recenzija3);

        Menu.add(proizvod1);
        Menu.add(proizvod2);
        Menu.add(proizvod3);
        Menu.add(proizvod4);

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

        for(int i = 0; i<Restorani.size();i++){
            Restorani.get(i).setMenu(Menu);
        }

        // Kreiranje array liste custom klase i popunjavanje iste
        ArrayList<ItemListPodaci> objekti = new ArrayList<>();
        for(int i=0; i<Restorani.size();i++){
            objekti.add(Restorani.get(i));
        }
        // Kreiranje adaptera koji konvertira polje u view
        ItemListAdapter adapter = new ItemListAdapter(this,Restorani);
        // Postavljanje adaptera u listview
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setOnItemClickListener(this);
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
