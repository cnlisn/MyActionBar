/*
 * ************************************************************
 *
 * @File：MainActivity.java  Module：app  Project：MyActionBar
 * @CreatedDate：2019-10-23 16:52:58
 * @LastDate：2019-10-23 16:42:37
 * @Author：LiShan
 * E-mail:cnlishan@163.com
 * Copyright (c) 2019
 *
 * ************************************************************
 */

package com.lisn.myactionbar;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.lisn.actionbarsg.ActionBarSG;
import com.lisn.common.ActionBarCommon;
import com.lisn.common.ActionBarSearch;
import com.lisn.common.ActionBarSuper;
import com.lisn.common.ActionView;
import com.lisn.common.OnActionBarChildClickListener;
import com.lisn.statusbarcompat.StatusBarCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBarCommon simple_action_bar_1 = findViewById(R.id.simple_action_bar_1);
        ActionBarCommon simple_action_bar_2 = findViewById(R.id.simple_action_bar_2);
        ActionBarCommon simple_action_bar_3 = findViewById(R.id.simple_action_bar_3);
        ActionBarSearch search_action_bar_1 = findViewById(R.id.search_action_bar_1);
        ActionBarSearch search_action_bar_2 = findViewById(R.id.search_action_bar_2);
        ActionBarSG action_bar_sg_1 = findViewById(R.id.action_bar_sg_1);
        ActionBarSG action_bar_sg_2 = findViewById(R.id.action_bar_sg_2);
        ActionBarSuper action_bar_super_2 = findViewById(R.id.action_bar_super_2);
        ActionBarSuper action_bar_super_3 = findViewById(R.id.action_bar_super_3);
        ActionBarSuper action_bar_super_4 = findViewById(R.id.action_bar_super_4);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simple_action_bar_1.getForegroundLayer().setVisibility(View.VISIBLE);
                simple_action_bar_2.getForegroundLayer().setVisibility(View.VISIBLE);
                simple_action_bar_3.getForegroundLayer().setVisibility(View.VISIBLE);
                search_action_bar_1.getForegroundLayer().setVisibility(View.VISIBLE);
                search_action_bar_2.getForegroundLayer().setVisibility(View.VISIBLE);
                action_bar_sg_1.getForegroundLayer().setVisibility(View.VISIBLE);
                action_bar_sg_2.getForegroundLayer().setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        simple_action_bar_1.getForegroundLayer().setVisibility(View.GONE);
                        simple_action_bar_2.getForegroundLayer().setVisibility(View.GONE);
                        simple_action_bar_3.getForegroundLayer().setVisibility(View.GONE);
                        search_action_bar_1.getForegroundLayer().setVisibility(View.GONE);
                        search_action_bar_2.getForegroundLayer().setVisibility(View.GONE);
                        action_bar_sg_1.getForegroundLayer().setVisibility(View.GONE);
                        action_bar_sg_2.getForegroundLayer().setVisibility(View.GONE);
                    }
                }, 3000);
            }
        });

        findViewById(R.id.tv_test_in_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestInFragmentActivity.class);
                startActivity(intent);
            }
        });

        SwitchCompat sc_status_bar_dark_icon = findViewById(R.id.sc_status_bar_dark_icon);
        sc_status_bar_dark_icon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                StatusBarCompat.setIconMode(MainActivity.this, isChecked);
            }
        });

        ActionView[] leftActionViews = action_bar_super_4.getLeftActionViews();

        leftActionViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "LeftIconClick 2", Toast.LENGTH_SHORT).show();
            }
        });

        ActionView[] rightActionViews = action_bar_super_4.getRightActionViews();
        for (int i = 0; i < rightActionViews.length; i++) {
            int finalI = i;
            rightActionViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "RightIconClick " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });
        }

        simple_action_bar_1.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "LeftIconClick", Toast.LENGTH_SHORT).show();
            }
        });

        simple_action_bar_1.setOnRightIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "RightIconClick", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
