package hr.mc2.foodhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Matija on 28.4.2016..
 */
public class WriteReviewActivity extends AppCompatActivity {

    Integer ocjena = 0;

    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String stredittext=data.getStringExtra("edittextvalue");
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarWriteReview);
        setSupportActionBar(toolbar);

        TextView setRating = (TextView)findViewById(R.id.setUserReview);
        TextView reviewText = (TextView)findViewById(R.id.reviewInProgress);
        Button submitButton = (Button)findViewById(R.id.submitReviewButton);

        setRating.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView setRating = (TextView)findViewById(R.id.setUserReview);
                if(ocjena<10)
                ocjena++;
                else ocjena=1;
                setRating.setText(ocjena.toString());

            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView setRating = (TextView)findViewById(R.id.setUserReview);
                TextView reviewText = (TextView)findViewById(R.id.reviewInProgress);

                Intent intent = new Intent();
                intent.putExtra("reviewText",reviewText.getText());
                intent.putExtra("rating",ocjena);
                setResult(RESULT_OK, intent);
                Toast.makeText(getBaseContext(),
                        "Work in progress.", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }


}
