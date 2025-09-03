package marvin.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import marvin.Marvin;

/**
 * Controller for the main GUI.
 */
public class MainWindow {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Marvin marvin;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private final Image marvinImage = new Image(this.getClass().getResourceAsStream("/images/marvin.png"));

    @FXML
    public void initialize() {
        // bind vbox height to scrollpane vvalue, so it scrolls down once the dialog container gets bigger.
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Marvin instance */
    public void setMarvin(Marvin m) {
        marvin = m;
    }

    /**
     * Creates two dialog boxes, one containing the user's input and the other containing Marvin's reply,
     * and then appends them to the dialog container. Clears user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String marvinReply = marvin.getResponse(input);

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getMarvinDialog(marvinReply, marvinImage)
        );

        userInput.clear();
    }
}
