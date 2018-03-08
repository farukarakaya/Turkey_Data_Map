import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by OFK on 26.7.2017.
 */

@ManagedBean
@ViewScoped
public class EvraklarView implements  Serializable{

    private List<Evrak> evraklar;

    @ManagedProperty("#{evraklar}")
    private EvraklarBean service;

    @PostConstruct
    public void init() {
        evraklar = service.createEvrak(30);

    }

    public List<Evrak> getEvraklar() {

        return evraklar;

    }

    public void setService(EvraklarBean service) {
        this.service = service;
    }

    public List<Evrak> getSeciliIlceninEvraklari(){
        return evraklar;
    }

    public List<Evrak> getSeciliKonununEvraklari(){
        return evraklar;
    }
}

