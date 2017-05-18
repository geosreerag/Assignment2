package ozly;
/**
 * @author ${geochirayath}
 
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import gui.FinalDisplayController;
import gui.GameResultController;
import gui.MainGUIController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ozlympic extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    
    // defined the class attributes
 	public static String selectedGame = null;
 	public static boolean cyclingFlag = false;
 	public static boolean runningFlag = false;
 	public static boolean swimmingFlag = false;
 	public static String predictedWinner = null;
 	
 	public static int cyclingCount = 0;
 	public static int swimmingCount = 0;
 	public static int runningCount = 0;
 	
 	public static Athlete cyclingAthletes[] = new Athlete[8];
 	public static Athlete swimmingAthletes[] = new Athlete[8];
 	public static Athlete runningAthletes[] = new Athlete[8];
 	
 	public static Athlete cyclingWinners[] = new Athlete[3];
 	public static Athlete swimmingWinners[] = new Athlete[3];
 	public static Athlete runningWinners[] = new Athlete[3];
 	
 	public static String cwinner1Id = "", cwinner2Id = "", cwinner3Id = "";
 	public static String swinner1Id = "", swinner2Id = "", swinner3Id = "";
 	public static String rwinner1Id = "", rwinner2Id = "", rwinner3Id = "";



	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("OzlympicApp");

        initRootLayout();
        
        showOzOverview();
        
        
        
		
	}
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Ozlympic.class.getResource("/gui/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the person overview inside the root layout.
     */
    public void showOzOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Ozlympic.class.getResource("/gui/MainGUI.fxml"));
            AnchorPane ozOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(ozOverview);
            
            // Give the controller access to the main app.
            MainGUIController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the person overview inside the root layout.
     */
    public void showResultOverview(String s) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Ozlympic.class.getResource("/gui/GameResult.fxml"));
            AnchorPane resultOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(resultOverview);
            
            // Give the controller access to the main app.
            GameResultController controller2 = loader.getController();
            controller2.setrecieveResult(s);
            controller2.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the person overview inside the root layout.
     */
    public void showFinalOverview(String s) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Ozlympic.class.getResource("/gui/FinalDisplay.fxml"));
            AnchorPane finalOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(finalOverview);
            
            // Give the controller access to the main app.
            FinalDisplayController controller3 = loader.getController();
            controller3.setrecieveResult(s);
            controller3.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    /**
     * The data as an observable list.
     */
    public ObservableList<String> gameList = FXCollections.observableArrayList();
    
    /**
     * Constructor
     */
    public Ozlympic() {
    	
    	gameList.add("Running");
    	gameList.add("Swimming");
    	gameList.add("Cycling");
    	
    }
    
    /**
     * Returns the data as an observable list of Stations. 
     * @return
     */
    public ObservableList<String> getGameData() {
        return gameList;
    }
    
    //select game functionality is implemented
  	public static void selectGame(String gameType) {
  		
		Athlete athlete[] = new Athlete[8];
		// creates an object for AthleteDatabase and calls the constructor for
		// the class
		AthleteDatabase a1 = new AthleteDatabase();
		athlete = AthleteDatabase.getAthlete();
		// creates an object for FilterAthletes and calls the constructor for
		// the class
		FilterAthletes fa1 = new FilterAthletes(athlete);

		switch (gameType) {
		case "R": {
			// running
			selectedGame = "R";
			// calls the FilterNow method
			fa1.FilterNow('R');
			// filterAthletes(athlete,'R');
			//System.out.println("Running selected. Participants are ready..Please start the game now.");
			break;
		}
		case "S": {
			// Swimming;
			selectedGame = "S";
			// calls the FilterNow method
			fa1.FilterNow('S');
			// filterAthletes(athlete,'S');
			//System.out.println("Swimming selected. Participants are ready..Please start the game now.");
			break;
		}
		case "C": {
			// Cycling;
			selectedGame = "C";
			// calls the FilterNow method
			fa1.FilterNow('C');
			// filterAthletes(athlete,'C');
			//System.out.println("Cycling selected. Participants are ready..Please start the game now.");
			break;
		}
		default:

			System.out.println("Enter a correct choice");
		}

		// assigns values into these varibales
		cyclingCount = fa1.getCyclingCount();
		runningCount = fa1.getRunningCount();
		swimmingCount = fa1.getSwimmingCount();

		cyclingAthletes = fa1.getCyclingAthletes();
		runningAthletes = fa1.getRunningAthletes();
		swimmingAthletes = fa1.getSwimmingAthletes();		
  	}
  	
  	public static void startGame() {
		Athlete athlete[] = new Athlete[26];
		athlete = AthleteDatabase.getAthlete();
		
		
		int winnerTime = 0, secondTime = 0, thirdTime = 0;
		ArrayList<Integer> timeNew = new ArrayList<Integer>();
		
		if (selectedGame == "R") {
			for(int i = 0; i <= runningCount; i++) {
				//individual time is been assigned
				timeNew.add(runningAthletes[i].getTime());
			}
			
			for (int i = 0; i <= runningCount; i++) {
				//times are sorted to find the winners			
				Collections.sort(timeNew);
			}
			
			//winner time assigned
			winnerTime = timeNew.get(0);
			secondTime = timeNew.get(1);
			thirdTime = timeNew.get(2);
				
			
			
			for (int i = 0; i <= runningCount; i++) {
				int points = 0, j = 0;
				//find the winner using the captured winner time
				if ((runningAthletes[i].getTime() == winnerTime) &&
						(rwinner1Id.isEmpty())) {
					rwinner1Id = runningAthletes[i].getAthId();
					//assigns the points to the winner
					points = runningAthletes[i].getPoints();
					runningAthletes[i].setPoints(5+points);
					runningWinners[j] = runningAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == runningWinners[j].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if ((runningAthletes[i].getTime() == secondTime) &&
							(rwinner2Id.isEmpty())) {
					rwinner2Id = runningAthletes[i].getAthId();
					//assigns points to the second winner
					runningAthletes[i].setPoints(2+points);
					runningWinners[j+1] = runningAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == runningWinners[j+1].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if ((runningAthletes[i].getTime() == thirdTime) &&
							(rwinner3Id.isEmpty())) {
					rwinner3Id = runningAthletes[i].getAthId();
					//assigns points to the third winner
					runningAthletes[i].setPoints(1+points);
					runningWinners[j+2] = runningAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == runningWinners[j+2].getAthId())
							athlete[k].setPoints(5+points);
					}
				}			
			}
			
			//System.out.println("winner1Id " + winner1Id + " winner2Id " + winner2Id + " winner3Id " + winner3Id);	
			
			if (predictedWinner == rwinner1Id)
				//if the predicted winner is same as the winner a congratulation message is been displayed
				System.out.println("Congratulations! You predicted the winner..");
			
			//System.out.println("Running completed successfully");
			runningFlag = true;
			
		}
		else if (selectedGame == "S") {
			for(int i = 0; i <= swimmingCount; i++) {
				timeNew.add(swimmingAthletes[i].getTime());
			}
			
			for (int i = 0; i <= swimmingCount; i++) {
				//times are sorted to find the winners			
				Collections.sort(timeNew);
			}
			
			//winner time assigned
			winnerTime = timeNew.get(0);
			secondTime = timeNew.get(1);
			thirdTime = timeNew.get(2);
			
			for (int i = 0; i <= swimmingCount; i++) {
				int points = 0, j = 0;
				if ((swimmingAthletes[i].getTime() == winnerTime) &&
					(swinner1Id.isEmpty())) {
					//finds the winner of the game
					swinner1Id = swimmingAthletes[i].getAthId();
					//assigns points
					points = swimmingAthletes[i].getPoints();
					swimmingAthletes[i].setPoints(5+points);
					swimmingWinners[j] = swimmingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == swimmingWinners[j].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if ((swimmingAthletes[i].getTime() == secondTime) &&
						(swinner2Id.isEmpty())) {
					//finds the second winner and sets the points
					swinner2Id = swimmingAthletes[i].getAthId();
					swimmingAthletes[i].setPoints(2+points);
					swimmingWinners[j+1] = swimmingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == swimmingWinners[j+1].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if ((swimmingAthletes[i].getTime() == thirdTime) &&
						(swinner3Id.isEmpty())) {
					//finds the thrid winner and assigns points
					swinner3Id = swimmingAthletes[i].getAthId();
					swimmingAthletes[i].setPoints(1+points);
					swimmingWinners[j+2] = swimmingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == swimmingWinners[j+2].getAthId())
							athlete[k].setPoints(5+points);
					}
				}			
			}
			
			if (predictedWinner == swinner1Id)
				//checkks and displays a message if the predicted winner is the actual winner
				System.out.println("Congratulations! You predicted the winner..");
			
			//System.out.println("Swimming completed successfully");
			swimmingFlag = true;
			
		}
		else if (selectedGame == "C"){
			for(int i = 0; i <= cyclingCount; i++) {
				timeNew.add(cyclingAthletes[i].getTime());
			}
			
			for (int i = 0; i <= swimmingCount; i++) {
				//times are sorted to find the winners			
				Collections.sort(timeNew);
			}
			
			//winner time assigned
			winnerTime = timeNew.get(0);
			secondTime = timeNew.get(1);
			thirdTime = timeNew.get(2);
			
			
			for (int i = 0; i <= cyclingCount; i++) {
				int points = 0, j = 0;
				if ((cyclingAthletes[i].getTime() == winnerTime) &&
					(cwinner1Id.isEmpty())) {
					//finds the winner of the game and assigns points to them
					cwinner1Id = cyclingAthletes[i].getAthId();
					points = cyclingAthletes[i].getPoints();
					cyclingAthletes[i].setPoints(5+points);
					cyclingWinners[j] = cyclingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == cyclingWinners[j].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if ((cyclingAthletes[i].getTime() == secondTime) &&
					(cwinner2Id.isEmpty())) {
					//finds the second winner and assigns points
					cwinner2Id = cyclingAthletes[i].getAthId();
					cyclingAthletes[i].setPoints(2+points);
					cyclingWinners[j+1] = cyclingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == cyclingWinners[j+1].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if ((cyclingAthletes[i].getTime() == thirdTime) &&
					(cwinner3Id.isEmpty())) {
					//finds the third winner and assigns points
					cwinner3Id = cyclingAthletes[i].getAthId();
					cyclingAthletes[i].setPoints(1+points);
					cyclingWinners[j+2] = cyclingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == cyclingWinners[j+2].getAthId())
							athlete[k].setPoints(5+points);
					}
				}			
			}
			
			//System.out.println("winner1Id " + winner1Id + " winner2Id " + winner2Id + " winner3Id " + winner3Id);	
			
			if (predictedWinner == cwinner1Id)
				//display a message if the predicted winner is the actual winner
				System.out.println("Congratulations! You predicted the winner..");
			
			//System.out.println("Cycling completed successfully");
			cyclingFlag = true;
		}
		else
			System.out.println("Please select a game first");
			
		
	}
  	
  	public static String finalResults(String ref) {
		//System.out.println("The final results are..");
		//System.out.println("	");
		
  		StringBuilder s = new StringBuilder();
  		
		//System.out.println("Item: Cycling");
		if (cyclingFlag == true) {
			int cyclingLength = cyclingWinners.length;	
			s.append("Item: Cycling");
			
			try
			{
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));
			writer.println(timeStamp);
			writer.println("Refree:" + ref);
			writer.close();
			}
			catch (IOException e) 
			{ // do something }
			}
			
			
			for(int i = 0; i < cyclingLength; i++){
				//assigns the details of the winner from the athlete database
				try {
				s.append(System.getProperty("line.separator"));
				s.append("ID:" + cyclingWinners[i].getAthId() + "  Name:" + cyclingWinners[i].getName() + "  Age:");
				s.append(cyclingWinners[i].getAge());
				s.append("  State:" + cyclingWinners[i].getState() + "  Time:");
				s.append(cyclingWinners[i].getTime());
				/*System.out.println("ID " + cyclingWinners[i].getAthId() + 
						" Name " + cyclingWinners[i].getName() + 
						" Age " + cyclingWinners[i].getAge() +
						" State " + cyclingWinners[i].getState() +
						" Time " + cyclingWinners[i].getTime());*/
				} catch (NullPointerException e) {
					System.out.println("null");
				}
				
				try
				{ 
				
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));
				writer.println("ID:" + cyclingWinners[i].getAthId() + 
						"  Name:" + cyclingWinners[i].getName() + 
						"  Age:" + cyclingWinners[i].getAge() +
						"  State:" + cyclingWinners[i].getState() +
						"  Time:" + cyclingWinners[i].getTime());
		
				
				writer.close();
				}
				catch (IOException e) 
				{ // do something }
				}
				
			}
			s.append(System.getProperty("line.separator"));
			s.append("Referee: " + ref);
			
			try
			{
			
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));
			writer.println("");
			writer.close();
			}
			catch (IOException e) 
			{ // do something }
			}
			catch (NullPointerException e) {
				System.out.println("null");
			}
			
		}
		else
			{
			//System.out.println("Cycling hasn't completed yet..");	
			//System.out.println("");	
			}
		//System.out.println("");	
		//System.out.println("Item: Swimming");
		if (swimmingFlag == true) {
			int swimmingLength = swimmingWinners.length;
			s.append(System.getProperty("line.separator"));
			s.append("Item: Swimming");
			
			try
			{
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));
			writer.println(timeStamp);
			writer.println("Refree:" + ref);
			writer.close();
			}
			catch (IOException e) 
			{ // do something }
			}
			
			for (int i = 0; i < swimmingLength; i++) {
				//gets the details of the winner from the athlete database
				try {
				s.append(System.getProperty("line.separator"));
				s.append("ID:" + swimmingWinners[i].getAthId() + "  Name:" + swimmingWinners[i].getName() + "  Age:");
				s.append(swimmingWinners[i].getAge());
				s.append("  State:" + swimmingWinners[i].getState() + "  Time:");
				s.append(swimmingWinners[i].getTime());
				/*System.out.println("ID " + swimmingWinners[i].getAthId() + " Name " + swimmingWinners[i].getName() + " Age "
						+ swimmingWinners[i].getAge() + " State " + swimmingWinners[i].getState() + " Time "
						+ swimmingWinners[i].getTime());*/
				
				} catch (NullPointerException e) {
					System.out.println("null");
				}
				try
				{ 
				
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));
				writer.println("ID:" + swimmingWinners[i].getAthId() + 
						"  Name:" + swimmingWinners[i].getName() + 
						"  Age:" + swimmingWinners[i].getAge() +
						"  State:" + swimmingWinners[i].getState() +
						"  Time:" + swimmingWinners[i].getTime());
		
				
				writer.close();
				}
				catch (IOException e) 
				{ // do something }
				}
				
			}
			s.append(System.getProperty("line.separator"));
			s.append("Referee: " + ref);
			
			try
			{
			
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));
			writer.println("");
			writer.close();
			}
			catch (IOException e) 
			{ // do something }
			}
			catch (NullPointerException e) {
				System.out.println("null");
			}
			
			
		}
		else
			{
			//System.out.println("Swimming hasn't completed yet..");
			System.out.println("");	
			}
		//System.out.println("");	
		//System.out.println("Item: Running");
		if (runningFlag == true) {
			int runningLength = runningWinners.length;	
			s.append(System.getProperty("line.separator"));
			s.append("Item: Running");
			
			try
			{
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));
			writer.println(timeStamp);
			writer.println("Refree:" + ref);
			writer.close();
			}
			catch (IOException e) 
			{ // do something }
			}
			
			for (int i = 0; i < runningLength; i++) {
				//displays the details of the winner from the athlete database	
				//System.out.println(runningWinners[i]);
				try {
					s.append(System.getProperty("line.separator"));
					s.append("ID:" + runningWinners[i].getAthId() + "  Name:" + runningWinners[i].getName() + "  Age:");
					s.append(runningWinners[i].getAge());
					s.append("  State:" + runningWinners[i].getState() + "  Time:");
					s.append(runningWinners[i].getTime());
					/*System.out.println("ID " + runningWinners[i].getAthId() + " Name " + runningWinners[i].getName() + " Age "
							+ runningWinners[i].getAge() + " State " + runningWinners[i].getState() + " Time "
							+ runningWinners[i].getTime());*/
				} catch (NullPointerException e) {
					System.out.println("null");
				}
				
				
				try
				{ 
				
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));
				writer.println("ID:" + runningWinners[i].getAthId() + 
						"  Name:" + runningWinners[i].getName() + 
						"  Age:" + runningWinners[i].getAge() +
						"  State:" + runningWinners[i].getState() +
						"  Time:" + runningWinners[i].getTime());
		
				
				writer.close();
				}
				catch (IOException e) 
				{ // do something }
				}
				catch (NullPointerException e) {
					System.out.println("null");
				}
				
			}
			s.append(System.getProperty("line.separator"));
			s.append("Referee: " + ref);
			
			try
			{
			
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));
			writer.println("");
			writer.close();
			}
			catch (IOException e) 
			{ // do something }
			}
			
			
		}
		else{
			
			System.out.println("Running hasn't completed yet..");
			System.out.println("");	
			}
		//GameResultController GRController = new GameResultController();
		//GRController.setrecieveResult(s);
		
		return s.toString();
	}
  	
  	public static String displayPoints() {
		Athlete athlete[] = new Athlete[26];
		athlete = AthleteDatabase.getAthlete();
		StringBuilder s = new StringBuilder();
		// creates an object for the points class and passes the parameters for the constructor
		Points p1 = new Points(athlete,
				rwinner1Id,rwinner2Id,rwinner3Id,
				swinner1Id,swinner2Id,swinner3Id,		
				cwinner1Id,cwinner2Id,cwinner3Id);
		//calls the calculatePoints() method from the points class
		s = p1.calculatePoints();
		
		return s.toString();
		
	}
    

	public static void main(String[] args) {
		Database d= new Database();
		launch(args);
		
	}
}
