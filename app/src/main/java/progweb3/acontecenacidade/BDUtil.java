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
    private static final int VERSAO = 2;

    public BDUtil(Context context){
        super(context,BASE_DE_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sqlEvento = new StringBuilder();
        sqlEvento.append(
                "CREATE TABLE EVENTO ( \n "+
                " ID   INTEGER PRIMARY KEY AUTOINCREMENT, \n"+
                " NOME  TEXT    NOT NULL, \n"+
                " DESCRICAO   TEXT    NOT NULL, \n"+
                " ENDERECO TEXT    NOT NULL, \n"+
                " DTINI TEXT    NOT NULL, \n"+
                " DTFIM TEXT    NOT NULL, \n"+
                " IDIMAGE INTEGER    NOT NULL, \n"+
                " PGTO BOOLEAN    NOT NULL, \n"+
                " VALOR DECIMAL    NOT NULL )\n"
        );

        StringBuilder sqlUsuario = new StringBuilder();

        sqlUsuario.append(
                "CREATE TABLE USUARIO ( \n"+
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, \n"+
                " NOME TEXT NOT NULL, \n"+
                " EMAIL TEXT NOT NULL, \n"+
                " SENHA TEXT NOT NULL,\n"+
                " LOGADO BOOLEAN NOT NULL ) \n"
        );


        db.execSQL(sqlEvento.toString());
        db.execSQL(sqlUsuario.toString());
    }

    /*Método abaixo é executado quando troca a versão do BD*/
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