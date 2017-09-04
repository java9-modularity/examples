package javamodularity.easytext.gui;

import java.util.ServiceLoader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javamodularity.easytext.algorithm.api.Analyzer;
import static javamodularity.easytext.algorithm.api.Preprocessing.toSentences;

public class Main extends Application {

    private static Iterable<Analyzer> analyzers;
    private static ComboBox<String> algorithm;
    private static TextArea input;
    private static Text output;
    private static String sampleText;

    public static void main(String[] args) {
        analyzers = ServiceLoader.load(Analyzer.class);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EasyText");
        Button btn = new Button();
        btn.setText("Calculate");
        btn.setOnAction(event ->
          output.setText(analyze(input.getText(), (String) algorithm.getValue()))
        );

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(3));
        vbox.setSpacing(3);
        Text title = new Text("Choose an algorithm:");
        algorithm = new ComboBox<>();
        for(Analyzer analyzer: analyzers) {
            algorithm.getItems().add(analyzer.getName());
        }

        vbox.getChildren().add(title);
        vbox.getChildren().add(algorithm);
        vbox.getChildren().add(btn);

        input = new TextArea();
        input.setText(sampleText);
        output = new Text();
        BorderPane pane = new BorderPane();
        pane.setRight(vbox);
        pane.setCenter(input);
        pane.setBottom(output);
        primaryStage.setScene(new Scene(pane, 300, 250));
        primaryStage.show();
    }

    private String analyze(String input, String algorithm) {
        for(Analyzer analyzer: analyzers) {
            if(analyzer.getName().equals(algorithm)) {
                return algorithm + ": " + analyzer.analyze(toSentences(input));
            }
        }

        return "No analyzer found for " + algorithm;
    }

    static {
      try {
        sampleText = new String (java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("testinput.txt")));
      } catch (java.io.IOException ioe) {
        sampleText = "Paste text here";
      }
    }
}
