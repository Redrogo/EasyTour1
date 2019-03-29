package com.example.ejercisio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String texto;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.id_Edittext);
    }

    public void LanzarActivity(View view) {

        texto = editText.getText().toString();



        Intent intent;

         Uri uri = null;
         uri.parse("http://wwww.mujeresenred.net");
         intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtra("cosa",texto);

        this.startActivity(intent);
    }
}
