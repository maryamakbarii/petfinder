package remote;


import remote.animals.Animals;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface apiTokenService {
    @FormUrlEncoded
    @POST("oauth2/token")
    Call<apiToken> getToken(@Field("grant_type") String grantType,
                            @Field("client_id") String clientId,
                            @Field("client_secret") String clientSecret);

    @GET("animals?type=dog&page=2")
    Call<Animals> getAllAnimals(@Header("Authorization") String authorization);


}

