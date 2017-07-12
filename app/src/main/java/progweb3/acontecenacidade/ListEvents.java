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
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import progweb3.acontecenacidade.Util.RetrofitInicializador;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        Call<List<Evento>> call = new RetrofitInicializador().getEventoService().buscaTodosEventos();
        call.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {

                if(response.code() == 200 ){
                    Toast.makeText(ListEvents.this, "Não foi possível buscar os eventos"+
                            response.message(), Toast.LENGTH_SHORT).show();

                    return;
                }

                List<Evento> listaEventos = response.body();

                adapter = new MyAdapter(ListEvents.this, listaEventos, ListEvents.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

                Toast.makeText(ListEvents.this, "Erro ao enviar requisição. "+t.getMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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