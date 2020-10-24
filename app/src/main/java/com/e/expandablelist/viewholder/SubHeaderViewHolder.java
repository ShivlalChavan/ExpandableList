package com.e.expandablelist.viewholder;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.e.expandablelist.R;


/**
 *
 */

public class SubHeaderViewHolder extends RecyclerView.ViewHolder
{
    //================================================================================
    // region VARIABLES

    TextView subHeaderTextView;

    // endregion
    //================================================================================

    //================================================================================
    // region CONSTRUCTOR
    public SubHeaderViewHolder(View view)
    {
        super(view);
        subHeaderTextView = (TextView) view.findViewById(R.id.sub_header_text_view);
    }
    // endregion
    //================================================================================


    //================================================================================
    // region BIND VIEWS

    public void setSubHeaderText(String text)
    {
        subHeaderTextView.setText(text);
    }

    // endregion
    //================================================================================
}
