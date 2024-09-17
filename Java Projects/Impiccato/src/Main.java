import java.util.Objects;
import java.util.Scanner;

public class Main {
    //Il numero di tentativi nell'impeccata è 10
    public static int tentativi = 10;


    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Il gioco si fa in due o piu' giocatori per essere valida, instruzioni:\n-Un giocatore deve scrivere una parola in mente (dev'essere una parola esistente, scelta dei giocatori se includere l'inglese o no)\n-Gli altri hanno 10 tentativi per indovinare la parole\n-Anche se si inseriscono maiuscole verrano trasformate tutte in minuscole");

            String word = "";
            char input = ' ';
            int currentTries = tentativi;
            boolean inCondition = true;
            boolean alreadySaid = false;
            boolean end = false;
            System.out.println("Inserire la parola da indovinare: ");

            word = scan.nextLine();
            word = word.toLowerCase();
            char[] arrayWord = word.toCharArray();

            char[] currentGuess = new char[arrayWord.length];

            for(int i = 0; i < arrayWord.length; i++){
                if(i == 0){
                    currentGuess[i] = arrayWord[i];
                }
                else if (i == arrayWord.length - 1) {
                    currentGuess[i] = arrayWord[i];
                }
                else{
                    currentGuess[i] = '_';
                }

            }

            System.out.println("\n\n\n \n\n\n \n\n\n \n\n\n \n\n\n \n\n\n\n \n \n \n \n \n \n \n \n\n\n \n\n\n \n\n\n");
        System.out.println("Attuale situazione: " + String.valueOf(currentGuess) + "\nTentativi Rimanenti: " + currentTries);
            while(currentTries > 0){
                System.out.println("Inserrie la lettera da indovinare (un carattere già inserito verrà contato comunque come tentativo)");
                input = scan.next().charAt(0);
                input = Character.toLowerCase(input);
                for(int i = 0; i < arrayWord.length; i++){
                    if(input == arrayWord[i]){
                        inCondition = true;
                        for(int x = 0; x < currentGuess.length; x++){
                            if(currentGuess[i] == input && i < arrayWord.length-1){
                                inCondition = false;
                                alreadySaid = true;
                            }
                        }
                    }

                }

                if(inCondition){
                    for(int i = 0; i < currentGuess.length; i++){
                        if(arrayWord[i] == input){
                            currentGuess[i] = input;
                        }
                    }
                }
                else if(alreadySaid){
                    System.out.println("Gia' detto!");
                    currentTries--;
                }
                else{
                    System.out.println("Carattere non esiste");
                    currentTries--;
                }


                System.out.println("Attuale situazione: " + String.valueOf(currentGuess) + "\nTentativi Rimanenti: " + currentTries);


                for(int i = 0; i < currentGuess.length; i++){
                    if (currentGuess[i] == '_') {
                        end = false;
                        break;
                    }
                }

                if(end){
                    break;
                }

                end = true;
                inCondition = false;
                alreadySaid = false;

            }

            if(currentTries == 0){
                System.out.println("Hai perso...La parola era " + String.valueOf(word));
            }

            if(Objects.equals(String.valueOf(word), String.valueOf(currentGuess))){
                System.out.println("Congratulazioni! Hai vinto");
            }


            System.out.println("□");

    }

}