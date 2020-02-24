package rofik.sman3.tugas4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    ArrayList<Hero> hero;
    private OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    HeroAdapter(ArrayList<Hero> hero) {
        this.hero = hero;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Creat View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        //set foto to imageView
        holder.imageView.setImageResource(hero.get(position).getPicture());
        //set nama to textView
        holder.textView.setText(hero.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(hero.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return hero.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //inisialisasi variabel

        ImageView imageView;
        TextView textView;

        public ViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.image_view);
            textView = view.findViewById(R.id.text_view);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Hero data);
    }
}
