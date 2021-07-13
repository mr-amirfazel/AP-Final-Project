package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Entrance {
    private final SceneLoader sceneLoader = new SceneLoader();
    @FXML
    private Pane enterPane;
    @FXML
    private Circle bcircle1;

    @FXML
    private Circle bcircle2;

    @FXML
    private Circle bcircle3;
 @FXML
    private Circle bcircle4;

    @FXML
    void Login(ActionEvent event) {
//        try {
//            root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        String css = this.getClass().getResource("../View/StyleSheets/Phase1.css").toExternalForm();
//        scene.getStylesheets().add(css);
//        stage.setTitle("LogIn");
//        stage.setScene(scene);
//        stage.show();
        sceneLoader.goToLogin(event);
    }
    @FXML
    void goToSignUp(ActionEvent event) {
//        try {
//            root = FXMLLoader.load(getClass().getResource("../View/SignUp.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        String css = this.getClass().getResource("../View/StyleSheets/Phase1.css").toExternalForm();
//        scene.getStylesheets().add(css);
//        stage.setTitle("Sign Up");
//        stage.setResizable(false);
//        stage.setScene(scene);
//        stage.show();
        sceneLoader.goToSignUp(event);
    }
    @FXML
    void bChange1(MouseEvent event) {

        Paint lg = bcircle1.getFill();
        enterPane.setBackground(new Background(new BackgroundFill(lg,null,null)));
    }

    @FXML
    void bChange2(MouseEvent event) {
        Paint lg = bcircle2.getFill();
        enterPane.setBackground(new Background(new BackgroundFill(lg,null,null)));
    }

    @FXML
    void bChange3(MouseEvent event) {
        Paint lg = bcircle3.getFill();
        enterPane.setBackground(new Background(new BackgroundFill(lg,null,null)));
    }
    @FXML
    void bChange4(MouseEvent event) {
        Paint lg = bcircle4.getFill();
        enterPane.setBackground(new Background(new BackgroundFill(lg,null,null)));
    }
    @FXML
    void getOut(ActionEvent event) {
        Stage stage;
        stage = (Stage)enterPane.getScene().getWindow();
        stage.close();
    }



}
