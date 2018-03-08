/**
 * Created by OFK on 18.7.2017.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TabViewManagedBean {
    private int index = 0;
    private String messageNum1 = "Tab#1 Content Is Loaded";
    private String messageNum2 = "Tab#2 Content Is Loaded";

    public String getMessageNum1() {
        System.out.println(messageNum1);
        return messageNum1;
    }

    public void setMessageNum1(String messageNum1) {
        this.messageNum1 = messageNum1;
    }

    public String getMessageNum2() {
        System.out.println(messageNum2);
        return messageNum2;
    }

    public void setMessageNum2(String messageNum2) {
        this.messageNum2 = messageNum2;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}