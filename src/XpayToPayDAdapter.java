public class XpayToPayDAdapter implements PayD{
    private final Xpay xpay;
    public XpayToPayDAdapter(Xpay xpay) {
        this.xpay = xpay;
    }

    @Override
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
        return xpay.getCardExpMonth() + xpay.getCardExpYear();
    }

    @Override
    public void setCardExpMonthYear(String cardExpMonthYear) {
        xpay.setCardExpMonth(cardExpMonthYear.substring(0,2));
        xpay.setCardExpYear(cardExpMonthYear.substring(2,4));
    }

    @Override
    public Integer getCVVNo() {
        return xpay.getCardCVVNo().intValue();
    }

    @Override
    public void setCVVNo(Integer cVVNo) {
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
