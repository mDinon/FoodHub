package hr.mc2.foodhub;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutFragment extends Fragment implements View.OnClickListener {

    Button myButton;

    @Override
    public void onClick(View v) {
        Fragment foodFragment = new FoodFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, foodFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.fragment_about, container,false);
        ImageView logo = (ImageView) myInflatedView.findViewById(R.id.view_logo);
        TextView text = (TextView) myInflatedView.findViewById(R.id.textView);
        myButton = (Button) myInflatedView.findViewById(R.id.butt);
        myButton.setOnClickListener(this);

        String name_restaurant = getArguments().getString("name");
        int logo_restaurant = getArguments().getInt("logo");
        text.setText(name_restaurant);
        logo.setImageResource(logo_restaurant);
        return myInflatedView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
