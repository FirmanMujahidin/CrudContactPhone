package firmanmujahidin.com.mycontactcrud.Rest;

import firmanmujahidin.com.mycontactcrud.Model.GetContact;
import firmanmujahidin.com.mycontactcrud.Model.PostPutDeletContact;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by firma on 17-Aug-17.
 */

public interface ApiInterface {

    @GET("kontak")
    Call<GetContact> getListContact(
    );

    @FormUrlEncoded
    @POST("kontak")
    Call<PostPutDeletContact> postContact (@Field("nama") String nama,
                                         @Field("nomor") String nomor);
    @FormUrlEncoded
    @PUT("kontak")
    Call<PostPutDeletContact> editContact (@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("nomor") String nomor);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call<PostPutDeletContact> deletContact(@Field("id") String id);

}
