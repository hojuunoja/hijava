package Date;

public class OneDayEvent extends Event{
	private Date date;

	public OneDayEvent(String title, Date date) {
		super(title);
		this.date = date;
	}

	public String toString() {
		return "\tTitle : " + super.toString() + ", When : " + date;
	}

	public boolean isRelevant(Date Other) {
		return date.CompareTo(Other) == 0;
	}
	
	public Date returnDate() {
		return date;
	}
}
