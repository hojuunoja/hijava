package Final_Sechedule;

public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String toString() {
		return year + "/" + month + "/" + day; 
	}
	
	public int compareTo(Date Other) {
		if( ( year > Other.year) || ( year == Other.year && month > Other.month )
				|| ( year == Other.year && month == Other.month && day > Other.day))
			return 1;
		
		else if( (year < Other.year) || (year == Other.year && month <  Other.month)
				|| (year == Other.year && month == Other.month && day < Other.day))
			
			return -1;
		
		return 0;
	}
}