package View;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    /**
     * Declare all of the objects in the View
     */
    @FXML
    private Button SubmitBtn;
    @FXML private Label AssignmentDetail;
    @FXML private Label Result;
    @FXML private TextField InputTxt;

    /**
     * This method will be run when the program start
     * It will show the description of the assignment
     */
    @FXML private void initialize() {
        String Assignment5 = "Problem 5.36: (Business application: checking ISBN ) Use loops to simplify Programming Exercise 3.9.";

        AssignmentDetail.setText(Assignment5);
        InputTxt.setFocusTraversable(false);
    }

    /**
     * This method will trigger when the Submit button is clicked
     */
    @FXML public void SubmitBtn_Click(){

        String ErrorMessage;
        String InputValue = InputTxt.getText();

        /**
         * Check the input value
         */
        if(InputValue.trim().isEmpty())
        {
            /**
             * If the input is empty or null, request user to enter 9 digits value
             */
            ErrorMessage = "Input value is missing.";
            infoBox(ErrorMessage, "Error!!!", null);
            InputTxt.requestFocus();
        }
        else if(InputValue.length() != 9)
        {
            /**
             * If the input value larger of smaller than 9 digits, ask user to enter 9 digits only
             */
            ErrorMessage = "Please enter total 9 digits!";
            infoBox(ErrorMessage, "Error!!!", null);
            InputTxt.requestFocus();
        }
        else {

            /**
             * Check if all of the digits are integer.
             */
            try {

                Integer.parseInt(InputValue);
                /**
                 * All of the digits can be safely converted to integer, accept the value
                 * Calculate the ISBN with that value
                 */
                Result.setText("ISBN 10: "+CalculateISBN(InputValue));

            } catch (Exception e) {
                /**
                 * Input value can not be converted to integer, request user to enter 9 numbers only
                 */
                ErrorMessage = "The input is not a valid number. Please enter number only!";
                infoBox(ErrorMessage, "Error!!!", null);
                InputTxt.clear();
                InputTxt.requestFocus();
            }
        }
    }

    /**
     * This method will calculate the ISBN 10
     * @param inputValue
     */
    @FXML public static String CalculateISBN(String inputValue) {
        String FinalISBN = "";
        if(inputValue.length() == 9)
        {
            int Sum = 0;

            /**
             * Create a loop to loop through the index of the value
             * At each index, get the char and convert it to interge
             * Then multiply that number with the index + 1 value, since the index start at 0
             * And first digit is supposed to multiply to 1
             */
            for(int i=0; i < inputValue.length(); i++)
            {
                Character CharAtIndex = inputValue.charAt(i);
                int DigitValue = Integer.parseInt(CharAtIndex.toString());
                Sum += DigitValue * MultiplyValue(i);
            }

            Sum = Sum % 11;
            if(Sum == 10)
            {
                /**
                 * If the Sum == 10, then return it as X
                 */
                FinalISBN = inputValue + "X";
            }
            else
            {
                /**
                 * Else just return as normal number
                 */
                FinalISBN = inputValue + Sum;
            }
        }
        return  FinalISBN;
    }

    /**
     * This method will show the alert box
     * @param infoMessage
     * @param titleBar
     * @param headerMessage
     */
    @FXML private void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    @FXML public static int MultiplyValue(int IndexValue)
    {
        return IndexValue + 1;
    }
}
