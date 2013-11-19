package com.example.android_sqllite_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SqlLiteExample extends Activity implements OnClickListener {

	private static final String TAG = null;
	EditText sqlname, sqlhotness, sqlrow;
	Button update, view, test, delete, edit, getinfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sql_lite_example);

		initializers();
		Log.e(TAG, "ONCREATE CALLED");
	}

	private void initializers() {
		// TODO Auto-generated method stub

		sqlname = (EditText) findViewById(R.id.etName);
		sqlhotness = (EditText) findViewById(R.id.etHotness);
		update = (Button) findViewById(R.id.btUpdate);
		view = (Button) findViewById(R.id.btView);
		delete = (Button) findViewById(R.id.btDelete);
		edit = (Button) findViewById(R.id.btEdit);
		getinfo = (Button) findViewById(R.id.btGetInfo);

		sqlrow = (EditText) findViewById(R.id.editText1);
		update.setOnClickListener(this);
		view.setOnClickListener(this);
		delete.setOnClickListener(this);
		edit.setOnClickListener(this);
		getinfo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btUpdate:
			try {
				String getName = sqlname.getText().toString();
				String getHotness = sqlhotness.getText().toString();

				HotOrNot entry = new HotOrNot(SqlLiteExample.this);
				entry.open();
				entry.createEntry(getName, getHotness);
				entry.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			break;

		case R.id.btView:

			Intent i = new Intent(this, SqlView.class);
			startActivity(i);

			break;

		case R.id.btEdit:

			String mName = sqlname.getText().toString();
			String mhotness = sqlhotness.getText().toString();

			String mRow = sqlrow.getText().toString();
			Long mLong = Long.parseLong(mRow);

			HotOrNot mhon = new HotOrNot(this);
			mhon.open();

			mhon.updateEntry(mLong, mName, mhotness);

			mhon.close();

			break;
		case R.id.btDelete:

			String dRow = sqlrow.getText().toString();
			Long dlong = Long.parseLong(dRow);
			
			HotOrNot dHon = new HotOrNot(this);
			dHon.open();
			
			dHon.deleteEntry(dlong);
			
			dHon.close();
			
			break;
		case R.id.btGetInfo:

			String s = sqlrow.getText().toString();
			long l = Long.parseLong(s);

			HotOrNot hon = new HotOrNot(this);
			hon.open();
			String returnedName = hon.getName(l);
			String returnedHotness = hon.getHotness(l);

			hon.close();

			sqlname.setText(returnedName);
			sqlhotness.setText(returnedHotness);

			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sql_lite_example, menu);
		return true;

	}
}
