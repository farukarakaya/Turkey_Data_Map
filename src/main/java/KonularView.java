import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by OFK on 26.7.2017.
 */

@ViewScoped
@ManagedBean
public class KonularView implements  Serializable{

    private List<Konu> konular;
    private Konu selectedIlce;
    private int sonKonum = 1; // 0 null 1 İl 2 ilçe
    private Navigator navigator = new Navigator();
    @ManagedProperty("#{konular}")
    private KonuBean service;
    private String prevCity = "";
    private String cityTemp;
    @PostConstruct
    public void init() {
        konular = service.createKonu(10,null);

    }

    public List<Konu> getKonular() {
        cityTemp = navigator.remoteAction();
        if(cityTemp != null && !cityTemp.equals(prevCity)) {
            prevCity = cityTemp;
            konular = service.createKonu(30, prevCity);
            sonKonum = 1;
        }
        return konular;

    }

    public void setService(KonuBean service) {
        this.service = service;
    }

    public Konu getSelectedIlce() {
        return selectedIlce;
    }


    public String getKonularLokasyon(){
        if(sonKonum == 0) return "Türkiye";
        else if(sonKonum ==1) return navigator.getCurrentCity();
        else return getSelectedIlce().getName();
    }
}