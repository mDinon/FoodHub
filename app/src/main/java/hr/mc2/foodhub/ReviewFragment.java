package hr.mc2.foodhub;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


/*Fragment za reviewove
* Nema puno ovdje zasad*/
public class ReviewFragment extends Fragment implements View.OnClickListener {

    Button myButton;

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
        View myInflatedView = inflater.inflate(R.layout.fragment_review, container, false);
        myButton = (Button) myInflatedView.findViewById(R.id.RevToFood);
        myButton.setOnClickListener(this);

        return myInflatedView;
    }

    @Override
    public void onClick(View v) {
        Fragment foodFragment = new FoodFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, foodFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
