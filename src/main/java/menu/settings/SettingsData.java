package menu.settings;

public class SettingsData {
    public String userName;
    public String pass;
    public String link;
    public Integer period;
    public Integer stickersSum;

    SettingsData(String userName, String pass, String link, Integer period, Integer stickersSum) {
        this.userName = userName;
        this.pass = pass;
        this.link = link;
        this.period = period;
        this.stickersSum = stickersSum;
    }

}
