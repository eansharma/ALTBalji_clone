package com.seeksolution.altbalaji.Adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.seeksolution.altbalaji.R;
import com.seeksolution.altbalaji.models.LatestModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LatestAdapters extends RecyclerView.Adapter<LatestAdapters.MyViewa> {
    public Context context;
    public ArrayList<LatestModel> arrayList;

    public LatestAdapters(Context context, ArrayList<LatestModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public LatestAdapters.MyViewa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mycoustom_layout,parent,false);

        return new MyViewa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LatestAdapters.MyViewa holder, int position) {
        final  int i= position;
        holder.imageView1.setVisibility(View.GONE);
        holder.simmer_imageview1.setVisibility(View.VISIBLE);
        holder.shimmerFrameLayout1.startShimmer();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Picasso.get()
                        .load(Uri.parse(arrayList.get(i).
                                getImageUrls())).
                        into(holder.imageView1);
                holder.shimmerFrameLayout1.stopShimmer();
                holder.simmer_imageview1.setVisibility(View.GONE);
                holder.imageView1.setVisibility(View.VISIBLE);


            }
        },5000);




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewa extends RecyclerView.ViewHolder {
        public ImageView imageView1;
        public ShimmerFrameLayout shimmerFrameLayout1;
        public ImageView  simmer_imageview1;
        public MyViewa(@NonNull View itemView) {


            super(itemView);
            imageView1=itemView.findViewById(R.id.iv_trending_list);
            shimmerFrameLayout1 = itemView.findViewById(R.id.trending_list_Shimmer_container);
            simmer_imageview1 = itemView.findViewById(R.id.iv_trending_simmer);
        }
    }
}
