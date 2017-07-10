package progweb3.acontecenacidade.service;

import progweb3.acontecenacidade.modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by rafael on 08/07/17.
 */

public interface UsuarioService {

    @POST("usuarios")
    Call<Void> insere(@Body Usuario usuario);


    @POST("usuarios/login")
    Call<Usuario> login(@Body Usuario usuario);
}
