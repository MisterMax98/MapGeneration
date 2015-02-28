package com.maxgames.mapeditor;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnTouchListener {
	MapEdit me;
	EditText ETid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		me = new MapEdit(this);
		setContentView(R.layout.activity_main);
		LinearLayout ll = (LinearLayout) findViewById(R.id.mll);
		ll.addView(me);
		me.setOnTouchListener(this);
		ETid = (EditText) findViewById(R.id.etID);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int id = Integer.parseInt(ETid.getText().toString());
		me.onTouch(v, event, id);
		return true;
	}

	@Override
	public void onBackPressed() {
		me.map.saveMap();
		super.onBackPressed();
	}

}
