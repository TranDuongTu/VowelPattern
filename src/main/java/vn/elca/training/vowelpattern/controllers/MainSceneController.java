package vn.elca.training.vowelpattern.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import vn.elca.training.vowelpattern.services.exceptions.InvalidInputException;

public class MainSceneController extends Controller {
	
	@FXML
	private TextField firstTextField, secondTextField;
	
	@FXML
	private Button detectBtn, closeBtn;
	
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
			alertResult(nlpService.sameVowelPatternOfLongWord(s1, s2));
		} catch (InvalidInputException ex) {
			System.out.println("Invalid Input");
		}
	}
	
	// ========================================================================
	// PRIVATE HELPERS
	// ========================================================================
	
	private void alertResult(boolean result) {
		System.out.println("Result: " + result);
	}
}
