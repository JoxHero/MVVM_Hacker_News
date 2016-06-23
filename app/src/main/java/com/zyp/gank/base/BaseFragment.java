/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.zyp.gank.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.common.Constants;

import com.zyp.gank.R;
import com.zyp.gank.dagger.HasComponent;

import butterknife.ButterKnife;
import icepick.Icepick;

/**
 * Base {@link android.app.Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {

    protected abstract void initializeInject();

    protected abstract void setupView();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initWindow();
    }

//    @TargetApi(19)
//    private void initWindow(){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
//            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }}

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Icepick.restoreInstanceState(this, savedInstanceState);

        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeInject();
        setupView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * Shows a {@link Toast} message.
     *
     * @param message An string representing a message to be shown.
     */
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showToastMessage(int resId) {
        Toast.makeText(getActivity(), getString(resId), Toast.LENGTH_SHORT).show();
    }

    public void showDialog(Context context, String title, String msg
            , String cancelBtn, DialogInterface.OnClickListener cancelListener
            , String confirmBtn, DialogInterface.OnClickListener confirmListener) {

        android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(context).create();
        dialog.setTitle(title);
        dialog.setMessage(msg);
        dialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEGATIVE, cancelBtn, cancelListener);
        dialog.setButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE, confirmBtn, confirmListener);
        dialog.show();
    }

//    protected void showDoubleDialog(String title, String message
//            , String confirmButtonStr, DialogInterface.OnClickListener confirmListener
//            , String cancelButtonStr, DialogInterface.OnClickListener cancelListener) {
//        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
//        builder.setTitle(title);
//        builder.setMessage(message);
//        builder.setPositiveButton(confirmButtonStr, confirmListener);
//        builder.setNegativeButton(cancelButtonStr, cancelListener);
//        builder.create();
//        AlertDialog dialog = builder.show();
//        TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
//        messageText.setLineSpacing(0f,1.2f);
//        messageText.setTextSize(14f);
//        messageText.setGravity(Gravity.CENTER);
//
//        dialog.show();
//    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    public void showProgressDialog() {
        showProgressDialog(null);
    }

    public void showProgressDialog(final DialogInterface.OnCancelListener onCancelListener) {
        DialogFragment dialogFragment = new DialogFragment() {

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                ProgressDialog dialog = new ProgressDialog(getActivity());
                dialog.setIndeterminate(true);
                dialog.setMessage(getString(R.string.message_loading));
                if (onCancelListener != null) {
                    dialog.setCancelable(true);
                    dialog.setOnCancelListener(onCancelListener);
                }

                return dialog;
            }
        };

        showDialogFragment(dialogFragment, Constants.FragmentTag.DIALOG_PROGRESS);
    }

    public void hideProgressDialog() {
        dismissDialogFragment(Constants.FragmentTag.DIALOG_PROGRESS);
    }

    protected void showHintMessageDialog(String message) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dismissDialogFragment(Constants.FragmentTag.DIALOG_HINT_MESSAGE);
            }
        });
        showDialogFragment(builder.create(), Constants.FragmentTag.DIALOG_HINT_MESSAGE);
    }

    protected void showDialogFragment(final Dialog dialog, final String tag) {
        DialogFragment dialogFragment = new DialogFragment() {

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                return dialog;
            }
        };

        showDialogFragment(dialogFragment, tag);
    }

    protected void showDialogFragment(DialogFragment dialogFragment, String tag) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment prev = fragmentManager.findFragmentByTag(tag);
        if (prev != null) {
            ((DialogFragment) prev).dismissAllowingStateLoss();
            ft.remove(prev);
        }

//        dialogFragment.show(fragmentManager, tag);
        if (!dialogFragment.isAdded()) {
            ft.add(dialogFragment, tag);
        }
        ft.commitAllowingStateLoss();
    }

    protected void dismissDialogFragment(String tag) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment dest = fragmentManager.findFragmentByTag(tag);
        if (dest != null) {
            ((DialogFragment) dest).dismissAllowingStateLoss();
            ft.remove(dest);
        }
    }

}
