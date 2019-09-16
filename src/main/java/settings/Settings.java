package settings;

import java.io.*;

public class Settings {
    public static String uid;
    public static String name;

    public static void saveSettings() {
        BufferedWriter bw = null;
        try{
            File mFile = new File("settings.ini");
            if (!mFile.exists()) {
                mFile.createNewFile();
            } else {
                mFile.delete();
                mFile.createNewFile();
            }
            Writer w = new FileWriter(mFile);
            bw = new BufferedWriter(w);
            bw.write(uid + "\n");
            bw.write(name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSettings(){
        BufferedReader br = null;
        try {
            File mFile = new File("settings.ini");
            if (!mFile.exists()){
                return;
            }
            Reader r = new FileReader(mFile);
            br = new BufferedReader(r);
            uid = br.readLine();
            name = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
