/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import templater.PageGenerator;

/**
 *
 * @author Sergey_Prig
 */
public class PageGeneratorTest {
    
    public PageGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void testGetPage() 
     {
        String emailKey = "email";
        String passwordKey = "password";
        String email = "email";
        String password = "password";
        String filetemplate = "authresponse.txt";
        String resJsonTrue = "{\n" + "status: 200,\n" + "body: {\n" +emailKey+": \""+email+"\",\n" +passwordKey+": \""+password+"\"\n" + "}\n" + "}";      
        
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put(emailKey, email);
        pageVariables.put(passwordKey, password);
        String res = PageGenerator.getPage(filetemplate, pageVariables);
        
        assertEquals(resJsonTrue, res);
     }
}
