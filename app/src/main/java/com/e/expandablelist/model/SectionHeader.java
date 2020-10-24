package com.e.expandablelist.model;



public class SectionHeader
{
    //================================================================================
    // region VARIABLES

    private String title;

    // endregion
    //================================================================================

    //================================================================================
    // region CONSTRUCTOR

    public SectionHeader(String title) {
        this.title = title;
    }

    // endregion
    //================================================================================

    //================================================================================
    // region GETTERS & SETTERS

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    // endregion
    //================================================================================

}
