package com.david.fingerlibrary.Preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;


public class TextPreference extends Preference {

    public TextPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public TextPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
      //  this.setWidgetLayoutResource(R.layout.calibration);
    }

    public TextPreference(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        TextView switchView = (TextView) holder.findViewById(android.R.id.title);
        switchView.setText("校准说明");
    }
}
