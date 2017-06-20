package progweb3.acontecenacidade;

/**
 * Created by KOSMOS00 on 19/06/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BDUtil extends SQLiteOpenHelper {

    private static final String BASE_DE_DADOS = "AconteceCidade";
    private static final int VERSAO = 1;

    public BDUtil(Context context){
        super(context,BASE_DE_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder criarTabela = new StringBuilder();
        criarTabela.append(" CREATE TABLE EVENTO (");
        criarTabela.append(" _ID   INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" NOME  TEXT    NOT NULL,");
        criarTabela.append(" DESCRICAO   TEXT    NOT NULL,");
        criarTabela.append(" ENDERECO TEXT    NOT NULL,");
        criarTabela.append(" DTINI TEXT    NOT NULL,");
        criarTabela.append(" DTFIM TEXT    NOT NULL,");
        criarTabela.append(" IDIMAGE INTEGER    NOT NULL,");
        criarTabela.append(" PGTO BOOLEAN    NOT NULL,");
        criarTabela.append(" VALOR DECIMAL    NOT NULL )");
        db.execSQL(criarTabela.toString());
    }

    /*Método abaixo é executado quando troa a versão do BD*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS EVENTO");
        onCreate(db);

    }

    /*Método usado para obter a conexão com o BD*/
    public SQLiteDatabase getConexao(){
        return this.getWritableDatabase();
    }




}