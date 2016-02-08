package com.chocho.beacon.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.red_folder.phonegap.plugin.backgroundservice.BackgroundService;

public class BeaconEpsiService extends BackgroundService {

    private final static String TAG = com.chocho.beacon.service.BeaconEpsiService.class.getSimpleName();

    private String token = "";

    @Override
    protected JSONObject doWork() {
        JSONObject result = new JSONObject();

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String now = df.format(new Date(System.currentTimeMillis()));

            String msg = "Hello - its currently " + now + " My token is " + token;
            result.put("Message", msg);

            Log.d(TAG, msg);
        } catch (JSONException e) {
        }

        return result;
    }

    @Override
    protected JSONObject getConfig() {
        JSONObject result = new JSONObject();

        try {
            result.put("token", this.token);
        } catch (JSONException e) {
        }

        return result;
    }

    @Override
    protected void setConfig(JSONObject config) {
        try {
            if (config.has("token")){
                this.token = config.getString("token");
            }
        } catch (JSONException e) {
        }

    }

    @Override
    protected JSONObject initialiseLatestResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void onTimerEnabled() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onTimerDisabled() {
        // TODO Auto-generated method stub

    }


}
