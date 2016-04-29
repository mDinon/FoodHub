package hr.mc2.foodhub;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/*Fragment za reviewove*/
public class ReviewFragment extends Fragment{

    private FloatingActionButton fab;

    private ArrayList<ReviewListPodaci> populateReviewList(String[] imena, String[] recenzije, int[] ocjene, int[] avatari){
        ArrayList<ReviewListPodaci> reviewListtoPopulate = new ArrayList<>();
        for(int i = 0;i<imena.length;i++){
            reviewListtoPopulate.add(new ReviewListPodaci(imena[i], recenzije[i], ocjene[i], avatari[i]));
        }
        return reviewListtoPopulate;
    }

    public ArrayList<ReviewListPodaci> Recenzije = new ArrayList<>();

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


        fab = (FloatingActionButton) myInflatedView.findViewById(R.id.newReview);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Click action
                Intent intent = new Intent(getActivity(), WriteReviewActivity.class);
                //Očekuje ReviewListPodaci objekt
                startActivityForResult(intent, 1);

            }

        });

        Bundle receivedData = ((FragmentCommunicationMenu) getActivity()).transferReviewData();
        String[] korisnici = receivedData.getStringArray("korisnici");
        String[] recenzije = receivedData.getStringArray("recenzije");
        int[] ocjene = receivedData.getIntArray("ocjene");
        int[] avatari = receivedData.getIntArray("avatari");

        Recenzije = populateReviewList(korisnici,recenzije,ocjene,avatari);

        // Kreiranje array liste custom klase i popunjavanje iste
        ArrayList<ReviewListPodaci> objekti = new ArrayList<>();
        for(int i=0; i<Recenzije.size();i++){
            objekti.add(Recenzije.get(i));
        }

        // Kreiranje adaptera koji konvertira polje u view
        /*ReviewListAdapter adapter = new ItemListAdapter(getActivity(),Recenzije);*/
        ReviewListAdapter adapter = (new ReviewListAdapter(getActivity(), R.layout.fragment_review, Recenzije));
        // Postavljanje adaptera u listview
        ListView listView = (ListView) myInflatedView.findViewById(R.id.reviewList);
        //listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        return myInflatedView;
    }


}
