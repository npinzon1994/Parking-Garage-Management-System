package view;

import java.io.Serializable;

import javafx.application.Application;
import javafx.stage.Stage;
import model.ParkingStructure;

public class MainWindow extends Application implements Serializable {

	Pane4MainWindow pmw;
	
	@Override
	public void start(Stage stage) throws Exception {
		pmw = new Pane4MainWindow();
		ParkingStructure.getLevel1().loadLevel();
	}
	
	public Pane4MainWindow getPane(){
		return pmw;
	}

}
