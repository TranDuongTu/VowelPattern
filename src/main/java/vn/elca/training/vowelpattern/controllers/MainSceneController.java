package vn.elca.training.vowelpattern.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vn.elca.training.vowelpattern.services.exceptions.InvalidInputException;

public class MainSceneController extends Controller {
	
	@FXML
	private TextField firstTextField, secondTextField;
	
	@FXML
	private Button detectBtn, closeBtn;
	
	@FXML
	private Label resultLabel;
	
	// ========================================================================
	// EVENT HANDLERS
	// ========================================================================

	@FXML
	protected void handleCloseBtnAction(ActionEvent e) {
		Platform.exit();
	}
	
	@FXML
	protected void handleDetectBtnAction(ActionEvent e) {
		String s1 = firstTextField.getText();
		String s2 = secondTextField.getText();
		
		try {
			showResult(nlpService.sameVowelPatternOfLongWord(s1, s2));
		} catch (InvalidInputException ex) {
			showError(ex.getMessage());
		}
	}
	
	// ========================================================================
	// PRIVATE HELPERS
	// ========================================================================
	
	private void showResult(boolean result) {
		resultLabel.setText(String.format("Two Strings %s same vowels pattern", 
				result ? "had" : "didn't have"));
	}
	
	private void showError(String message) {
		resultLabel.setText("Invalid input: " + message);
	}
}
