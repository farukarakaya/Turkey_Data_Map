import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
/**
 * Created by OFK on 10.8.2017.
 */
@ManagedBean
public class MapView {
    Navigator navigator = new Navigator();

    public boolean getIlRenderOption(){
        return navigator.getDblClickedCity() == null;
    }
    public boolean getIlceRenderOption(){
        return !getIlRenderOption();
    }

}
