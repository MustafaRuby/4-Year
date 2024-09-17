import java.util.Random;

public class General extends Mage {
    private int heroVitality;
    Random rand = new Random();
    public General(String name, Faction faction){
        super(name);
        setHeroVitality(rand.nextInt(10)+1);
        setFaction(faction);
        setStrength(measureStrength());
    }

    public int getHeroVitality() {
        return heroVitality;
    }

    public void setHeroVitality(int heroVitality) {
        this.heroVitality = heroVitality;
    }

    public int measureStrength() {
        return (50 * this.heroVitality + 50 * getExperience());
    }

    @Override
    public String toString() {
        return "General{" + super.toString() +
                "; hero vitality = " + this.heroVitality
                 + "}";
    }
}
