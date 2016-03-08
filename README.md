# ttpt
Here's the tech test. Clone and run mvn clean install
For the Web Service test, you will need SoapUI and to import the given SoapUI project.

## Integer array task: 
run the IntegerArrayTaskTest.java as JUnit test

## Web front end (Selenium) task: 
run WebFrontEndTest.java as JUnit test

NB to run successfully you will have to set up a ChromeDriver in the appropriate location

## Web service task: 
use the attached SoapUI project (in src/test/resources) to run the test
(I used SoapUI as it's easier to build SOAP requests that way. I did not have time to create a SOAP client from scratch in Java)

Project name: Webservicex-net-soapui-project.xml
Run test case:
Test Suite -> Get UK locations for county of Kent

Currrently just asserts that the data contains XML referring to Kent.

That's all...
