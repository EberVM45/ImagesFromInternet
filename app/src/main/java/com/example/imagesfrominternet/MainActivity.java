package com.example.imagesfrominternet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.imagesfrominternet.data.RequestHeroes;
import com.example.imagesfrominternet.model.Hero;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Hero> ArrayListHeroes;
    RequestHeroes requestHeroes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestHeroes=new RequestHeroes(this);
        requestHeroes.Request_Heroes();
    }
}