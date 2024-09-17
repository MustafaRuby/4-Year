import java.util.Random;

abstract public class Mage {

    private String name;
    private int strength;
    private int experience;
    private Faction faction;

    public Mage(String name) {
        Random rand = new Random();
        this.name = name;
        this.experience = rand.nextInt(10)+1;
        this.strength = measureStrength();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }
    public abstract int measureStrength();

    @Override
    public String toString() {
        return "name = '" + this.name + "'" +
                "; experience = " + this.experience +
                "; strength = " + this.strength +
                "; faction = " + this.faction;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
