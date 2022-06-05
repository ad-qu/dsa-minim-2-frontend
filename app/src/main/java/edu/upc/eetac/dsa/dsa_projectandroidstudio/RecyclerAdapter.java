package edu.upc.eetac.dsa.dsa_projectandroidstudio;

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

    private List<UserRanking> usersList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View layout;
        public ImageView image;
        public TextView username_txt;
        public TextView points_txt;

        public ViewHolder(View v) {
            super(v);

            layout = v;
            image = (ImageView) v.findViewById(R.id.icon);
            username_txt = (TextView) v.findViewById(R.id.firstLine);
            points_txt = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public RecyclerAdapter(List<UserRanking> myDataset)
    {
        usersList = myDataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v =inflater.inflate(R.layout.row_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.username_txt.setText(usersList.get(position).getUsername());
        holder.points_txt.setText(usersList.get(position).getPoints());

        Picasso.get().load(usersList.get(position).getAvatar()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}