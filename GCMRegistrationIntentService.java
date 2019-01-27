package com.avinash.findmydrug;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

/**
 * Created by AVINASH on 04-03-2018.
 */

public class GCMRegistrationIntentService extends IntentService {

    public static final String REGISTRATION_SUCCESS = "RegistrationSuccess";
    public static final String REGISTRATION_ERROR = "RegistrationError";
    public GCMRegistrationIntentService(){
        super("");
    }
    public static String token = null;

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        registerGCM();
    }

    private void registerGCM(){
        Intent registrationComplete = null;
        InstanceID instanceID;
        try{
            instanceID = InstanceID.getInstance(getApplicationContext());
            token = instanceID.getToken(getString(R.string.gcm_defaultSenderId), GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            Log.w("GCMRegIntentService", "token:"+token);
            registrationComplete = new Intent();
            registrationComplete.setAction(REGISTRATION_SUCCESS);
            registrationComplete.addCategory(Intent.CATEGORY_DEFAULT);
            registrationComplete.putExtra("token", token);
            sendBroadcast(registrationComplete);
        } catch (Exception e){
            Log.w("GCMRegIntentService", "Registration error");
            registrationComplete = new Intent(REGISTRATION_ERROR);
        }
    }
}
