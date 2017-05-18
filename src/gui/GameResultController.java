package gui;

/**
 * @author ${sreeragsaradesh}
 
 */

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ozly.Ozlympic;


public class GameResultController {
	
	@FXML
	private TextArea resultBox;
	
	@FXML
	private Button backBtn;
	
	@FXML
	private Button quitBtn;
	
	
	private String recieveResult;

	private Ozlympic mainGUI;
	
	public GameResultController() {
		
	}
	
	public void setrecieveResult(String s) {
		this.recieveResult = s;
	}
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize the person table with the two columns.
   
    	
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Ozlympic mainGUI) {
        this.mainGUI = mainGUI;
        
        resultBox.setText(recieveResult);
      
    }
    
    @FXML
    private void handleBackBtnAction() {
        // Button was clicked, do something...
    	mainGUI.initRootLayout();
    	mainGUI.showOzOverview();
    }
    
    @FXML
    public void handleQuitButtonAction() {
        Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    
    

}
