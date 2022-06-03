package edu.upc.eetac.dsa;

public class Users {

    String username;
    int points;
    String avatar;

    public Users(String username, int points, String avatar) {

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


