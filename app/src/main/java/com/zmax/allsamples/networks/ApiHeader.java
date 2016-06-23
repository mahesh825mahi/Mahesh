package com.zmax.allsamples.networks;
/**
 * Created by BMS2 on 10/14/2015.
 */
public class ApiHeader
{
    private final String name;
    private final String value;

    public ApiHeader(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }
}
