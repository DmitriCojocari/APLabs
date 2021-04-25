package optional.lab8.report;

import optional.lab8.dao.MovieDAO;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.awt.*;
import java.io.*;

public class ReportGenerator {

    private VelocityEngine velocityEngine;

    public ReportGenerator() {
        velocityEngine = new VelocityEngine();
    }

    public void generateReport(Object resourceDirectoryPath) throws Exception {
        initializeVelocityEngine(resourceDirectoryPath, getVelocityEngine());

        Template t = velocityEngine.getTemplate("lab8.vm");

        VelocityContext context = new VelocityContext();

        MovieDAO movieDAO = new MovieDAO();
        context.put("movies", movieDAO.getAllMovies());

        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(resourceDirectoryPath + "report.html")), "UTF8"));

        t.merge(context, out);

        Desktop d = Desktop.getDesktop();
        d.open(new File(resourceDirectoryPath + "report.html"));
        out.close();
    }

    private VelocityEngine initializeVelocityEngine(Object resourceDirectoryPath, VelocityEngine velocityEngine) {
        velocityEngine.setProperty("resource.loader", "file");
        velocityEngine.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        velocityEngine.setProperty("file.resource.loader.path", resourceDirectoryPath);
        velocityEngine.setProperty("file.resource.loader.cache", true);
        velocityEngine.setProperty("file.resource.loader.modificationCheckInterval", "2");

        velocityEngine.init();
        return velocityEngine;
    }

    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }
}
