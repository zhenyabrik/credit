#Project structure description:


---credit
|   .classpath
|   .project
|   credit.iml
|   local.log
|   log.out
|   pom.xml

+---.idea
+---config
|       testng.xml
|       
+---src
|   \---test
|       +---java
|       |   \---ua
|       |       \---com
|       |           \---sravnizajm
|       |               +---config
|       |               |       BasePage.java
|       |               |       BaseTest.java
|       |               |       Driver.java
|       |               |       
|       |               +---ua.com.sravnizajm.pages
|       |               |       MyWalletNetUaPage.java
|       |               |       SravniZaymPage.java
|       |               |       
|       |               +---tests
|       |               |       CreditTest.java
|       |               |       
|       |               \---utils
|       |                       Constants.java
|       |                       Functions.java
|       |                       Log.java
|       |                       TestListener.java
|       |                       Timeouts.java
|       |                       Wait.java
|       |                       
|       \---resources
|           |   log4j.properties
|           |   RedmeFile.md
|           |   
|           \---driver
|                   chromedriver.exe

* Set Up Environment

- Setup Java 8 and Maven 3.5.0 on your PC;
- Setup installed Intellij IDEA;

* Run test

1.	Open Maven Project in Intellij IDEA
2.	Click on 'clean' 
3.	Click on 'test' 

* Generate report:

C:\PROJECTS\tz\target\surefire-reports\index.html
   
   
	
 