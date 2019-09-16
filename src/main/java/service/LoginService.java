package service;

import controller.UIController;
import repository.ClientRepo;
import settings.Settings;

import java.io.IOException;

public class LoginService {
    private UIController uiController;

    private ClientRepo clientRepo = new ClientRepo();

    public LoginService(UIController uiController){
        this.uiController = uiController;
    }


    public void login(String name) {
        if (Settings.uid != null && Settings.name == name){
            uiController.showSectionChooserScreen();
        } else {
            try {
                Settings.name = name;
                Settings.uid = clientRepo.createClient(name).getData().getUid();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
