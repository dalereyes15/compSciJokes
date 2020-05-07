package edu.psu.jjb24.csjokes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements DisplaySetupDialog.DisplaysetUpDialogListener,
                                                                DisplayPunchlineDialog.DisplayPunchLineDialogListener{
    String[] joke_title;
    String[] joke_setup;
    String[] joke_punchline;
    int currentJoke = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the action bar
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        joke_title = getResources().getStringArray(R.array.JokeTitle);
        joke_setup = getResources().getStringArray(R.array.JokeSetup);
        joke_punchline = getResources().getStringArray(R.array.JokePunchline);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_joke:
                //select a random joke within jokes array
                Random random = new Random();
                currentJoke = random.nextInt(joke_title.length);
                String jokeTitle = joke_title[currentJoke];
                String jokeSetUp = joke_setup[currentJoke];
                String jokePunchline = joke_punchline[currentJoke];
                displaySetupDialog(jokeTitle,jokeSetUp,jokePunchline);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void displaySetupDialog(String title, String setUp, String punchline) {
        DisplaySetupDialog displaySetupDialog = new DisplaySetupDialog();
        Bundle args = new Bundle();
        //set the arguments in the bundle
        args.putString("title", title);
        args.putString("setup", setUp);
        args.putString("punchline", punchline);
        displaySetupDialog.setArguments(args);
        displaySetupDialog.show(getSupportFragmentManager(),"setUp Dialog");

    }

    @Override
    public void displayPunchLineDialog(String title, String setUp, String punchline) {
        DisplayPunchlineDialog displayPunchlineDialog = new DisplayPunchlineDialog();
        Bundle args = new Bundle();
        //Set arguments in the bundle
        args.putString("title", title);
        args.putString("setup", setUp);
        args.putString("punchline", punchline);
        displayPunchlineDialog.setArguments(args);
        displayPunchlineDialog.show(getSupportFragmentManager(),"punchline dialog");

    }
}