import java.lang.Math;
import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Backend{
    private double xl, fxl, xc, fxc, ra, rdc;
    private double lbead, cpar;
    private double cdecoup, cdamp;
    private double rdamp_min, rdamp_max;
    ActionListener al;

    public void addActionListener(ActionListener pl) {
        al = AWTEventMulticaster.add(al, pl);

    }


    public void removeActionListener(ActionListener pl) {
        al=AWTEventMulticaster.remove(al, pl);

    }
    public void calculate_lbead(){
        if(xl > 0 && fxl > 0) {
            lbead = xl / (2 * fxl * Math.PI);

        }
        else {
            lbead = 0;
        }
        if(al!=null) al.actionPerformed(new ActionEvent(
                this,
                ActionEvent.ACTION_PERFORMED,
                ""));
    }
    public void calculate_cpar(){
        if(xc != 0 && fxc > 0){
            if(xc < 0 ){ xc -= xc; }
            cpar = 1/(2*Math.PI * fxc * xc);

        }
        else {
            cpar = 0;
        }
        if(al!=null) al.actionPerformed(new ActionEvent(
                this,
                ActionEvent.ACTION_PERFORMED,
                ""));
    }

    public void calculate_rdamp(){

        if(lbead > 0 && cdamp > 0){
            rdamp_min = 2 * Math.sqrt(lbead/cdamp);

        }
        else{
            rdamp_min = 0;
        }
        if(lbead  > 0 && cdecoup > 0){
            rdamp_max = 0.5 * Math.sqrt(lbead/cdecoup);

        }
        else {
            rdamp_max = 0;
        }

        if(al!=null) al.actionPerformed(new ActionEvent(
                    this,
                    ActionEvent.ACTION_PERFORMED,
                    ""));

    }

    public void calculate(){
        calculate_lbead();
        calculate_cpar();
        calculate_rdamp();
    }

    public void setXl(double xl) {
        this.xl = xl;
    }

    public void setFxl(double fxl) {
        this.fxl = fxl;
    }

    public void setXc(double xc) {
        this.xc = xc;
    }

    public void setFxc(double fxc) {
        this.fxc = fxc;
    }

    public void setRa(double ra) {
        this.ra = ra;
    }

    public void setRdc(double rdc) {
        this.rdc = rdc;
    }

    public double getLbead() {
        return lbead;
    }

    public double getCpar() {
        return cpar;
    }

    public void setCdecoup(double cdecoup) {
        this.cdecoup = cdecoup;
    }

    public void setCdamp(double cdamp) {
        this.cdamp = cdamp;
    }

    public double getRdamp_min() {
        return rdamp_min;
    }

    public double getRdamp_max() {
        return rdamp_max;
    }


}
