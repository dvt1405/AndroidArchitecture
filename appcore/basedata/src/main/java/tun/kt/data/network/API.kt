package tun.kt.data.network

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tun.kt.data.model.ListImageResponse

interface API {
    @GET("rest")
    fun searchImage(
        @Query("method") method: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("nojsoncallback") nojsonCallback: String,
        @Query("page") page: String,
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("per_page") perpage: String
    ): Call<ListImageResponse>

//    @GET("rest")
//    fun searchImageObservable(
//        @Query("method") method: String,
//        @Query("api_key") apiKey: String,
//        @Query("format") format: String,
//        @Query("nojsoncallback") nojsonCallback: String,
//        @Query("page") page: String,
//        @Query("lat") lat: String,
//        @Query("lon") lon: String,
//        @Query("per_page") perpage: String
//    ): Observable<ListImageResponse>
}