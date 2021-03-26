package optional.lab5.command;

import optional.lab5.command.Command;
import optional.lab5.model.Catalog;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.awt.*;
import java.io.*;

public class ReportCommand implements Command {

    private Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute(Object resourceDirectoryPath) throws Exception {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("resource.loader", "file");
        velocityEngine.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        velocityEngine.setProperty("file.resource.loader.path", resourceDirectoryPath);
        velocityEngine.setProperty("file.resource.loader.cache", true);
        velocityEngine.setProperty("file.resource.loader.modificationCheckInterval", "2");

        velocityEngine.init();

        Template t = velocityEngine.getTemplate("lab5.vm");

        VelocityContext context = new VelocityContext();
        context.put("items", getCatalog().getItems());

        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(resourceDirectoryPath + "report.html")), "UTF8"));

        t.merge(context, out);

        Desktop d = Desktop.getDesktop();
        d.open (new File (resourceDirectoryPath + "report.html"));
        out.close();
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
