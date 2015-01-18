package com.TechNawabs.memoryscrap;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class StartActivity extends Activity 
{
	int waitTime = 4 * 1000;    //4 seconds
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		new Handler().postDelayed(new Runnable() 
		{
			@Override
			public void run() 
			{
				Intent intent = new Intent(StartActivity.this,LoginActivity.class);
				finish();
				startActivity(intent);
				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
			}
		}, waitTime);	
	}
	@Override
	public void onBackPressed() 
	{
		finish();
		super.onBackPressed();
	}
}
