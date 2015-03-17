package com.maxgames.mapeditor;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnTouchListener {
	EditText ETid;
	Game g;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		g = new Game(this, new Map(70, this));
		setContentView(g);
		g.setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		g.onTouch(v, event, v.getId());
		return true;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
