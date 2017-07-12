package progweb3.acontecenacidade.Util;

import android.util.Log;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import progweb3.acontecenacidade.EventActivity;
import progweb3.acontecenacidade.Evento;
import progweb3.acontecenacidade.R;

/**
 * Created by rafael on 11/07/17.
 */

public class EventoUtil {

    private EditText nameField;
    private EditText enderecoField;
    private EditText descricaoField;
    private EditText dataInicioField;
    private EditText dataFimField;


    public EventoUtil(EventActivity activity) {

        nameField = (EditText) activity.findViewById(R.id.evento_form_nome);
        enderecoField = (EditText) activity.findViewById(R.id.evento_form_endereco);
        descricaoField = (EditText) activity.findViewById(R.id.evento_form_descricao);
        dataInicioField = (EditText) activity.findViewById(R.id.evento_form_data_inicio);
        dataFimField = (EditText) activity.findViewById(R.id.evento_form_data_fim);
    }

    public Evento getEvento(){
        Evento evento = new Evento();
        evento.setNome(nameField.getText().toString());
        evento.setEndereco(enderecoField.getText().toString());
        evento.setDescricao(descricaoField.getText().toString());

        try{
            evento.setDtInicio(stringToCalendar(dataInicioField.getText().toString(), "dd/mm/yyyy"));
            evento.setDtInicio(stringToCalendar(dataFimField.getText().toString(), "dd/mm/yyyy"));
        } catch (ParseException e) {
            Log.e("ERRO", "Erro ao converter data! Estabelecendo data padrão");
            evento.setDtInicio(Calendar.getInstance());
            evento.setDtFim(Calendar.getInstance());
        }

        return evento;
    }

    public void limparEventoForm(){
        nameField.setText("");
        descricaoField.setText("");
        enderecoField.setText("");
        dataInicioField.setText("");
        dataFimField.setText("");
    }

    public static Calendar stringToCalendar(String dataString, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dataString));

        return c;
    }

    public static String calendarToString(Long calendarInMillis, String pattern){

        SimpleDateFormat format1 = new SimpleDateFormat(pattern);
        String formatted = format1.format(calendarInMillis);

        return formatted;
    }


}
