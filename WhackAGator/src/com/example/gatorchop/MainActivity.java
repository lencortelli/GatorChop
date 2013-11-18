package com.example.gatorchop;


import com.example.gatorchop.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button playButton;
	Button instructionsButton;
	Button highScoresButton; 
	TextView instructions;
	TextView goNoles;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		playButton = (Button) findViewById(R.id.play_button);
		playButton.setBackgroundColor(Color.YELLOW);
		playButton.setTextColor(Color.RED);
		
		instructions = (TextView) findViewById(R.id.instructions);
		//playint.setBackgroundColor(Color.RED);
		instructions.setTextColor(Color.YELLOW);
		
		goNoles = (TextView) findViewById(R.id.goNoles);
		goNoles.setTextColor(Color.YELLOW);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v == playButton)
		{
			Intent playIntent = new Intent(this, PlayActivity.class);
			startActivity(playIntent);
			finish();
		}
		
	}

}
