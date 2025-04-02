package com.opentab;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane; // Import for popup GUI

public class AutoCloseChromeTab {
    public static void main(String[] args) {
        String userName = System.getProperty("user.name");

        try {
            String filePath_86 = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"; 
            String filePath_64 = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            String filePath_Appdata = "C:\\Users\\" + userName + "\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
            // Check if Chrome is already running
            File file_86 = new File(filePath_86);
            File file_64 = new File(filePath_64);
            File file_apdata = new File(filePath_Appdata);
            
            String chromePath = null;
            
            // Check for Chrome in 32-bit installation
            if (file_86.exists()) {
                chromePath = filePath_86;
                System.out.println("Chrome version 32 bit");
            }
            // Check for Chrome in 64-bit installation
            else if (file_64.exists()) {
                chromePath = filePath_64;
                System.out.println("Chrome version 64 bit");
            }
            // Check for Chrome in AppData (user-specific installation)
            else if (file_apdata.exists()) {
                chromePath = filePath_Appdata;
                System.out.println("Chrome version AppData");
            }

            // If no Chrome path is found, show an alert popup
            if (chromePath == null) {
                
                return; // Exit if Chrome is not found
            }

            // Launch Chrome with tabs
            Thread.sleep(1000);
            Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors h4ttps://dcallcenter.noblesoft");
            Thread.sleep(1000);
            Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-pri.noblesoft:8089/ws");
            Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-sec.noblesoft:8089/ws");

            Thread.sleep(2000);                
            Robot robot = new Robot();

            // Close tabs using keyboard shortcuts
            closeTab(robot);
            closeTab(robot);
        } catch (IOException | InterruptedException | AWTException e) {
            e.printStackTrace();
        }
    }

    // Method to close a tab using the keyboard shortcut (Ctrl + W)
    private static void closeTab(Robot robot) throws InterruptedException {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);  // Wait a bit
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
