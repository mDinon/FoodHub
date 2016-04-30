package hr.mc2.foodhub;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


//Aktivnost u kojoj korisnik vidi detalje o nekom objektu
public class MenuActivity extends AppCompatActivity implements FragmentCommunicationMenu {

    String storeReviewText;
    int storeRating = 0;

    /*Nepotrebno
    public Bundle passNewReview(){
            if(storeRating!=0){
            Intent intent = getIntent();
            Bundle reviewData = new Bundle();
            reviewData.putString("reviewText", storeReviewText);
            reviewData.putInt("rating", storeRating);
            return reviewData;}
        else return null;
    }*/

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if (requestCode == 1) {
            //if(resultCode == RESULT_OK){
                String userReview =data.getStringExtra("reviewText");
                int userRating =data.getIntExtra("rating",0);
                storeReviewText = userReview;
                storeRating = userRating;

           // }
       // }
    }

    /*Tu primaj i šalji podatke ostalim aktivnostima putem intentova*/

    //Ova funkcja šalje podatke AboutFragmentu
    @Override
    public Bundle transferAboutData() {
        Intent intent = getIntent();
        Bundle data = new Bundle();
        data.putString("name", intent.getStringExtra("imeObjekta"));
        data.putString("opis", intent.getStringExtra("opisObjekta"));
        data.putInt("logo", intent.getIntExtra("logoObjekta",0));
        data.putString("rating", intent.getStringExtra("ratingObjekta"));

        data.putString("adresa", intent.getStringExtra("adresaObjekta"));
        data.putString("url", intent.getStringExtra("urlObjekta"));
        data.putString("telefon", intent.getStringExtra("telefonObjekta"));
        data.putString("mail", intent.getStringExtra("mailObjekta"));

        return data;
    }
    @Override
    public Bundle transferFoodData() {
        Intent intent = getIntent();
        Bundle data = new Bundle();

        data.putStringArray("imenaProizvoda",intent.getStringArrayExtra("imenaProizvoda"));
        data.putStringArray("cijeneProizvoda",intent.getStringArrayExtra("cijeneProizvoda"));
        data.putStringArray("sastojciProizvoda",intent.getStringArrayExtra("sastojciProizvoda"));

        return data;
    }

    @Override
    public Bundle transferReviewData() {
        Intent intent = getIntent();
        Bundle data = new Bundle();

        data.putStringArray("korisnici",intent.getStringArrayExtra("korisnici"));
        data.putStringArray("recenzije",intent.getStringArrayExtra("recenzije"));
        data.putIntArray("ocjene",intent.getIntArrayExtra("ocjene"));
        data.putIntArray("avatari",intent.getIntArrayExtra("avatari"));

        return data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager1);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
