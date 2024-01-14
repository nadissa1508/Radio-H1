public class Radio {

    private boolean frequency;
    private boolean status;
    private double[] stations; 

    public Radio(){
        frequency = true;
        status = true;
        stations = new double[12];
    }

    boolean isOn(){
        return status;
    }

    
}
