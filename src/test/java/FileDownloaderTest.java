import downloaderURL.FileDownloader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.Objects;


public class FileDownloaderTest {

    public static String testingDirectoryPath = Path.of("").toAbsolutePath().toString();;

    @Test
    public void fileDownloadershouldDownloadCorrectAmountOfBytes() {
        FileDownloader fileDownloader = new FileDownloader();
        String url = Objects.requireNonNull(getClass().getResource("/hqdefault.jpg")).toString();

        File file = new File("D:\\HSE\\2nd course\\KPO\\[SECOND_MODULE]_Seminar_HW\\HW1(DownloaderURL)\\src\\test\\resources");
        System.out.println(file.exists());
        System.out.println(file.getTotalSpace());

        File file2 = new File("/hqdefault");
        System.out.println(file2.exists());
        System.out.println(file2.getTotalSpace());

        fileDownloader.load(url);
    }
}
