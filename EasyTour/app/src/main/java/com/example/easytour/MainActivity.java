package com.example.easytour;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EasySlider easyslider;
    Button b_inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_inicio = (Button) findViewById(R.id.b_inicio);
        b_inicio.setOnClickListener(this);



        /*EASY SLIDER*/
        //------------------------------------------------------------------------------------------
        easyslider = findViewById(R.id.id_slider);

        List<SliderItem> easysliders = new ArrayList<>();

        easysliders.add(new SliderItem("Torre latinoamericana", R.drawable.toote));
        easysliders.add(new SliderItem("Palacio de Bellas Artes", R.drawable.easytouruno));
        easysliders.add(new SliderItem("Ángel de la independia", R.drawable.easytourdos));
        easyslider.setPages(easysliders);
        //------------------------------------------------------------------------------------------
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Modificar.class);
        startActivity(intent);
    }
}


