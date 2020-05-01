package com.example.tallerfinal_firebase;
import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Notas prom = new Notas();
    DecimalFormat df = new DecimalFormat("#.0");

    private EditText codMatricula;
    private EditText nombre;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private Button guardar;
    private Button salir;
    private TextView resultado;



    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codMatricula = findViewById(R.id.txtcodmatricula);
        nombre = findViewById(R.id.txtnombre);
        nota1 = findViewById(R.id.txtnota1);
        nota2 = findViewById(R.id.txtnota2);
        nota3 = findViewById(R.id.txtnota3);
        guardar = findViewById(R.id.btnguargar);
        salir = findViewById(R.id.btnsalir);
        resultado = findViewById(R.id.txtresultado);

        databaseReference = FirebaseDatabase.getInstance().getInstance().getReference("Notas");



        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prom.setNota1(Double.parseDouble(nota1.getText().toString()));
                prom.setNota2(Double.parseDouble(nota2.getText().toString()));
                prom.setNota3(Double.parseDouble(nota3.getText().toString()));





                resultado.setText(df.format(prom.promedioNotas()));
                resultado.setVisibility(view.VISIBLE);


                String codM = codMatricula.getText().toString().trim();
                String nom = nombre.getText().toString().trim();
                String res = resultado.getText().toString().trim();

                prom.setIdUnico(UUID.randomUUID().toString());
                prom.setCodMatricula(codM);
                prom.setNombre(nom);
                prom.setPromedioNotas(res);
                databaseReference.child("Estudiante").child(prom.getNombre()).setValue(prom);

                Notas notas = new Notas(prom.getIdUnico(), codM, nom, res);



                Toast.makeText(MainActivity.this, "Guardado correcto", Toast.LENGTH_LONG).show();

                codMatricula.setText("");
                nombre.setText("");
                nota1.setText("");
                nota2.setText("");
                nota3.setText("");
                codMatricula.requestFocus();

            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);

            }
        });

    }
}
