package com.rdc.goospet.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.rdc.goospet.R;
import com.rdc.goospet.base.BaseSwipeBackActivity;
import com.rdc.goospet.presenter.SettingPresenter;
import com.rdc.goospet.view.vinterface.SettingVInterface;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private List<String> list2 = new ArrayList<>();
    private ArrayAdapter<String> sizeApapter;
    private EditText nameEdt;
    private Spinner sizeSpn;
    private SwitchCompat wechatSwh;
    private SwitchCompat qqSwh;
    private SwitchCompat msgSwh;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        nameEdt = (EditText) findViewById(R.id.name_edt);
        sizeSpn = (Spinner) findViewById(R.id.size_spn);
        wechatSwh = (SwitchCompat) findViewById(R.id.wechat_swh);
        qqSwh = (SwitchCompat) findViewById(R.id.qq_swh);
        msgSwh = (SwitchCompat) findViewById(R.id.msg_swh);


        list2.add("正常");
        list2.add("稍大");
        list2.add("稍小");
        sizeApapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list2);
        sizeApapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sizeSpn.setAdapter(sizeApapter);
        sizeSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.msg_swh:
                break;
            case R.id.qq_swh:
                break;
            case R.id.wechat_swh:
                break;
            default:
                break;
        }
    }
}
