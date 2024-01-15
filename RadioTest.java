import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RadioTest {

    private Radio radio;

    // Este método se ejecuta antes de cada prueba
    @Before
    public void setUp() {
        radio = new Radio();
    }

    // Prueba para verificar que devuelve -1 cuando el radio está apagado
    @Test
    public void testSelectStationWhenRadioOff() {
        radio.switchOnOff(); // Apaga el radio
        double selectedStation = radio.selectStation(1); // Intenta seleccionar una estación
        assertEquals(-1, selectedStation, 0.01); // Verifica que devuelva -1 cuando el radio está apagado
    }

    // Prueba para verificar que devuelve -1 cuando el número de botón es inválido
    @Test
    public void testSelectStationWithInvalidButton() {
        double selectedStation = radio.selectStation(0); // Intenta seleccionar una estación con un botón inválido
        assertEquals(-1, selectedStation, 0.01); // Verifica que devuelva -1 cuando el número de botón es inválido
    }
}
