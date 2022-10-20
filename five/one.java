package five;

import java.util.Scanner;

class Country{
    private String iataCountryCode;
    private String countryName;

    Country(){}

    Country(String cc, String name){
        this.iataCountryCode = cc;
        this.countryName = name;
    }
    
    public String getIataCountryCode() {
        return iataCountryCode;
    }

    
    public void setIataCountryCode(String iataCountryCode) {
        this.iataCountryCode = iataCountryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public
    String toString(){
        String sf1=String.format("%-25s %s\n",this.iataCountryCode,this.countryName);  
        return sf1;
    }
}

class Client extends Country{
    private int clientId;
    private String clientName;
    private String phoneNumber;
    private String email;
    private String passport;
    private Country country;

    Client(){}

    Client(int id, String name, String phn, String email, String pass, String cc, String cn){
        super(cc,cn);
        this.clientId = id;
        this.clientName = name;
        this.phoneNumber = phn;
        this.email = email;
        this.passport = pass;
        // this.country.setIataCountryCode(cc);
        // this.country.setCountryName(cn);
    }

    int getClientId() {
        return clientId;
    }

    void setClientId(int clientId) {
        this.clientId = clientId;
    }

    String getClientName() {
        return clientName;
    }

    void setClientName(String clientName) {
        this.clientName = clientName;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPassport() {
        return passport;
    }

    void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public
    String toString(){
        String sf1=String.format("%-25s %-25s %-25s %-25s %s\n",this.clientId,this.clientName,this.phoneNumber,this.email,this.passport); 
        String fin = super.toString() + sf1;
        return fin;
    }

}

class clientBO{

    void viewDetails(Client[] clientList){
        System.out.format("%-25s %-25s %-25s %-25s %-25s %-25s %s\n", "Client ID", "Client Name", "Phone Number", "Email", "Passport","IATACountryCode","Country Name");

        for(int i=0;i<clientList.length;i++)
            System.out.println(clientList[i].toString());
    }

    void printClientDetails(Client[] clientList, String countryName){
        
        for(int i=0;i<clientList.length;i++)
        if(countryName.equals(clientList[i].getCountryName())){
            System.out.format("%-25s %-25s %-25s %-25s %-25s %-25s %s\n", "Client ID", "Client Name", "Phone Number", "Email", "Passport","IATACountryCode","Country Name");
            System.out.println(clientList[i].toString());
            
            }
    }

}

class one{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of users:");
        int n = sc.nextInt();
        sc.nextLine();
        Client arr[] = new Client[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter country code:");
            String cco = sc.nextLine();
            System.out.println("Enter country name:");
            String cn = sc.nextLine();
            // Country cc = new Country(cco,cn);
            System.out.println("Enter client id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter client name:");
            String name = sc.nextLine();
            System.out.println("Enter client phone number:");
            String phn = sc.nextLine();
            System.out.println("Enter client email:");
            String email = sc.nextLine();
            System.out.println("Enter client passport number:");
            String pass = sc.nextLine();
            arr[i] = new Client(id,name,phn,email,pass,cco,cn);
        }

        while(true){
            System.out.println("1. View Details");
            System.out.println("2. Filter client with country");
            System.out.println("3. Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            clientBO cb = new clientBO();

            if(ch==1)
                cb.viewDetails(arr);
            
            else if(ch==2){
                System.out.println("Enter country:");
                String country = sc.nextLine();
                cb.printClientDetails(arr, country);
            }
            
            else if(ch==3)
                System.exit(0);
            
            else
                System.out.println("Invalid Choice");
        }

    }
}
