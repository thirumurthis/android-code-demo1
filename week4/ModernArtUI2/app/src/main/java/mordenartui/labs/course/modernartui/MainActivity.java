package mordenartui.labs.course.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private DialogFragment mDialog;
    private WebView mwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textv1 = (TextView)findViewById(R.id.textView1);
        TextView textv2 = (TextView)findViewById(R.id.textView2);
        TextView textv3 = (TextView)findViewById(R.id.textView3);
        TextView textv4 = (TextView)findViewById(R.id.textView4);
        TextView textv5 = (TextView)findViewById(R.id.textView5);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressval = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressval = progress;
                Toast.makeText(getApplicationContext(),"Loading "+progress,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Loading start",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Loading stop",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_title) {
            mDialog = new MenuDialogFragment();
            mDialog.show(getFragmentManager(),"Alert");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void shutdownDialog(){
        mDialog.dismiss();
    }

    public Context getContext(){
       return getApplicationContext();
    }
    public WebView getMWebView(){
        mwebView = (WebView)findViewById(R.id.webview);
        return  mwebView;
    }

}
