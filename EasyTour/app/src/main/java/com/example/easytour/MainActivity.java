package com.example.easytour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    EasySlider easyslider;
    Button b_inicio;
    TextInputEditText tie_correo, tie_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tie_correo = (TextInputEditText) findViewById(R.id.tie_correo) ;
        tie_password = (TextInputEditText) findViewById(R.id.tie_password);

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
        new Cliente();
        Intent intent = new Intent(this, Modificar.class);
        startActivity(intent);
    }

    //Esta clase es para que la app sea como cliente y mande una petición con los datos
    //Se usa socket de datagrama orientados a conexión
    private  class  Cliente(){
        boolean estado = false;
        try{
            InetAddress maquinaReceptora = InetAddress.getByName("198.168.15.18");
            int puertoReceptor = 1024;
            int miPuerto = 1025;
            String correo = tie_correo.getText().toString();
            String password = tie_password.getText().toString();

            String mensaje = correo + " | "+ password; //Se le asignan el texto que se obtuvo de los campos del XML

            //Se instancia a Socket Datagrama
            MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);

            //Se hace la conexion
            miSocket.connect(maquinaReceptora, puertoReceptor);
            for(int i=0; i<10; i++){
                miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);

                //Ahora recibe mensaje por parte del servidor
                System.out.println(miSocket.recibeMensaje());
                estado = true;
                //Se cierra la conexion
                miSocket.disconnect();
                miSocket.close();
            }

        }catch(Exception e){e.printStackTrace();}
        return estado;
    }

}


