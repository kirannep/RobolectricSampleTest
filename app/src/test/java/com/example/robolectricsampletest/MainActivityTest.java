package com.example.robolectricsampletest;

import android.widget.TextView;
import android.widget.Toast;

import org.apache.tools.ant.Main;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static android.os.Build.VERSION_CODES.KITKAT;
import static org.junit.Assert.*;
import static org.robolectric.RuntimeEnvironment.application;
import static org.robolectric.Shadows.shadowOf;

//Config annotation with old API level because API 29 doesnt work with latest Robolectric version 4.3.1
@RunWith(RobolectricTestRunner.class)
@Config(sdk = KITKAT)
public class MainActivityTest {

    MainActivity activity = Robolectric.buildActivity(MainActivity.class)
            .create()
            .resume()
            .get();
//       MainActivity activity = Robolectric.setupActivity(MainActivity.class);


    @Test
    public void shouldnotbenull(){
        assertNotNull(activity);
    }
//
    @Test
    public void showToast() {
        activity.findViewById(R.id.tvID).performClick();
        List<Toast> toasts = shadowOf(application).getShownToasts();
//        activity.showToast();
////        assertThat(toasts.toString(), equalTo("Testing Android Rocks!"));
//        assertEquals("helo",);
    }

    //testing number of toast when called activity.showtoast method
    @Test
    public void showToastsize(){
        activity.showToast();
        List<Toast> toasts = shadowOf(application).getShownToasts();
        assertEquals(1,toasts.size());
        assertNotNull(toasts);
    }
}