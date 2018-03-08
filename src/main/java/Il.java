/**
 * Created by OFK on 26.7.2017.
 */
public class Il {

    private String name;
    private int value;
    public Il(){}
    public Il(String name){
        this.name = name;
    }
    public Il(String name, int value){
        this.value = value;
        this.name = name;
    }
    public String getName(){return name;}
    public void setName(String name){
        this.name = name;
    }
    public int getValue(){
        return value;
    }
    private  void setValue(int value){
        this.value = value;
    }
}
