package gui;
/**
 * @author ${sreeragsaradesh}
 
 */

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ozly.GameFullException;
import ozly.Ozlympic;
import ozly.NoRefereeException;
import ozly.TooFewAthleteException;

public class MainGUIController {

	// GUI elements
	@FXML
	private Button runningBtn;

	@FXML
	private Button cyclingBtn;

	@FXML
	private Button swimmingBtn;

	@FXML
	private Button startGameBtn;

	@FXML
	private Button finalResultBtn;

	@FXML
	private Button quitBtn;

	@FXML
	private ChoiceBox<String> referee;

	@FXML
	private TextField playerNo;

	@FXML
	private TextArea msgArea;

	ObservableList<String> refereeList = FXCollections.observableArrayList("Sam", "Geo", "James");

	private String gameSelected = "";

	// Reference to the main application.
	private Ozlympic mainGUI;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public MainGUIController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		referee.setItems(refereeList);
		referee.setValue("none");

	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Ozlympic mainGUI) {
		this.mainGUI = mainGUI;

	}

	// GUI event handlers
	@FXML
	private void handleRunningBtnAction() {
		// Button was clicked, do something...
		mainGUI.selectGame("R");
		gameSelected = "R";
	}

	@FXML
	private void handleCyclingBtnAction() {
		// Button was clicked, do something...
		mainGUI.selectGame("C");
		gameSelected = "C";
	}

	@FXML
	private void handleSwimmingBtnAction() {
		// Button was clicked, do something...
		mainGUI.selectGame("S");
		gameSelected = "S";
	}

	@FXML
	private void handleStartGameBtnAction() throws TooFewAthleteException,GameFullException{
		// private void handleStartGameBtnAction() throws
		// Exception,TooFewAthleteException {
		// Button was clicked, do something...
		boolean allGood = true;

		if (playerNo.getText().isEmpty()) {
			msgArea.setText("Please enter number of players");
			allGood = false;
		} else {
			if ((Integer.parseInt(playerNo.getText()) < 4) || (Integer.parseInt(playerNo.getText()) > 8)) {

				msgArea.setText("GameFull/TooFewAthlete Exception: Incorrect number of players");
				allGood = false;
				// throw new TooFewAthleteException("Incorrect number of
				// players");
			}
			try{
				if (Integer.parseInt(playerNo.getText()) < 4) {
					 throw new TooFewAthleteException("too few players");
									
				} 
			}
			catch (TooFewAthleteException exp){
				System.out.println(exp);
			}
			try{
				if (Integer.parseInt(playerNo.getText()) > 8) {
					 throw new GameFullException("too Many players");
									
				} 
			}
			catch (GameFullException exp){
				System.out.println(exp);
			}

		}

		if (referee.getValue() == "none") {
			msgArea.setText("NoRefereeException:  Please select a referee");
			allGood = false;
			// throw new NoRefereeException("NoRefereeException: No Referee
			// Selected");
		}
		
		try{
			if (referee.getValue() == "none") {
				 throw new NoRefereeException("NoRefereeException:  Please select a referee");
								
			} 
		}
		catch (NoRefereeException exp){
			System.out.println(exp);
		}
		
		

		if (gameSelected == "") {
			msgArea.setText("Please select a game first");
			allGood = false;
		}

		if (allGood == true) {
			mainGUI.startGame();
			String s = mainGUI.finalResults(referee.getValue());
			mainGUI.initRootLayout();
			mainGUI.showResultOverview(s);
		}

	}

	@FXML
	private void handleFinalBtnAction() {
		// Button was clicked, do something...
		String s = mainGUI.displayPoints();
		mainGUI.initRootLayout();
		mainGUI.showFinalOverview(s);
	}

	@FXML
	public void handleQuitButtonAction() {
		Stage stage = (Stage) quitBtn.getScene().getWindow();
		stage.close();
		System.exit(0);
	}

	public void display() {

	}

}
