import java.util.*;
import java.io.*;
// "throws IOException" needed for methods that do file IO or call other methods that do

class Main {

    // file read and write objects
    FILEREAD fileLoader = new FILEREAD();
    WRITEFILE fileSaver = new WRITEFILE();

    // data structure to store csv file data in array of objects
    // each object stores one "row"
    POSTALAREA postalAreaList[]; 

    public void importfileRowList() throws IOException
    {
        // read file contents, store returned value as a single string
        String fileData = fileLoader.readCSVfile("postcodeData.csv");
        // use-remove line-breaks("\r\n"), split file string into rows, store into array of strings 
        String[] fileRowList = fileData.split("\r\n");
        // store how many rows were returned (size of array)
        int noOfPostRows = fileRowList.length;
        // create array, an element for each file row
        postalAreaList = new POSTALAREA[noOfPostRows];
        // use each row from file to create postcode area object, store it in the array
        for (int i = 0; i < noOfPostRows; i++) {
            postalAreaList[i] = new POSTALAREA(fileRowList[i]);
        }
    }  

    public void findMaxPlayers() {
        // set max position to first postal area in list
        int maxPlayerPosition = 0;
        // set max player to first players in first postcode in list
        int maxPlayers = postalAreaList[maxPlayerPosition].getPlayers();
        // repeat for the rest of the list
        for (int i = 1; i < postalAreaList.length; i++) {
            // if the players in the next postcode in the list is more than max players
            if (maxPlayers < postalAreaList[i].getPlayers()) {
                // update the max position to the current position
                maxPlayerPosition = i;
                // update the max players to the players in the next postcode
                maxPlayers = postalAreaList[maxPlayerPosition].getPlayers();
            }  // end if 
        }  // end loop
        // display the max player
        System.out.println("Max players is: " + maxPlayers);
    }

    public void exportGlasgowRows()  throws IOException
    {
        // to gather the text for file export
        String fileContent = "";

        // join column headings on to end of file content
        fileContent = fileContent + "PostCode" + "," + "Players";
        
        // get strings of row data from each object in the list of objects
        for (int i = 0; i < postalAreaList.length; i++) {
            // decide if this row is to be exported (Glasgow codes start with G)
            if (((postalAreaList[i].getPostCode()).substring(0,1)).equals("G")) {
                // add newline before actual row data
                fileContent = fileContent + "\n";
                // add latest row to the export string
                fileContent = fileContent + postalAreaList[i].getPostalAreaRow();                
            }
        }
        // send completed export string to the file
        fileSaver.writeCSVfile("winners.csv", fileContent);
    }

    public void displayPrizes() {
        // start the prize money at 0
        int totalPrize = 0;
        // repeat the update for every postcode in the list
        for (POSTALAREA nextPostalArea: postalAreaList) {
            // decide if this is a Glasgow postcode
            if (((nextPostalArea.getPostCode()).substring(0,1)).equals("G")) {
                // increased prize money
                totalPrize = totalPrize + 1100;
            }
            else
            {
                // normal prize money
                totalPrize = totalPrize + 1000;
            }
        }
        // output result to display
        System.out.println("Total prize: " + totalPrize);
    }

    // top level algorithm
    public void processPostCode()   throws IOException 
    { 
        // import data from file
        importfileRowList();
        // calculate most players using standard algorithm
        findMaxPlayers();
        // calculate prize money
        displayPrizes();
        // export selected data
        exportGlasgowRows();
    }

    public static void main(String[] args)  throws IOException
    {
        Main myApp = new Main();
        myApp.processPostCode();
    }
}