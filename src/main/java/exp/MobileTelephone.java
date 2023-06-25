package exp;

public class MobileTelephone {
    private SIM sim;

    public MobileTelephone(SIM sim){
        setSIM(sim);
    }

    public void setSIM(SIM sim) {
        this.sim = sim;
    }

    public String getNumber(){
        return sim.getNumber();
    }
}
