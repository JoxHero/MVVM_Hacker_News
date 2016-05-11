package com.zyp.sweat_money.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.hitherejoe.mvvm_hackernews.R;
import com.zyp.sweat_money.SweatMoneyApp;
import com.zyp.sweat_money.dagger.components.ApplicationComponent;
import com.zyp.sweat_money.dagger.modules.ActivityModule;
import com.zyp.sweat_money.navigation.Navigator;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Base {@link android.app.Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    public Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        //session 的统计
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment        The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction =this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected void showHintMessageDialog(String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

              dialog.dismiss();
            }
        });
        builder.create();
        builder.show();
    }

    /**
     * Shows a {@link Toast} message.
     *
     * @param message An string representing a message to be shown.
     */
    protected void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showToastMessage(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link com.zyp.sweat_money.dagger.components.ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((SweatMoneyApp) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link com.zyp.sweat_money.dagger.modules.ActivityModule}
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }


}
