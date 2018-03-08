import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OFK on 26.7.2017.
 */
@ManagedBean(name ="evraklar")
@ApplicationScoped
public class EvraklarBean {

    Navigator navigator = new Navigator();

    public List<Evrak> createEvrak(int size) {
        List<Evrak> list = new ArrayList<Evrak>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Evrak("Evrak" +i));
        }
        return list;

    }

}