package hr.mc2.foodhub;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Fragment foodFragment = new FoodFragment();
        Fragment aboutFragment = new AboutFragment();

        Bundle data = new Bundle();
        data.putString("name", "Ime_lokala_restorana_cega vec");
        data.putInt("logo", R.drawable.test_logo);
        aboutFragment.setArguments(data);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, aboutFragment);
       // transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
