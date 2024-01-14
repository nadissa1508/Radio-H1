/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @author Mia Alejandra Fuentes Merida, 00000
 * @description clase que funciona como interfaz para que el usuario pueda utilizar el sistema,
 * aquí se encuentra el menú principal con las funcionalidades del radio
 * @date creación 09/01/2023 última modificación 16/01/2023
 */

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void menu(){
        Radio radio = new Radio();
        Scanner teclado = new Scanner(System.in);
        int option = 0;
        String opUser = "";

        while (option != 6){
            System.out.println("\n***************************");
            System.out.println("\nBIENVENIDO!");
            System.out.println("\n***************************");
            System.out.println("\n\n1.Prender el radio \n2.Cambiar de AM a FM \n3.Cambiar emisora \n4.Guardar Emisora \n5.Seleccionar emisora \n6.Apagar el radio ");
            System.out.println("\nSeleccione su opción: ");
            opUser = teclado.nextLine();

            try{
                option = Integer.parseInt(opUser);      
            }catch(Exception e){
                System.out.println("\nError, ingrese un número");
            }

            if(option >0 && option < 7){
                if(option == 1){
                    //analizar como cambiar el estado sin utilizar parámetros
                    radio.switchOnOff();                 

                }else if(option == 2){
                    if(!radio.isOn()){  
                        System.out.println("\nError, ingrese debe encender el radio");
                    }else{
                        radio.switchAMFM();
                    }

                }else if(option == 3){
                    if(!radio.isOn()){
                        System.out.println("\nError, ingrese debe encender el radio");
                    }else{
                        double station = radio.nextStation();
                        System.out.println("\nEsta escuchando la emisora " + station +" !");
                    }

                }else if(option == 4){
                    if(!radio.isOn()){
                        System.out.println("\nError, ingrese debe encender el radio");
                    }else{
                        String id = "", estacion = "";
                        int buttonId = 0;
                        double station = 0.0;
                        
                        System.out.println("\nIngrese número de botón para la estación: ");
                        id = teclado.nextLine();

                        try{
                            buttonId = Integer.parseInt(id);
                        }catch(Exception e){
                            System.out.println("\nError, ingrese un número");
                            return;
                        }

                        System.out.println("\nIngrese la estación que desea guardar: ");
                        estacion = teclado.nextLine();

                        try{
                            station = Double.parseDouble(estacion);
                        }catch(Exception e){
                            System.out.println("\nError, ingrese un número decimal");
                            return;
                        }

                        radio.saveStation(buttonId, station);
                    }

                }else if(option == 5){
                    if(!radio.isOn()){
                        System.out.println("\nError, ingrese debe encender el radio");
                    }else{
                        String id = "";
                        int buttonId = 0;

                        System.out.println("\nIngrese el número de botón de la estación: ");
                        id = teclado.nextLine();

                        try{
                            buttonId = Integer.parseInt(id);
                        }catch(Exception e){
                            System.out.println("\nError, ingrese un número");
                            return;
                        }

                        double station = radio.selectStation(buttonId);
                        System.out.println("\nReproduciendo la emisora " + station +" !");
                    }

                }else if(option == 6){
                    if(!radio.isOn()){
                        System.out.println("\nError, el radio ya está apagado");
                    }else{
                        radio.switchOnOff();
                    }
                }
            }else{
                System.out.println("\nError, opción incorrecta");
            }

        }

    }

    public static void main(String[] args) {
        menu();
    } 

}
