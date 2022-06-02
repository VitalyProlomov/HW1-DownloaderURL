package downloaderURL;

import java.io.File;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FileDownloader {
    AtomicInteger file_name_number = new AtomicInteger(0);

    // Path of the directory where to download files to.
    private String downloadPath = "";
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    public String getDownloadPath() {
        return downloadPath;
    }

    /**
     * Setting current download folder (directory).
     * If given path is incorrect
     * @param downloadPath path os the directory
     */
    public void setDownloadPath(String downloadPath) {
        try {
            File file = new File(downloadPath);
            if (file.exists()) {
                this.downloadPath = downloadPath;
                System.out.println("Directory successfully set to " + downloadPath);
            } else {
                System.out.println("Such directory does not exist, try another");
            }

        } catch (SecurityException ex) {
            System.out.println("Security exception occurred when we tried to check if the specified directory,\n" +
                    "Directory was not set." + ex.getMessage());
        }

    }

    public void load(String url) {
        String[] array = new String[1];
        array[0] = url;
        load(array);
    }

    public void load(String[] parameters) {
        for (String url: parameters) {
            executorService.execute(new DownloadThread(url, downloadPath, file_name_number.incrementAndGet()));
        }
    }

}
