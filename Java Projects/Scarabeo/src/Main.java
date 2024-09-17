import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);


        boolean started = false;
        boolean p1State = false;
        boolean p2State = false;

        Player player1 = null;
        Player player2 = null;

        String name;
        String currentWord;
        String lastWord = "";

        int choice = 0;


        System.out.println("Welcome to Scarab! Here are the rules: \n" +
                "1. Each player is given a name and a certain amount of letters each round" +
                "\n2. Each round the players get new letters, and they have to form a word that\n   has at least one letter that matches with the last inserted letter, the\n   first word is decided by the first player that forms a word correctly" +
                "\n3. No matter the letters inserted they'll be automatically turned into lower case" +
                "\n4. The word inserted has to have each letter from the words at the player's disposal" +
                "\n5. A typo in the word will cost the player his turn, so right carefully" +
                "\n6. You will have ten letters at your disposal each round" +
                "\n7. A player gets a point when they form a word correctly" +
                "\n8. If players disagree, you can always decrease a point to both players" +
                "\n8. The player with the most points after the end of the game wins");

        do{
            System.out.println("-----------------------------------\n");

            System.out.println("0. Turn off the game\n"
            + "1. Create 2 players\n"
            + "2. Visualize information on player 1\n"
            + "3. Visualize information on player 2\n"
            + "4. Play a round\n"
            + "5. Restart the game\n"
            + "6. Review the rules\n"
            + "7. Decrease one point for player 1\n"
            + "8. Decrease one point for player 2");

            System.out.println("\n-----------------------------------");

            choice = scan.nextInt();
            switch (choice){
                case 1:{
                    if(player1 != null){
                        System.out.println("Error! Players already made");
                    }
                    else{
                        System.out.println("Insert name of player 1");
                        name = scanLine.nextLine();
                        player1 = new Player(name);

                        System.out.println("Insert name of player 2");
                        name = scanLine.nextLine();
                        player2 = new Player(name);

                    }
                    break;
                }
                case 2:{
                    if(player1 == null)
                    {
                        System.out.println("Error! No players are created yet!");
                    }
                    else{
                        System.out.println(player1);
                    }
                    break;
                }
                case 3:{
                    if(player2 == null)
                    {
                        System.out.println("Error! No players are created yet!");
                    }
                    else{
                        System.out.println(player2);
                    }
                    break;
                }
                case 4:{
                    if(player1 == null){
                        System.out.println("Error! No players are created yet!");
                    }
                    else{
                        player1.generateLetters();
                        player2.generateLetters();
                        if(!started){
                            started = true;

                            System.out.println(player1.getName() + "'s turn");
                            System.out.print("Your letters: ");
                            player1.showLetters();

                            System.out.println("Insert your word: ");
                            currentWord = scanLine.nextLine();

                            currentWord = currentWord.toLowerCase();

                            p1State = player1.checkWord(currentWord, currentWord);
                            player1.checkState(p1State);

                            if(p1State){
                                System.out.println(player1.getName() + " gains one point.");
                            }
                            else{
                                System.out.println("Invalid word. " + player1.getName() + " gains no points.");
                            }
                            lastWord = currentWord;

                            System.out.println(player2.getName() + "'s turn");
                            System.out.print("Your letters: ");
                            player2.showLetters();
                            if(!p1State){
                                System.out.println("\nlast word hasn't been decided yet.");
                            }
                            else{
                                System.out.println("\nlast word: " + lastWord);
                            }

                            System.out.println("Insert your word: ");
                            currentWord = scanLine.nextLine();

                            currentWord = currentWord.toLowerCase();
                            if(!p1State){

                                p2State = player2.checkWord(currentWord, currentWord);
                                player2.checkState(p2State);

                                if(p2State){
                                    System.out.println(player2.getName() + " gains one point.");
                                    lastWord = currentWord;
                                }
                                else{
                                    System.out.println("Invalid word. " + player2.getName() + " gains no points.");
                                }

                            }
                            else{
                                p2State = player2.checkWord(currentWord, lastWord);
                                player2.checkState(p2State);

                                if(p2State){
                                    System.out.println(player2.getName() + " gains one point.");
                                    lastWord = currentWord;
                                }
                                else{
                                    System.out.println("Invalid word. " + player2.getName() + " gains no points.");
                                }

                            }

                            if(player1.getScore() == 0 && player2.getScore() == 0){
                                started = false;
                            }
                        }
                        else{
                            player1.generateLetters();
                            player2.generateLetters();

                            System.out.println(player1.getName() + "'s turn");
                            System.out.print("Your letters: ");
                            player1.showLetters();
                            System.out.println("\nlast word: "+ lastWord);

                            System.out.println("Insert your word: ");
                            currentWord = scanLine.nextLine();

                            currentWord = currentWord.toLowerCase();
                            p1State = player1.checkWord(currentWord, lastWord);
                            player1.checkState(p1State);

                            if(p1State){
                                System.out.println(player1.getName() + " gains one point.");
                                lastWord = currentWord;
                            }
                            else{
                                System.out.println("Invalid word. " + player1.getName() + " gains no points.");
                            }


                            System.out.println(player2.getName() + "'s turn");
                            System.out.print("Your letters: ");
                            player2.showLetters();
                            System.out.println("\nlast word: " + lastWord);

                            System.out.println("Insert your word: ");
                            currentWord = scanLine.nextLine();

                            currentWord = currentWord.toLowerCase();
                            p2State = player2.checkWord(currentWord, lastWord);
                            player2.checkState(p2State);

                            if(p2State){
                                System.out.println(player2.getName() + " gains one point.");
                                lastWord = currentWord;
                            }
                            else{
                                System.out.println("Invalid word. " + player2.getName() + " gains no points.");
                            }
                        }
                    }
                    break;
                }

                case 5:{
                    if(player1 == null){
                        System.out.println("Error! There's no game on.");
                    }
                    else{
                        player1 = null;
                        player2 = null;

                        started = false;
                        p1State = false;
                        p2State= false;

                        currentWord = "";
                        lastWord = "";
                        System.out.println("Game restarted\n\n");
                    }

                    break;
                }
                case 6:{
                    System.out.println(
                            "\n1. Each player is given a name and a certain amount of letters each round" +
                            "\n2. Each round the players get new letters, and they have to form a word that\n   has at least one letter that matches with the last inserted letter, the\n   first word is decided by the first player that forms a word correctly" +
                            "\n3. No matter the letters inserted they'll be automatically turned into lower case" +
                            "\n4. The word inserted has to have each letter from the words at the player's disposal" +
                            "\n5. A typo in the word will cost the player his turn, so right carefully" +
                            "\n6. You will have ten letters at your disposal each round" +
                            "\n7. A player gets a point when they form a word correctly" +
                            "\n8. If players disagree, you can always decrease a point to both players" +
                            "\n8. The player with the most points after the end of the game wins");
                }
                case 7:{
                    if(player1 == null){
                        System.out.println("Error! No players are created yet!");
                    }
                    else{
                        if(player1.getScore() - 1 < 0){
                            System.out.println("Player's score is already the minimum");
                        }
                        else{
                            player1.decreasePoint();
                            System.out.println(player1.getName() + "'s score decreased by 1 point");
                        }
                    }
                    break;

                }
                case 8:{
                    if(player1 == null){
                        System.out.println("Error! No players are created yet!");
                    }
                    else{
                        if(player2.getScore() - 1 < 0){
                            System.out.println("Player's score is already the minimum");
                        }
                        else{
                            player2.decreasePoint();
                            System.out.println(player2.getName() + "'s score decreased by 1 point");
                        }
                    }
                    break;
                }
            }
        }while(choice != 0);


    }
}