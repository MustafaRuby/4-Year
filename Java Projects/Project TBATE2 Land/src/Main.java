
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Human human;
        Elf elf;
        Dwarf dwarf;
        Hobbit hobbit;

        Orc orc;
        Urukhai urukhai;
        Haradrim haradrim;

        Mage mage1;
        Mage mage2;
        Mage winner;

        General general1 = null;
        General general2;

        Battleground battleground = null;

        Scanner scan = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);

        String name;

        int choice;
        int choice2;

        Faction faction;

        boolean status;

        ArrayList<Mage> list;
        System.out.println("""
                ____________________________________________________________________________
                Welcome to TBATE2 land, here are the rules you need to know:
                -Everytime the land expires, meaning one faction looses, you need to start a new land;
                -Before any battle or duel, you need to create at least 3 characters of each faction excluding generals;
                -There are two factions: good & evil;
                -The good faction: Humans; Elves; Dwarves; Hobbits; the average strongest race are the elves;
                -The evil faction: Orcs; Urukhai; Haradrims; the average strongest race are the Urukhai;
                -Every faction gets it's own generals, all generals can become equal in strength and have no specific race;
                -Duels can only be performed between two normal mages or two generals;
                -A duel between two normal mages will lead to the death of the loosing party, and the increment of the experience of a character;
                 -A duel between two generals will only end with the death of the loosing party in the case that the party's hero vitality is entirely consumed;
                 ---------------------------------------------------------------------------
                """);
        do{
            System.out.println("""
                    0. Exit the game;
                    1. Start a new land;
                    2. Add a new mage;
                    3. Search for information about a mage via name;
                    4. Duel between two normal random mages (opposite factions);
                    5. Duel between two random generals (opposite factions);
                    6. List of all mages;
                    7. A list of all the soldiers of the forces of good;
                    8. A list of all the soldiers of the forces of evil;
                    9. Final battle (causes the land to expire);
                    10. Eliminate a character via name;
                    """);
            choice = scan.nextInt();
            System.out.println("\n------------------------------------------------------------------");
            switch (choice){
                case 1: {
                    if(battleground != null){
                        System.out.println("You have a land already in place... Do you want to start a new land? yes = 1; No = 0.");
                        choice2 = scan.nextInt();
                        while (choice2 != 0 && choice2 != 1){
                            System.out.println("Error, you need to insert 1 or 0");
                            choice2 = scanLine.nextInt();
                        }
                        switch (choice2){
                            case 0:
                                break;
                            case 1:
                                battleground = new Battleground();
                                System.out.println("Success");
                        }
                        break;
                    }
                    battleground = new Battleground();
                    System.out.println("Success");
                    break;
                }
                case 2: {
                    if(battleground == null){
                        System.out.println("No land is in place yet");
                        break;

                    }
                    System.out.println("""
                            Choose the race or status of the character:
                            1. General;
                            2. Human;
                            3. Elf;
                            4. Dwarf;
                            5. Hobbit;
                            6. Orc;
                            7. Urukhai;
                            8. Haradrim.
                            """);
                    choice = scan.nextInt();
                    while (!(choice >= 1 && choice <= 8)){
                        System.out.println("Error!");
                        choice = scan.nextInt();
                    }

                    switch (choice){
                        case 1:
                        {
                            System.out.println("Insert the name of the general");
                            name = scanLine.nextLine();

                            System.out.println("Insert the faction of the general: evil = 0; good = 1");
                            choice2 = scan.nextInt();

                            while (choice2 != 0 && choice2 != 1){
                                choice2 = scan.nextInt();
                            }
                            switch (choice2){
                                case 0:
                                {
                                    general1 = new General(name, Faction.EVIL);
                                    break;
                                }
                                case 1:
                                {
                                    general1 = new General(name, Faction.GOOD);
                                    break;
                                }
                            }
                            status = battleground.addMage(general1);
                            if(status){
                                System.out.println("General added successfully");
                            }
                            else{
                                System.out.println("Something went wrong");
                            }
                            break;
                        }
                        case 2:{
                            System.out.println("Insert the name of the human");
                            name = scanLine.nextLine();

                            human = new Human(name);
                            status = battleground.addMage(human);

                            if(status){
                                System.out.println("Human added successfully");
                            }
                            else{
                                System.out.println("Something went wrong");
                            }
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Insert the name of the elf");
                            name = scanLine.nextLine();

                            elf = new Elf(name);
                            status = battleground.addMage(elf);

                            if(status){
                                System.out.println("Elf added successfully");
                            }
                            else{
                                System.out.println("Something went wrong");
                            }
                            break;
                        }
                        case 4:
                        {
                            System.out.println("Insert the name of the dwarf");
                            name = scanLine.nextLine();

                            dwarf = new Dwarf(name);
                            status = battleground.addMage(dwarf);

                            if(status){
                                System.out.println("Dwarf added successfully");
                            }
                            else {
                                System.out.println("Something went wrong");
                            }
                            break;
                        }
                        case 5:
                        {
                            System.out.println("Insert the name of the hobbit");
                            name = scanLine.nextLine();

                            hobbit = new Hobbit(name);
                            status = battleground.addMage(hobbit);

                            if(status){
                                System.out.println("Hobbit added successfully");
                            }
                            else{
                                System.out.println("Something went wrong");
                            }
                            break;
                        }
                        case 6:
                        {
                            System.out.println("Insert the name of the Orc");
                            name = scanLine.nextLine();

                            orc = new Orc(name);
                            status = battleground.addMage(orc);

                            if(status){
                                System.out.println("Orc added successfully");
                            }
                            else{
                                System.out.println("Something went wrong");
                            }
                            break;
                        }
                        case 7:
                        {
                            System.out.println("Insert the name of the urukhai");
                            name = scanLine.nextLine();

                            urukhai = new Urukhai(name);
                            status = battleground.addMage(urukhai);

                            if(status){
                                System.out.println("Urukhai added successfully");
                            }
                            else{
                                System.out.println("Something went wrong");
                            }
                            break;
                        }
                        case 8:
                        {
                            System.out.println("Insert the name of the haradrim");
                            name = scanLine.nextLine();

                            haradrim = new Haradrim(name);
                            status = battleground.addMage(haradrim);

                            if(status){
                                System.out.println("haradrim added successfully");
                            }
                            else{
                                System.out.println("Something went wrong");
                            }
                            break;
                        }

                    }

                    break;

                }
                case 3:{
                    if(battleground == null){
                        System.out.println("No land is in place yet");
                        break;
                    }

                    System.out.println("Insert the name of the character you desire to retrieve information on");
                    name = scanLine.nextLine();
                    mage1 = battleground.searchMage(name);
                    if(mage1 != null){
                        System.out.println(mage1);
                    }
                    else {
                        System.out.println("Character not found");
                    }

                    break;
                }
                case 4:{
                    if(battleground == null){
                        System.out.println("No land is in place yet");
                        break;
                    }
                    mage1 = battleground.randomGoodMage();
                    mage2 = battleground.randomEvilMage();

                    if(mage1 == null || mage2 == null){
                        System.out.println("There aren't enough characters yet for a duel");
                        break;
                    }
                    System.out.println("Contestant 1: " + mage1);
                    System.out.println("Contestant 2: " + mage2);
                    System.out.println("----------------------------------------------------------");

                    winner = battleground.duel(mage1, mage2);

                    if(winner == null){
                        System.out.println("No winner. there has been a tie");
                    }
                    else{
                        System.out.println("Winner: " + winner);
                    }
                    break;
                }
                case 5:{
                    if(battleground == null){
                        System.out.println("No land is in place yet");
                        break;
                    }
                    general1 = battleground.randomGoodGeneral();
                    general2 = battleground.randomEvilGeneral();

                    if(general1 == null || general2 == null){
                        System.out.println("Not enough generals in one or both factions");
                        break;
                    }
                    System.out.println("Contestant 1: " + general1);
                    System.out.println("Contestant 2: " + general2);
                    System.out.println("------------------------------------------------------------------");
                    winner = battleground.lanceDuel(general1, general2);

                    if(winner == null){
                        System.out.println("There have been a tie, both generals were deducted a hero vitality point");
                    }
                    else{
                        System.out.println(winner);
                    }
                    break;
                }
                case 6:{
                    if(battleground == null){
                        System.out.println("No land is in place yet");
                        break;
                    }
                    battleground.magesList();
                    break;
                }
                case 7:{
                    if(battleground == null){
                        System.out.println("No land is in place yet");
                        break;
                    }

                    list = battleground.goodMagesList();

                    if(list.isEmpty()){
                        System.out.println("No good mages yet");
                        break;
                    }
                    for(Mage m : list){
                        System.out.println(m);
                    }
                    break;
                }
                case 8:{
                    if(battleground == null){
                        System.out.println("No land is in place yet");
                        break;
                    }

                    list = battleground.evilMagesList();

                    if(list.isEmpty()){
                        System.out.println("No evil mages yet");
                        break;
                    }
                    for(Mage m : list){
                        System.out.println(m);
                    }
                    break;
                }
                case 9:{
                    if(battleground == null){
                        System.out.println("No land is in place yet");
                        break;
                    }

                    faction = battleground.allOutBattle();
                    if(faction == Faction.NO_CHARACTERS){
                        System.out.println("There are not enough characters on one or both sides to initiate the war");
                        break;
                    }
                    else if(faction == Faction.GOOD){
                        System.out.println("The forces of the good won the war");
                        battleground = null;
                        System.out.println("The land expired");
                        break;
                    }
                    else{
                        System.out.println("The forces of evil won the war");
                        battleground = null;
                        System.out.println("The land expired");
                        break;
                    }
                }
                case 10:{
                    if(battleground == null){
                        System.out.println("No land is in place yet");
                        break;
                    }

                    System.out.println("Insert the name of the character to eliminate");
                    name = scanLine.nextLine();
                    status = battleground.eliminateCharacter(name);
                    if(status){
                        System.out.println("Character eliminated successfully");
                    }
                    else {
                        System.out.println("No character with such name exists in this land");
                    }
                    break;

                }
                default:
                    System.out.println("Error, you need to insert a number you're allowed to");
                    break;

            }
            System.out.println("------------------------------------------------------------------");
        }while (choice != 0);


    }
}