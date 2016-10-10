package in.digievo.explosiontest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    String DeviceModel;
    Button getboth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t2 = (TextView) findViewById(R.id.textView2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

        getboth = (Button)findViewById(R.id.button1);
        getboth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DeviceModel= android.os.Build.MODEL;
                showWorkingDialog();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        removeWorkingDialog();
                        if(DeviceModel.contains("SM-N930"))
                        {
                            Intent main1Intent = new Intent(MainActivity.this, DangerActivity.class);
                            MainActivity.this.startActivity(main1Intent);
                        }
                        else
                        {
                            Intent main2Intent = new Intent(MainActivity.this, SafeActivity.class);
                            MainActivity.this.startActivity(main2Intent);
                        }
                    }

                }, 3000);


            }
        });

    }


    private ProgressDialog working_dialog;
    private void showWorkingDialog() {
        working_dialog = ProgressDialog.show(this, "","Comparing CPU temparature with temparature of the sun", true);
    }

    private void removeWorkingDialog() {
        if (working_dialog != null) {
            working_dialog.dismiss();
            working_dialog = null;
        }
    }

}