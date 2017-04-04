import java.util.*;

class POSTALAREA {
    
    // class properties
    String postCode = "";
    int players = 0;

    // this version uses data read from file
    // parameter is a string of csv row data
    public POSTALAREA(String fileRow) {
        // separate csv items into a string array
        String[] columnDataList = fileRow.split(",");
        // store 1st item from the row
        this.postCode = columnDataList[0];
        // store last item from row, needs to covert type from string to integer
        this.players = Integer.parseInt(columnDataList[1]);
    }
    
    // return properties as a string suitable for a CSV row
    public String getPostalAreaRow() {
        String postCodeRow = postCode + "," + String.valueOf(players);
        return postCodeRow;
    }

    public int getPlayers() {
        return players;
    }

    public String getPostCode() {
        return postCode;
    }

}