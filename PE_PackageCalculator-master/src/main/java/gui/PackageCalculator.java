package gui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class PackageCalculator extends Application {

	public final static String APPNAME = "PackageCalculator";
	
	// singleton
	private static PackageCalculator instance;
	public static PackageCalculator getInstance() {
		return instance;
	}
	
    //  initialising gui areas
	public ToolbarArea toolbarArea = new ToolbarArea();
	public ExplorerArea explorerArea = new ExplorerArea();
	public CalculatorArea editorArea = new CalculatorArea();;
	public InspectorArea inspectorArea = new InspectorArea();
	public MessagesArea messagesArea = new MessagesArea();
	public StatusArea statusArea = new StatusArea();

	// root path to current open project
	public String rootPath;
	
	// remember stage for subwindows
	private Stage primaryStage;
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) {
		// remember singleton instance (instantiated by javafx)
		PackageCalculator.instance = this;
		
		// remember stage for subwindows
		this.primaryStage = primaryStage;
		
		// lr2SplitPane
		SplitPane lr2SplitPane = new SplitPane();
		lr2SplitPane.getItems().addAll(editorArea, inspectorArea);
		lr2SplitPane.setDividerPositions(0.8f, 0.2f);
		
		// tdSplitPane
		SplitPane tdSplitPane = new SplitPane();
		tdSplitPane.setOrientation(Orientation.VERTICAL);
		tdSplitPane.getItems().addAll(lr2SplitPane, messagesArea);
		tdSplitPane.setDividerPositions(0.9f, 0.1f);
		
		// lrSplitPane
		SplitPane lrSplitPane = new SplitPane();
		lrSplitPane.getItems().addAll(explorerArea, tdSplitPane);
		lrSplitPane.setDividerPositions(0.2f, 0.8f);
		
		// add all areas
		BorderPane mainPane = new BorderPane();
		mainPane.setTop(toolbarArea);
		mainPane.setCenter(lrSplitPane);
		mainPane.setBottom(statusArea);

		// show main pane
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene scene = new Scene(mainPane, screenBounds.getWidth(), screenBounds.getHeight(), true);
		primaryStage.setTitle(APPNAME);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// load default workspace
		//ProjectHandling.openProject("/Users/...");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
