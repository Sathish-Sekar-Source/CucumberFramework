package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
    public static void main(String[] args) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/extent-report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        ExtentTest test = extent.createTest("Sample Test");
        test.pass("Step 1: Passed");
        test.fail("Step 2: Failed");

        extent.flush(); // Generates the report
    }
}