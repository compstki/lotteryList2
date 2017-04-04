// link GUI libraries
import javax.swing.*;
// link file handling libraries
import java.io.*;

public class WRITEFILE
{
    // file writer object
    private FileWriter fWriter;

    // outbuffer will have the text to store
    public void writeCSVfile(String filename, String fileContent) throws IOException
    {
        // open the new file
        fWriter = new FileWriter(filename);
        // write the data to the file
        fWriter.write(fileContent);
        // close the file
        fWriter.close();
    }
}