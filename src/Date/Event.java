package Date;

public abstract class Event {
	private String title;
	
	public Event() {;}
	
	public Event(String title) {
		this.title = title;
	}
	
	public String toString() {
		return title;
	}
	
	public abstract boolean isRelevant(Date Other) ;
	public abstract Date returnDate();
	
	public int compareTo(Event Other) {
		return this.returnDate().CompareTo(Other.returnDate());
	}
}
