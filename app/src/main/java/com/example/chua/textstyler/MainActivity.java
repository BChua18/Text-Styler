package com.example.chua.textstyler;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener {

    private EditText Text;
    private CheckBox Bold, Italic;
    private RadioButton Red, Green, Blue;
    private TextView Style;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        Text = (EditText)findViewById(R.id.mtxtText);
        Bold = (CheckBox)findViewById(R.id.mchkBold);
        Italic = (CheckBox)findViewById(R.id.mchkItalic);
        Red = (RadioButton)findViewById(R.id.mRbRed);
        Green = (RadioButton)findViewById(R.id.mRbGreen);
        Blue = (RadioButton)findViewById(R.id.mRbBlue);
        Style = (TextView)findViewById(R.id.mtxtStyle);

        Text.addTextChangedListener(this);
        Bold.setOnCheckedChangeListener(this);
        Italic.setOnCheckedChangeListener(this);
        Red.setOnCheckedChangeListener(this);
        Green.setOnCheckedChangeListener(this);
        Blue.setOnCheckedChangeListener(this);
}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Style.setText(Text.getText().toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(Bold.isChecked()) {
            if (Italic.isChecked())
                Style.setTypeface(Typeface.create(Style.getTypeface(), Typeface.BOLD_ITALIC));
            else
                Style.setTypeface(Typeface.create(Style.getTypeface(), Typeface.BOLD));
        }
        if(Italic.isChecked()) {
            if (Bold.isChecked())
                Style.setTypeface(Typeface.create(Style.getTypeface(), Typeface.BOLD_ITALIC));
            else
                Style.setTypeface(Typeface.create(Style.getTypeface(), Typeface.ITALIC));
    }
    if(!Bold.isChecked()){
            if (Italic.isChecked())
                Style.setTypeface(Typeface.create(Style.getTypeface(), Typeface.ITALIC));
            else
                Style.setTypeface(Typeface.create(Style.getTypeface(), Typeface.NORMAL));
        }
    if(!Italic.isChecked()){
        if(Bold.isChecked())
            Style.setTypeface(Typeface.create(Style.getTypeface(), Typeface.BOLD));
        else
            Style.setTypeface(Typeface.create(Style.getTypeface(), Typeface.NORMAL));
    }
    if(Red.isChecked())
            Style.setTextColor(Color.RED);
        if (Green.isChecked())
            Style.setTextColor(Color.GREEN);
        if(Blue.isChecked())
            Style.setTextColor(Color.BLUE);
    }
}
