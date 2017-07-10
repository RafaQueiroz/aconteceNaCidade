package progweb3.acontecenacidade.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import progweb3.acontecenacidade.BDUtil;
import progweb3.acontecenacidade.modelo.Usuario;

/**
 * Created by rafael on 09/07/17.
 */

public class UsuarioDao extends BDUtil {

    public UsuarioDao(Context context) {
        super(context);
    }

    public void insereUsuario(Usuario usuario){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", usuario.getNome());
        dados.put("email", usuario.getEmail());
        dados.put("senha", usuario.getSenha());
        dados.put("logado", usuario.getLogado());

        db.insert("USUARIO", null, dados);
        db.close();
    }

    public Usuario getUsuarioLogado(){
        SQLiteDatabase db = getReadableDatabase();

        StringBuilder sql = new StringBuilder();
        sql.append(
            "SELECT * FROM USUARIO WHERE LOGADO = TRUE"
        );

        Cursor c = db.rawQuery(sql.toString(), null);

        Usuario usuario = null;

        if (c.moveToFirst()){
            usuario = new Usuario();

            usuario.setNome(c.getString(c.getColumnIndex("NOME")));
            usuario.setEmail(c.getString(c.getColumnIndex("EMAIL")));
            usuario.setSenha(c.getString(c.getColumnIndex("SENHA")));
        }
        c.close();

        return usuario;
    }




}
