/**
 * Created by OFK on 24.7.2017.
 */

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name ="konular")
@ApplicationScoped
public class KonuBean {


    public List<Konu> createKonu(int size,String il) {
        List<Konu> list = new ArrayList<Konu>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Konu(il + "  konu"+i, (int)(Math.random()*13)));
        }
        return list;


    }

}