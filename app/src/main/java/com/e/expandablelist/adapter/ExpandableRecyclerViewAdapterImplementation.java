package com.e.expandablelist.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.e.expandablelist.MainActivity;
import com.e.expandablelist.R;
import com.e.expandablelist.model.PhonePOJO;
import com.e.expandablelist.model.SectionHeader;
import com.e.expandablelist.model.SectionSubHeader;
import com.e.expandablelist.thirdparty.ExpandableRecyclerViewAdapter;
import com.e.expandablelist.thirdparty.ExpandableRowOnClickListener;
import com.e.expandablelist.thirdparty.ExpandableRowSubViewOnClickListener;
import com.e.expandablelist.viewholder.HeaderViewHolderTwo;
import com.e.expandablelist.viewholder.PhonelViewHolder;
import com.e.expandablelist.viewholder.SubHeaderViewHolder;

import java.util.ArrayList;
import java.util.List;

import static com.e.expandablelist.thirdparty.ExpandableRecyclerViewAdapter.EXPANSION_STATE_MINIMIZED;


public class ExpandableRecyclerViewAdapterImplementation
        extends ExpandableRecyclerViewAdapter<SectionHeader, SectionSubHeader, PhonePOJO, HeaderViewHolderTwo, SubHeaderViewHolder, PhonelViewHolder>
        implements ExpandableRowSubViewOnClickListener<SectionHeader, SectionSubHeader, PhonePOJO>,
        ExpandableRowOnClickListener<SectionHeader, SectionSubHeader, PhonePOJO>
{
    //================================================================================
    // region VARIABLES

    private Context context;

    //----------------- data source for section content -----------------\\
    // Separate data source for the content of each section.
    // Make changes to the data source as you normally would in a RecyclerView.
    // After changes --> update????
    public ArrayList<PhonePOJO> iphoneList = new ArrayList<>();
    public ArrayList<PhonePOJO> samsungList = new ArrayList<>();


    public void addSumsungData(ArrayList<PhonePOJO> samsungList){
        this.samsungList.clear();
        this.samsungList.addAll(samsungList);
    }

    public void addIPhoneData(ArrayList<PhonePOJO> samsungList){
        this.iphoneList.clear();
        this.iphoneList.addAll(samsungList);
    }

    // endregion
    //================================================================================

    //================================================================================
    // region CONSTRUCTOR




    public ExpandableRecyclerViewAdapterImplementation(Context context)
    {
        // Provide the ExpandableRecyclerViewAdapter with class information for our view holders
        super(HeaderViewHolderTwo.class,
                SubHeaderViewHolder.class,
                PhonelViewHolder.class);

        // Set the reference to context
        this.context = context;

        // Set the on click listener for sub views of our rows.
        this.expandableRowSubViewOnClickListener = this;
        this.expandableRowOnClickListener = this;
    }



    // endregion
    //================================================================================

    //================================================================================
    // region EXPANDABLE: CREATING SECTIONS

    @Override
    public int getNumberOfSections()
    {
        // Return the number of sections we want in the recycler view
        return 2;
    }

    @Override
    public SectionHeader getHeaderForSection(int sectionIndex)
    {
        // Create each header section

        switch (sectionIndex)
        {
            case 0:
                return new SectionHeader("iPhone");
            case 1:
                return new SectionHeader("Samsung");
            default:
                return new SectionHeader("iPhone");
        }
    }

    @Override
    public SectionSubHeader getSubHeaderForSection(int sectionIndex)
    {
        // Create each sub header section
        // using the same section sub header for each section
        // you can easily change this according to the section index
        return new SectionSubHeader("Expand", "Minimize", "Loading", "Error Loading - retry");
    }

    @Override
    public List<PhonePOJO> getContentForSection(int sectionIndex)
    {
        // Pass the Lists representing the content of each section
        switch (sectionIndex)
        {
            case 0:
                return iphoneList;
            case 1:
                return samsungList;
            default:
                return iphoneList;

        }
    }

    // endregion
    //================================================================================

    //================================================================================
    // region EXPANDABLE: CREATING VIEW HOLDERS

    @Override
    public HeaderViewHolderTwo createSectionHeaderViewHolder(ViewGroup parent)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_row_two, parent, false);
        return new HeaderViewHolderTwo(view);
    }

    @Override
    public SubHeaderViewHolder createSectionSubHeaderViewHolder(ViewGroup parent)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subheader_row, parent, false);
        return new SubHeaderViewHolder(view);
    }

    @Override
    public PhonelViewHolder createSectionContentViewHolder(ViewGroup parent)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_for_phone_list, parent, false);
        return new PhonelViewHolder(view);
    }

    // endregion
    //================================================================================

    //================================================================================
    // region EXPANDABLE: BINDING VIEW HOLDER VIEWS

    @Override
    public void bindSectionHeaderViewHolder(HeaderViewHolderTwo holder,
                                            SectionHeader header,
                                            int sectionIndex,
                                            int expansionState)
    {
        // set header text
        holder.setHeaderText(header.getTitle());

        // set up expand button
        Drawable drawable;
        if(expansionState == EXPANSION_STATE_MINIMIZED)
        {
            drawable = ContextCompat.getDrawable(context, R.drawable.ic_baseline_keyboard_arrow_down_24);
        }
        else
        {
            drawable = ContextCompat.getDrawable(context, R.drawable.ic_baseline_keyboard_arrow_up_24);
        }

        holder.setExpandButtonImage(drawable);

        // explicitly register the image button for click listening
        // DO NOT implement OnClickListener in this subclass.
        // OnClickListener is implemented by ExpandableRecyclerViewAdapter and delegates to
        // ExpandableRowSubViewOnClickListener (this must be implemented here).
        holder.expandButton.setOnClickListener(this);
    }

    @Override
    public void bindSectionSubHeaderViewHolder(SubHeaderViewHolder holder,
                                               SectionSubHeader subHeader,
                                               int sectionIndex,
                                               int expansionState)
    {
        // Only need to handle loading and error, sub header is hidden for other states

        switch (expansionState)
        {
            case ExpandableRecyclerViewAdapter.EXPANSION_STATE_LOADING_CONTENT:
                holder.setSubHeaderText(subHeader.getLoadingString());
                break;
            case ExpandableRecyclerViewAdapter.EXPANSION_STATE_ERROR_LOADING:
                holder.setSubHeaderText(subHeader.getErrorString());
                break;
        }
    }




    @Override
    public void bindSectionContentViewHolder(PhonelViewHolder holder, PhonePOJO content, int sectionIndex, int expansionState)
    {
      //  holder.setTitle(content.getPicture());


        holder.setPhoneImage(content.getPicture());
        holder.setTitle(content.getTitle());
        holder.setDate(content.getDate());
        holder.setQuantity(content.getQuantity());
        holder.setRating(content.getRating());
    }

    // endregion
    //================================================================================

    //================================================================================
    // region EXPANDABLE: OTHER STATE METHODS

    @Override
    public int getDefaultExpansionStateForSection(int sectionIndex)
    {
        // Provide the default state of each section.
        return EXPANSION_STATE_MINIMIZED;
    }

    @Override
    public boolean shouldShowSectionSubHeader(int sectionIndex, int expansionState)
    {
        // Only show the sub header is the section is loading or had an error
        return  expansionState == EXPANSION_STATE_LOADING_CONTENT ||
                expansionState == EXPANSION_STATE_ERROR_LOADING;
    }

    @Override
    public int getSavedStateForSection(int sectionIndex, int expansionState)
    {
        if(expansionState == EXPANSION_STATE_EXPANDED)
            return expansionState;
        else
            return EXPANSION_STATE_MINIMIZED;
    }

    // endregion
    //================================================================================

    //================================================================================
    // region EXPANDABLE ROW ON CLICK LISTENER

    @Override
    public void sectionHeaderClicked(SectionHeader header, int sectionIndex, int expansionState)
    {
        Log.i(String.valueOf(sectionIndex), "section Header Clicked");
    }

    @Override
    public void sectionSubHeaderClicked(SectionSubHeader subHeader, int sectionIndex, int expansionState)
    {
        // If there is an error, reload the section
        if(expansionState == EXPANSION_STATE_ERROR_LOADING)
        {
            // Reload
            setExpansionStateLoading(sectionIndex);

            MainActivity activity = (MainActivity) context;

            switch (sectionIndex)
            {
                case 0:
                    activity.loadIPhone();
                    break;
                case 1:
                    activity.loadSamsung();
                    break;
                case 2:
                    activity.loadSamsung();
                    break;

            }
        }
    }

    @Override
    public void sectionContentClicked(PhonePOJO content, int sectionIndex, int sectionContentIndex) {

    }



    // endregion
    //================================================================================

    //================================================================================
    // region EXPANDABLE ROW SUB VIEW ON CLICK LISTENER

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onSubViewClickedInSectionHeader(View view, SectionHeader header, int sectionIndex, int expansionState)
    {
        if(view.getId() == R.id.expand_button)
        {
            if(expansionState == EXPANSION_STATE_MINIMIZED)
            {
                if(sectionHasContent(sectionIndex))
                {
                    setExpansionStateExpanded(sectionIndex);
                }
                else
                {
                    setExpansionStateLoading(sectionIndex);

                    MainActivity activity = (MainActivity) context;

                    switch (sectionIndex)
                    {
                        case 0:
                            activity.loadIPhone();
                            break;
                        case 1:
                            activity.loadSamsung();
                            break;

                    }
                }
            }
            else if(expansionState == EXPANSION_STATE_EXPANDED)
            {
                setExpansionStateMinimized(sectionIndex);
            }
        }
    }

    @Override
    public void onSubViewClickedInSectionSubHeader(View view, SectionSubHeader subHeader, int sectionIndex, int expansionState)
    {
        Log.i(String.valueOf(sectionIndex), "sub view clicked in sub header");
    }

    @Override
    public void onSubViewClickedInSectionContentRow(View view, PhonePOJO content, int sectionIndex, int sectionContentIndex) {

    }




    // endregion
    //================================================================================
}
