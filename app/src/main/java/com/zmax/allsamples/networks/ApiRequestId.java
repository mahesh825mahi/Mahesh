package com.zmax.allsamples.networks;

/**
 * Created by BMS2 on 10/14/2015.
 */
public enum ApiRequestId
{
    LOGIN(1),WORKSHOP_REACH(2), SERVICE_CHECK(3) ,CONFIRM_ORDERS(4),DRIVERS_LIST(5),REGISTER_DRIVER(6),WORKSHOP_DROP(7),FINAL_DELIVERY(8), FB_LOGIN(9),GOOGLE_LOGIN(10);

    private int id;
    ApiRequestId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
}
