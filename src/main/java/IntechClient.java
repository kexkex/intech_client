import model.Client;
import settings.Settings;
import ui.UI;

import java.io.IOException;

public class IntechClient {
    public static void main(String[] args) {
        Settings.loadSettings();
        UI ui = new UI();
        ui.showLoginScreen();

    }
}
