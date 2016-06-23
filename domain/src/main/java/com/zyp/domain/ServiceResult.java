package com.zyp.domain;

import com.google.gson.Gson;

/**
 * Created by Henry on 2015/11/11.
 */
public class ServiceResult {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
