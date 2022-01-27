package in.seekmyvision.a95classroom.Home;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import in.seekmyvision.a95classroom.R;

public class Home_page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    LinearLayout profile;
    Toolbar toolbar;

    CardView register,login,payment1,web,support,term_condition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



      support = (CardView) findViewById(R.id.support);
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("95classroom.in@gmail.com") + "?subject=" +
                        Uri.encode("Feedback") + "&body=" + Uri.encode("");

                Uri uri = Uri.parse(uriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
       });



        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://95classroom.thinkific.com/users/sign_up");
            }
       });


        login = findViewById(R.id.login);

       login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://95classroom.thinkific.com/users/sign_in");


            }
       });


        term_condition = findViewById(R.id.term_condition);

        term_condition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              gotoUrl("https://95classroom.thinkific.com/pages/terms-and-conditions");

           }
       });


        payment1 = findViewById(R.id.payment1);

        payment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://paytm.business/link/paymentForm/85979/LL_370110876");


            }
        });

        web = findViewById(R.id.web);

        web.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://95classroom.thinkific.com/courses/ondemandcourse");


           }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        profile = header.findViewById(R.id.profile);
        profile.setOnClickListener(this);
    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.About) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(String.format("%1$s", getString(R.string.about)));
            builder.setMessage(getResources().getText(R.string.about_text));
            builder.setPositiveButton("OK", null);
            builder.setIcon(R.mipmap.ic_launcher);
            AlertDialog welcomeAlert = builder.create();
            welcomeAlert.show();
            ((TextView) welcomeAlert.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());


        } else if (id == R.id.Payment) {
            Intent intent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://paytm.business/link/paymentForm/85979/LL_370110876"));
            startActivity(intent);


        } else if (id == R.id.Partnership) {
            Intent intent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://95classroom.thinkific.com/pages/partnership"));
            startActivity(intent);

        } else if (id == R.id.documents) {
            Intent intent = new Intent(getApplicationContext(), Document_page.class);
            startActivity(intent);

        } else if (id == R.id.Youtube) {

            Intent intent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://www.youtube.com/channel/UCE1jp6cO1Ltd7rQGIHUenWA"));
            startActivity(intent);

        } else if (id == R.id.Telegram) {

            Intent intent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://t.me/ninetyfiveclassroom"));
            startActivity(intent);

        } else if (id == R.id.Chat) {


            Intent intent = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" + Uri.encode("95classroom.in@gmail.com") + "?subject=" +
                    Uri.encode("Feedback") + "&body=" + Uri.encode("");

            Uri uri = Uri.parse(uriText);
            intent.setData(uri);
            startActivity(Intent.createChooser(intent, "Send Email"));


        } else if (id == R.id.Chat1) {


            Intent intent = new Intent(getApplicationContext(), chat1_page.class);
            startActivity(intent);



        } else if (id == R.id.Policy) {

            Intent intent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://95classroom.thinkific.com/pages/terms-and-conditions"));
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent shareintent = new Intent();
            shareintent.setAction(Intent.ACTION_SEND);
            shareintent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=in.seekmyvision.a95classroom");
            shareintent.setType("text/plain");
            startActivity(Intent.createChooser(shareintent, " share via"));



        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.profile) {
            //Intent intent = new Intent(getApplicationContext(), MyProfile.class);
           // startActivity(intent);
        }
    }
}
