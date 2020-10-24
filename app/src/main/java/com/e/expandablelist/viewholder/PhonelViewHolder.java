package com.e.expandablelist.viewholder;

import android.graphics.drawable.Drawable;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.e.expandablelist.R;



public class PhonelViewHolder extends RecyclerView.ViewHolder
{
    //================================================================================
    // region VARIABLES


  ImageView image;
    TextView txtTitle;
    TextView txtDate;
    TextView txtQuantity;
    RatingBar rtPhone;

    // endregion
    //================================================================================

    //================================================================================
    // region CONSTRUCTOR

    public PhonelViewHolder(View view)
    {
        super(view);
        image = (ImageView) view.findViewById(R.id.image);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtDate = (TextView) view.findViewById(R.id.txtDate);
        txtQuantity = (TextView) view.findViewById(R.id.txtQuantity);
        rtPhone = (RatingBar) view.findViewById(R.id.rtPhone);
    }

    // endregion
    //================================================================================

    //================================================================================
    // region BIND VIEWS


    public void setTitle(String name)
    {
        this.txtTitle.setText(name);
    }

    public void setQuantity(String text)
    {
        txtQuantity.setText(text);
    }

    public void setDate(String text)
    {
        txtDate.setText(text);
    }


    public  void setPhoneImage(Drawable drawable) { this.image.setImageDrawable(drawable);}

    public void  setRating(float rating){
        rtPhone.setRating(rating);
    }


    // endregion
    //================================================================================

}
