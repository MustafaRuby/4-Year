public class Haradrim extends Mage {
    public Haradrim (String name){
        super(name);
        setFaction(Faction.EVIL);
    }

    public int measureStrength() {
        return 40 + 5*getExperience();
    }

    @Override
    public String toString() {
        return "Haradrim{" + super.toString() + "}";
    }
}
