public interface IRadio {
    void saveSation(int buttonId, double station);
    void switchOnOff();
    void switchAMFM();
    double selectStation(int button);
    boolean isOn();
    boolean isAm();
    double nextStation();
}