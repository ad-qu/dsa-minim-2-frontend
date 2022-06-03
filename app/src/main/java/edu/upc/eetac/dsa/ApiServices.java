package edu.upc.eetac.dsa;

import java.util.List;
import edu.upc.eetac.dsa.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("/dsaApp/user/stats/ranking")
    Call<List<Users>> getRanking();
}