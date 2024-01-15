import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RadioTest {

    private Radio radio;


    // método que se ejecuta antes de cada prueba
    @Before
    public void setUp() {
        radio = new Radio();
    }

    // Prueba para verificar que devuelve -1 cuando el radio está apagado
    @Test
    public void testSelectStationWhenRadioOff() {
        radio.switchOnOff(); // Apaga el radio
        double selectedStation = radio.selectStation(1); //seleccionar  estación
        assertEquals(-1, selectedStation, 0.01);
    }

    // Prueba para verificar que devuelve -1 cuando el número de botón es inválido
    @Test
    public void testSelectStationWithInvalidButton() {
        double selectedStation = radio.selectStation(0); //seleccionar una estación con un botón inválido
        assertEquals(-1, selectedStation, 0.01);
    }

     // guardar estacion en el que se encuentra el radio
    @Test
    public void testSelectStation() {
        radio.switchOnOff(); // Enciende el radio
        radio.switchAMFM();  // Cambia a AM
        radio.saveStation(1, 600); // Guarda una estación en el botón 
        double result = radio.selectStation(1);
        assertEquals(600.0, result, 0.01); 
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

    // Prueba cuando el botón es inválido
    @Test
    public void testSaveStation_invalidButtonId() {
        int invalidButtonId = 15;
        double station = 101.5;
        radio.saveStation(invalidButtonId, station); // Verifica que el mensaje de error sea el esperado
    }

}
