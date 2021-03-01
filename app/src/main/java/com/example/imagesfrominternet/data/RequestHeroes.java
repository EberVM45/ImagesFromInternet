package com.example.imagesfrominternet.data;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.imagesfrominternet.MainActivity;
import com.example.imagesfrominternet.R;
import com.example.imagesfrominternet.model.Hero;
import com.example.imagesfrominternet.view.Fragment_Heroes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class RequestHeroes {
    RequestQueue requestQueue;
    Context context;
    MainActivity mainActivity;
    private static final String TAG = "VollHero";
    public RequestHeroes(Context context){
        this.context=context;
        if(context instanceof MainActivity){
            mainActivity=(MainActivity)context;
        }
        requestQueue= Volley.newRequestQueue(context);
    }
    public void Request_Heroes(){
        String url_Heroes = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";
        JsonRequest jsonRequest=new JsonObjectRequest(url_Heroes,null,
                response -> {
                    try {
                        JSONArray jsonArray=response.getJSONArray("heroes");
                        Type listType=new TypeToken<ArrayList<Hero>>(){}.getType();
                        Gson gson=new Gson();
                        MainActivity.ArrayListHeroes=gson.fromJson(jsonArray.toString(),listType);
                        Fragment_Heroes fragment_heroes=new Fragment_Heroes();
                        if (mainActivity.findViewById(R.id.RV_Heros) != null && mainActivity.getSupportFragmentManager().findFragmentById(R.id.RV_Heros) == null){
                            mainActivity.getSupportFragmentManager().beginTransaction().add(R.id.RV_Heros, fragment_heroes).commit();
                        }
                    }catch (Exception ex) {
                        //Toast.makeText()
                    }},
                error -> {
                });
     requestQueue.add(jsonRequest);
    }
}
