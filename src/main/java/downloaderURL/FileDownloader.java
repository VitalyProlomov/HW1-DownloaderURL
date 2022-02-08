package downloaderURL;

import java.io.File;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {
    // Path of the directory where to download files to.
    public static String downloadPath = "";

    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static String getDownloadPath() {
        return downloadPath;
    }

    /**
     * Setting current download folder (directory).
     * If given path is incorrect
     * @param downloadPath path os the directory
     */
    public static void setDownloadPath(String downloadPath) {
        try {
            File file = new File(downloadPath);
            if (file.exists()) {
                FileDownloader.downloadPath = downloadPath;
                System.out.println("Directory successfully set to " + downloadPath);
            } else {
                System.out.println("Such directory does not exist, try another");
            }

        } catch (SecurityException ex) {
            System.out.println("Security exception occurred when we tried to check if the specified directory,\n" +
                    "Directory was not set." + ex.getMessage());
        }

    }

    public static void load(String url) {
        String[] array = new String[1];
        array[0] = url;
        load(url);
    }

    public static void load(String[] parameters) {
        for (String url: parameters) {
            executorService.execute(new DownloadThread(url, downloadPath));
        }
    }

}
