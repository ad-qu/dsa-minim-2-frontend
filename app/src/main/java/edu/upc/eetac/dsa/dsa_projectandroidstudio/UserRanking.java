package edu.upc.eetac.dsa.dsa_projectandroidstudio;

public class UserRanking {

    String username;
    int points;
    String avatar;

    public UserRanking(String username, int points, String avatar) {

        this.username = username;
        this.points = points;
        this.avatar = avatar;
    }

    public String getUsername(){
        return this.username;
    }
    public int getPoints() { return this.points; }
    public String getAvatar(){
        return this.avatar;
    }
}
