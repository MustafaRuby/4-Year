public class Human extends Mage{
    public Human(String name) {
        super(name);
        setFaction(Faction.GOOD);
    }
    public int measureStrength() {
        return 30 + 6 * getExperience();
    }



    @Override
    public String toString() {
        return "Human{" + super.toString() + "}";
    }
}
