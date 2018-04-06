package  com.example.minhthanh.lab5_android;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by minh thanh on 4/5/2018.
 */

public class FragmentDialog extends AppCompatDialogFragment {

    String RadioString;
    String name;
    String[] dayDetail;
    String day,bool;
    String yearStr,dateStr,monthStr;
    private EditText textName;
    private DatePicker date;
    private TextView btnSave,btnCancel;

    public interface OnInputListener{
        void sendInput(String RadioString, String dateStr, String monthStr, String yearStr, String input);
    }
    public OnInputListener mOnInputListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_dialog,container,false);
        textName = view.findViewById(R.id.editText);
        date   = view.findViewById(R.id.dialog_date_datePicker);
        RadioGroup radio = view.findViewById(R.id.toDoRG);
        btnSave   = view.findViewById(R.id.button2);
        btnCancel = view.findViewById(R.id.button1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        if(MainActivity.flag == true)
            textName.setText(name);

            date.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    yearStr = String.valueOf(year);
                    dateStr = String.valueOf(dayOfMonth);
                    monthStr = String.valueOf(monthOfYear);
                }
            });

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId)
                {
                    case R.id.high:{
                        RadioString = "HIGH";
                        break;
                    }
                    case R.id.normal:{
                        RadioString = "NORMAL";
                        break;
                    }
                    case R.id.low:{
                        RadioString = "LOW";
                        break;
                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOnInputListener.sendInput(RadioString,dateStr,monthStr,yearStr,textName.getText().toString());
                getDialog().dismiss();
            }
        });

        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputListener = (OnInputListener) context;
        }catch (ClassCastException e){
        }
    }
}


