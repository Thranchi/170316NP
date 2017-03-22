package kr.blogspot.httpcarelesssandbox.a170316np;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        setTitle("Reservation");

        int presentpage=0;

        Button next,prev;
        GridLayout people,result;
        TextView timert,datet,timet,adultt,teent,kidt;
        Switch st;
        FrameLayout ground;
        final DatePicker datep;
        TimePicker timep;
        LinearLayout buttonbox;
        EditText adultn, teenn, kidn;
        Chronometer timer;

        next=(Button)findViewById(R.id.next);
        prev=(Button)findViewById(R.id.prev);

        result=(GridLayout)findViewById(R.id.result);
        people=(GridLayout)findViewById(R.id.people);

        datet=(TextView)findViewById(R.id.datet);
        timet=(TextView)findViewById(R.id.timet);
        adultt=(TextView)findViewById(R.id.adultt);
        teent=(TextView)findViewById(R.id.teent);
        kidt=(TextView)findViewById(R.id.kidt);
        timert=(TextView)findViewById(R.id.timert);

        timer=(Chronometer)findViewById(R.id.timer);

        st=(Switch)findViewById(R.id.startingswitch);

        ground=(FrameLayout)findViewById(R.id.ground);

        datep=(DatePicker)findViewById(R.id.datePicker);

        timep=(TimePicker)findViewById(R.id.timePicker);

        buttonbox=(LinearLayout)findViewById(R.id.buttonbox);

        if(st.isChecked())
        {
            presentpage=1;
            timer.start();
                    prev.setEnabled(false);
                    datep.setVisibility(View.VISIBLE);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            datep.setVisibility(View.GONE);

                        }
                    });
                            timer.stop();
            next.setEnabled(false);
        }
        else
        {
            presentpage=0;

            timer.setBase(SystemClock.elapsedRealtime());

            datet.setText(null);
            timet.setText(null);
            adultt.setText(null);
            teent.setText(null);
            kidt.setText(null);

            buttonbox.setVisibility(View.GONE);
            ground.setVisibility(View.GONE);
            datep.setVisibility(View.GONE);
            timep.setVisibility(View.GONE);
            result.setVisibility(View.GONE);
        }
    }
}
