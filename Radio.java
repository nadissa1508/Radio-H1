public class Radio {

    private boolean frequency;
    private boolean status;
    private double actualStation;
    private double[] stations; 

    public Radio(){
        //AM -> true FM -> false
        frequency = true;
        status = true;
        actualStation = 530.0;
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

    double nextStation(){
        double station = 0.0, add = 0.0, range = 0.0;

        if(isAM()){
            add = 10;
            range = 1610;
        }else{
            add = 0.2;
            range= 107.9;
        }

        station += add;

        if((station > range) && (add == 10)){
            station = 530;
        }else if((station > range) && (add == 107.9)){
            station = 87.9;
        }

        return station;
    }    

    
}
