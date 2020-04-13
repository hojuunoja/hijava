package Date;

import java.util.Scanner;

public class Sechedule {
	private int capacity;
	private Event[] events;
	private int n_events;
	private Scanner Input;

	public Sechedule() {
		capacity = 10;
		n_events = 0;
		events = new Event[capacity];
		Input = new Scanner(System.in);
	}

	public void processCommand() {

		while(true) {
			System.out.print("$ ");
			String Command = Input.next();
			if(Command.toLowerCase().equals("add")) {
				add_Event();
			}
			else if(Command.toLowerCase().equals("find")) {
				find_Event();
			}
			else if(Command.toLowerCase().equals("show")) {
				show_Event();
			}
			else if(Command.toLowerCase().equals("sort")) {
				sort_Event(0, n_events - 1);
			}
			else if(Command.toLowerCase().equals("exit")) 
				break;
		}
		Input.close();
	}

	private void sort_Event(int begin, int end) {
		
		if(end <= begin)return;
		
		int Pivot = begin;
		int Left = begin+1;
		int Right = end;
		
		while( Left <= Right) {
			while(( Left <= Right ) && ( events[Left].compareTo(events[Right]))<=0)++Left;
			while( ( Right > Pivot ) && ( events[Right].compareTo(events[Pivot])) >0 ) --Right;
			
			if(Left <= Right) {
				Event temp = events[Left];
				events[Left] = events[Right];
				events[Right] = temp;
			}
			else {
				Event temp = events[Right];
				events[Right] = events[Pivot];
				events[Pivot] = temp;
			}
		}
		sort_Event(begin, Right - 1);
		sort_Event(Right + 1, end);
	}

	private void show_Event() {
		for(int i = 0; i < n_events; i++) {
			System.out.println(events[i].toString());
		}
	}

	private void find_Event() {
		System.out.print("When : ");
		String Search = Input.next();
		Date SearchDate = ParseInt(Search);

		for(int i = 0; i < n_events; i++) {
			if(events[i].isRelevant(SearchDate))
				System.out.println(events[i].toString());
		}
	}

	private void add_Event() {
		String type = Input.next();

		switch(type.toLowerCase()) {
		case "onedayevent":
			add_onedayevent();
			break;

		case "durationevent":
			add_durationevent();
			break;

		case "deadlineevent":
			add_deadlineevent();
			break;
		}
	}

	private void add_onedayevent() {
		System.out.print("Title : ");
		String title = Input.next();
		System.out.print("When : " );
		String date = Input.next();

		Date OneDay = ParseInt(date);
		OneDayEvent onedayevent = new OneDayEvent(title, OneDay);
		Insert_Event(onedayevent);
	}

	private void add_durationevent() {
		System.out.print("Title : ");
		String title = Input.next();
		System.out.print("Begin : " );
		String begin = Input.next();
		System.out.print("End : " );
		String end = Input.next();

		Date Begin = ParseInt(begin);
		Date End = ParseInt(end);	
		Event durationevent = new DurationEvent(title, Begin, End);
		Insert_Event(durationevent);
	}

	private void add_deadlineevent() {
		System.out.print("Title : ");
		String title = Input.next();
		System.out.print("Until : " );
		String until = Input.next();
		
		Date Until = ParseInt(until);	
		Event deadlineevent = new DeadLineEvent(title, Until);
		Insert_Event(deadlineevent);
	}

	private void Insert_Event(Event onedayevent) {
		if(n_events >= capacity)
			Reallocate();

		events[n_events++] = onedayevent;
	}

	private void Reallocate() {
		capacity *= 2;
		Event[] temp = new Event[capacity];
		System.arraycopy(events, 0, temp, 0, n_events);

		events = temp;
	}

	private Date ParseInt(String date) {
		String[] tokens = date.split("/");
		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);

		Date oneday = new Date(year, month, day);
		return oneday;
	}

	public static void main(String[] args) {
		Sechedule sechedule = new Sechedule();
		sechedule.processCommand();
	}
}
