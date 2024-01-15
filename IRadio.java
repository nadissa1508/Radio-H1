/**
*  Universidad del Valle de Guatemala
* @author Angie Nadissa Vela López, 23764
* @author Mia Alejandra Fuentes Merida, 23775
* @description interfaz donde se definieron los métodos a implementar en la clase Radio
* @date creación 09/01/2023 última modificación 16/01/2023
*/
public interface IRadio {
    void saveStation(int buttonId, double station);
    void switchOnOff();
    void switchAMFM();
    double selectStation(int button);
    boolean isOn();
    boolean isAM();
    double nextStation();
}