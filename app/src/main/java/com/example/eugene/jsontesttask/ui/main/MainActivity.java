package com.example.eugene.jsontesttask.ui.main;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eugene.jsontesttask.R;
import com.example.eugene.jsontesttask.ui.base.BaseActivity;
import com.example.eugene.jsontesttask.ui.jsondata.JsonDataFragment;

public class MainActivity extends BaseActivity {
    @Override
    public int provideLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
    }

    private void initFragment() {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flPlaceholder, JsonDataFragment.newInstance());
        ft.commit();
    }
}
