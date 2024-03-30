import java.io.IOException;

interface Command {
    void execute(String[] args) throws InvalidCommandException, IOException;
}


