package com.example.danieljet.testanimation;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.examole.selfdefination.Sincurve;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textview;
    private Sincurve  sincurve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.translate);
        textview = (TextView)findViewById(R.id.integrated_action);
        sincurve = (Sincurve)findViewById(R.id.surface_view);
        //属性动画(平移动画)
        ObjectAnimator  animator = ObjectAnimator.ofFloat(button,"translationX",100);
        animator.setDuration(3000);
        animator.start();
        //综合动画
        PropertyValuesHolder one = PropertyValuesHolder.ofFloat("translationX",300);
        PropertyValuesHolder two = PropertyValuesHolder.ofFloat("scaleX",1f,0,1f);
        PropertyValuesHolder three =  PropertyValuesHolder.ofFloat("scaleY",1f,0,1f);
        ObjectAnimator.ofPropertyValuesHolder(textview,one,two,three).setDuration(4000).start();

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
}
