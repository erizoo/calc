package by.erizol.calc.calcapp.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import by.erizol.calc.calcapp.data.network.ApiMethods;
import by.erizol.calc.calcapp.data.network.ServiceNetwork;
import by.erizol.calc.calcapp.data.network.ServiceNetworkImp;
import by.erizol.calc.calcapp.utils.Constant;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * модуль предоставляет зависимости для АПИ-шки
 * данные сущности добавляются в "зависимые" объекты через конструктор.
 * через ту же аннотацию {@link javax.inject.Inject}.
 * Dagger 2 умеет предоставлять зависимости в поля, конструкторы и через методы, при добавленной
 * аннотации.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    ServiceNetwork provideServiceNetwork(ServiceNetworkImp serviceNetwork) {
        return serviceNetwork;
    }

    @Provides
    @Singleton
    ApiMethods provideApiMethodsService(Retrofit retrofit) {
        return retrofit.create(ApiMethods.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(HttpUrl baseUrl, Converter.Factory converterFactory, CallAdapter.Factory callAdapterFactory, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    public Converter.Factory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Singleton
    @Provides
    public Gson provideGson() {

        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    @Singleton
    public CallAdapter.Factory provideRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    HttpUrl provideHttpUrl() {
        return HttpUrl.parse(Constant.BASE_URI);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS);

        builder.addInterceptor(chain -> {
            Response response = chain.proceed(chain.request());


            return response;
        });

        return builder.build();
    }
}
