import java.util.Date;

/**
 * Created by OFK on 26.7.2017.
 */
public class Evrak {
    private String name;
    private Date date;
    private String özet;

    public Evrak(){}
    public Evrak(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    private void setName(String name){
        this.name = name;
    }
}
