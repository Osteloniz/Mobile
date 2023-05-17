package com.example.mobile_ac2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobile_ac2.R;

public class MainActivity extends AppCompatActivity {

    Button buttonAcessar;

    TextView textName, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAcessar = (Button) findViewById(R.id.btnAcessar);
        textName = (TextView) findViewById(R.id.textName);
        textPassword = (TextView) findViewById(R.id.textPassword);

        buttonAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se o campo text name for diferente de 0 caracters entrar no if.
                if (textName.getText().toString().trim().length() != 0){
                    Intent i = new Intent(MainActivity.this, AcivityListaAgenda.class);
                    startActivity(i);
                }else{
                    finish();
               }

            }
        });

    }


}