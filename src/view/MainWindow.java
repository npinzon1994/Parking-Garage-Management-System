package view;

import java.io.Serializable;

import javafx.application.Application;
import javafx.stage.Stage;
import model.ParkingStructure;

public class MainWindow extends Application implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;	
	Pane4MainWindow pmw;

	@Override
	public void start(Stage stage) throws Exception {
		pmw = new Pane4MainWindow();
		ParkingStructure.load();
		
		
	}

	public Pane4MainWindow getPane() {
		return pmw;
	}

}
