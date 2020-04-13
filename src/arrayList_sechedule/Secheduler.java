package arrayList_sechedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Secheduler{
	private ArrayList<Event> events = new ArrayList<>();
	private Scanner Input = new Scanner(System.in);

	public void processCommand() {

		String Command;
		while(true) {
			System.out.print("$ ");
			Command = Input.next();

			if(Command.equalsIgnoreCase("add")) {
				add_Event();
			}
			else if(Command.equalsIgnoreCase("show")) {
				add_Show();
			}
			else if(Command.equalsIgnoreCase("Find")) {
				add_Find();
			}
			else if(Command.equals("sort")) {
				Collections.sort(events);
			}
			else if(Command.equalsIgnoreCase("exit"))
				break;
		}
		Input.close();
	}

	private void sort_Event(Compare[] data, int begin, int end) {
		
		if(end <= begin)return;
		
		int Pivot = begin;
		int Left = begin + 1;
		int Right = end;
		
		while(Left <= Right) {
			
			for(; ( Left <= Right ) && ( data[Left].compareTo(data[Right] ) <= 0); ++Left);
			for(; ( Right > Pivot ) && ( data[Right].compareTo(data[Pivot] ) > 0); --Right);
			
			if(Left<=Right) {
				Compare temp = data[Left];
				data[Left] = data[Right];
				data[Right] = temp;
			}
			else {
				Compare temp = data[Right];
				data[Right] = data[Pivot];
				data[Pivot] = temp;
			}
		}
		sort_Event(data, begin, Right -1);
		sort_Event(data, Right + 1, end);
	}

	private void add_Find() {
		String Search = Input.next();
		Date searEvent = parseIntStrok(Search);

		for(Event event : events)
			if(event.isRelevant(searEvent))
				System.out.println(event.toString());
	}

	private void Insert_Event(Event event) {
		events.add(event);
	}

	private Date parseIntStrok(String date) {
		String[] tokens = date.split("/");
		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);

		Date Date = new Date(year, month, day);
		return Date;
	}

	private void add_Show() {
		for(Event event : events )
			System.out.println(event.toString());
	}

	private void add_Event() {

		String type = Input.next();
		switch(type) {

		case "oneday":
			System.out.print("Title : ");
			String title = Input.next();
			System.out.print("When : ");
			String date = Input.next();

			Date oneday = parseIntStrok(date);
			Event onedayevent = new OneDay(title, oneday);

			Insert_Event(onedayevent);
			break;

		case "duration":
			System.out.print("Title : ");
			title = Input.next();

			System.out.print("begin : ");
			String begin = Input.next();

			System.out.print("begin : ");
			String end = Input.next();

			Date Begin = parseIntStrok(begin);
			Date End = parseIntStrok(end);

			Event durationevet = new Duration(title, Begin, End);

			Insert_Event(durationevet);		
			break;

		case "deadline":
			System.out.print("Title : ");
			title = Input.next();

			System.out.print("until : ");
			String until = Input.next();

			Date Until = parseIntStrok(until);

			Event deadlineevent = new DeadLine(title, Until);

			Insert_Event(deadlineevent);	
			break;

		default:
			break;
		}
	}

	public static void main(String[] args) {

		Secheduler app = new Secheduler();
		app.processCommand();
	}
}