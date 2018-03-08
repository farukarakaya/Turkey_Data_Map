/**
 * Created by OFK on 11.7.2017.
 */
import javax.faces.bean.*;

import java.util.Random;
import javax.faces.context.*;
import com.google.gson.*;


import java.util.ArrayList;


@ManagedBean
public class Navigator {
    private String currentLoc;
    private String dblClicked;
    private String[] results = {"page1", "page2", "page3"};
    private Random randomizer = new Random();
    public String randomChooser() {
        return results[randomizer.nextInt(4)];
    }

    public JsonElement getArr() {
        Gson gson = new Gson();
        JsonObject obj = new JsonObject();
        Obj myobj = new Obj();
        return gson.toJsonTree(myobj);
    }

    public String remoteAction() {
        currentLoc = FacesContext.getCurrentInstance().getExternalContext()
                    .getRequestParameterMap().get("clickedID");

        return currentLoc;
    }
    public String remoteDblAction(){

        dblClicked = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("dblClicked");
        //  System.out.print(value);
        return dblClicked;
    }
    public String remoteIlce(){
        String value;
        value = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("clickedIlce");
        return value;
    }
    public String getCurrentCity(){
        //System.out.println(currentLoac);
        if(currentLoc != null) return currentLoc;
        return "Türkiye";
    }
    public String getDblClickedCity(){
        return dblClicked;
    }
    public int getRandom(){
        return (int)(Math.random()*247);
    }
        class Obj {
            ArrayList<il> iller;

            public Obj() {
                iller = new ArrayList();
                iller.add(new il(13, 13));
                iller.add(new il(36, 36));
                iller.add(new il(67, 67));
                iller.add(new il(33, 33));
                iller.add(new il(38, 36));
                iller.add(new il(43, 43));
            }

            class il {
                properties properties;
                int value;
                String h1text = "konu1";
                String h2text = "konu2";
                String h3text = "konu3";
                String h4text = "konu4";
                int h1value = 0;
                int h2value = 0;
                int h3value = 0;
                int h4value = 0;
                public il(int id, int value) {
                    properties = new properties(id);
                    this.value = value;
                }
            }
            class properties{
                int id;
                public properties(int id){this.id = id;}
            }
        }
    }