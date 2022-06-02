package downloaderURL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadThread implements Runnable {
    String fileURL;

    // Stored here to preventing updating information about directory in
    // unnecessary time.
    String directoryPath;

    int name_number;

    DownloadThread(String url, String directoryPath, int name_number) {
        fileURL = url;
        this.directoryPath = directoryPath;
        this.name_number = name_number;
    }

    @Override
    public void run() {
        try (ReadableByteChannel byteChannel = Channels.newChannel(new URL(fileURL).openStream())) {
            String format = fileURL.split("\\.")[fileURL.split("\\.").length - 1];
            FileOutputStream fileOutputStream = new FileOutputStream(
                    directoryPath + File.separatorChar +
                         "new_file_" + name_number + "." + format
            );

            fileOutputStream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
            System.out.println("File with url " + fileURL + " loaded successfully.");
        } catch (FileNotFoundException ex) {
            System.out.println("Could not save file to the " + directoryPath + "directory");

        } catch (IOException ex) {
            System.out.println("Some unforeseeable mistake occurred.");
        }

    }
}
