package com.example.gatorchop;

import java.util.Random;

import com.example.gatorchop.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends Activity {
	
	String TAG = "PlayActivity";
	int score =0;
	int txtTime = 30;
	boolean[] vals = new boolean[5];
	MediaPlayer warChant;
	MediaPlayer soundfxHit;
	Button music;
	Button fx;
	TextView txtTimer;
	boolean musicOn = true;
	boolean fxOn = true;
	final int SCORE_INCREMENT = 15;
	
	@Override
	public void onStart()
	{
		super.onStart();
	
		warChant.start();
		warChant.setLooping(true);
		
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		warChant.pause();
		soundfxHit.pause();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);
		txtTimer = (TextView)findViewById(R.id.txtTimer);
		txtTimer.setTextColor(Color.RED);
		warChant = MediaPlayer.create(this, R.raw.fsu_war_chant);
		soundfxHit = MediaPlayer.create(this, R.raw.hit);
		music = (Button)findViewById(R.id.music);
		fx = (Button)findViewById(R.id.fx);
		warChant.setLooping(true);
		
		resetImages();
		
		ImageView v = (ImageView)findViewById(R.id.imageView1);
		
		v.setClickable(true);
		v.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(vals[0] == true)
				{
					if(fxOn){
						soundfxHit.start();	
					}
					resetImages();
					nextSet();
					score+= 15;
				}
				
			}
			
		});
		
		v = (ImageView)findViewById(R.id.imageView2);
		v.setClickable(true);
		v.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				if(vals[1] == true)
				{
					if(fxOn){
						soundfxHit.start();	
					}
					resetImages();
					nextSet();
					score+= SCORE_INCREMENT;
				}
				
			}
			
		});
		
		v = (ImageView)findViewById(R.id.imageView3);
		v.setClickable(true);
		v.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				if(vals[2] == true)
				{
					if(fxOn){
						soundfxHit.start();	
					}
					resetImages();
					nextSet();
					score+= SCORE_INCREMENT;
				}
				
			}
			
		});
		
		v = (ImageView)findViewById(R.id.imageView4);
		v.setClickable(true);
		v.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				if(vals[3] == true)
				{
					if(fxOn){
						soundfxHit.start();	
					}
					resetImages();
					nextSet();
					score+= SCORE_INCREMENT;
				}
				
			}
			
		});
		
		v = (ImageView)findViewById(R.id.imageView5);
		v.setClickable(true);
		v.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				if(vals[4] == true)
				{
					if(fxOn){
						soundfxHit.start();	
					}
					resetImages();
					nextSet();
					score+= SCORE_INCREMENT;
				}
				
			}
			
		});
		
		
		new CountDownTimer(35000, 1000){

			@Override
			public void onFinish() {
				displayScore();
				
			}

			@Override
			public void onTick(long arg0) {
				if(txtTime >= 0)
				{
					txtTimer.setText(Integer.toString(txtTime--));
				}
				nextSet();
			}
			
			
		}.start();
			
		
	}//End of onCreate
	


	public void nextSet()
	{
		int next = 0;
		Random r = new Random();
		ImageView v;
		
		next = r.nextInt(5) + 1;
		
		switch(next)
		{
			case 1:	resetImages();
				v = (ImageView)findViewById(R.id.imageView1);
				v.setImageResource(R.drawable.gator);
				vals[0] = true;
				break;
		
			case 2: resetImages();
				v = (ImageView)findViewById(R.id.imageView2);
				v.setImageResource(R.drawable.gator);
				vals[1] = true;
				break;
	

			case 3: resetImages();
				v = (ImageView)findViewById(R.id.imageView3);
				v.setImageResource(R.drawable.gator);
				vals[2] = true;
				break;
		
		
			case 4: resetImages();
				v = (ImageView)findViewById(R.id.imageView4);
				v.setImageResource(R.drawable.gator);
				vals[3] = true;
				break;
		

			case 5: resetImages();
				v = (ImageView)findViewById(R.id.imageView5);
				v.setImageResource(R.drawable.gator);
				vals[4] = true;
				break;
		
			default:	resetImages();
						break;	
		}//End of switch
		
		//Toast.makeText(this, "next Set", Toast.LENGTH_LONG).show();
		
	}
	
	
	public void resetImages()
	{
		ImageView v = (ImageView)findViewById(R.id.imageView1);
		v.setImageResource(R.drawable.blank);
		
		v = (ImageView)findViewById(R.id.imageView2);
		v.setImageResource(R.drawable.blank);
		
		v = (ImageView)findViewById(R.id.imageView3);
		v.setImageResource(R.drawable.blank);
		
		v = (ImageView)findViewById(R.id.imageView4);
		v.setImageResource(R.drawable.blank);
		
		v = (ImageView)findViewById(R.id.imageView5);
		v.setImageResource(R.drawable.blank);
		
		for(int i = 0; i < 5; i++)
			vals[i] = false;
	}
	
	
	// Function called if user clicks sound FX off or music off
	public void onClick(View v)
	{
		
		if(v == fx)
		{
			if(fxOn)
			{
				fx.setText(R.string.play_sound_fx);
				fxOn = false;
			}
			else
			{
				fx.setText(R.string.stop_sound_fx);
				fxOn = true;
			}
		}
		
		if(v == music)
		{
			if(musicOn)
			{
				warChant.pause();
				warChant.seekTo(0);
				music.setText(R.string.play_music);
				musicOn = false;
			}
			else
			{
				warChant.start();
				warChant.setLooping(true);
				music.setText(R.string.stop_music);
				musicOn = true;
			}
		}

	}

	
	public void displayScore()
	{
		TextView txtTime = (TextView)findViewById(R.id.txtTimer);
		Button btnPlayAgain = (Button)findViewById(R.id.playagain);
		btnPlayAgain.setVisibility(View.VISIBLE);
		btnPlayAgain.setClickable(true);
		final Intent intent = new Intent(this, PlayActivity.class);
		btnPlayAgain.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				startActivity(intent);
				finish();
			}
			
		});
		
		txtTime.setText("Score: " + score);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
