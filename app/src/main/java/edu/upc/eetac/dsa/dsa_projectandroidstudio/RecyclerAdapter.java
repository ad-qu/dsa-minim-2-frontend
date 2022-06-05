package edu.upc.eetac.dsa.dsa_projectandroidstudio;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<UserRanking> usersList;

    public RecyclerAdapter(ArrayList<UserRanking> usersList)
    {
        this.usersList = usersList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View layout;
        public ImageView image;
        public TextView username_txt;
        public TextView points_txt;

        public ViewHolder(final View v) {
            super(v);

            image = (ImageView) v.findViewById(R.id.icon);
            username_txt = (TextView) v.findViewById(R.id.firstLine);
            points_txt = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return  new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        holder.username_txt.setText(usersList.get(position).getUsername());
        holder.points_txt.setText(usersList.get(position).getPoints());

        Picasso.get().load(usersList.get(position).getAvatar()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

}