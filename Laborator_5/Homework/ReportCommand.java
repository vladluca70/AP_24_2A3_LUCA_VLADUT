import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

class ReportCommand implements Command {
    @Override
    public void execute(String[] args) throws InvalidCommandException, IOException {
        if (args.length != 1) {
            throw new InvalidCommandException("Error");
        }

        String masterDirectory = args[0];
        File directory = new File(masterDirectory);

        if (!directory.exists() || !directory.isDirectory()) {
            throw new InvalidCommandException("Invalid directory: " + masterDirectory);
        }

        File reportFile = new File("report.html");
        PrintWriter writer = new PrintWriter(reportFile);

        /*
        * formarea documentului HTML
        * */
        writer.println("<html>");
        writer.println("<head><title>Employee Report</title></head>");
        writer.println("<body>");
        writer.println("<h1>Employee Report</h1>");
        writer.println("<ul>");

        for (String employee : directory.list()) {
            writer.println("<li>" + employee + "</li>");
        }

        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");

        writer.close();
        /*deschid fisierul HTML in browser*/
        Desktop.getDesktop().open(reportFile);
    }
}


