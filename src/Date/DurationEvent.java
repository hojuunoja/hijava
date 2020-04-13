package Date;

public class DurationEvent extends Event {
	private Date begin;
	private Date end;
	
	public DurationEvent(String title, Date begin, Date end) {
		super(title);
		this.begin = begin;
		this.end = end;
	}
	
	public String toString() {
		return "\tTitle : " + super.toString() + ", When : " + begin + "~" + end;
	}
	
	public boolean isRelevant(Date Other) {
		return begin.CompareTo(Other) <= 0 && end.CompareTo(Other) >= 0;
	}
	
	public Date returnDate() {
		return begin;
	}
}
