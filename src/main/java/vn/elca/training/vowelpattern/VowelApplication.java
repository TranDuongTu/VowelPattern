package vn.elca.training.vowelpattern;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vn.elca.training.vowelpattern.controllers.Controller;
import vn.elca.training.vowelpattern.services.NLPService;

public class VowelApplication extends Application {
	
	private static final String APP_CONTEXT_FILE = 
			"spring_context/application_context.xml";
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(APP_CONTEXT_FILE);
		Scene scene = new Scene(loadRootNode(
				context.getBean("nlpService", NLPService.class)));
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Vowel Pattern Detector");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private Parent loadRootNode(NLPService nlpService) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		Parent root = (Parent) loader.load(new FileInputStream(
				"src/main/resources/javafx_resources/main_scene_layout.fxml"));
		
		((Controller) loader.getController()).setNlpService(nlpService);
		
		return root;
	}
}