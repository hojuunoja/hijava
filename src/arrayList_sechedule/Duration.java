package arrayList_sechedule;

public class Duration extends Event{
	private Date begin;
	private Date end;
	
	public Duration(String title, Date begin, Date end) {
		super(title);
		this.begin = begin;
		this.end = end;
	}
	
	public String toString() {
		return "\tTitle : " + super.toString() + "\t\t\t\t" + begin.toString() + "~" + end.toString();
	}
	
	public boolean isRelevant(Date Other) {
		return begin.compareTo(Other)<=0 && end.compareTo(Other)>=0;
	}
	
	public Date getDate() {
		return begin;
	}
}