package com.TechNawabs.memoryscrap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity 
{
	EditText name,pwd;
	Button log,reg;
	SharedPreferences sp;
	SharedPreferences.Editor speditor;
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		name = (EditText) findViewById(R.id.editText1);
		pwd = (EditText) findViewById(R.id.editText2);
		sp=getSharedPreferences("userdata",MODE_PRIVATE);
		speditor=sp.edit();
		
		log = (Button) findViewById(R.id.button1);
		log.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(name.getText().toString().isEmpty())
				{
					name.setBackgroundColor(Color.RED);
					Toast.makeText(getBaseContext(), "Invalid Username !!! :", Toast.LENGTH_SHORT).show();
				}
				if((name.isFocusable()==true)||(pwd.isFocusable()==true))
				{
					name.setBackgroundColor(Color.WHITE);
					pwd.setBackgroundColor(Color.WHITE);
				}
				if(pwd.getText().toString().isEmpty())
				{
					pwd.setBackgroundColor(Color.RED);
					Toast.makeText(getBaseContext(), "Invalid Password !!! :", Toast.LENGTH_SHORT).show();
				}
				String n,p;
				n=sp.getString("NAME","");
				p=sp.getString("PASWRD","");
				if((name.getText().toString().equals(n))&&(pwd.getText().toString().equals(p))){
					Toast.makeText(getBaseContext(), "Welcome "+name.getText().toString(),Toast.LENGTH_LONG).show();
					Intent nd=new Intent(getBaseContext(),DiaryActivity.class);
					startActivity(nd);
				}
			}
		});
		reg = (Button) findViewById(R.id.button2);
		reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(name.getText().toString().isEmpty())
				{
					name.setBackgroundColor(Color.RED);
					Toast.makeText(getBaseContext(), "Invalid Username !!! :", Toast.LENGTH_SHORT).show();
				}
				if((name.isFocusable()==true)||(pwd.isFocusable()==true))
				{
					name.setBackgroundColor(Color.WHITE);
					pwd.setBackgroundColor(Color.WHITE);
				}
				if(pwd.getText().toString().isEmpty())
				{
					pwd.setBackgroundColor(Color.RED);
					Toast.makeText(getBaseContext(), "Invalid Password !!! :", Toast.LENGTH_SHORT).show();
				}
				if((!pwd.getText().toString().isEmpty())&&(!name.getText().toString().isEmpty())){
					speditor.putString("NAME",name.getText().toString());
					speditor.putString("PASWRD",pwd.getText().toString());
					speditor.commit();
					Toast.makeText(getBaseContext(),"Hello "+name.getText().toString()+" You are Registered",Toast.LENGTH_LONG).show();
				}


			}
		});
		tv = (TextView) findViewById(R.id.textView1);
	}
}
