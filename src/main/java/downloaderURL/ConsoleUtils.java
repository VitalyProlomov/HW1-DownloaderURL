package downloaderURL;

import java.io.File;
import java.util.Locale;
import java.util.Objects;

public class ConsoleUtils {
    public static void readCommand(String line) {

        String command = line.split(" ")[0].toLowerCase(Locale.ROOT).trim();

        switch (command) {
            case "/help":
                printCommands();
                break;

            case "/load":
                if (line.split(" ").length < 2) {
                    System.out.println("Please enter at least 1 URL parameter into request");
                    return;
                }

                /*
                if (Objects.equals(FileDownloader.getDownloadPath(), "")) {
                    System.out.println("Set the directory first.");
                    return;
                }
                 */
                String[] parameters = line.substring(command.length() + 1, line.length()).split(" ");
                FileDownloader.load(parameters);
                break;

            case "/dest":
                if (line.split(" ").length < 2) {
                    System.out.println("Please enter a path for directory in the same line.");
                    return;
                }

                String path = line.split(" ")[1];
                FileDownloader.setDownloadPath(path);
                break;

            case "/exit":
                return;
            // break ?
            default:
                System.out.println("Incorrect command, print /help to see commands.");
                break;
        }
    }

    public static void printCommands() {
        System.out.println("""
                Hey user! Here are some helpful commands:
                 /load <URL> - download file located in entered URL
                 /load <URL1> <URL2> <URL3> ... - download several URL files
                 /dest <PATH> change folder where to download all the files
                 /exit - finish program
                 P.S words in <> must be actual URLs and paths.
                """);
    }
}
