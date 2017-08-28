package firmanmujahidin.com.mycontactcrud.Rest;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by firma on 17-Aug-17.
 */

public class ApiClient {

    public static ApiInterface initRetrofit(){

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(270, TimeUnit.SECONDS);
        builder.connectTimeout(270, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = builder.build();


        Retrofit adapter_ = new Retrofit.Builder()
                .baseUrl("http://192.168.43.106/ci-restserver-master/index.php/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface adapter = adapter_.create(ApiInterface.class);

        return adapter;
    }
}
