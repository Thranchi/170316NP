package kr.blogspot.httpcarelesssandbox.a170316np;

import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
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
    int presentpage=0;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        setTitle("Reservation");



        Button next,prev;
        final GridLayout people,result;
        TextView timert,datet,timet,adultt,teent,kidt;
        Switch st;
        FrameLayout ground;
        final DatePicker datep;
        final TimePicker timep;
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

        adultn=(EditText)findViewById(R.id.adultn);
        teenn=(EditText)findViewById(R.id.teenn);
        kidn=(EditText)findViewById(R.id.kidn);

        timer=(Chronometer)findViewById(R.id.timer);

        st=(Switch)findViewById(R.id.startingswitch);

        ground=(FrameLayout)findViewById(R.id.ground);

        datep=(DatePicker)findViewById(R.id.datePicker);

        timep=(TimePicker)findViewById(R.id.timePicker);

        buttonbox=(LinearLayout)findViewById(R.id.buttonbox);

        if(st.isChecked()) {
            presentpage = 1;
            timer.setVisibility(View.VISIBLE);
            timet.setVisibility(View.VISIBLE);
            timer.start();
            for (; ; ) {
                switch (presentpage) {
                    case 1: {
                        datep.setVisibility(View.VISIBLE);
                        prev.setEnabled(false);
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presentpage += 1;
                                datep.setVisibility(View.GONE);
                            }
                        });
                        break;
                    }
                    case 2:{
                        timep.setVisibility(View.VISIBLE);
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presentpage += 1;
                                timep.setVisibility(View.GONE);
                            }
                        });
                        prev.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presentpage -= 1;
                                timep.setVisibility(View.GONE);

                            }
                        });
                        break;
                    }

                    case 3:{
                        people.setVisibility(View.VISIBLE);
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presentpage += 1;
                                people.setVisibility(View.GONE);
                            }
                        });
                        prev.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presentpage -= 1;
                                people.setVisibility(View.GONE);

                            }
                        });
                        break;
                    }

                    case 4:{
                        result.setVisibility(View.VISIBLE);
                        timer.stop();
                        datet.setText(datep.getYear()+"."+datep.getMonth()+"."+datep.getDayOfMonth()+".");
                        timet.setText(timep.getHour()+" : "+timep.getMinute());
                        String ad = adultn.getText().toString();
                        if(ad.getBytes().length <= 0)
                        {
                            ad="0";
                        }
                        String te = teenn.getText().toString();
                        if(ad.getBytes().length <= 0)
                        {
                            te="0";
                        }
                        String ki = kidn.getText().toString();
                        if(ad.getBytes().length <= 0)
                        {
                            ki="0";
                        }
                        adultt.setText(ad+" .");
                        teent.setText(ad+" .");
                        kidt.setText(ad+" .");

                        next.setEnabled(false);
                        prev.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presentpage -= 1;
                                result.setVisibility(View.GONE);
                            }
                        });
                        break;
                    }




                }
            }
        }
        else
        {
            presentpage=0;

            timer.setBase(SystemClock.elapsedRealtime());
            timer.setVisibility(View.GONE);
            timert.setVisibility(View.GONE);
            datet.setText(null);
            timet.setText(null);
            adultt.setText(null);
            teent.setText(null);
            kidt.setText(null);

            buttonbox.setVisibility(View.GONE);
            people.setVisibility(View.GONE);
            ground.setVisibility(View.GONE);
            datep.setVisibility(View.GONE);
            timep.setVisibility(View.GONE);
            result.setVisibility(View.GONE);
        }
    }
}
