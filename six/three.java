import java.util.*;

class Address implements Comparable<Address> {
    private String userName;
    private String addressLine1;
    private String addressLine2;
    private int pinCode;

    public Address() {}

    public Address(String userName, String addressLine1, String addressLine2, int pinCode) {
        this.userName = userName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.pinCode = pinCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public int compareTo(Address o) {
        Address aObj = (Address) o;
        if (getPinCode() == aObj.getPinCode())
            return getAddressLine1().compareTo(aObj.getAddressLine1());
            
        else if (getPinCode() > aObj.getPinCode())
            return 1;

        else 
            return -1;
        
    }
}

public class three {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of users:");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Address> arr = new ArrayList<>();
        System.out.println("Enter user address in CSV(Username,AddressLine 1,AddressLine 2,PinCode)");
        while (n>0){
            String details = sc.nextLine();
            String[] s = details.split(",");
            arr.add(new Address(s[0],s[1],s[2],Integer.parseInt(s[3])));
            n--;
        }
        Collections.sort(arr);
        System.out.println("User Details:");
        for(Address a : arr){
            StringJoiner sj = new StringJoiner(",");
            sj.add(a.getUserName());
            sj.add(a.getAddressLine1());
            sj.add(a.getAddressLine2());
            sj.add(String.valueOf(a.getPinCode()));
            System.out.println(sj);
        }
    }
}