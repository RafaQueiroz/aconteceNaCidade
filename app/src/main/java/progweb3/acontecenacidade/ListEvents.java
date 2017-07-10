package progweb3.acontecenacidade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListEvents extends AppCompatActivity implements ClickRecycler {
    private static final int VERTICAL_ITEM_SPACE = 48;
    private RecyclerView recyclerView;
    MyAdapter adapter;
    private List<Evento> listaEventos = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_events);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));

        //TODO:Carregar eventos webservice



        for(int i=0; i< 3; i++)
            listaEventos.add(Evento.carrega());
            adapter = new MyAdapter(this, listaEventos, this);
            recyclerView.setAdapter(adapter);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //listaEventos.add(Evento.carrega());
               // adapter.notifyDataSetChanged();
                Intent i = new Intent (ListEvents.this, EventActivity.class);
                startActivity(i);

            }
        });
    }
    @Override
    public void onCustomClick(Object object) {
        System.out.println("funciona");
        Evento e = (Evento) object;
        System.out.println("Evento = " + e.toString());
    }
}