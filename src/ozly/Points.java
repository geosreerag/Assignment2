package ozly;

/**
 * @author ${sreeragsaradesh}

 */
/* The class points is inheriting from Ozlympic*/
public class Points {
	private Athlete athlete[] = new Athlete[26];
	public  String cwinner1Id = null, cwinner2Id = null, cwinner3Id = null;
	public  String swinner1Id = null, swinner2Id = null, swinner3Id = null;
	public  String rwinner1Id = null, rwinner2Id = null, rwinner3Id = null;
	
	public Points(Athlete athlete[],String rwinner1Id,String rwinner2Id,String rwinner3Id,
			String swinner1Id,String swinner2Id,String swinner3Id,
			String cwinner1Id,String cwinner2Id,String cwinner3Id) {
		this.athlete = athlete;
		this.cwinner1Id = cwinner1Id;
		this.cwinner2Id = cwinner2Id;
		this.cwinner3Id = cwinner3Id;
		this.swinner1Id = swinner1Id;
		this.swinner2Id = swinner2Id;
		this.swinner3Id = swinner3Id;
		this.rwinner1Id = rwinner1Id;
		this.rwinner2Id = rwinner2Id;
		this.rwinner3Id = rwinner3Id;
		}
	/* This is a method to calculate the points*/
	public StringBuilder calculatePoints() {
		
		StringBuilder s = new StringBuilder();

		//System.out.println(rwinner1Id + "-" + rwinner2Id + "-" + rwinner3Id + " " + swinner1Id + "-" + swinner2Id + "-"
				//+ swinner3Id + " " + cwinner1Id + "-" + cwinner2Id + "-" + cwinner3Id);
     /*For loop to set the points*/
		for (int i = 0; i < athlete.length; i++) {

			athlete[i].setPoints(0);
			/*this would help to find the Winneer of the Game*/
			if (athlete[i].getAthId().equals(rwinner1Id))
				athlete[i].setPoints(athlete[i].getPoints() + 5);
			if (athlete[i].getAthId().equals(cwinner1Id))
				athlete[i].setPoints(athlete[i].getPoints() + 5);
			if (athlete[i].getAthId().equals(swinner1Id))
				athlete[i].setPoints(athlete[i].getPoints() + 5);
			/*To find the 2nd place holder*/
			if (athlete[i].getAthId().equals(rwinner2Id))
				athlete[i].setPoints(athlete[i].getPoints() + 2);
			if (athlete[i].getAthId().equals(cwinner2Id))
				athlete[i].setPoints(athlete[i].getPoints() + 2);
			if (athlete[i].getAthId().equals(swinner2Id))
				athlete[i].setPoints(athlete[i].getPoints() + 2);
			/*Helps to assign the points for Third place holder*/
			if (athlete[i].getAthId().equals(rwinner3Id))
				athlete[i].setPoints(athlete[i].getPoints() + 1);
			if (athlete[i].getAthId().equals(cwinner3Id))
				athlete[i].setPoints(athlete[i].getPoints() + 1);
			if (athlete[i].getAthId().equals(swinner3Id))
				athlete[i].setPoints(athlete[i].getPoints() + 1);
			
			/* We print the Details of the player who have won the game in the 1st three places with the least time*/
			//System.out.println("ID " + athlete[i].getAthId() + " Name " + athlete[i].getName() + " Points "
				//	+ athlete[i].getPoints());
			
			s.append(System.getProperty("line.separator"));
			s.append("ID:" + athlete[i].getAthId() + "  Name:" + athlete[i].getName() + "  Points:"
					+ athlete[i].getPoints());
			
			
		}
		return s;
	}

}
