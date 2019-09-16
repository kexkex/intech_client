package controller;

import model.Content;
import service.ClientService;
import service.ContentService;
import service.LoginService;
import settings.Settings;
import ui.UI;

public class UIController {
    private UI ui;

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String BACK = "*";

    private static Menu menu = Menu.Login;
    private LoginService loginService = new LoginService(this);
    private ClientService clientService = new ClientService(this);
    private ContentService contentService = new ContentService(this);

    public UIController(UI ui){
        this.ui = ui;
    }

    public void showCurrentScreen() {
        switch (menu){
            case SectionChooser: showSectionChooserScreen();
                break;
            case ContentSection: showContentScreen(contentService.getContent());
                break;
            case ClientSection: showClientScreen(clientService.getContent());
                break;
        }
        ui.readAction();
    }

    public void readAction(String s){
        Action action = Action.ERROR_INPUT;
        switch (s){
            case ONE: action = Action.ONE;
                break;
            case TWO: action = Action.TWO;
                break;
            case BACK: action = Action.BACK;
        }
        doAction(action);
    }

    private void doAction(Action action) {
        switch (action){
            case ONE: doOneAction();
                break;
            case TWO: doTwoAction();
                break;
            case BACK: doBackAction();
                break;
            case ERROR_INPUT: ui.showError("Bad input");
        }
    }

    private void doTwoAction() {
        switch (menu){
            case ClientSection: deleteClientContent();
                break;
            case ContentSection: addContent();
                break;
            case SectionChooser: menu = Menu.ClientSection;
                showSuccess("Moved To Client Section");
                break;
        }
        showCurrentScreen();
    }

    private void doOneAction() {
        switch (menu){
            case ClientSection: getNextClientContent();
                break;
            case ContentSection: getNextContent();
                break;
            case SectionChooser: menu = Menu.ContentSection;
                showSuccess("Moved To Content Section");
                break;
        }
        showCurrentScreen();
    }

    private void doBackAction() {
        if (menu == Menu.SectionChooser) {
            System.out.println("Good bye!");
            Settings.saveSettings();
        } else {
            menu = Menu.SectionChooser;
            showSuccess("Back To Section Chooser Screen");
            showCurrentScreen();
        }
    }

    public void showSectionChooserScreen() {
        clientService.flushPage();
        contentService.flushPage();
        ui.showSectionChooserScreen();
    }

    private void showClientScreen(Content content) {
        if (content != null) {
            ui.showClientScreen(content);
        } else {
            showError("No more contents for you!");
            doBackAction();
        }
    }

    private void showContentScreen(Content content){
        if (content != null) {
            ui.showContentScreen(content);
        } else {
            showError("No more contents for you!");
            doBackAction();
        }
    }

    public void showSuccess(String s) {
        ui.showSuccess(s);
    }

    public void showError(String s) {
        ui.showError(s);
    }

    public void login(String name){
        loginService.login(name);
        menu = Menu.SectionChooser;
        showCurrentScreen();
    }

    private void addContent() {
        contentService.addContent();
    }

    private void deleteClientContent() {
        clientService.deleteContent();
    }

    private void getNextClientContent() {
        showClientScreen(clientService.getNextContent());
    }

    private void getNextContent() {
        showContentScreen(contentService.getNextContent());

    }

    enum Menu {
        Login,
        SectionChooser,
        ContentSection,
        ClientSection
    }

    enum Action {
        ONE,
        TWO,
        BACK,
        ERROR_INPUT
    }
}
