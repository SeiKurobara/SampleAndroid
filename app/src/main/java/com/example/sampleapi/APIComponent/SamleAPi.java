package com.example.sampleapi.APIComponent;

import android.util.Log;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SamleAPi {
    RetrofitService retrofitService;
    private static final String TAG = "SamleAPi";

    public void getSampleAPI(SampleCallback sampleCallback){
        retrofitService = new RetrofitService();

        String apiURL = "https://jsonplaceholder.typicode.com/";
        Call<List<HashMap<String, Object>>> call = retrofitService.getRft2(apiURL).getSampleAPI();
        // Perform asynchronous network call

        call.enqueue(new Callback<List<HashMap<String, Object>>>() {
            @Override
            public void onResponse(Call<List<HashMap<String, Object>>> call, Response<List<HashMap<String, Object>>> response) {
                sampleCallback.onSuccess( response.body());
                Log.d(TAG, "onResponse: " +  response.body().toString());
            }

            @Override
            public void onFailure(Call<List<HashMap<String, Object>>> call, Throwable t) {
                sampleCallback.onFailure("Failure" + t);
            }
        });
    }
}
