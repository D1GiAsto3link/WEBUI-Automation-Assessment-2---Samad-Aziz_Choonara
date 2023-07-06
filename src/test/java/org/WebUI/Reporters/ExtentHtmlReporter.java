package org.WebUI.Reporters;


public class ExtentHtmlReporter {


    public ExtentHtmlReporter(String s) {
this.htmlreporter();
    }

    public void htmlreporter(){

        ExtentHtmlReporter htmlReporter =  new
                ExtentHtmlReporter(System.getProperty("C:\\Users\\Digi_WS\\IdeaProjects\\Redo of Toolsqa\\src\\test\\java\\org\\toolsqa\\Reporters")
                +"/Reporters/extentReport.html");


    }



}
