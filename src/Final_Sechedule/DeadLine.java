package Final_Sechedule;

public class DeadLine extends Event{
	private Date deadline;
	
	public DeadLine(String title, Date deadline) {
		super(title);
		this.deadline = deadline;
	}
	
	public String toString() {
		return "\tTitle : " + super.toString() + "\t\t\t\tUntil : " + deadline.toString();
	}
	
	public boolean isRelevant(Date Other) {
		return deadline.compareTo(Other)>=0;
	}
	
	public Date getDate() {
		return deadline;
	}
}