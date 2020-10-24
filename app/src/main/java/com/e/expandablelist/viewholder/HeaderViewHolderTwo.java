package com.e.expandablelist.viewholder;

import android.graphics.drawable.Drawable;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.e.expandablelist.R;


/**
 *
 */

public class HeaderViewHolderTwo extends RecyclerView.ViewHolder
{
    //================================================================================
    // region VARIABLES

    TextView headerTextView;
    public ImageButton expandButton;

    // endregion
    //================================================================================

    //================================================================================
    // region CONSTRUCTOR

    public HeaderViewHolderTwo(View view)
    {
        super(view);
        headerTextView = (TextView) view.findViewById(R.id.header_text_view);
        expandButton = (ImageButton) view.findViewById(R.id.expand_button);
    }

    // endregion
    //================================================================================

    //================================================================================
    // region BIND VIEWS

    public void setHeaderText(String text)
    {
        headerTextView.setText(text);
    }


    public void setExpandButtonImage(Drawable drawable)
    {
        expandButton.setImageDrawable(drawable);
    }

    // endregion
    //================================================================================
}
