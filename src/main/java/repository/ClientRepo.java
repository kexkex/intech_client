package repository;

import api.ApiInstance;
import api.IntechServerApi;
import model.BaseResponse;
import model.Client;
import model.Content;

import java.io.IOException;
import java.util.List;

public class ClientRepo {
    private IntechServerApi api = ApiInstance.INSTANCE;

    //Not used, only for testing
    public BaseResponse<List<Client>> getClients() throws IOException {
        return api.getClients().execute().body();
    }

    public BaseResponse<Content> getClientContent(String uid, Integer page) throws IOException {
        return api.getClientContent(uid, page).execute().body();
    }

    public BaseResponse<Client> createClient(String name) throws IOException{
        return api.createClient(name).execute().body();
    }

    public BaseResponse<Content> removeContent(String uid, Integer page) throws IOException {
        return api.deleteClientContent(uid, page).execute().body();
    }
}
