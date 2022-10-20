package five;

import java.util.Scanner;
abstract class Match {
    private int currentScore;
    private float currentOver;
    private int target;

    void display(){
        System.out.println("Requirements:\nNeed "+(getTarget()-getCurrentScore())+" in "+calculateBalls()+" balls");
        System.out.println("Require Run Rate - "+calculateRunrate());
    }
    abstract float calculateRunrate();
    abstract int calculateBalls();

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public float getCurrentOver() {
        return currentOver;
    }

    public void setCurrentOver(float currentOver) {
        this.currentOver = currentOver;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }
}

class ODI extends Match{

    @Override
    float calculateRunrate() {
        float reqRunRate=(float)((getTarget()-getCurrentScore())/calculateBalls());
        return reqRunRate * 6;
    }

    @Override
    int calculateBalls() {
        int over = (int)(getCurrentOver()*10);
        int ballsRemaining=(50*6)-((over%10)+(over/10)*6);
        return ballsRemaining;
    }
    
}

class T20 extends Match{

    @Override
    float calculateRunrate() {
        float reqRunRate=(float)((getTarget()-getCurrentScore())/calculateBalls());
        return reqRunRate * 6;
    }

    @Override
    int calculateBalls() {
        int over = (int)(getCurrentOver()*10);
        int ballsRemaining=(20*6)-((over%10)+(over/10)*6);
        return ballsRemaining;
    }
    
}

class Test extends Match {

    @Override
    float calculateRunrate() {
        float reqRunRate=(float)((getTarget()-getCurrentScore())/calculateBalls());
        return reqRunRate * 6;
    }

    @Override
    int calculateBalls() {
        int over = (int)(getCurrentOver()*10);
        int ballsRemaining=(90*6)-((over%10)+(over/10)*6);
        return ballsRemaining;
    }
    
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Cricket Format\n"+"1.ODI\n"+"2.T20\n"+"3.Test");
        int format =sc.nextInt();
        System.out.println("Enter the Current Score");
        int currentScore=sc.nextInt();
        System.out.println("Enter the Current over");
        float currentOver=sc.nextFloat();
        System.out.println("Enter the Target");
        int target=sc.nextInt();
        sc.close();
        if (format==1) {
            ODI match  = new ODI();
            match.setCurrentScore(currentScore);
            match.setCurrentOver(currentOver);
            match.setTarget(target);
            match.display();
        }else if(format==2){
            T20 match  = new T20();
            match.setCurrentScore(currentScore);
            match.setCurrentOver(currentOver);
            match.setTarget(target);
            match.display();
        }else if(format==3){
            Test match  = new Test();
            match.setCurrentScore(currentScore);
            match.setCurrentOver(currentOver);
            match.setTarget(target);
            match.display();
        }else{
            System.out.println("Invalid Format type");
        }
    }
}