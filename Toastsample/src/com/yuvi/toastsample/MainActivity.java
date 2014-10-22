package com.yuvi.toastsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.yuvi.toastsample.animatelayout.Animatebox;

public class MainActivity extends Activity implements OnClickListener {
	/** Called when the activity is first plecreated. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		((Button) findViewById(R.id.button1)).setOnClickListener(this);
		((Button) findViewById(R.id.button2)).setOnClickListener(this);
		((Button) findViewById(R.id.button3)).setOnClickListener(this);
		((Button) findViewById(R.id.button4)).setOnClickListener(this);
		((Button) findViewById(R.id.button5)).setOnClickListener(this);

		((TextView) findViewById(R.id.textView1))
				.setText("Click The Button To See the Dialogbox With diffrent style");

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Animatebox ab = new Animatebox(MainActivity.this);
			ab.setTextmesg("No Internet connection");
			ab.setAnimation(Utils.LENGTH_LONG);
			ab.setColor(Utils.BLUE);
			break;
		case R.id.button2:
			Animatebox abc = new Animatebox(MainActivity.this);
			abc.setTextmesg("No Internet connection");
			abc.setAnimation(Utils.LENGTH_MEDIUM);
			abc.setColor(Utils.RED);
			break;
		case R.id.button3:
			Animatebox abcd = new Animatebox(MainActivity.this);
			abcd.setTextmesg("No Internet connection");
			abcd.setAnimation(Utils.LENGTH_SHORT);
			abcd.setColor(Utils.GREEN);
			
			break;
		case R.id.button4:
			Animatebox abcde = new Animatebox(MainActivity.this);
			abcde.setTextmesg("No Internet connection");
			abcde.setAnimation(4000);
			abcde.setColor(Utils.YELLOW);
			break;
		case R.id.button5:
			Animatebox.Create(this, "No Internet Connection",R.drawable.ic_launcher, Utils.LENGTH_LONG);		}

	}

}
