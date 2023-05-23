package com.example.agenda.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agenda.R;

public class MainActivity extends AppCompatActivity {

    Button btnAcess;
    TextView textName, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAcess = (Button) findViewById(R.id.btnAcessar);
        textName = (TextView) findViewById(R.id.textName);
        textPassword = (TextView) findViewById(R.id.textPassword);

        btnAcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se o campo text name for diferente de 0 caracters entrar no if.
                if (textName.getText().toString().trim().length() != 0){
                    Intent i = new Intent(MainActivity.this, AgendaActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "campos vazios!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}