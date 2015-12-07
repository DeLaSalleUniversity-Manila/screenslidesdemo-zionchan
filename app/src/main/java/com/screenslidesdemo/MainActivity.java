package com.screenslidesdemo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private static Sample[] mSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSamples = new Sample[]{
                new Sample(R.string.title_screen_slide, ScreenSlideActivity.class),
        };

        setListAdapter(new ArrayAdapter<Sample>(this, R.layout.my_list_item,
                android.R.id.text1,
                mSamples));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
    }

    private class Sample {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }
}
