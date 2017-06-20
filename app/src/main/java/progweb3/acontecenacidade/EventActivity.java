package progweb3.acontecenacidade;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class EventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Button salvar = (Button) findViewById(R.id.button3);
        Button apagar = (Button) findViewById(R.id.button4);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventoModel evento = new EventoModel(getBaseContext());
                EditText nome = (EditText) findViewById(R.id.nome);
                EditText descricao = (EditText) findViewById((R.id.descricao));
                EditText endereco = (EditText) findViewById((R.id.endereco));
                EditText dtIni = (EditText) findViewById(R.id.dtInicio);
                EditText dtFim = (EditText) findViewById(R.id.dtFim);
                //EditText idImg = (EditText) findViewById(R.id.imageView2);
                Boolean pgto = findViewById(R.id.chkpago).isEnabled();
                EditText valor = (EditText) findViewById(R.id.valor);
                String resultado = evento.insert(
                        nome.getText().toString(),
                        descricao.getText().toString(),
                        endereco.getText().toString(),
                        dtIni.getText().toString(),
                        dtFim.getText().toString(),
                        2,
                        pgto.booleanValue(),
                        Double.parseDouble(valor.getText().toString())
                );
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                limparCampos();
            }
        });

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    private void limparCampos(){

        EditText nome = (EditText) findViewById(R.id.nome);
        EditText descricao = (EditText) findViewById((R.id.descricao));
        EditText endereco = (EditText) findViewById((R.id.endereco));
        EditText dtIni = (EditText) findViewById(R.id.dtInicio);
        EditText dtFim = (EditText) findViewById(R.id.dtFim);
        //EditText idImg = (EditText) findViewById(R.id.imageView2);
        Boolean pgto = findViewById(R.id.chkpago).isEnabled();
        EditText valor = (EditText) findViewById(R.id.valor);
        nome.setText("");
        descricao.setText("");
        endereco.setText("");
        dtIni.setText("");
        dtFim.setText("");
        valor.setText("");


    }
}
