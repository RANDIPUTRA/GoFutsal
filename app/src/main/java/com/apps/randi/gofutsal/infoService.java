package com.apps.randi.gofutsal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface infoService {

    //read data
    @GET("17za69")
    Call<LapanganModel> getLapanganFutsal();

}
