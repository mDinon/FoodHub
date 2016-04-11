package hr.mc2.foodhub;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class FoodFragment extends Fragment implements View.OnClickListener{

    Button myButton;

    @Override
    public void onClick(View v) {
        Fragment aboutFragment = new AboutFragment();
        Bundle data = new Bundle();
        data.putString("name", "Ime_lokala_restorana_cega vec");
        data.putInt("logo", R.drawable.test_logo);
        aboutFragment.setArguments(data);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, aboutFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();
    }

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

        myButton = (Button) myInflatedView.findViewById(R.id.buttonToAbout);
        myButton.setOnClickListener(this);
        return myInflatedView;
    }
}
