import java.awt.*;
import java.io.File;
import java.io.IOException;

class ViewCommand implements Command {
    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (args.length != 1) {
            throw new InvalidCommandException("Usage: view <document_path>");
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            throw new InvalidCommandException("File does not exist: " + args[0]);
        }

        /*deschid fisierul*/
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


