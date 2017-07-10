package progweb3.acontecenacidade.Util;

import android.widget.EditText;

import progweb3.acontecenacidade.CadastraUsuarioFormActivity;
import progweb3.acontecenacidade.R;
import progweb3.acontecenacidade.modelo.Usuario;

/**
 * Created by rafael on 08/07/17.
 */

public class UsuarioUtil {


    private EditText nameField;
    private EditText emailField;
    private EditText passField;
    private EditText confirmPassField;

    public UsuarioUtil(CadastraUsuarioFormActivity activity) {
        nameField = (EditText) activity.findViewById(R.id.user_name);
        emailField = (EditText) activity.findViewById(R.id.user_email);
        passField = (EditText) activity.findViewById(R.id.user_pass);
        confirmPassField = (EditText) activity.findViewById(R.id.user_name);
    }

    public Usuario getUsuario(){

        String nome = nameField.getText().toString();
        String email = emailField.getText().toString();
        String senha = passField.getText().toString();

        Usuario usuario = new Usuario(nome, email, senha);

        return usuario;
    }
}
