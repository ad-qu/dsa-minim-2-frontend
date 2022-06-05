package edu.upc.eetac.dsa.dsa_projectandroidstudio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingActivity extends AppCompatActivity {

    ApiServices services;

    public ArrayList<UserRanking> rankingCall;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Button ranking_btn = (Button) findViewById(R.id.activity_btn);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        services = ApiRetrofit.getApiService().create(ApiServices.class);

        ranking_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Call<List<UserRanking>> rankingCall = services.getRanking();

                rankingCall.enqueue(new Callback<List<UserRanking>>() {

                    @Override
                    public void onResponse(Call<List<UserRanking>> call, Response<List<UserRanking>> response) {

                        if(response.code() == 201) {

                            List<UserRanking> body = response.body();

                            SetInfo(body);
                            setAdapter();

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

                Toast.makeText(getApplicationContext(), "Ranking updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void SetInfo(List<UserRanking> body) { rankingCall = new ArrayList<UserRanking>(body); }

    private void setAdapter() {

        RecyclerAdapter adapter = new RecyclerAdapter(rankingCall);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}