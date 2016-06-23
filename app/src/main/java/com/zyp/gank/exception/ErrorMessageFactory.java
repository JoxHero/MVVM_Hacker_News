package com.zyp.gank.exception;

import android.content.Context;
import android.util.Log;

import com.zyp.data.exception.NetworkConnectionException;
import com.zyp.gank.GankApp;
import com.zyp.gank.R;

/**
 * Factory used to create error messages from an Exception as a condition.
 */
public class ErrorMessageFactory {

    public static final String TAG = "ErrorMessageFactory";
    
    private ErrorMessageFactory() {
        //empty
    }

    /**
     * Creates a String representing an error message.
     *
     * @param context   Context needed to retrieve string resources.
     * @param e An exception used as a condition to retrieve the correct error message.
     * @return {@link String} an error message.
     */
    public static String create(Context context, Throwable e) {
        Log.e(GankApp.TAG, "there is error!", e);
        
        String message = null;
        if (e instanceof NetworkConnectionException
                || e instanceof java.net.ConnectException
                || e instanceof java.net.UnknownHostException) {
            message = context.getString(R.string.exception_message_no_connection);
        } else if (e instanceof java.net.SocketTimeoutException) {
            message = context.getString(R.string.exception_message_connect_timeout);
        } else if (e instanceof retrofit.HttpException) {
            message = context.getString(R.string.exception_message_server_error);
        } else {
//            message = context.getString(R.string.exception_message_generic);
        }


        return message;
    }
}
