package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainWindow extends Application {

	Pane4MainWindow pmw;
	
	@Override
	public void start(Stage stage) throws Exception {
		pmw = new Pane4MainWindow();
		
	}
	
	public Pane4MainWindow getPane(){
		return pmw;
	}

}
