package ozly;

/**
 * @author ${geochirayath}
 *
 */
//import random library
import java.util.Random;

public class Athlete {
	//attributes of this class
	private String athId;
	private String Name;
	private int Age;
	private String State;
	private char Type;
	private int Time;
	private int Points;

//getters and setters to access the private attributes in this class
	public String getAthId() {
		return athId;
	}

	public void setAthId(String athId) {
		this.athId = athId;
	}

	public char getType() {
		return Type;
	}

	public void setType(char type) {
		Type = type;
	}

	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		Time = time;
	}
	//constructor of this class that initialize the attributes
	public Athlete(String athId, String name, int age, String state, char type, int points) {
		super();
		this.athId = athId;
		this.Name = name;
		this.Age = age;
		this.State = state;
		this.Type = type;
		this.Points = points;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getPoints() {
		return Points;
	}

	public void setPoints(int points) {
		Points = points;
	}
	
 // used to run the compete method for the all the event by passing min and max time
	public void compete(int minTimer, int maxTimer){
		Random random = new Random();
		//assign a random time for a player during an event within the defined time frames
		int finishTimer = random.nextInt(maxTimer-minTimer)+minTimer;
		this.setTime(finishTimer);
		
	}

	

}
