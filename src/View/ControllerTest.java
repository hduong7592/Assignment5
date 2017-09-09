package View;

import org.junit.Assert;

import static org.junit.Assert.*;

public class ControllerTest {
    @org.junit.Test
    public void calculateISBN(){
        String ExpectedResult = "123456789X";
        Assert.assertEquals("ERROR CALCULATING ISBN!",ExpectedResult,Controller.CalculateISBN("123456789"));
        System.out.println(Controller.CalculateISBN("123456789"));
    }

}