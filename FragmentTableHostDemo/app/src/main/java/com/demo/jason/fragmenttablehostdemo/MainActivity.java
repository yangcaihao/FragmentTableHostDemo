package com.demo.jason.fragmenttablehostdemo;

import android.app.Fragment;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.demo.jason.fragmenttablehostdemo.FragmentTab.FragmentTab1;
import com.demo.jason.fragmenttablehostdemo.FragmentTab.FragmentTab2;
import com.demo.jason.fragmenttablehostdemo.FragmentTab.FragmentTab3;

public class MainActivity extends FragmentActivity implements FragmentTab1.OnFragmentInteractionListener, FragmentTab2.OnFragmentInteractionListener, FragmentTab3.OnFragmentInteractionListener {

    private FragmentTabHost tableHost;
    private LayoutInflater layoutInflater;
    private Class[] fragmentArray = {FragmentTab1.class, FragmentTab2.class, FragmentTab3.class};
    private String[] tabNames = {"tab1", "tab2", "tab3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        layoutInflater = getLayoutInflater();
        tableHost = (FragmentTabHost) findViewById(R.id.tabhost);
        tableHost.setup(this, getSupportFragmentManager(), R.id.real_content);
        int count = fragmentArray.length;
        int i = 0;
        for (i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = tableHost.newTabSpec(tabNames[i]).setIndicator(getTabIndicator(i));
            tableHost.addTab(tabSpec, fragmentArray[i], null);
            tableHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_text_selector);
        }

    }

    private View getTabIndicator(int index) {
        View view = null;
        view = layoutInflater.inflate(R.layout.tab_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.tab_text);
        textView.setText(tabNames[index]);
        return view;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
