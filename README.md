# Screen Object Model Framework

Screen Object Modle is a design pattern that has become popular in test automation for enhancing test maintenance and reducing code duplication especially in Mobile UI Automation.
In this framework the tests use the screen object class methods to interact with the UI of the page. If the page UI changes, then the tests need not be changed, only the code within the screen object needs to be changed. 
All the changes that support the new UI are located in one place. Hence, locators and test scripts are stored separately.


**Tools and technologies used:**

1. Language: Java
2. Testing framework: Testng
3. TDD framework: Screen Object Model
4. Automation tool: Selenium-Appium
5. Build tool: maven
6. Reporting: ExtentReport


**Setting up the project**

1. Install latest java
    - https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
    
2. Once Installed verify by hitting the command on Terminal:

       $ java -version
    
3. Download and install maven 
    - https://maven.apache.org/download.cgi
  
4. Set M2_HOME and JAVA_HOME in ~/.bash_profile
    - https://www.youtube.com/watch?v=j0OnSAP-KtU
    - https://www.youtube.com/watch?v=0gceUrMnjzo

5. Download and install Appium

        Make sure `npm` is installed beforehand
        Hit the below command on Terminal to verify:
            - npm -v
        
        OnTerminal:
            npm install -g appium
            appium -v
6. Start Appium server and Connect device/emulator:
        
        #OnTerminal:
            1. appium - Will launch appium on port: 4723
            
            2. appium -p 4725 - Will launch on the port you specify.
            Note: you need to run appium on different port for Anroid
            
         #Configure emulator:
            1. Hit the command on Terminal to know how many devices are configured on Android Studio:
                - emulator -list-avds
            2. Hit the below command to launch emulator:
                - emulator -avd <Name of available device> e.g. emulator -avd Pixel_4_Latest
            3. In case of appium desktop build if error is thrown try: 
                - adb kill-server; adb start-server
             
   **Note: Make sure that the virtual devices are configured in Android studio before running the above commands. https://developer.android.com/studio/run/managing-avds**                 
      
7. Download Eclipse or Intellij and install

        - Download and install intellij; https://www.jetbrains.com/idea/download/?section=windows
        - Once installed, we must install some plugin
        - Go to Intellij IDEA -> Preferences -> plugins -> Marketplace
        - Search "testNg" and install
        
8. Clone the project: 
        
        Open Terminal 
        $ cd <Name of the local folder ex..Document>
        $documents> git clone https://github.com/kajalrahi/Truecaler
   
10. Open the project in intellij
        
        File -> Open -> <local folder> -> Truecaller
        
11. Don't forget to Download Truecaller app from Play store in device/emulator connected with Android studio      
        
12. Execution of tests

**Follow the below steps to execute the test**

 **Run individual Test:**

    We can run individual test by visiting /src/test/java/test/onboarding/RegisterUserTest.java
    
    1. Click on the triangle available to the Left of the test you want to execute and select `Run`

    2. Select the test name from the dropdown on the Title bar and click on the Run(>) icon to its Right

 **Reporting Mechanism:**
 
   Reports are designed using ExtentReporter and can be accessed visiting the file:
   - /report/Truecaller_report.html

   
