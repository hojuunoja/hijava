package Final_Sechedule;

public class OneDay extends Event{
	private Date oneday;
	
	public OneDay(String title, Date oneday) {
		super(title);
		this.oneday = oneday;
	}
	
	public String toString() {
		return "\tTitle : " + super.toString() + "\t\t\t\tToday : " + oneday.toString();
	}
	
	public boolean isRelevant(Date Other) {
		return oneday.compareTo(Other) == 0 ;
	}
	
	public Date getDate() {
		return oneday;
	}
}