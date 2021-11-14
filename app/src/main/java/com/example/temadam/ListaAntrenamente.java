package com.example.temadam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaAntrenamente extends AppCompatActivity {

    private ListView listView;
    private AntrenamentAdapter antrenamentAdapter;
    private Button btnUpdate,btnImportJson;
    private JsonRead jsonRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_antrenamente);

        btnUpdate=findViewById(R.id.btnUpdate);
        btnImportJson=findViewById(R.id.btnJson);
        listView=findViewById(R.id.lvAntrenamente);

        jsonRead=new JsonRead();

        antrenamentAdapter=new AntrenamentAdapter(createList());
        listView.setAdapter(antrenamentAdapter);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                antrenamentAdapter.updateList(createList2());
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListaAntrenamente.this, antrenamentAdapter.getItem(i).toString(),Toast.LENGTH_LONG).show();

            }
        });

        btnImportJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        jsonRead.readJson("https://jsonkeeper.com/b/GBQI", new IResponse() {
                            @Override
                            public void onSuccess(List<Antrenament> list) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        antrenamentAdapter.updateList(list);
                                    }
                                });
                            }

                            @Override
                            public void onError(String errorMessage) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(ListaAntrenamente.this,errorMessage, Toast.LENGTH_LONG).show();
                                    }
                                });

                            }
                        });
                    }
                });
                thread.start();
            }
        });


    }

    private List<Antrenament> createList(){
        ArrayList<Antrenament> lista=new ArrayList<>();

        Antrenament antrenament1=new Antrenament("Alergare", 30, "Banda");
        Antrenament antrenament2=new Antrenament("Picioare", 15, "Presa picioare");
        Antrenament antrenament3=new Antrenament("Overhead-Press", 15, "Haltera");

        lista.add(antrenament1);
        lista.add(antrenament2);
        lista.add(antrenament3);

        return lista;
    }

    private List<Antrenament> createList2(){
        ArrayList<Antrenament> lista=new ArrayList<>();

        Antrenament antrenament1=new Antrenament("Barbel Rows",30,"Haltera");
        Antrenament antrenament2=new Antrenament("Romanian Deadlift",10,"Haltera");
        Antrenament antrenament3=new Antrenament("Seated Cable Rows",15,"Cable seat");

        lista.add(antrenament1);
        lista.add(antrenament2);
        lista.add(antrenament3);

        return lista;
    }
}

