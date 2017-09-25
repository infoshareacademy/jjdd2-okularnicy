import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {

    private List<String> fileList;
    private String pathToZip = "testdata/zip/omeganbp.zip";
    private String pathToOutputFolder = "testdata/zip/unzip/";


    public void unZipIt(String zipFile, String outputFolder){

        byte[] buffer = new byte[1024];

        File folder = new File(outputFolder);
        if(!folder.exists()){
            folder.mkdir();
        }

        ZipInputStream zipInputStream = null;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while(zipEntry!=null){

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }







    }




}
