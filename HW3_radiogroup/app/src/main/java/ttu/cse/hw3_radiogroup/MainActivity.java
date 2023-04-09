package ttu.cse.hw3_radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {

    RadioGroup unit;
    EditText value;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit=findViewById(R.id.radioGroup);
        unit.setOnCheckedChangeListener(this);
        value=findViewById(R.id.editText);
        value.addTextChangedListener(this);
        answer=findViewById(R.id.textView);

    }


    protected void calc(){
        double val,f;
        String str=value.getText().toString();
        try{
            val=Double.parseDouble(str);
        }
        catch (Exception e){
            val=0;
        }

        if(unit.getCheckedRadioButtonId()==R.id.radioButton){
            f=val*3.28;
            answer.setText("="+String.format("%.2f",f));
        }
        else{
            f=val/3.28;
            answer.setText("="+String.format("%.5f",f));
        }

    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        calc();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        calc();
    }
}