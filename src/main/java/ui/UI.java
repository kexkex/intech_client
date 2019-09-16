package ui;

import controller.UIController;
import model.Content;
import java.util.Scanner;

public class UI {

    private UIController uiController = new UIController(this);

    public void showSectionChooserScreen() {
        println("****************");
        println("Choose Section:");
        println("1 - Content Section, 2 - Client Section, * - Exit");
    }

    public void showLoginScreen() {
        println("****************");
        println("Enter your name to login:");
        String name = readInput();
        uiController.login(name);
    }

    public void showError(String s){
        println("****************");
        println("Error: " + s);
    }

    public void showSuccess(String s){
        println("****************");
        println("Success: " + s);
    }


    public void showClientScreen(Content content) {
        println("****************");
        println("Client Contents Section:");
        println("1 - Show Next Content, 2 - Delete Content, * - Back To Choose Section");
        println(content.getName());
    }

    public void showContentScreen(Content content) {
        println("****************");
        println("Contents Section:");
        println("1 - Show Next Content, 2 - Add Content To Library, * - Back To Choose Section");
        println(content.getName());
    }

    public String readInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void readAction(){
        uiController.readAction(readInput());
    }

    private void println(String s){
        System.out.println(s);
    }
}
