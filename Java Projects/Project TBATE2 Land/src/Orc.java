public class Orc extends Mage{
    public Orc(String name){
        super(name);
        setFaction(Faction.EVIL);
    }


    public int measureStrength() {
        if(getExperience() < 5){
            return 30 + 2*getExperience();
        }
        else{
            return 70 + 2*getExperience();
        }
    }

    @Override
    public String toString() {
        return "Orc{" + super.toString() + "}";
    }
}
