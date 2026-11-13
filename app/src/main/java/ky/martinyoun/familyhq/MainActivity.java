package ky.martinyoun.familyhq;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Opens MY (MartinYoun) Family HQ in a Chrome Custom Tab.
 * A Custom Tab shares Chrome's claude.ai sign-in, so the app always shows the
 * live version, saves changes, and Email updates (Gmail + Claude) keep working.
 */
public class MainActivity extends Activity {
    static final String APP_URL = "https://claude.ai/artifact/6QBnAABZbx2KTNoWMT7ANV";
    static final String[] BROWSERS = {"com.android.chrome", "com.chrome.beta", "com.microsoft.emmx", "com.sec.android.app.sbrowser", "org.mozilla.firefox"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL));
        Bundle extras = new Bundle();
        extras.putBinder("android.support.customtabs.extra.SESSION", null); // marks this as a Custom Tab
        i.putExtras(extras);
        i.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", 0xFF1C1B19);
        i.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 1);
        i.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 2); // hide share button
        String pkg = pickBrowser();
        if (pkg != null) i.setPackage(pkg);
        try {
            startActivity(i);
        } catch (ActivityNotFoundException e) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL)));
            } catch (ActivityNotFoundException e2) {
                Toast.makeText(this, "Install Google Chrome to open MyFamilyHQ", Toast.LENGTH_LONG).show();
            }
        }
        finish();
    }

    private String pickBrowser() {
        PackageManager pm = getPackageManager();
        for (String p : BROWSERS) {
            try { pm.getPackageInfo(p, 0); return p; } catch (PackageManager.NameNotFoundException ignored) { }
        }
        return null;
    }
}
