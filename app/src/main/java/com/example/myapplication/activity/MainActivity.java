package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.api_services.ApiClient;
import com.example.myapplication.api_services.ApiInterface;
import com.example.myapplication.model.DataModels;
import com.example.myapplication.model.Model;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private String cardData;
    private  Model[] modelDataArray = null;
    private String[] dataCardVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);

        Button button = findViewById(R.id.textButton);
        retrofit_api_call(button);
    }



    public  void retrofit_api_call(Button button) {

        ApiInterface apiInstance = ApiClient.getApiClient().create(ApiInterface.class);
        Call<String> call = apiInstance.getCardData();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                // removing / present in the data received
                cardData = response.body().substring(1);
                Gson gson = new Gson();

                //parsing json string into pojo via gson
                DataModels data_model = gson.fromJson(cardData, DataModels.class);
                modelDataArray = data_model.getModelArray();

                // data to be sent via intent to be dusplayed in cards
                dataCardVisible = new String[modelDataArray.length];

                for(int k=0; k < modelDataArray.length; k++)
                {

                    dataCardVisible[k] = modelDataArray[k].getText();
                }

                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Intent i = new Intent(MainActivity.this, HorizontalScrollActivity.class);
                        i.putExtra("text", dataCardVisible);
                        startActivity(i);

                    }
                });
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(MainActivity.this, "No Connectivity...Please try later!", Toast.LENGTH_SHORT).show();
                button.setText("No Connectivity");

            }
        });

    }

}