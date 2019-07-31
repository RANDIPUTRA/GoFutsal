package com.apps.randi.gofutsal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class infoAdapter extends RecyclerView.Adapter<infoAdapter.MyHolder> {

    List<ItemLapangan> mList;
    Context ctx;

    public infoAdapter(Context ctx,List<ItemLapangan> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_lapangan,viewGroup, false);
        final MyHolder holder = new MyHolder(layout);

//        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(ctx,DetailTokoh.class);
//                i.putExtra("nama_ulama",mList.get(holder.getAdapterPosition()).getNama_ulama());
//                i.putExtra("tanggal_ulama",mList.get(holder.getAdapterPosition()).getTanggal_lahir());
//                i.putExtra("tempat_ulama",mList.get(holder.getAdapterPosition()).getTempat_lahir());
//                i.putExtra("link_ulama",mList.get(holder.getAdapterPosition()).getLink_gambar());
//                i.putExtra("desk",mList.get(holder.getAdapterPosition()).getDesk());
//
//                ctx.startActivity(i);
//
//            }
//        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        ItemLapangan lapanganList = mList.get(i);
        myHolder.nama.setText(lapanganList.getNama_lapangan());
        Glide.with(ctx).load(lapanganList.getFoto()).override(350,550).into(myHolder.link_gambar);
        myHolder.alamat.setText(lapanganList.getAlamat());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nama, alamat;
        ImageView link_gambar;
//        Button btnDetail;
        public MyHolder(View v)
        {
            super(v);

            nama  = (TextView) v.findViewById(R.id.nama_lapangan);
            alamat = (TextView) v.findViewById(R.id.alamat);
            link_gambar = (ImageView) v.findViewById(R.id.link_gambar);
//            btnDetail = (Button) v.findViewById(R.id.btn_detail);

        }

    }
}
