import java.util.ArrayList;
import java.util.Random;

public class Battleground {
    Random rand = new Random();
    ArrayList<Mage> goodForces;
    ArrayList<Mage> evilForces;
    ArrayList<General> goodGenerals;
    ArrayList<General> evilGenerals;
    public Battleground(){
        goodForces = new ArrayList<>();
        evilForces = new ArrayList<>();
        goodGenerals = new ArrayList<>();
        evilGenerals = new ArrayList<>();
    }


    public boolean addMage(Mage mage){
        for(Mage m : goodForces){
            if(m.getName().equals(mage.getName())){
                return false;
            }
        }
        for(Mage m : evilForces){
            if(m.getName().equals(mage.getName())){
                return false;
            }
        }

        if(mage.getFaction() == Faction.GOOD){
            if(mage.getClass().equals(General.class))
            {
                goodGenerals.add((General) mage);
            }
            goodForces.add(mage);
        }
        else{
            if(mage.getClass().equals(General.class))
            {
                evilGenerals.add((General) mage);
            }
            evilForces.add(mage);
        }
        return true;
    }

    public Mage randomGoodMage(){
        if((goodForces.size() - goodGenerals.size()) < 3){
            return null;
        }
        Mage mage = goodForces.get(rand.nextInt(goodForces.size()));
        while (mage.getClass().equals(General.class)){
            mage = goodForces.get(rand.nextInt(goodForces.size()));
        }
        return mage;
    }

    public Mage randomEvilMage(){
        if ((evilForces.size() - evilGenerals.size())< 3){
            return null;
        }
        Mage mage = evilForces.get(rand.nextInt(evilForces.size()));
        while (mage.getClass().equals(General.class)){
            mage = evilForces.get(rand.nextInt(evilForces.size()));
        }
        return mage;
    }

    public General randomGoodGeneral(){
        if(goodGenerals.isEmpty() || (goodForces.size() - goodGenerals.size()) < 3){
            return null;
        }
        return goodGenerals.get(rand.nextInt(goodGenerals.size()));
    }

    public General randomEvilGeneral(){
        if(evilGenerals.isEmpty() || (evilForces.size() - evilGenerals.size()) < 3){
            return null;
        }
        return evilGenerals.get(rand.nextInt(evilGenerals.size()));
    }

    public Mage duel(Mage mage1, Mage mage2){

        if(mage1.getStrength() > mage2.getStrength()){
            if(mage1.getExperience() < 10){
                if(mage1.getFaction() == Faction.GOOD){
                    goodForces.get(goodForces.indexOf(mage1)).setExperience(mage1.getExperience() +1);
                    goodForces.get(goodForces.indexOf(mage1)).setStrength(goodForces.get(goodForces.indexOf(mage1)).measureStrength());
                }
                else{
                    evilForces.get(evilForces.indexOf(mage1)).setExperience(mage1.getExperience() +1);
                    evilForces.get(evilForces.indexOf(mage1)).setStrength(evilForces.get(evilForces.indexOf(mage1)).measureStrength());
                }

            }

            if(mage2.getFaction() == Faction.GOOD){
                goodForces.remove(mage2);
            }
            else{
                evilForces.remove(mage2);
            }
            
            return mage1;
        }
        else if (mage1.getStrength() < mage2.getStrength()){
            if(mage2.getExperience() < 10){
                if(mage2.getFaction() == Faction.GOOD){
                    goodForces.get(goodForces.indexOf(mage2)).setExperience(mage2.getExperience() +1);
                    goodForces.get(goodForces.indexOf(mage2)).setStrength(goodForces.get(goodForces.indexOf(mage2)).measureStrength());
                }
                else{
                    evilForces.get(evilForces.indexOf(mage2)).setExperience(mage2.getExperience() +1);
                    evilForces.get(evilForces.indexOf(mage2)).setStrength(evilForces.get(evilForces.indexOf(mage2)).measureStrength());
                }

            }

            if(mage1.getFaction() == Faction.GOOD){
                goodForces.remove(mage1);
            }
            else{
                evilForces.remove(mage1);
            }

            return mage2;
        }
        else {
            return null;
        }
    }

    public General lanceDuel(General general1, General general2){

        if(general1.getStrength() > general2.getStrength()){

            if(general1.getExperience() < 10){
                if(general1.getFaction() == Faction.GOOD){
                    goodForces.get(goodForces.indexOf(general1)).setExperience(general1.getExperience() +1);
                    goodForces.get(goodForces.indexOf(general1)).setStrength(goodForces.get(goodForces.indexOf(general1)).measureStrength());
                }
                else{
                    evilForces.get(evilForces.indexOf(general1)).setExperience(general1.getExperience() +1);
                    evilForces.get(evilForces.indexOf(general1)).setStrength(evilForces.get(evilForces.indexOf(general1)).measureStrength());
                }

            }

            if(general1.getHeroVitality() < 10){
                if(general1.getFaction() == Faction.GOOD){
                    ((General)(goodForces.get(goodForces.indexOf(general1)))).setHeroVitality(((General)(goodForces.get(goodForces.indexOf(general1)))).getHeroVitality() + 1);
                    goodForces.get(goodForces.indexOf(general1)).setStrength(goodForces.get(goodForces.indexOf(general1)).measureStrength());
                }
                else{
                    ((General)(evilForces.get(evilForces.indexOf(general1)))).setHeroVitality(((General)(evilForces.get(evilForces.indexOf(general1)))).getHeroVitality() + 1);
                    evilForces.get(evilForces.indexOf(general1)).setStrength(evilForces.get(evilForces.indexOf(general1)).measureStrength());
                }

            }

            if(general2.getHeroVitality() > 1){
                if(general2.getFaction() == Faction.GOOD){
                    ((General)(goodForces.get(goodForces.indexOf(general2)))).setHeroVitality(((General)(goodForces.get(goodForces.indexOf(general2)))).getHeroVitality() - 1);
                    goodForces.get(goodForces.indexOf(general2)).setStrength(goodForces.get(goodForces.indexOf(general2)).measureStrength());
                }
                else{
                    ((General)(evilForces.get(evilForces.indexOf(general2)))).setHeroVitality(((General)(evilForces.get(evilForces.indexOf(general2)))).getHeroVitality() - 1);
                    evilForces.get(evilForces.indexOf(general2)).setStrength(evilForces.get(evilForces.indexOf(general2)).measureStrength());
                }
            }
            else{
                if(general2.getFaction() == Faction.GOOD){
                    goodForces.remove(general2);
                    goodGenerals.remove((general2));
                }
                else{
                    evilForces.remove(general2);
                    evilGenerals.remove(general2);
                }
            }

            return general1;
        }
        if(general1.getStrength() < general2.getStrength()){
            if(general2.getExperience() < 10){
                if(general2.getFaction() == Faction.GOOD){
                    goodForces.get(goodForces.indexOf(general2)).setExperience(general2.getExperience() +1);
                    goodForces.get(goodForces.indexOf(general2)).setStrength(goodForces.get(goodForces.indexOf(general2)).measureStrength());
                }
                else{
                    evilForces.get(evilForces.indexOf(general2)).setExperience(general2.getExperience() +1);
                    evilForces.get(evilForces.indexOf(general2)).setStrength(evilForces.get(evilForces.indexOf(general2)).measureStrength());
                }

            }

            if(general2.getHeroVitality() < 10){
                if(general2.getFaction() == Faction.GOOD){
                    ((General)(goodForces.get(goodForces.indexOf(general2)))).setHeroVitality(((General)(goodForces.get(goodForces.indexOf(general2)))).getHeroVitality() + 1);
                    goodForces.get(goodForces.indexOf(general2)).setStrength(goodForces.get(goodForces.indexOf(general2)).measureStrength());
                }
                else{
                    ((General)(evilForces.get(evilForces.indexOf(general2)))).setHeroVitality(((General)(evilForces.get(evilForces.indexOf(general2)))).getHeroVitality() + 1);
                    evilForces.get(evilForces.indexOf(general2)).setStrength(evilForces.get(evilForces.indexOf(general2)).measureStrength());
                }
            }

            if(general1.getHeroVitality() > 1){
                if(general1.getFaction() == Faction.GOOD){
                    ((General)(goodForces.get(goodForces.indexOf(general1)))).setHeroVitality(((General)(goodForces.get(goodForces.indexOf(general1)))).getHeroVitality() - 1);
                    goodForces.get(goodForces.indexOf(general1)).setStrength(goodForces.get(goodForces.indexOf(general1)).measureStrength());
                }
                else{
                    ((General)(evilForces.get(evilForces.indexOf(general1)))).setHeroVitality(((General)(evilForces.get(evilForces.indexOf(general1)))).getHeroVitality() - 1);
                    evilForces.get(evilForces.indexOf(general1)).setStrength(evilForces.get(evilForces.indexOf(general1)).measureStrength());
                }
            }
            else{
                if(general1.getFaction() == Faction.GOOD){
                    goodForces.remove(general1);
                    goodGenerals.remove((general1));
                }
                else{
                    evilForces.remove(general1);
                    evilGenerals.remove(general1);
                }
            }

            return general2;


        }
        else{
            if(general1.getHeroVitality() > 1){
                if(general1.getFaction() == Faction.GOOD){
                    ((General)(goodForces.get(goodForces.indexOf(general1)))).setHeroVitality(((General)(goodForces.get(goodForces.indexOf(general1)))).getHeroVitality() - 1);
                    goodForces.get(goodForces.indexOf(general1)).setStrength(goodForces.get(goodForces.indexOf(general1)).measureStrength());
                }
                else{
                    ((General)(evilForces.get(evilForces.indexOf(general1)))).setHeroVitality(((General)(evilForces.get(evilForces.indexOf(general1)))).getHeroVitality() - 1);
                    evilForces.get(evilForces.indexOf(general1)).setStrength(evilForces.get(evilForces.indexOf(general1)).measureStrength());
                }
            }
            else{
                if(general1.getFaction() == Faction.GOOD){
                    goodForces.remove(general1);
                    goodGenerals.remove((general1));
                }
                else{
                    evilForces.remove(general1);
                    evilGenerals.remove(general1);
                }
            }

            if(general2.getHeroVitality() > 1){
                if(general2.getFaction() == Faction.GOOD){
                    ((General)(goodForces.get(goodForces.indexOf(general2)))).setHeroVitality(((General)(goodForces.get(goodForces.indexOf(general2)))).getHeroVitality() - 1);
                    goodForces.get(goodForces.indexOf(general2)).setStrength(goodForces.get(goodForces.indexOf(general2)).measureStrength());
                }
                else{
                    ((General)(evilForces.get(evilForces.indexOf(general2)))).setHeroVitality(((General)(evilForces.get(evilForces.indexOf(general2)))).getHeroVitality() - 1);
                    evilForces.get(evilForces.indexOf(general2)).setStrength(evilForces.get(evilForces.indexOf(general2)).measureStrength());
                }
            }
            else{
                if(general2.getFaction() == Faction.GOOD){
                    goodForces.remove(general2);
                    goodGenerals.remove((general2));
                }
                else{
                    evilForces.remove(general2);
                    evilGenerals.remove(general2);
                }
            }
            return null;
        }

    }

    public Mage searchMage(String name){
        for(Mage m : goodForces){
            if((m.getName()).equalsIgnoreCase(name)){
                return m;
            }
        }

        for(Mage m : evilForces){
            if(m.getName().equalsIgnoreCase(name)){
                return m;
            }
        }

        return null;

    }

    public Faction allOutBattle(){
        if((goodForces.size()-goodGenerals.size()) < 3 || (evilForces.size() - evilGenerals.size()) < 3){
            return Faction.NO_CHARACTERS;
        }
        int goodStrength = 0;
        int evilStrength = 0;

        for(Mage m : goodForces){
            goodStrength += m.getStrength();
        }

        for(Mage m : evilForces)
        {
            evilStrength += m.getStrength();
        }

        if(goodStrength > evilStrength){
            evilForces = null;
            return Faction.GOOD;
        }
        else {
            goodForces = null;
            return Faction.EVIL;
        }
    }

    public void magesList(){

        if(goodForces.isEmpty() && evilForces.isEmpty()){
            System.out.println("No characters have been added yet");
            return;
        }

        System.out.println("Good Faction:\n");

        if(goodForces.isEmpty()){
            System.out.println("No good forces yet");
        }

        for(Mage m : goodForces){
            System.out.println(m);
        }

        System.out.println("------------------------------------------------------------------");

        System.out.println("Evil Faction\n");

        if(evilForces.isEmpty()){
            System.out.println("No evil forces yet");
        }

        for(Mage m : evilForces){
            System.out.println(m);
        }

    }

    public ArrayList<Mage> goodMagesList(){
        return new ArrayList<>(goodForces);
    }

    public ArrayList<Mage> evilMagesList(){
        return new ArrayList<>(evilForces);
    }

    public boolean eliminateCharacter(String name){
        if(searchMage(name) == null){
            return false;
        }
        else if(searchMage(name).getFaction() == Faction.GOOD){
            goodForces.remove(searchMage(name));
            if(searchMage(name).getClass().equals(General.class)){
                goodGenerals.remove(searchMage(name));
            }
            return true;
        }
        else {
            evilForces.remove(searchMage(name));
            if(searchMage(name).getClass().equals(General.class)){
                evilGenerals.remove(searchMage(name));
            }
            return true;
        }
    }
    
}
