package com.TechNawabs.memoryscrap;

import java.util.Calendar;
import java.util.Locale;
import java.util.zip.Inflater;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class DiaryActivity extends Activity 
{
	Calendar c;
	TextView tv;
	ActionBar ab;
	TextToSpeech tts;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diary);
		
		//SpeechText
		tts=new TextToSpeech(getBaseContext(),new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				tts.setLanguage(Locale.getDefault());
				tts.setPitch(1.3f);
				tts.setSpeechRate(1.2f);
			}
		});

		tv = (TextView) findViewById(R.id.TV1);
		c=Calendar.getInstance();
		tv.setText("     "+c.get(Calendar.DAY_OF_MONTH)+"\n"+c.getDisplayName(Calendar.MONTH,Calendar.LONG,Locale.UK));
		ab = getActionBar();
		ab.setDisplayShowTitleEnabled(false);
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setDisplayUseLogoEnabled(false);
		ab.setDisplayShowHomeEnabled(true);
	}
	@SuppressLint("NewApi")
	public boolean onCreateOptionsMenu(Menu m) 
	{
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.diary, m);

		return super.onCreateOptionsMenu(m);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) 
		{
			case R.id.text:
				
				Toast.makeText(getBaseContext(), " Text selected ", Toast.LENGTH_SHORT).show();
				break;
				
			case R.id.speech:
				tts.speak("Text is",TextToSpeech.QUEUE_FLUSH,null);
				Toast.makeText(getBaseContext(), " Speech selected ", Toast.LENGTH_SHORT).show();
				break;

			case R.id.rem:
				
				Toast.makeText(getBaseContext(), " Reminder selected ", Toast.LENGTH_SHORT).show();
				break;
				
			case R.id.NP:
				
				Toast.makeText(getBaseContext(), " New Page", Toast.LENGTH_SHORT).show();
				break;
			
			case R.id.item1:
				
				Toast.makeText(getBaseContext(), " About us selected ", Toast.LENGTH_SHORT).show();
				break;	
			
			case R.id.item2:
				
				Toast.makeText(getBaseContext(), " Like us selected ", Toast.LENGTH_SHORT).show();
				break;	
		}
		return super.onOptionsItemSelected(item);
	}
}
