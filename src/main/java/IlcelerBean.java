import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name ="ilceler")
@ApplicationScoped
public class IlcelerBean {

    Navigator navigator = new Navigator();

    public List<Ilce> createIlce(int size, String il) {
        List<Ilce> list = new ArrayList<Ilce>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Ilce(il + "  ilçe"+i, (int)(Math.random()*13)));
        }
        return list;


    }

}