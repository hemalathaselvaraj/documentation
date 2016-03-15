package model;

/**
 * Created by rajeshbabuk on 3/4/16.
 */
public class Request {

    private String patronName;
    private String itemBarcode;
    private String requestPosition;

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public String getRequestPosition() {
        return requestPosition;
    }

    public void setRequestPosition(String requestPosition) {
        this.requestPosition = requestPosition;
    }
}
