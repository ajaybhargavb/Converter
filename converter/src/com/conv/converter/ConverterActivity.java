package com.conv.converter;
/**
 @author:Ajay Bhargav B
 */
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConverterActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	EditText fedit,cedit;
	Button convert,reset;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conv);
        
        fedit=(EditText)findViewById(R.id.fedit);
        cedit=(EditText)findViewById(R.id.cedit);
        convert=(Button)findViewById(R.id.convert);
        reset=(Button)findViewById(R.id.reset);
        convert.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.convert)
		{
		String fvalue=fedit.getText().toString();
		String cvalue=cedit.getText().toString();
		if((fvalue.equals("")&&cvalue.equals("")))
		{
			Toast.makeText(this,R.string.toastnullmsg,Toast.LENGTH_LONG).show();
			Log.d("ConverterActivity","ToastNull fah : "+fvalue+"cel : "+cvalue);
		}
		else if(!fvalue.equals(""))
		{
		float f=Float.parseFloat(fvalue);
		float cel;
		cel=((f-32)*5)/9;
		String res=Float.toString(cel);
		cedit.setText(res);
		}
		else if(fvalue.equals(""))
		{
		float c=Float.parseFloat(cvalue);
		float fah;
		fah=((9*c)/5)+32;
		String res1=Float.toString(fah);
		fedit.setText(res1);
		}
	}
	else if(v.getId()==R.id.reset)
	{
		fedit.setText(null);
		cedit.setText(null);
	}
	}
}