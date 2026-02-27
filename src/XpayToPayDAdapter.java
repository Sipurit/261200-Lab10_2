public class XpayToPayDAdapter implements PayD{
    private final Xpay xpay;
    public XpayToPayDAdapter(Xpay xpay) {
        this.xpay = xpay;
    }

    @Override // we use XpayToPayD as adapter that in middle between xpay and payD
    public long getCreditCardNo() { 
        return Long.parseLong(xpay.getCreditCardNo());
    }

    @Override
    public void setCreditCardNo(long creditCardNo) {
        xpay.setCreditCardNo(String.valueOf(creditCardNo));
    }

    @Override
    public String getCardOwnerName() {
        return xpay.getCustomerName();
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        xpay.setCustomerName(cardOwnerName);
    }

    @Override
    public String getCardExpMonthYear() {
        return xpay.getCardExpMonth() + "/" + xpay.getCardExpYear();
    }

    @Override
    public void setCardExpMonthYear(String cardExpMonthYear) {
        xpay.setCardExpMonth(cardExpMonthYear.substring(0,2));
        xpay.setCardExpYear(cardExpMonthYear.substring(2,4));
    }

    @Override
    public Integer getCVVNo() { // We use intValue since xpay.getCardCVVNo originally from Short
        return xpay.getCardCVVNo().intValue();
    }

    @Override
    public void setCVVNo(Integer cVVNo) { // We use shortValue since cVVNo originally from Integer
        xpay.setCardCVVNo(cVVNo.shortValue());
    }

    @Override
    public Double getTotalAmount() {
        return xpay.getAmount();
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        xpay.setAmount(totalAmount);
    }
}
