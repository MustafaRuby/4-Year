public class Hobbit extends Mage{
    public Hobbit(String name){
        super(name);
        setFaction(Faction.GOOD);
    }

    public int measureStrength(){
        return 10 + 3 * getExperience();
    }

    @Override
    public String toString() {
        return "Hobbit{" + super.toString() + "}";
    }
}
