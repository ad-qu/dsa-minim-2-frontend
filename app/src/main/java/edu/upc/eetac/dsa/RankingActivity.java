package edu.upc.eetac.dsa;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingActivity extends AppCompatActivity {

    ApiServices services;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Button ranking_btn = (Button) findViewById(R.id.activity_btn);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        services = ApiConnection.getApiService().create(ApiServices.class);

        ranking_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Call<List<Users>> rankingCall = services.getRanking();

                rankingCall.enqueue(new Callback<List<Users>>() {

                    @Override
                    public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                        if(response.code() == 201) {

                            List<Users> rankingCall = response.body();
                            myAdapter = new RecyclerAdapter(rankingCall);
                            recyclerView.setAdapter(myAdapter);

                            Toast.makeText(getApplicationContext(), "Ranking updated", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Users>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}