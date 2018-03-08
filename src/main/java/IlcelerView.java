/**
 * Created by OFK on 20.7.2017.
 */

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;



@ManagedBean(name="ilcelerView")
@ViewScoped
public class IlcelerView implements Serializable {

    private List<Ilce> ilceler;
    private Ilce selectedIlce;
    private int sonKonum = 1; // 0 null 1 İl 2 ilçe
    private Navigator navigator = new Navigator();
    @ManagedProperty("#{ilceler}")
    private IlcelerBean service;
    private String prevCity = "";
    private String cityTemp;
    @PostConstruct
    public void init() {
        ilceler = service.createIlce(10,null);

    }

      public List<Ilce> getIlceler() {
        cityTemp = navigator.remoteAction();
        if(cityTemp != null && !cityTemp.equals(prevCity)) {
            prevCity = cityTemp;
            ilceler = service.createIlce(30, prevCity);
            sonKonum = 1;
        }
        return ilceler;

    }

    public void setService(IlcelerBean service) {
        this.service = service;
    }

    public Ilce getSelectedIlce() {
        return selectedIlce;
    }

    public void setSelectedIlce(Ilce selectedIlce) {
        this.selectedIlce = selectedIlce;
    }

    public String getKonularLokasyon(){
        if(sonKonum == 0) return "Türkiye";
        else if(sonKonum ==1) return navigator.getCurrentCity();
        else return getSelectedIlce().getName();
    }
}
