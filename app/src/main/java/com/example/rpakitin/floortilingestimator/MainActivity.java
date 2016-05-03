package com.example.rpakitin.floortilingestimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int tileWidth;
    int tileHeight;
    int tileDimension = 1;
    int totalAmount;
    double totalOverage;
    String tileChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText width = (EditText)findViewById(R.id.txtWidth);
        final EditText height = (EditText)findViewById(R.id.txtHeight);
        final Spinner tileSize = (Spinner)findViewById(R.id.txtTileSize);
        Button total = (Button)findViewById(R.id.btnTileAmt);
        total.setOnClickListener(new View.OnClickListener() {
            final TextView resultTotal = ((TextView)findViewById(R.id.txtTileResult));
            final TextView resultOverage = ((TextView)findViewById(R.id.txtTileExtraResult));
            @Override
            public void onClick(View v) {
                tileWidth = Integer.parseInt(width.getText( ).toString( ));
                tileHeight = Integer.parseInt(height.getText( ).toString( ));
                totalAmount = (tileWidth * tileHeight) / tileDimension;
                totalOverage = totalAmount * .1;
                DecimalFormat currency = new DecimalFormat("###,###");
                tileChoice = tileSize.getSelectedItem( ).toString( );
                resultTotal.setText("You will need " + currency.format(totalAmount) + " tiles.");
                resultOverage.setText("You will need " + currency.format(totalOverage) + " extra tiles.");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
