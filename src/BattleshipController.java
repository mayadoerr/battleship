import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class BattleshipController {

    @FXML
    private Button resultsButton;

    @FXML
    private Text resultsText;

    @FXML
    void resultsClick(ActionEvent event) {
        int shotCounter = Main.shotCounter;

        String results;

        Main main = new Main();
        if (shotCounter < 100) {
            results = "Shots: " + shotCounter + "\nThe 0computer did pretty good.";
        }
        else if (shotCounter < 200) {
            results = "Shots: " + shotCounter + "\nThe computer did ok.";
        }else if (shotCounter < 300){
            results = "Shots: " + shotCounter + "\nThe computer did terrible.";
        } else{
            results = "Shots: " + shotCounter + "\nThe computer should hand in its CPU and never play again.";
        }
        resultsText.setText(results);

    }
}
