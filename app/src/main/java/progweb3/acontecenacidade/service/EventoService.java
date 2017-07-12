package progweb3.acontecenacidade.service;

import progweb3.acontecenacidade.Evento;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by rafael on 12/07/17.
 */

public interface EventoService {

    @POST("eventos")
    public Call<Void> insere(@Body Evento evento);


}
