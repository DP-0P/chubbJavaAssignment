package five;
import java.util.Scanner;

interface Bank{
    double calculateCreditScore();
}

class RBI implements Bank{
    private String accountNumber, holderName;
    private double creditScore;
    private final double CREDIT = 0.1;

    public double getCREDIT() {
        return CREDIT;
    }

    public double calculateCreditScore() {
        // TODO Auto-generated method stub
        return 0;
    }

    // double calculateCreditScore()

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }

}

class ICICI extends RBI{
    public double calculateCreditScore(double amt){
        double cc = amt * getCREDIT();
        return cc + getCreditScore();
    }
}

class HDFC extends RBI{
    public double calculateCreditScore(double amt){
        double cc = amt * getCREDIT();
        return cc + getCreditScore();
    }
}

class three{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter Bank Name:");       
            System.out.println("1. ICICI");       
            System.out.println("2. HDFC");
            int ch = sc.nextInt();
            sc.nextLine();
            if(ch==1){
                ICICI icici = new ICICI();

                System.out.println("Enter the Holder Name:");
                String name = sc.nextLine();
                icici.setHolderName(name);

                System.out.println("Enter the Account Number:");
                String acc = sc.nextLine();
                icici.setAccountNumber(acc);

                System.out.println("Enter the Credit Score:");
                double cs = sc.nextDouble();
                icici.setCreditScore(cs);

                System.out.println("Enter the Amount to be Paid:");
                double amt = sc.nextDouble();
                
                System.out.println("Amount paid successfully !!!");
                System.out.println("HI, "+icici.getHolderName());
                System.out.println("You have gained "+String.format("%.2f",(icici.calculateCreditScore(amt)-icici.getCreditScore()))+" credit score for the payment of "+String.format("%.2f",amt));
                System.out.println("Your total credit score is "+String.format("%.2f",icici.calculateCreditScore(amt)));
            }

            if(ch==2){
                HDFC hdfc = new HDFC();

                System.out.println("Enter the Holder Name:");
                String name = sc.nextLine();
                hdfc.setHolderName(name);

                System.out.println("Enter the Account Number:");
                String acc = sc.nextLine();
                hdfc.setAccountNumber(acc);

                System.out.println("Enter the Credit Score:");
                double cs = sc.nextDouble();
                hdfc.setCreditScore(cs);

                System.out.println("Enter the Amount to be Paid:");
                double amt = sc.nextDouble();

                System.out.println("Amount paid successfully !!!");
                System.out.println("HI, "+hdfc.getHolderName());
                System.out.println("You have gained "+String.format("%.2f",(hdfc.calculateCreditScore(amt)-hdfc.getCreditScore()))+" credit score for the payment of "+String.format("%.2f",amt));
                System.out.println("Your total credit score is "+String.format("%.2f",hdfc.calculateCreditScore(amt)));
            }

            else
                System.out.println("Invalid Choice");
        }
    }
}
