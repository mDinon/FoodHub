package hr.mc2.foodhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Matija on 29.4.2016..
 */
public class ProductDetailsActivity extends AppCompatActivity {


    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarProductDetail);
        setSupportActionBar(toolbar);

        TextView imeProizvoda = (TextView)findViewById(R.id.imeProizvodaDetalji);
        TextView sastojciProizvoda = (TextView)findViewById(R.id.sastojciProizvodaDetalji);
        TextView cijeneProizvodaDetalji = (TextView)findViewById(R.id.cijenaProizvodaDetalji);

        Intent intent = getIntent();

        Bundle receivedData = new Bundle();
        imeProizvoda.setText(intent.getStringExtra("imeProizvoda"));
        sastojciProizvoda.setText(intent.getStringExtra("sastojciProizvoda"));
        cijeneProizvodaDetalji.setText(intent.getStringExtra("cijenaProizvoda") + " kn");

    }

}
