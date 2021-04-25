package optional.lab8;

import optional.lab8.report.ReportGenerator;
import optional.lab8.tool.ImportTool;

public class Lab8Optional {

    public static void main(String[] args) throws Exception {
        ImportTool importTool = new ImportTool();
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateReport("src/main/java/optional/lab8/resources/");
    }

}

