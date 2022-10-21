import java.util.*;

class Hall {
    private String name;
    private double costPerDay;
    private String owner;

    public Hall(String name, double costPerDay, String owner) {
        this.name = name;
        this.costPerDay = costPerDay;
        this.owner = owner;
    }

    public Hall() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

public class four {

    public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
     System.out.println("Enter the number of halls:");
     int n = sc.nextInt();
     sc.nextLine();
     ArrayList<Hall> hall = new ArrayList<>();
     while (n-- != 0){
         String details = sc.nextLine();
         String[] arr = details.split(",");
         hall.add(new Hall(arr[0],Double.parseDouble(arr[1]),arr[2]));
     }

        Collections.sort(hall,(o1,o2) -> (o1.getOwner().compareTo(o2.getOwner())));
        System.out.format("%-15s %-10s %s\n","Name","Cost","Owner");
        for(Hall details : hall){
            System.out.format("%-15s %-10s %s\n",details.getName(),details.getCostPerDay(),details.getOwner());
        }
    }
}