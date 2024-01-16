/**
*  Universidad del Valle de Guatemala
* @author Angie Nadissa Vela López, 23764
* @author Mia Alejandra Fuentes Merida, 23775
* @description Clase para realizar las pruebas unitarias del sistema
* @date creación 09/01/2023 última modificación 16/01/2023
*/
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RadioTest {

    private Radio radio;


    // método que se ejecuta antes de cada prueba
    @Before
    public void setUp() {
        radio = new Radio();
    }

    // Prueba para verificar que devuelve -1 cuando el número de botón es inválido
    @Test
    public void testSelectStationWithInvalidButton() {
        double selectedStation = radio.selectStation(0); //seleccionar una estación con un botón inválido
        //falla porque como no existe boton 0 se devuelve -1 en lugar de una emisora
        assertEquals(530, selectedStation, 0.01);
    }

     // guardar estacion en el que se encuentra el radio
    @Test
    public void testSelectStation() {
        radio.switchOnOff(); // Enciende el radio
        radio.switchAMFM();  // Cambia a FM
        radio.saveStation(1, 88.1); // Guarda una estación en el botón 
        double result = radio.selectStation(1);
        assertEquals(88.1, result, 0.01); 
    }

    // Prueba para guardar una estación cuando el botón es inválido
    @Test
    public void testSaveStation_invalidButtonId() {
        int invalidButtonId = 15;
        double station = 101.5;
        radio.saveStation(invalidButtonId, station);// Verifica que el mensaje de error sea el esperado
    }

    // Prueba para el método switchOnOff cuando el radio está apagado
    @Test
    public void testSwitchOnOffRadioApagado() {
        Radio radio = new Radio();
        assertFalse(radio.isOn()); // Aseguramos que el radio está apagado 
        radio.switchOnOff(); //encender
        assertTrue(radio.isOn()); // Verificamos que el radio esté encendido
    }

    // Prueba para el método switchOnOff cuando el radio está encendido
    @Test
    public void testSwitchOnOffRadioEncendido() {
        Radio radio = new Radio();
        radio.switchOnOff(); //ACtualmente el radio esta encendido
        assertTrue(radio.isOn()); // Apagar 
        radio.switchOnOff();
        assertFalse(radio.isOn()); // Verificamos que el radio esté apagado después de llamar al método
    }

    // Prueba para verficar el avance del dial en las emisoras
    @Test
    public void testNextStationWorksCorrectly() {
        // Enciende el radio, guarda y selecciona una emisora, luego prueba
        //que nextStation regrese a la emisora inicial 530 (estamos en frecuencia AM)
        radio.switchOnOff(); 
        radio.saveStation(1, 1610);
        radio.selectStation(1);
        double inicialStation = radio.nextStation();
        Assertions.assertEquals(530, inicialStation);
    }

}
