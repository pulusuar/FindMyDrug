package com.avinash.findmydrug;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by AVINASH on 04-03-2018.
 */

public class GCMTokenRefreshListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        startService(new Intent(this, GCMRegistrationIntentService.class));
    }
}
