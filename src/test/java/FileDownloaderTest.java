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

    @Before
    public void setTestingDirectoryPath() {
        FileDownloader.setDownloadPath(testingDirectoryPath);
    }


    @Test
    public void shouldDownloadExistingInternetPhotoToCurrentFolder() throws MalformedURLException {
        String url = Objects.requireNonNull(getClass().getResource("hqdefault.jpg")).toString();

        FileDownloader.load(url);

        File downloadedFile = new File(String.valueOf(getClass().getResource("hqdefault.jpg")));

        assertEquals(getClass().getResource("hqdefault.jpg")..getFile(), downloadedFile);

    }
}
