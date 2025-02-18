package com.opentab;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class AutoCloseChromeTab2 {
    public static void main(String[] args) {
        try {
            // Path to the Chrome executable
            String chromePath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"; 
//            String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            // Check if Chrome is already running
            if (!isChromeRunning()) {
//                // Chrome isn't running, so we start it
//                ProcessBuilder processBuilder1 = new ProcessBuilder(chromePath, "--new-window", "--ignore-certificate-errors", "https://dcallcenter.noblesoft");
//                processBuilder1.start();
//                ProcessBuilder processBuilder2 = new ProcessBuilder(chromePath, "--new-tab", "--ignore-certificate-errors", "https://freepbx-pri.noblesoft:8089/ws");
//                processBuilder2.start();
//                ProcessBuilder processBuilder3 = new ProcessBuilder(chromePath, "--new-tab", "--ignore-certificate-errors", "https://freepbx-sec.noblesoft:8089/ws");
//                processBuilder3.start();
            } else {
                // Chrome is already running, just open new tabs
                Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://dcallcenter.noblesoft");
                Thread.sleep(3000);
                Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-pri.noblesoft:8089/ws");
                Thread.sleep(3000);
                Runtime.getRuntime().exec(chromePath + " --new-tab --ignore-certificate-errors https://freepbx-sec.noblesoft:8089/ws");
                Thread.sleep(3000);
                
            }
            
//            Thread.sleep(2000);
            // Wait for a few seconds to allow the tabs to open
//            Thread.sleep(3000); // Adjust the time as needed

            // Create a Robot instance to simulate keyboard input
            Robot robot = new Robot();

            // Switch to the second tab (Ctrl + Tab or Ctrl + PgDn)
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            Thread.sleep(1000);  // Wait a bit to make sure the tab switches

            // Close the second tab (Ctrl + W)
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_W);
//            robot.keyRelease(KeyEvent.VK_W);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            Thread.sleep(1000);  // Wait a bit

            // Switch to the third tab (Ctrl + Tab again)
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            Thread.sleep(1000);  // Wait a bit

            // Close the third tab (Ctrl + W)
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_W);
//            robot.keyRelease(KeyEvent.VK_W);
//            robot.keyRelease(KeyEvent.VK_CONTROL);

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
