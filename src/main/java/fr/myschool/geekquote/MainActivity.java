package fr.myschool.geekquote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.EventListener;

import fr.myschool.geekquote.model.Quote;

public class MainActivity extends AppCompatActivity {

    private ArrayList quotes = new ArrayList<Quote>();
    private LinearLayout ll_main_vert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ll_main_vert  = (LinearLayout) findViewById(R.id.ll_main_vert);

        String[] storedQuotes = getResources().getStringArray(R.array.quotList);
        for(String strQ : storedQuotes){
            addQuote(strQ);
            Log.d("sebi", "onCreate: " + strQ);
        }

        Button bt_main_add = (Button) findViewById(R.id.btn_main_add);
        bt_main_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addQuote(getQuoteEt());
            }
        });
    }

    public void addQuote(String strQuote){
        quotes.add(new Quote(strQuote));
        TextView tv_quote = new TextView(this);
        tv_quote.setText(strQuote);
        tv_quote.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv_quote.setGravity(Gravity.CENTER);

        if(quotes.size() % 2 == 1){
            tv_quote.setTextColor(getResources().getColor(R.color.clr_txt_even));
            tv_quote.setBackgroundColor(getResources().getColor(R.color.clr_bg_even));
        } else {
            tv_quote.setTextColor(getResources().getColor(R.color.clr_txt_odd));
            tv_quote.setBackgroundColor(getResources().getColor(R.color.clr_bg_odd));
        }
        ll_main_vert.addView(tv_quote);
    }

    public String getQuoteEt(){
        EditText et_quote = (EditText) findViewById(R.id.et_main_add) ;
        return et_quote.getText().toString();

    }
}
