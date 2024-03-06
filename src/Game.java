public class Game {

    private int min = 1, max = 100;
    
    public int getRandomNum(){
        return (int)(Math.random() * max)-min;
    }

    public boolean isHigher(int guess, int randomNum) {
        if (guess > randomNum) {
            return true;
        }
        return false;
    }

    public boolean isInteger(String number){
        if (number == null){
            return false;
        }

        try {
            int num = Integer.parseInt(number);
        } catch (NumberFormatException e){
            return false;
        }
        
        return true;
    }

    public boolean isBetweenMinMax(int guess){
        if (guess < min || guess > max){
            return false;
        }
        return true;
    }

}
