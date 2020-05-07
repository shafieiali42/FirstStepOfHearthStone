package Models.Cards;

import java.util.ArrayList;

public class Passive {

    private String name;
    private String description;
    public static final int NUMBER_OF_PASSIVES=7;
    static ArrayList<Passive> passives=new ArrayList<Passive>();



    public static ArrayList<Passive> getPassives() {
        return passives;
    }
    public static void setPassives(ArrayList<Passive> passives) {
        Passive.passives = passives;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "["+"Name: "+this.getName()+" Description: "+this.description+" ]";
    }

}
