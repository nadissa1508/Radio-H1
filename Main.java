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

                }else if(option == 2){

                }else if(option == 3){

                }else if(option == 4){

                }else if(option == 5){

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
