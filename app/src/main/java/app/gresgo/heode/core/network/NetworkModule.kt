package app.gresgo.heode.core.network

import app.gresgo.heode.utils.BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun create() = module {
        single { provideOkHttpClient() }
        single { provideGsonConverterFactory() }
        single { provideRetrofit(BASE_URL, get(), get()) }
        single { provideHeodeApi(get()) }
    }

    private fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()

    private fun provideGsonConverterFactory(): Converter.Factory =
        GsonConverterFactory.create()

    private fun provideRetrofit(
        url: String,
        client: OkHttpClient,
        converter: Converter.Factory
    ): Retrofit =
        Retrofit.Builder()
            .client(client)
            .baseUrl(url)
            .addConverterFactory(converter)
            .build()

    private fun provideHeodeApi(retrofit: Retrofit): HeodeApi =
        retrofit.create(HeodeApi::class.java)

}