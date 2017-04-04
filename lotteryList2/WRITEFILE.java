import java.io.*;
// "throws IOException" needed for methods that do file IO or call other methods that do
public class WRITEFILE
{
    // file writer object
    private FileWriter fWriter;

    // fileContent will have all the text to store
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