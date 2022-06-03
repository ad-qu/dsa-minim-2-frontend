package edu.upc.eetac.dsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go_btn = (Button) findViewById(R.id.activity_btn);

        go_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openRankingActivity();
            }
        });
    }

    private void openRankingActivity() {

        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
    }
}
