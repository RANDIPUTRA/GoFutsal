package com.apps.randi.gofutsal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformasiFragment extends Fragment {

    private infoAdapter viewAdapter;
    private List<ItemLapangan> mItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View myFragment = inflater.inflate(R.layout.fragment_lapangan,container,false);
        final RecyclerView recyclerView = myFragment.findViewById(R.id.lapangan_r);
        viewAdapter = new infoAdapter(getContext(), mItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);
        infoService api = infoEndPoint.getClient().create(infoService.class);
        Call<LapanganModel> call = api.getLapanganFutsal();
        call.enqueue(new Callback<LapanganModel>() {
            @Override
            public void onResponse(Call<LapanganModel> call, Response<LapanganModel> response) {
                mItems = response.body().getItem();
                viewAdapter = new infoAdapter(getContext(), mItems);
                recyclerView.setAdapter(viewAdapter);
            }

            @Override
            public void onFailure(Call<LapanganModel> call, Throwable t) {
                Toast.makeText(getContext(), "Maaf Koneksi Internet Anda sedang Gangguan ", Toast.LENGTH_SHORT).show();

            }
        });


        return myFragment;

    }


}
