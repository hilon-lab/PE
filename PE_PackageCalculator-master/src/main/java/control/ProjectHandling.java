package control;

import java.io.File;
import gui.PackageCalculator;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;

public class ProjectHandling {

	static public void openProject(String rootPath) {
		// update window title
		PackageCalculator.getInstance().getPrimaryStage().setTitle(PackageCalculator.APPNAME + " – " + rootPath);
		// load tree in explorer
		PackageCalculator.getInstance().explorerArea.loadNewTree(rootPath);
		// remember open project
		PackageCalculator.getInstance().rootPath = rootPath;
	}

	static public void openProject() {
		final DirectoryChooser directoryChooser = new DirectoryChooser();
		File projectDirectory;
		projectDirectory = directoryChooser.showDialog(PackageCalculator.getInstance().getPrimaryStage());
		if (projectDirectory != null) {
			projectDirectory.getAbsolutePath();
		}
		//openProject(projectDirectory.getAbsolutePath());
	}

	static public void newFile() {

	}
	// Initializes that you can produce an Error message window if something is not fine
	static public void showError(String text) {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText(text);
		alert.showAndWait();
	}
}
