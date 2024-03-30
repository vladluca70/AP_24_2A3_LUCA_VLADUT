import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DocumentManagerApp {
    /*
     Mapare pentru a asocia numele comenzilor cu obiectele corespunzatoare de tip Command
     */
    private static final Map<String, Command> commands = new HashMap<>();

    static {
        // Inițializarea map-ului cu obiectele corespunzătoare ale comenzilor
        commands.put("view", new ViewCommand());
        commands.put("report", new ReportCommand());
        commands.put("export", new ExportCommand());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] tokens = input.split("\\s+");
            String commandName = tokens[0];

            Command command = commands.get(commandName);
            if (command == null) {
                System.out.println("Invalid command");
                continue;
            }

            try {
                command.execute(Arrays.copyOfRange(tokens, 1, tokens.length));
            } catch (InvalidCommandException | IOException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}


