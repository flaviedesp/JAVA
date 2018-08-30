

public class PriseServeur {

    private String machine;
    private int port;
    private String formatDate;

    public PriseServeur(String nomMachine, int numeroPort) {
        this.machine = nomMachine;
        this.port =  numeroPort;               

    }
    public void setFormatDate(String formatDate){
        this.formatDate = formatDate;
    }
    public String getFormatDate(){
        return formatDate;
    }
    public String getNomMachine(){
        return machine;
    }
    public int getNumeroPort(){
        return port;
    }
}
