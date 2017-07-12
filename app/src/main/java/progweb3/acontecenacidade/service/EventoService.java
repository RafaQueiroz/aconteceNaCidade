package progweb3.acontecenacidade.service;

import java.util.List;

import progweb3.acontecenacidade.Evento;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by rafael on 12/07/17.
 */

public interface EventoService {

    @POST("eventos")
    Call<Void> insere(@Body Evento evento);

    @GET("/eventos")
    Call<List<Evento>> buscaTodosEventos();



}
