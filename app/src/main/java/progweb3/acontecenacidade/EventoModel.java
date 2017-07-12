package progweb3.acontecenacidade;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOSMOS00 on 19/06/2017.
 */

public class EventoModel {

    private static final String TABLE_NAME = "EVENTO";

    /*private static final String DB_CREATE_QUERY =
            " CREATE TABLE " + TABLE_NAME + "(" +
                    "_ID   INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " NOME  TEXT    NOT NULL," +
                    " DESCRICAO   TEXT    NOT NULL," +
                    " ENDERECO TEXT    NOT NULL,)" +
                    " DTINI TEXT    NOT NULL,)" +
                    " DTFIM TEXT    NOT NULL,)" +
                    " IDIMAGE INTEGER    NOT NULL,)" +
                    " PGTO BOOLEAN    NOT NULL,)" +
                    " VALOR DECIMAL    NOT NULL)";*/

    private BDUtil bdUtil;

    public EventoModel(Context context) {
        bdUtil = new BDUtil(context);
        //bdUtil.getConexao().execSQL(DB_CREATE_QUERY.toString());
    }

    public String insert(String nome, String descricao, String endereco, String dtIni, String dtFim, int idImg,boolean pgto, double valor  ) {
        ContentValues valores = new ContentValues();
        valores.put("NOME", nome);
        valores.put("DESCRICAO", descricao);
        valores.put("ENDERECO", String.valueOf(endereco));
        valores.put("DTINI", dtIni);
        valores.put("DTFIM", dtFim);
        valores.put("IDIMAGE", idImg);
        valores.put("PGTO", pgto);
        valores.put("VALOR", valor);
        long resultado = bdUtil.getConexao().insert(TABLE_NAME, null, valores);
        if (resultado == -1)
            return "Erro ao inserir registro";
        return "Registro Inserido com sucesso";
    }

    public Integer delete(int codigo) {
        return bdUtil.getConexao().delete(TABLE_NAME, "_id = ?", new String[]{Integer.toString(codigo)});
    }

    public List<Evento> getAll(){
        List<Evento> eventos = new ArrayList<>();
        // monta a consulta
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT _ID, NOME, DESCRICAO, DTINI ");
        stringBuilderQuery.append("FROM " + TABLE_NAME + " " );
        stringBuilderQuery.append("ORDER BY NOME");
        //consulta os registros que estão no BD
        Cursor cursor = bdUtil.getConexao().rawQuery(stringBuilderQuery.toString(), null);
        //aponta cursos para o primeiro registro
        cursor.moveToFirst();
        Evento evento = null;
        //Percorre os registros até atingir o fim da lista de registros
        while (!cursor.isAfterLast()){
            // Cria objetos do tipo tarefa
            evento =  new Evento();
            //adiciona os dados no objeto
            evento.setId(cursor.getLong(cursor.getColumnIndex("_ID")));
            evento.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
            evento.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
            //evento.setDtInicio(cursor.getString(cursor.getColumnIndex("DTINI")));
            //adiciona o objeto na lista
            eventos.add(evento);
            //aponta para o próximo registro
            cursor.moveToNext();
        }
        //retorna a lista de objetos
        return eventos;
    }
    public Evento getTarefa(int codigo){
        Cursor cursor =  bdUtil.getConexao().rawQuery("SELECT * FROM "+ TABLE_NAME +" WHERE _ID = "+ codigo,null);
        cursor.moveToFirst();
        Evento e = new Evento();
        e.setId(cursor.getLong(cursor.getColumnIndex("_ID")));
        e.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
        e.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
        //t.setDtInicio(cursor.getString(cursor.getColumnIndex("DTINI")));
        return e;
    }

    public void update(Evento tarefa){
        ContentValues contentValues =  new ContentValues();
        contentValues.put("NOME",       tarefa.getNome());
        contentValues.put("DESCRICAO",   tarefa.getDescricao());
        //contentValues.put("DATA",       tarefa.getDtInicio());
        //atualiza o objeto usando a chave
        bdUtil.getConexao().update(TABLE_NAME, contentValues, "_id = ?", new String[]{Long.toString(tarefa.getId())});
    }

}

