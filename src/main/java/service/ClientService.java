package service;

import controller.UIController;
import model.BaseResponse;
import model.Content;
import repository.ClientRepo;
import settings.Settings;

import java.io.IOException;

public class ClientService {
    private UIController uiController;

    private ClientRepo clientRepo = new ClientRepo();
    private static int page;

    public ClientService(UIController uiController){
        this.uiController = uiController;
    }

    public Content getContent() {
        BaseResponse<Content> response = null;
        try {
            response = clientRepo.getClientContent(Settings.uid, page);
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

    public Content deleteContent() {
     BaseResponse<Content> response = null;
        try {
            response = clientRepo.removeContent(Settings.uid, page);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response != null){
            if (response.getStatus() == 200){
                uiController.showSuccess("Content at page " + page + " removed");
                page = 0;
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

    public void flushPage(){
        page = 0;
    }
}
