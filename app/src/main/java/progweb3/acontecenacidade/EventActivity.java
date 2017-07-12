package progweb3.acontecenacidade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import progweb3.acontecenacidade.Util.EventoUtil;
import progweb3.acontecenacidade.Util.RetrofitInicializador;
import progweb3.acontecenacidade.dao.UsuarioDao;
import progweb3.acontecenacidade.modelo.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventActivity extends Activity {

    private Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        usuarioLogado = new UsuarioDao(this).getUsuarioLogado();

        if(usuarioLogado == null){
            Intent vaiParaLogin = new Intent(EventActivity.this, LoginActivity.class);
            startActivity(vaiParaLogin);
        }

        Button btnSalvar = (Button) findViewById(R.id.btn_salvar);
        Button apagar = (Button) findViewById(R.id.btn_apagar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //Fixme: Datas estão entrando como Null verificar no webservice
            //Fixme: Avaliar como fazer upload de imagens

            Evento evento = new EventoUtil(EventActivity.this).getEvento();
            evento.setProprietario(usuarioLogado);

            Call call = new RetrofitInicializador().getEventoService().insere(evento);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {

                    if(response.code() == 201){
                        Toast.makeText(EventActivity.this,
                                "Evento cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    Toast.makeText(EventActivity.this,
                            "Ops! Não foi possível cadastrar o evento. Código: "+response.code(),
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Toast.makeText(EventActivity.this,
                            "Ops! Não foi possível cadastrar o evento. Código: "+t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });

            }
        });

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EventoUtil(EventActivity.this).limparEventoForm();
            }
        });
    }


}
