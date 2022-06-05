package edu.upc.eetac.dsa.dsa_projectandroidstudio;

import java.util.LinkedList;
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

        services = ApiRetrofit.getApiService().create(ApiServices.class);

        ranking_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Call<List<UserRanking>> rankingCall = services.getRanking();

                rankingCall.enqueue(new Callback<List<UserRanking>>() {

                    @Override
                    public void onResponse(Call<List<UserRanking>> call, Response<List<UserRanking>> response) {

                        if(response.code() == 201) {

                            List<UserRanking> rankingCall = response.body();
                            myAdapter = new RecyclerAdapter(rankingCall);
                            recyclerView.setAdapter(myAdapter);

                            Toast.makeText(getApplicationContext(), "Ranking updated", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserRanking>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });

                /*UserRanking u1 = new UserRanking("a", 100, "https://avatars.githubusercontent.com/u/50048787?v=4");
                UserRanking u2 = new UserRanking("b", 10, "https://avatars.githubusercontent.com/u/57569408?v=4");

                List<UserRanking> rankingCall = new LinkedList<>();
                rankingCall.add(u1);
                rankingCall.add(u2);
                myAdapter = new RecyclerAdapter(rankingCall);
                recyclerView.setAdapter(myAdapter);

                Toast.makeText(getApplicationContext(), "Ranking updated", Toast.LENGTH_LONG).show();*/
            }
        });
    }
}