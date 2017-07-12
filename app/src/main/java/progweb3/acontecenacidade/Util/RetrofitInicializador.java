package progweb3.acontecenacidade.Util;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import progweb3.acontecenacidade.service.EventoService;
import progweb3.acontecenacidade.service.UsuarioService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rafael on 08/07/17.
 */

public class RetrofitInicializador {

    private Retrofit retrofit;

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient.Builder client = new OkHttpClient.Builder().addInterceptor(interceptor);

    public RetrofitInicializador() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.10.8.172:8080/wsAconteceNaCidade/api/")
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public UsuarioService getUsuarioService(){
        return retrofit.create(UsuarioService.class);
    }

    public EventoService getEventoService(){
        return  retrofit.create(EventoService.class);
    }
}
