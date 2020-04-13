package Date;

public class DeadLineEvent extends Event {
	private Date deadline;
	
	public DeadLineEvent(String title, Date deadline) {
		super(title);
		this.deadline = deadline;
	}
	
	public String toString() {
		return "\tTitle : " + super.toString() + ", When : " + deadline;
	}
	
	public boolean isRelevant(Date Other) {
		return deadline.CompareTo(Other) >= 0;
	}
	
	public Date returnDate() {
		return deadline;
	}
}
