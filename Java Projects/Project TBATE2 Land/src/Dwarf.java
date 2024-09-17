public class Dwarf extends Mage{
    public Dwarf(String name) {
        super(name);
        setFaction(Faction.GOOD);
    }

    public int measureStrength(){
        return 20+4*getExperience();
    }

    @Override
    public String toString() {
        return "Dwarf{" + super.toString() + "}";
    }
}
