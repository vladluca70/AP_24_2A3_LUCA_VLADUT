import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

class ExportCommand implements Command {
    @Override
    public void execute(String[] args) throws InvalidCommandException, IOException {
        if (args.length != 1) {
            throw new InvalidCommandException("Error");
        }

        String masterDirectory = args[0];
        File directory = new File(masterDirectory);

        if (!directory.exists() || !directory.isDirectory()) {
            throw new InvalidCommandException("Invalid master directory: " + masterDirectory);
        }

        File jsonFile = new File("repository.json");
        PrintWriter writer = new PrintWriter(jsonFile);

        /*exportare fisier in format JSON*/
        writer.println("[");
        File[] files = directory.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                writer.println("  \"" + files[i].getName() + "\"" + (i < files.length - 1 ? "," : ""));
            }
        }
        writer.println("]");

        writer.close();

        System.out.println("Repository exported to repository.json");
    }
}


