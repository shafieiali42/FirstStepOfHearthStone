package Models.Cards.GameCards.WeaponCards;

import Models.Cards.CardClasses.Weapon;

public class Gearblade extends Weapon {

    @Override
    public Gearblade copy() {
        System.out.println("Copy of Gearblade:))");
        Gearblade copy = new Gearblade();
        copy.setName(this.getName());
        copy.setManaCost(this.getManaCost());
        copy.setRarity(this.getRarity());
        copy.setDescription(this.getDescription());
        copy.setClassOfCard(this.getClassOfCard());
        copy.setType(this.getType());
        copy.setRarity(this.getRarity());
        copy.setIsPlayed(this.isPlayed());
        copy.setAttackPower(this.getAttackPower());
        copy.setDurability(this.getDurability());
        return copy;
    }


}
