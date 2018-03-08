/**
 * Created by OFK on 26.7.2017.
 */
public class Konu {
    private String name;
    private int value;
    public Konu(){}
    public Konu(String name){
        this.name = name;
    }
    public Konu(String name, int value){
        this.name = name;
        this.value = value;
    }
    public String getName(){
        return name;
    }
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