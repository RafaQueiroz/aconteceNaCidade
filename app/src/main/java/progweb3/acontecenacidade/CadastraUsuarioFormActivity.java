package progweb3.acontecenacidade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import progweb3.acontecenacidade.Util.RetrofitInicializador;
import progweb3.acontecenacidade.Util.UsuarioUtil;
import progweb3.acontecenacidade.modelo.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastraUsuarioFormActivity extends AppCompatActivity {

    private UsuarioUtil usuarioUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_usuario_form);

        this.usuarioUtil = new UsuarioUtil(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.usuario_form_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_usuario_form_ok:
                Usuario usuario = this.usuarioUtil.getUsuario();

                Call call = new RetrofitInicializador().getUsuarioService().insere(usuario);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {

                        Toast.makeText(CadastraUsuarioFormActivity.this,
                                "code - "+response.code(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(CadastraUsuarioFormActivity.this,
                                "mensagem - "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                Intent intentVaiParaEventos = new Intent(CadastraUsuarioFormActivity.this,
                        LoginActivity.class);
                startActivity(intentVaiParaEventos);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
