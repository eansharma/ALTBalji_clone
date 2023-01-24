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
import com.seeksolution.altbalaji.models.TvModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TvAdapters extends RecyclerView.Adapter<TvAdapters.TvView> {
    public Context context;
    public ArrayList<TvModel> arrayList;
    public TvAdapters(Context context, ArrayList<TvModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public TvAdapters.TvView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mycoustom_layout,parent,false);
        return new TvView(view);
    }
    @Override
    public void onBindViewHolder(@NonNull TvAdapters.TvView holder, int position) {
        final  int i = position;
        holder.imageView2.setVisibility(View.GONE);
        holder.simmerImage2.setVisibility(View.VISIBLE);
        holder.shimmerFrameLayout2.startShimmer();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Picasso
                        .get()
                        .load(Uri.parse(arrayList.get(i).getImageUrls()))
                        .into(holder.imageView2);
                holder.shimmerFrameLayout2.stopShimmer();
                holder.imageView2.setVisibility(View.VISIBLE);
                holder.simmerImage2.setVisibility(View.GONE);

            }
        },5000);

    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class TvView extends RecyclerView.ViewHolder {
        public ImageView imageView2;
        public ShimmerFrameLayout shimmerFrameLayout2;
        public ImageView simmerImage2;
        public TvView(@NonNull View itemView) {
            super(itemView);
            imageView2 =itemView.findViewById(R.id.iv_trending_list);
            shimmerFrameLayout2 = itemView.findViewById(R.id.trending_list_Shimmer_container);
            simmerImage2 = itemView.findViewById(R.id.iv_trending_simmer);
        }
    }
}