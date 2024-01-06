/*
 * Copyright (C) 2023-2024 The Nameless-AOSP Project
 * SPDX-License-Identifier: Apache-2.0
 */

package co.aospa.settings.network;

import android.content.Context;
import android.content.pm.PackageManager;

import com.android.settings.core.BasePreferenceController;

public class PreferredNrModePreferenceController extends BasePreferenceController {

    private static final String PKG_NRMODE = "org.sun.nrmode";

    private final PackageManager mPackageManager;

    public PreferredNrModePreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
        mPackageManager = context.getPackageManager();
    }

    @Override
    public int getAvailabilityStatus() {
        return isPackageInstalled(PKG_NRMODE) ?
                AVAILABLE : UNSUPPORTED_ON_DEVICE;
    }

    private boolean isPackageInstalled(String packageName) {
        try {
            mPackageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
