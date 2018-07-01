package entity;

import java.util.Date;

/**
 * Created by xixi on 2018/6/20.
 */
public class OrderInfo {
    private int orderID;
    private int productID;
    private User user;
    private int amount;
    private double totalMoney;
    private String remark;
    private String requiredDate;
    private String createdDate;
    private int orderType;
    private String deliveryAddress;
    private String receiverName;
    private String receiverTelephone;
    private int receiverPostcode;
    private int billNeeded;
    private String payerName;
    private String payerAddress;
    private String payerTelephone;
    private int payerPostcode;
    private int status;
    private int operatorID;
    private String operateDate;
    private String firstCategory;
    private String secondCategory;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverTelephone() {
        return receiverTelephone;
    }

    public void setReceiverTelephone(String receiverTelephone) {
        this.receiverTelephone = receiverTelephone;
    }

    public int getReceiverPostcode() {
        return receiverPostcode;
    }

    public void setReceiverPostcode(int receiverPostcode) {
        this.receiverPostcode = receiverPostcode;
    }

    public int getBillNeeded() {
        return billNeeded;
    }

    public void setBillNeeded(int billNeeded) {
        this.billNeeded = billNeeded;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerAddress() {
        return payerAddress;
    }

    public void setPayerAddress(String payerAddress) {
        this.payerAddress = payerAddress;
    }

    public String getPayerTelephone() {
        return payerTelephone;
    }

    public void setPayerTelephone(String payerTelephone) {
        this.payerTelephone = payerTelephone;
    }

    public int getPayerPostcode() {
        return payerPostcode;
    }

    public void setPayerPostcode(int payerPostcode) {
        this.payerPostcode = payerPostcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(String firstCategory) {
        this.firstCategory = firstCategory;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductOriginal_price() {
        return productOriginal_price;
    }

    public void setProductOriginal_price(double productOriginal_price) {
        this.productOriginal_price = productOriginal_price;
    }

    public String getProductMeasure() {
        return productMeasure;
    }

    public void setProductMeasure(String productMeasure) {
        this.productMeasure = productMeasure;
    }

    public String getProductdiscount() {
        return productdiscount;
    }

    public void setProductdiscount(String productdiscount) {
        this.productdiscount = productdiscount;
    }

    public double getTotalMoneyAfter() {
        return totalMoneyAfter;
    }

    public void setTotalMoneyAfter(double totalMoneyAfter) {
        this.totalMoneyAfter = totalMoneyAfter;
    }

    public String getProductRemarks() {
        return productRemarks;
    }

    public void setProductRemarks(String productRemarks) {
        this.productRemarks = productRemarks;
    }

    private String productName;
    private double productOriginal_price;
    private String productMeasure;
    private String productdiscount;
    private double totalMoneyAfter;
    private String productRemarks;




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
