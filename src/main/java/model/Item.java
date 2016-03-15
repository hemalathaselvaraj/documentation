package model;

/**
 * Created by rajeshbabuk on 3/4/16.
 */
public class Item {

    private String itemBarcode;
    private String customerCode;
    private String transitStatus;

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getTransitStatus() {
        return transitStatus;
    }

    public void setTransitStatus(String transitStatus) {
        this.transitStatus = transitStatus;
    }
}
