import java.util.*;

class Event{
    private String eventName;
    private int maxTickets;
    private String ownerName;

    Event(){}

    Event(String eventName,int maxTickets,String ownerName){
        this.eventName = eventName;
        this.maxTickets = maxTickets;
        this.ownerName = ownerName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(int maxTickets) {
        this.maxTickets = maxTickets;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // @Override
    public int equals(String ownerName, ArrayList<Event> arr){
        ArrayList<String> ar = new ArrayList<>();
        for(int i=0;i<arr.size();i++)
        ar.add(arr.get(i).getOwnerName());
        return Collections.frequency(ar, ownerName);
    }

}

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of events:");
        int n = sc.nextInt();
        sc.nextLine();
        if(n<0)
            System.out.println("Invalid Output");
        else{
            ArrayList<Event> al = new ArrayList<>();

            System.out.println("Enter event details in CSV format:");
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
                while (st.hasMoreTokens()) {
                    String event = st.nextToken();
                    int maxTicket = Integer.parseInt(st.nextToken());
                    String ownerName = st.nextToken();
                    al.add(new Event(event,maxTicket,ownerName));
                }
            }

            System.out.println("Enter owner name:");
            String owner = sc.nextLine();

            Event temp = new Event();
            System.out.println(owner+" has been organising: "+temp.equals(owner,al)+" events");
        }
    }
}