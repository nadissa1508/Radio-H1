public class Radio {

    private boolean frequency;
    private boolean status;
    private double[] stations; 

    public Radio(){
        //AM -> true FM -> false
        frequency = true;
        status = true;
        stations = new double[12];
    }

    boolean isOn(){
        return status;
    }

    void switchAMFM(){
        frequency = !frequency;
        if(frequency){
            System.out.println("Frecuencia cambiada a AM");
        }else{
            System.out.println("Frecuencia cambiada a FM");
        }
    }

    

    
}
