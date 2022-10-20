import java.util.Scanner;

class address{
    private String addressLine1, addressLine2, city, state;
    private int pincode;
    
    address(String addressLine1, String addressLine2, String city, String state, int pincode){
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    
    void get(){
        System.out.println(this.addressLine1);
        System.out.println(this.addressLine2);
        System.out.println(this.city);
        System.out.println(this.state);
        System.out.println(this.pincode);
    }
    
    @Override
    public String toString(){
        return this.addressLine1+" "+this.addressLine2+" "+this.city+" "+this.state+" "+this.pincode+"\n";
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter addressLine1");
        String ad1 = sc.next();
        System.out.println("Enter addressLine2");
        String ad2 = sc.next();
        System.out.println("Enter city");
        String city = sc.next();
        System.out.println("Enter state");
        String state = sc.next();
        System.out.println("Enter pincode");
        int pin = sc.nextInt();
        
        address ad = new address(ad1,ad2,state,city,pin);
        
        // System.out.println(ad.toString());
        System.out.println("The address details are:");
        ad.get();
    }
    
}