# ll_code_challenge

##Intellij Download
https://www.jetbrains.com/idea/#chooseYourEdition

##Maven Install
https://maven.apache.org/download.cgi

##JDK 1.8
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

## Supported browsers
- Firefox (Latest version)
- Chrome (Latest version)

Project can be opened as maven project from Intellij, then from the terminal you can run the following command in order to download the driver binaries
mvn clean test -DsuiteXmlFile=testng.xml

The previous command should run the tests


Note:
Regarding the second scenario I added a new tests because I saw that Delete is not working if a search is executed, so I added delete with/without search

From IntelliJ you can go to the testng.xml file, right click and select the option run tests.

Here's a video of the executed tests
https://screencast.com/t/AaGeiFyyL