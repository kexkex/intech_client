package api;

import model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IntechServerApi {
    @GET("/clients")
    Call<BaseResponse<List<Client>>> getClients();

    @GET("/clients/{uid}/content/{page}")
    Call<BaseResponse<Content>> getClientContent(@Path("uid") String uid, @Path("page") Integer page);

    @POST("/clients")
    Call<BaseResponse<Client>> createClient(@Body String name);

    @GET("/contents")
    Call<BaseResponse<List<Content>>> getContents();

    @GET("/contents/{page}")
    Call<BaseResponse<Content>> getContent(@Path("page") Integer page);

    @POST("/contents/{page}")
    Call<BaseResponse<Content>> addContentToClient(@Path("page") Integer page, @Body String uid);

    @DELETE("/clients/{uid}/content/{page}")
    Call<BaseResponse<Content>> deleteClientContent(@Path("uid") String uid, @Path("page") Integer page);
}
