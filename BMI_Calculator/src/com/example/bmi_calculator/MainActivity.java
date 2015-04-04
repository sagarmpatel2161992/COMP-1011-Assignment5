/*
 Application Name: BMI Calculator Application
 Programmer: Sagar Patel
 Description : BMI Calculator using height and weight
 Date: 4/3/2015
  */
package com.example.bmi_calculator;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends ActionBarActivity {

	// Object Declaration
	private TextView txt1, txt2, txt3, txt4, txterror1, txterror2;
	private Button btn,btnreset;
	private EditText ed1,ed2,edmulti;
	private ToggleButton tbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Bundle temp = savedInstanceState;
        txt1 = (TextView)findViewById(R.id.textViewheight);
        txt1.setTextColor(Color.parseColor("#FF0000"));
        txt2 = (TextView)findViewById(R.id.textViewweight);
        txt2.setTextColor(Color.parseColor("#FF0000"));
        txt3 = (TextView)findViewById(R.id.textView1);
        txt4 = (TextView)findViewById(R.id.textView2);
        txterror1 = (TextView)findViewById(R.id.textView3);
        txterror2 = (TextView)findViewById(R.id.textView4);
        btn = (Button)findViewById(R.id.button1);
        btnreset = (Button)findViewById(R.id.button2);
        ed1 = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);
        edmulti = (EditText)findViewById(R.id.editText3);
        tbtn = (ToggleButton)findViewById(R.id.toggleButton1);
        edmulti.setVisibility(View.INVISIBLE);
        
        tbtn.setOnClickListener(new OnClickListener() {
			
        	// Toggle button click event
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				final String change = tbtn.getText().toString();
		        // Check if metric is selected or imperial
				if(change.equalsIgnoreCase("metric"))
		        {
					// Setting unit for height and width to meter and kg respectively 
		        	txt3.setText("meter");
		        	txt4.setText("kg");
		        }
				else
				{
					// Setting unit for height and width to inches and lbs respectively
					txt3.setText("inches");
					txt4.setText("lbs");
				}
		        
				
			}
		});
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// String Variable Declaration and fetching value from textbox
				String value1=ed1.getText().toString().trim();  
                String value2=ed2.getText().toString().trim();
                
                               
                // converting height and width to double
                double height = Double.parseDouble(value1);  
                double weight = Double.parseDouble(value2); 
                
                
                //BMI Declaration 
                double BMI;    
                // 
                final String textcheck = tbtn.getText().toString();
				
                // Condition to check if units are imperial or matric
                if(textcheck.equalsIgnoreCase("imperial"))
                {
                	//  equation for Imperial 
                 BMI = (weight * 703)/(height*height);
                }
				else
				{
				//  equation for Metric 
					BMI = weight/(height*height);
				}
                // Conditions to check BMI Scale
				if(BMI < 18.5)
				{
					// print if its under weight
					edmulti.setText(BMI + "\nUnderweight less than 18.5");
					edmulti.setVisibility(View.VISIBLE);
					edmulti.setKeyListener(null);
					Toast.makeText(getApplicationContext(),String.valueOf(BMI) + "\n\nUnderweight",Toast.LENGTH_LONG).show();
				 
				}				
				else if(BMI >= 18.5 && BMI < 24.9)
				{
					// print if its Normal
					edmulti.setText(BMI + "\nNormal between 18.5 and 24.9");
					edmulti.setVisibility(View.VISIBLE);
					edmulti.setKeyListener(null);
					Toast.makeText(getApplicationContext(),String.valueOf(BMI) + "\n\nNormal",Toast.LENGTH_LONG).show();
				}
				else if(BMI>= 25 && BMI < 29.9 )
				{
					// print if its Over weight
					edmulti.setText(BMI + "\nOverweight between 25 and 29.9");
					edmulti.setVisibility(View.VISIBLE);
					edmulti.setKeyListener(null);
					Toast.makeText(getApplicationContext(),String.valueOf(BMI) + "\n\nOverweight",Toast.LENGTH_LONG).show();
				}
				else if(BMI >= 30)
				{
					// print if its Obese
					edmulti.setText(BMI + "\nObese 30 or greater");
					edmulti.setVisibility(View.VISIBLE);
					edmulti.setKeyListener(null);
					Toast.makeText(getApplicationContext(),String.valueOf(BMI) + "\n\nObese",Toast.LENGTH_LONG).show();
				}
                 
			}
           
		});
        
        btnreset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ed1.setText(null);
				ed2.setText(null);
				
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
