package Models.Cards.CardClasses;

//import Models.Cards;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.util.ArrayList;
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = AghaHaghi.class, name = "aghahaghi"),
//        @JsonSubTypes.Type(value = Ali.class, name = "ali"),
//        @JsonSubTypes.Type(value = Benyamin.class, name = "benyamin"),
//        @JsonSubTypes.Type(value = Cat.class, name = "cat"),
//        @JsonSubTypes.Type(value = Faeze.class, name = "faeze"),
//        @JsonSubTypes.Type(value = HighMasterSaman.class, name = "highmastersaman"),
//        @JsonSubTypes.Type(value = HosseinHima.class, name = "hosseinhima"),
//        @JsonSubTypes.Type(value = Hossein.class, name = "hossein"),
//        @JsonSubTypes.Type(value = Javad.class, name = "javad"),
//        @JsonSubTypes.Type(value = Khashayar.class, name = "khashayar"),
//        @JsonSubTypes.Type(value = Lachin.class, name = "lachin"),
//        @JsonSubTypes.Type(value = Matin.class, name = "matin"),
//        @JsonSubTypes.Type(value = Mobin.class, name = "mobin"),
//        @JsonSubTypes.Type(value = Nima.class, name = "nima"),
//        @JsonSubTypes.Type(value = Shahryar.class, name = "shahryar"),
//        @JsonSubTypes.Type(value = Yasaman.class, name = "yasaman"),
//})
public class Minion extends Cards {

    public static final int NUMBER_OF_MINIONS = 16;
    private static ArrayList<Minion> minions = new ArrayList<Minion>();


    private int firstAttackPower;
    private int firstHealthPower;
    private int attackPower;
    private int healthPower;
    private boolean active = true;
    private boolean canBeAttacked = true; // if we have taunt and it is not taunt then this field would be false:))
    private boolean taunt = false;
    private boolean hasAttackInThisTurn = false;
    private boolean divineShield=false;
    private boolean rush=false;


    public boolean isTaunt() {
        return taunt;
    }

    public boolean isRush() {
        return rush;
    }

    public void setRush(boolean rush) {
        this.rush = rush;
    }

    public static void initFirstAttackAndHp(){
        for (Minion minion:getMinions()){
            minion.firstAttackPower=minion.attackPower;
            minion.firstHealthPower =minion.healthPower;
        }
    }

    public int getFirstAttackPower() {
        return firstAttackPower;
    }

    public void setFirstAttackPower(int firstAttackPower) {
        this.firstAttackPower = firstAttackPower;
    }

    public int getFirstHealthPower() {
        return firstHealthPower;
    }

    public void setFirstHealthPower(int firstHealthPower) {
        this.firstHealthPower = firstHealthPower;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isCanBeAttacked() {
        return canBeAttacked;
    }



    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    public boolean isHasAttackInThisTurn() {
        return hasAttackInThisTurn;
    }

    public boolean isDivineShield() {
        return divineShield;
    }

    public void setDivineShield(boolean divineShield) {
        this.divineShield = divineShield;
    }

    public Minion() {
        super();
    }


    @Override
    public Minion  copy() {
        System.out.println("Copy of Minion:))");
        Minion copy = new Minion();
        copy.setName(this.getName());
        copy.setManaCost(this.getManaCost());
        copy.setRarity(this.getRarity());
        copy.setDescription(this.getDescription());
        copy.setClassOfCard(this.getClassOfCard());
        copy.setType(this.getType());
        copy.setRarity(this.getRarity());
        copy.setIsPlayed(this.isPlayed());
        copy.setFirstAttackPower(this.firstAttackPower);
        copy.setFirstHealthPower(this.healthPower);
        copy.attackPower = this.attackPower;
        copy.healthPower = this.healthPower;
        copy.active = this.active;
        copy.canBeAttacked = this.canBeAttacked;
        copy.taunt = this.taunt;
        copy.hasAttackInThisTurn = this.hasAttackInThisTurn;
        return copy;
    }

//
//    @Override
//    public  <T extends Cards> T  copy(T t) {
//        Class cls = t.getClass();
//        T t1 = null;
//        try {
//            Constructor cons = cls.getConstructor();
//            t1 = (T) cons.newInstance();
//            Field[] fields = cls.getDeclaredFields();
//            for (Field field : fields) {
//                field.setAccessible(true);
//                field.set(t1, field.get(t));
//            }
//        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return t1;
//    }

//    public <T> T copy(T t) {
//        Class cls = t.getClass();
//        T t1 = null;
//        try {
//            Constructor cons = cls.getConstructor();
//            t1 = (T) cons.newInstance();
//            Field[] fields = cls.getDeclaredFields();
//            for (Field field : fields) {
//                field.setAccessible(true);
//                field.set(t1, field.get(t));
//            }
//        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return t1;
//    }


    //Getter and Setter
    //*****************
    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealthPower() {
        return healthPower;
    }

    public void setHealthPower(int healthPower) {
        this.healthPower = healthPower;
    }

    public static ArrayList<Minion> getMinions() {
        return minions;
    }

    public boolean getIsActive() {
        return active;
    }

    public void setIsActive(boolean active) {
        this.active = active;
    }

    public boolean getCanBeAttacked() {
        return canBeAttacked;
    }

    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }

    public boolean getIsTaunt() {
        return taunt;
    }

    public void setIsTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    public boolean getHasAttackInThisTurn() {
        return hasAttackInThisTurn;
    }

    public void setHasAttackInThisTurn(boolean hasAttackInThisTurn) {
        this.hasAttackInThisTurn = hasAttackInThisTurn;
    }

    @Override
    public String toString() {
        return "[" + "Name: " + this.getName() + " ,  classOfCard: " + this.getClassOfCard() + " , Money" + this.getMoneyCost() + " ]";
    }

    //    @Override
//    public int getHp() {
//        return healthPower;
//    }
//
//    @Override
//    public int getAttack() {
//        return attackPower;
//    }
//
//    @Override
//    public void setHp(int hp) {
//        this.healthPower = hp;
//    }
//
//    @Override
//    public void setAttack(int attack) {
//        this.attackPower = attack;
//    }

}
