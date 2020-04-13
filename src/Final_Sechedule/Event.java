package Final_Sechedule;

public abstract class Event implements Compare{
	private String title;
	
	public Event() {;}
	
	public Event(String title) {
		this.title = title;
	}
	
	public String toString() {
		return title;
	}
	
	public abstract boolean isRelevant(Date date);
	public abstract Date getDate();
	
	public int compareTo( Object Other) {
		Date mine = getDate();
		Date yours = ((Event)Other).getDate();
		
		return mine.compareTo(yours);
	}
}