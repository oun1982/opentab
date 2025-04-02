package com.opentab;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class AutoCloseChromeTabAddAppdata {
    public static void main(String[] args) {
    	String userName = System.getProperty("user.name");
        try {
        	String filePath_86 = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"; 
            String filePath_64 = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            String filePath_Appdata = "C:\\Users\\"+userName+"\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
            
          
            File file_86 = new File(filePath_86);
            File file_64 = new File(filePath_64);
            File file_appdata = new File(filePath_Appdata);
            
            if(file_86.exists()) {
            	String chromePath = filePath_86;
            	Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://dcallcenter.noblesoft");
                Thread.sleep(1000);
                Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-pri.noblesoft:8089/ws");
                Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-sec.noblesoft:8089/ws");
                System.out.println("Chrome version 32 bit");
                
            }else if (file_64.exists()){
            	String chromePath = filePath_64;
            	Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://dcallcenter.noblesoft");
                Thread.sleep(1000);
                Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-pri.noblesoft:8089/ws");    
                Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-sec.noblesoft:8089/ws");
                System.out.println("Chrome version 64 bit");
                
            }else if (file_appdata.exists()) {
            	String chromePath = filePath_Appdata;
            	Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://dcallcenter.noblesoft");
                Thread.sleep(1000);
                Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-pri.noblesoft:8089/ws");    
                Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-sec.noblesoft:8089/ws");
                System.out.println("Chrome version 64 bit");
                
            }else {
            	JOptionPane.showMessageDialog(null, "Chrome executable not found on this system. Please install Chrome.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
    
            Thread.sleep(2000);                
            Robot robot = new Robot();

            // Switch to the second tab (Ctrl + Tab or Ctrl + PgDn)
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            Thread.sleep(1000);  // Wait a bit to make sure the tab switches

//             Close the second tab (Ctrl + W)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);  // Wait a bit

            // Switch to the third tab (Ctrl + Tab again)
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            Thread.sleep(1000);  // Wait a bit

            // Close the third tab (Ctrl + W)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        } catch (IOException | InterruptedException | AWTException e) {
            e.printStackTrace();
        }
    }

    // Method to check if Chrome is running
    private static boolean isChromeRunning() throws IOException {
        String line;
        Process process = Runtime.getRuntime().exec("tasklist");
        java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
        while ((line = input.readLine()) != null) {
            if (line.contains("chrome.exe")) {
                return true; // Chrome is running
            }
        }
        return false; // Chrome is not running
    }
}
