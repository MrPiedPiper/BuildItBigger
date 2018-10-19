package com.fancystachestudios.bakingapp.javajokes;

public class JavaJoke {

    public String getJoke(){
        String[] jokes = {
                "What'd one chicken say to the other? \"You're looking a little peckish\"",
                "Why did the chicken cross the road? No, really. Why?",
                "How many programmers does it take to install a lightbulb? 1 to make the project, 1 to make the library, and... Yeah, don't know where I was going with this one."
        };
        int randomIndex = (int) (Math.random() * (jokes.length));

        return jokes[randomIndex];
    }
}
