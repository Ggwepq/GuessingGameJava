public class Player {
    private String name;
    private int attempt;

    Player(String name, int attempt){
        this.name = name;
        this.attempt = attempt;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAttempt(int attempt){
        this.attempt = attempt;
    }

    public String getName(){
        return this.name;
    }

    public int getAttempt(){
        return this.attempt;
    }
}