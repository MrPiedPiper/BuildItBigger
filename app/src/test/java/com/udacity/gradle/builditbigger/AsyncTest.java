package com.udacity.gradle.builditbigger;

import org.junit.runner.RunWith;

//@RunWith(AndroidJUnit4.class)
public class AsyncTest {

}
/*
package com.udacity.gradle.builditbigger;

import android.widget.TextView;

import com.fancystachestudios.androidjokes.JokeActivity;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class AsyncTest extends ActivityTestRule<JokeActivity> {

    JokeActivity activity;
    TextView jokeTextView;
    ExecutorService executor = Executors.newSingleThreadExecutor();

    public AsyncTest(Class<JokeActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = this.getActivity();
        jokeTextView = (TextView) activity.findViewById(R.id.joke_text);
    }

    private Future<String> getJokeText(){
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() {
                while(true){
                    if(!jokeTextView.getText().toString().equals("Loading...")){
                        return jokeTextView.getText().toString();
                    }
                }
            }
        });
        return future;
    }

    @Test
    public void verifyAsyncCompleted() throws ExecutionException, InterruptedException {
        String jokeText = getJokeText().get();
        executor.shutdown();
        assert (!jokeText.equals("Loading..."));
    }
}
*/
