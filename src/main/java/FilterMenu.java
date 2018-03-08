/**
 * Created by OFK on 26.7.2017.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.Date;


@ManagedBean
public class FilterMenu {
    private String selecetedIl;
    private String selecetedIlce;
    private String selecetedKOnu;
    private List<Il> iller = new ArrayList<Il>();
    private List<Ilce> ilceler = new ArrayList<Ilce>();
    private List<Konu> konular = new ArrayList<Konu>();
    private Date date1;
    private Date date2;
    public FilterMenu(){
        iller.add(new Il("sada343"));
        iller.add(new Il("sada4r"));
        iller.add(new Il("sada212"));
        iller.add(new Il("sada76"));
    }

    public List<Il> getIller(){
        return iller;
    }

    public List<Ilce> getIlceler(){
        return ilceler;
    }
    public List<Konu> getKonular(){
        return konular;
    }
    public String getIlFiltresi() {
        return selecetedIl;
    }

    public void setIlFiltresi(String console) {
        selecetedIl = console;
    }
    public String getIlceFiltresi() {
        return selecetedIlce;
    }

    public void setIlceFiltresi(String console) {
        selecetedIlce = console;
    }
    public String getKonuFiltresi() {
        return selecetedKOnu;
    }

    public void setKonuFiltresi(String console) {
        selecetedKOnu = console;
    }
    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }
    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date1) {
        this.date2 = date2;
    }

}
