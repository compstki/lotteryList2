import java.io.*;
// "throws IOException" needed for methods that do file IO or call other methods that do
public class FILEREAD
{
    // parameter is the name of the text file (CSV) to be read
    public  String readCSVfile(String fileName) throws IOException {
        // set aside storage for 5000 characters from a text file
        char[] inBuffer = new char[5000];
        // open the file using a FileReader object and the file name
        FileReader fReader = new FileReader(fileName);
        // read the data from backing storage file, store the number of characters read
        int size = fReader.read(inBuffer); 
        // close the file
        fReader.close();
        // convert the text to a string, trim off empty characters 
        String fileContent = String.valueOf(inBuffer).substring(0,size);
        // return file contents as a single string
        return fileContent;
    }
}