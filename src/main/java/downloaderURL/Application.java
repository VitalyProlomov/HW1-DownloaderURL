package downloaderURL;

import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hey user, this is file downloader.\n" +
                "If you are new here or just want know all commands, print '/help'.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("/exit")) {
            ConsoleUtils.readCommand(input);
            input = scanner.nextLine();
        }

        System.out.println("Bye!");
    }
}
