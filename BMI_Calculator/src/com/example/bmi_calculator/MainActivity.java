package com.example.bmi_calculator;

import android.support.v7.app.ActionBarActivity;
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

	private TextView txt1, txt2, txt3, txt4;
	private Button btn;
	private EditText ed1,ed2;
	private ToggleButton tbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txt1 = (TextView)findViewById(R.id.textViewheight);
        txt2 = (TextView)findViewById(R.id.textViewweight);
        txt3 = (TextView)findViewById(R.id.textView1);
        txt4 = (TextView)findViewById(R.id.textView2);
        btn = (Button)findViewById(R.id.button1);
        ed1 = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);
        tbtn = (ToggleButton)findViewById(R.id.toggleButton1);
        
        tbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String change = tbtn.getText().toString();
		        if(change.equalsIgnoreCase("metric"))
		        {
		        	txt3.setText("meter");
		        	txt4.setText("kg");
		        }
				else
				{
					txt3.setText("inches");
					txt4.setText("lbs");
				}
		        
				
			}
		});
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String value1=ed1.getText().toString();  
                String value2=ed2.getText().toString(); 
                String scale;
                double height = Double.parseDouble(value1);  
                double weight = Double.parseDouble(value2); 
                double BMI;    
                final String tcheck = tbtn.getText().toString();
				if(tcheck.equalsIgnoreCase("imperial"))
                {
                 BMI = (weight * 703)/(height*height);
                }
				else
				{
					BMI = weight/(height*height);
				}
				if(BMI < 18.5)
				{
					Toast.makeText(getApplicationContext(),String.valueOf(BMI) + "\n\nUnderweight",Toast.LENGTH_LONG).show();
				 
				}
				else if(BMI >= 18.5 && BMI < 24.9)
				{
					Toast.makeText(getApplicationContext(),String.valueOf(BMI) + "\n\nNormal",Toast.LENGTH_LONG).show();
				}
				else if(BMI>= 25 && BMI < 29.9 )
				{
					Toast.makeText(getApplicationContext(),String.valueOf(BMI) + "\n\nOverweight",Toast.LENGTH_LONG).show();
				}
				else if(BMI >= 30)
				{
					Toast.makeText(getApplicationContext(),String.valueOf(BMI) + "\n\nObese",Toast.LENGTH_LONG).show();
				}
                 
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
