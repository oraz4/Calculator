package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Calculator extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Calculator");

        //ImageIcon logo  = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("calculator.png")));
        //JFrame window = new JFrame();
        //window.setIconImage(logo.getImage());
        stage.getIcons().add(new Image("calculator.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}