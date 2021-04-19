package com.thuso.shoppe.enums;

public enum ErrorMessages {
    CUSTOMER_DATA("Customer data not provided."),
    PRODUCT_DATA("Product data not provided."),
    NO_SUCH_CUSTOMER("Customer doesn't exist."),
    NO_SUCH_PRODUCT("Product doesn't exist."),
    INSUFFICIENT_FUNDS("Insufficient points.");

    private final String text;

    /**
     * @param text
     */
    ErrorMessages(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
