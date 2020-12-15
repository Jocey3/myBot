package menu.settings;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageSettingsFile {

    private SettingsData settingsData;
    Pattern patternInfo = Pattern.compile("login:\"(.*?)\",pass:\"(.*?)\",link:\"(.*?)\",period:\"(\\d*)\",stickersSum:\"(\\d*)\".");

    public ManageSettingsFile() {
        initSettingsData();
    }

    public SettingsData getSettingsData() {

        return settingsData;
    }


    private void initSettingsData() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/menu/settings/Settings"))) {
            String info = br.readLine();
            Matcher matcher = patternInfo.matcher(info);
            if (matcher.find()) {
                settingsData = new SettingsData(matcher.group(1), matcher.group(2), matcher.group(3), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInSettings(SettingsData settingsData) {
        writeInFileSettings(settingsData);
    }

    private void writeInFileSettings(SettingsData settingsData) {
        try {
            String info = "login:\"" + settingsData.userName + "\",pass:\"" + settingsData.pass + "\",link:\"" + settingsData.link + "\",period:\"" + settingsData.period + "\",stickersSum:\"" + settingsData.stickersSum + "\".";
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/menu/settings/Settings", false));
            bw.write(info);
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
