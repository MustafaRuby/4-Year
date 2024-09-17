public class Urukhai extends Mage {
    public Urukhai(String name){
        super(name);
        setFaction(Faction.EVIL);
    }


    public int measureStrength() {
        return 50 + 5*getExperience();
    }

    @Override
    public String toString() {
        return "Urukhai{" + super.toString() + "}";
    }

}
