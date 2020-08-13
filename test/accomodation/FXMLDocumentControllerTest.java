/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodation;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Crazydude
 */
public class FXMLDocumentControllerTest {
    
    public FXMLDocumentControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of closeTab method, of class FXMLDocumentController.
     */
    @Test
    public void testCloseTab() {
        System.out.println("closeTab");
        MouseEvent event = null;
        LoginController instance = new LoginController();
        instance.closeTab(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class FXMLDocumentController.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        ActionEvent event = null;
        LoginController instance = new LoginController();
        instance.login(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
