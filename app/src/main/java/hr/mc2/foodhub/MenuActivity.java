package hr.mc2.foodhub;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
//http://stackoverflow.com/questions/2139134/how-to-send-an-object-from-one-android-activity-to-another-using-intents
//Aktivnost u kojoj korisnik vidi detalje o nekom objaktu
public class MenuActivity extends AppCompatActivity implements FragmentCommunicationMenu {

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

        return data;
    }
    @Override
    public Bundle transferFoodData() {
        Intent intent = getIntent();
        Bundle data = new Bundle();

        data.putStringArray("imenaProizvoda",intent.getStringArrayExtra("imenaProizvoda"));
        data.putStringArray("cijeneProizvoda",intent.getStringArrayExtra("cijeneProizvoda"));

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
