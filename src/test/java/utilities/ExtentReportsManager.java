package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportsManager implements ITestListener {

    ExtentSparkReporter sparkReporter;
    ExtentReports report;
    ExtentTest test;
    String fileName;

    public void onStart(ITestContext context) {
        // File Name Creation
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        fileName = "Test-Report-" + timestamp + ".html";

        // Setting Reports Name and Theme
        sparkReporter = new ExtentSparkReporter(".\\Reports\\" + fileName);
        sparkReporter.config().setDocumentTitle("OpenCartV01 Automation Report");
        sparkReporter.config().setReportName("OpenCartV01 Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        report = new ExtentReports();
        report.attachReporter(sparkReporter);
        report.setSystemInfo("Application", "OpenCart");
        report.setSystemInfo("Module", "Admin");
        report.setSystemInfo("Sub Module", "Customers");
        report.setSystemInfo("User Name", System.getProperty("user.name"));
        report.setSystemInfo("Environment", "QA");

        String os = context.getCurrentXmlTest().getParameter("os");
        report.setSystemInfo("Operating System", os);

        String browser = context.getCurrentXmlTest().getParameter("browser");
        report.setSystemInfo("Browser", browser);

        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            report.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    public void onTestSuccess(ITestResult result) {
        test = report.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " got passed");
    }

    public void onTestFailure(ITestResult result) {
        test = report.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try{
            String fileName = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(fileName);
        }catch (Exception ignored){
            ignored.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = report.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " got skipped");
        test.log(Status.FAIL, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) {
        report.flush();

        String reportPath = System.getProperty("user.dir") + "\\Reports\\" + fileName;
        File reportName = new File(reportPath);
        try {
            Desktop.getDesktop().browse(reportName.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
