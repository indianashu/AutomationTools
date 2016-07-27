package com.ilabs.afv.locators;

/**
 * Created by habi.ravi on 10/15/2014.
 */
public enum InteractionStatus {
    INITIAL_INQUIRY(1),
    DECISIONING_STAGE(2),
    LOOKING_FOR_DEAL_DISCOUNT(3),
    CAN_CLOSE_WITH_FOLLOW_UP(4),
    SALE(5), UNCERTAIN_NO_SALE(6);
    private final int value;

    private InteractionStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
