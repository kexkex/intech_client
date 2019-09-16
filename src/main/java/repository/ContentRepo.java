package repository;

import api.ApiInstance;
import api.IntechServerApi;
import model.BaseResponse;
import model.Content;

import java.io.IOException;
import java.util.List;

public class ContentRepo {
    private IntechServerApi api = ApiInstance.INSTANCE;

    public BaseResponse<List<Content>> getContents() throws IOException {
        return api.getContents().execute().body();
    }

    public BaseResponse<Content> getContent(Integer page) throws IOException {
        return api.getContent(page).execute().body();
    }

    public BaseResponse<Content> addContent(Integer page, String uid) throws IOException {
        return api.addContentToClient(page, uid).execute().body();
    }
}
