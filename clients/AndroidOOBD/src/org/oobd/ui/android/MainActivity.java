package org.oobd.ui.android;

import org.oobd.ui.android.application.AndroidGui;
import org.oobd.ui.android.bus.BluetoothInitWorker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * 
 * @author Andreas Budde, Peter Mayer
 * Activity that is launched when the app is launched.
 */
public class MainActivity extends Activity {
	
	private Button mDiagnoseButton;
	
	public static MainActivity myMainActivity;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        myMainActivity = this;     
        
        mDiagnoseButton = (Button)findViewById(R.id.diagnose_button);
        mDiagnoseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AndroidGui.getInstance().startScriptEngine();
				startActivity(new Intent(MainActivity.this, Diagnose.class));
			}
		});
    }
    

    /**
     * Create Option menu with link to settings
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.home_menu, menu);
		return true;
    }
    
    public void startDiagnoseActivity() {
    	startActivity(new Intent(MainActivity.this, Diagnose.class));
    }
    
    /**
     * Gets called when a menu item is selected (in this case settings)
     */
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.settings) {
			startActivity(new Intent(this, Settings.class));
			return (true);
		}
		return (super.onOptionsItemSelected(item));
	}


	public static MainActivity getMyMainActivity() {
		return myMainActivity;
	}


	public static void setMyMainActivity(MainActivity myMainActivity) {
		MainActivity.myMainActivity = myMainActivity;
	}
	
	
    
}