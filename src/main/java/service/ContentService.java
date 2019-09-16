package service;

import controller.UIController;
import model.BaseResponse;
import model.Content;
import repository.ContentRepo;
import settings.Settings;

import javax.xml.ws.Response;
import java.io.IOException;

public class ContentService {

    private UIController uiController;
    private ContentRepo contentRepo = new ContentRepo();
    private static int page;

    public ContentService(UIController uiController) {
        this.uiController = uiController;
    }

    public Content getContent() {
        BaseResponse<Content> response = null;
        try {
            response = contentRepo.getContent(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response != null){
            if (response.getStatus() == 200){
                uiController.showSuccess("Content at page " + page);
                return response.getData();
            }
            uiController.showError(response.getMessage());
        }
        return null;
    }

    public Content getNextContent() {
        page++;
        return getContent();
    }

    public Content addContent() {
        BaseResponse<Content> response = null;
        try {
            response = contentRepo.addContent(page, Settings.uid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response != null){
            if (response.getStatus() == 200){
                uiController.showSuccess("Content at page " + page + "added");
                return response.getData();
            }
            uiController.showError(response.getMessage());
        }
        return null;
    }

    public void flushPage(){
        page = 0;
    }
}
