public class Radio {

    private boolean frequency;
    private boolean status;
    private double actualStation;
    private double[] stations; 
    private boolean isAm;
    private double currentStation;
    private double[] amStations = new double[12];
    private double[] fmStations = new double[12];

    public Radio(){
        //AM -> true FM -> false
        frequency = true;
        status = true;
        actualStation = 530.0;
        stations = new double[12];
        this.stationsAM = new double[12];
        this.stationsFM = new double[12];
        this.isAm = true;
        this.currentStation = 530;
    }

    public void saveStation(int buttonId, double station) {
        if (!isOn) {
            System.out.println("El radio está apagado");
            return;
        }
        if (buttonId < 1 || buttonId > 12) {
            System.out.println("ID de botón inválido");
            return;
        }
        if (isAm) {
            amStations[buttonId - 1] = station;
        } else {
            fmStations[buttonId - 1] = station;
        }
    }

    public boolean isAm() {
        return isAm;
    }

    boolean isOn(){
        return status;
    }

    public double selectStation(int buttonId) {
        if (!isOn) {
            System.out.println("El radio está apagado");
            return -1;
        }
        if (buttonId < 1 || buttonId > 12) {
            System.out.println("ID de botón inválido");
            return -1;
        }
        currentStation = isAm ? amStations[buttonId - 1] : fmStations[buttonId - 1];
        return currentStation;
    }

    public void switchOnOff() {
        isOn = !isOn;
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
