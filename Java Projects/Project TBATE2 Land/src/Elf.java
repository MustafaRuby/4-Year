public class Elf extends Mage{
    public Elf(String name){
        super(name);
        setFaction(Faction.GOOD);
    }

    public int measureStrength(){
        if(getExperience() < 5){
            return 20 + 3*getExperience();
        }
        else{
            return 80 + 2*getExperience();
        }
    }

    @Override
    public String toString() {
        return "Elf{" + super.toString() + "}";
    }
}
