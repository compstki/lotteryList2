import java.util.*;

class POSTALAREA {
    
    String postCode = "";
    int players = 0;

    // this version uses data read from file
    // parameter is a string row of csv data
    public POSTALAREA(String fileRow) {
        // separate csv items into a string array
        String[] columnDataList = fileRow.split(",");
        // store 1st item from the row
        this.postCode = columnDataList[0];
        // store last item from row
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
    
    public String getPostCodeZone() {
        return postCode.substring(0,1);
    }

    // calculate and display individual prize share
    // parameter is money to be shared
    public void sharePrize(int prizeFund) {
        System.out.println("Postcode: " + postCode);
        System.out.println("Players: " + players);
        System.out.println("Prize: " + (prizeFund / players));
    }

}