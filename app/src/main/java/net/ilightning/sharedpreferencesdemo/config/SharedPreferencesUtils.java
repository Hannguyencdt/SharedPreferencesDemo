package net.ilightning.sharedpreferencesdemo.config;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/*** Created by Admin on 4/5/2018.
 */

public class SharedPreferencesUtils {

    private static String myShare = "myShare";

    public static void setString(Context context, String keyName, String valueName) {
        SharedPreferences.Editor editor =
                context.getSharedPreferences(myShare, MODE_PRIVATE).edit();
        editor.putString(keyName, valueName);
        editor.apply();
    }

    public static String getString(Context context, String key) {
        SharedPreferences prefs =
                context.getSharedPreferences(myShare, MODE_PRIVATE);
        String name = prefs.getString(key, "name");
        return name;
    }

    public static void setBoolean(Context context, String keyName, boolean valueName) {
        SharedPreferences.Editor editor =
                context.getSharedPreferences(myShare, MODE_PRIVATE).edit();
        editor.putBoolean(keyName, valueName);
        editor.apply();
    }

    public static Boolean getBoolean(Context context, String key) {
        SharedPreferences prefs =
                context.getSharedPreferences(myShare, MODE_PRIVATE);
        Boolean value = prefs.getBoolean(key, false);
        return value;
    }

    public static void clearAllSharedPreferences(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(myShare, MODE_PRIVATE);
        prefs.edit().clear().apply();


    }
}
