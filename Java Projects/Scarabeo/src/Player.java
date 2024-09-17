import java.util.Arrays;
import java.util.Random;

public class Player {
    private String name;
    private char[] charactersDisposal;
    private char[] corrCharacters;
    private int score;

    final static int DIM = 10;

    public Player(){

    }
    public Player(String name) {
        this.name = name;
        charactersDisposal = new char[DIM];
        corrCharacters = new char[DIM];
        score = 0;
    }

    public String getName() {
        return name;
    }

    public char[] getCharactersDisposal() {
        return charactersDisposal;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharactersDisposal(char[] charactersDisposal) {
        this.charactersDisposal = charactersDisposal;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void generateLetters(){
        Random rand = new Random();
        char c = 'a';

        for(int i = 0; i < 10; i++){
            this.charactersDisposal[i] = (char)(c + rand.nextInt(26));
        }
        this.corrCharacters = this.charactersDisposal;
    }

    public void showLetters(){
        for(int i =0; i < DIM; i++){
            System.out.print("| " + this.charactersDisposal[i] + " ");
        }
        System.out.print("|");
    }

    @Override
    public String toString() {
        return "Player: " + name +
                "\nScore: " + score;
    }

    public void decreasePoint(){
        this.score--;
    }
    public boolean checkWord(String word, String lastWord){

        boolean result = true;
        char[] wording = word.toCharArray();
        char[] lastWording = lastWord.toCharArray();

        for(int i = 0; i <wording.length; i++){
            for(int x = 0; x < lastWording.length; x++){
                if(wording[i] == lastWording[x]){
                    result = true;
                    x = lastWording.length;
                }
                else if (wording != lastWording) {
                    result = false;
                }
            }

            if(result){
                i = wording.length;
            }
        }

        if(!result){
            return result;
        }

        for(int i = 0; i < wording.length; i++){
            for(int x = 0; x < this.corrCharacters.length; x++){
                if(wording[i] == this.corrCharacters[x]){
                    this.corrCharacters[x] = '*';
                    x = DIM;
                    result = true;
                }
                else if (wording[i] == '*') {
                    result = false;
                    x = DIM;
                }
                else{
                    result = false;
                }
            }
            if(!result)
            {
                return result;
            }
        }



        return result;
    }

    public void checkState(boolean wordState){
        if(wordState){
            this.score++;
        }
    }





}
