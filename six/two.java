// import java.text.ParseException;
// import java.text.SimpleDateFormat;
import java.text.*;
import java.util.*;

class TicketBooking {
    private String stageEventShow;
    private Date bookingTime;
    private String seatNumber;
    private double price;

    public TicketBooking(){}

    public TicketBooking(String stageEventShow, Date bookingTime, String seatNumber, double price) {
        this.stageEventShow = stageEventShow;
        this.bookingTime = bookingTime;
        this.seatNumber = seatNumber;
        this.price = price;
    }
    
    public void setStageEventShow(String stageEventShow) {
        this.stageEventShow = stageEventShow;
    }

    public String getStageEventShow() {
        return this.stageEventShow;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getBookingTime() {
        return this.bookingTime;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s",this.stageEventShow,this.bookingTime,this.seatNumber,this.price);
    }

}

class PriceAndBookingTimeComparator extends TicketBooking implements Comparable<TicketBooking> {
    PriceAndBookingTimeComparator(String stageEventShow, Date bookingTime, String seatNumber, double price){
        super(stageEventShow,bookingTime,seatNumber,price);
    }

    public int compareTo(TicketBooking ticketBooking) {
        if(getPrice() == ticketBooking.getPrice())
            return getBookingTime().compareTo(ticketBooking.getBookingTime());

        else if(getPrice()  >  ticketBooking.getPrice())
            return 1;

        else
            return -1;
    }

}

public class two {
    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bookings:");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<PriceAndBookingTimeComparator> details = new ArrayList<>();
        while(n>0)
        {
            System.out.println("Enter the details of booking:");
            String userDetails = sc.nextLine();
            String[] arr = userDetails.split(",");
            SimpleDateFormat dateFormtat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormtat.parse(arr[1]);
            details.add(new PriceAndBookingTimeComparator(arr[0], date, arr[2], Double.parseDouble(arr[3])));
            n--;
        }
        System.out.println("Sorted Order:");
        System.out.println(String.format("%-15s %-15s %-15s %-15s","Event Name","Booking Time","Seat Number","Price"));
        Collections.sort(details);
        for(PriceAndBookingTimeComparator pbtc : details )
            System.out.println(String.format("%-15s %-15s %-15s %-15s",pbtc.getStageEventShow(),pbtc.getBookingTime(),pbtc.getSeatNumber(),pbtc.getPrice())); 
    }
}