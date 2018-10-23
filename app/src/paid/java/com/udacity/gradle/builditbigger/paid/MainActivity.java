package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fancystachestudios.androidjokes.JokeActivity;
import com.fancystachestudios.androidjokes.SimpleIdlingResource;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.OnPostTaskListener{

    @Nullable
    private SimpleIdlingResource mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        /*
        JavaJoke javaJoke = new JavaJoke();
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(getString(R.string.jokeId), javaJoke.getJoke());
        */
        new EndpointsAsyncTask().execute(this);

        //startActivity(intent);
        //Toast.makeText(this, javaJoke.getJoke(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostTask(String result) {

        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(getString(R.string.jokeId), result);

        startActivity(intent);

        if(mIdlingResource != null){
            mIdlingResource.setIdleState(true);
        }

        //Toast.makeText(this, "I'm testing this", Toast.LENGTH_SHORT).show();
    }


    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource(){
        if(mIdlingResource == null){
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }
}
