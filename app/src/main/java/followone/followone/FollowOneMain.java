package followone.followone;

import android.app.FragmentTransaction;
import android.graphics.Interpolator;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class FollowOneMain extends AppCompatActivity implements /*OnMapReadyCallback,GoogleMap.OnMapClickListener*/{

    Toolbar appBar;
    SupportMapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_one_main);
        this.appBar=((Toolbar)this.findViewById(R.id.appBar));
        //this.appBar.setAlpha((float) 0.5);
        this.setSupportActionBar(this.appBar);
        this.mapFragment=SupportMapFragment.newInstance();
        android.support.v4.app.FragmentTransaction transaction=this.getSupportFragmentManager().beginTransaction();
        TestingAnimation animation=new TestingAnimation();
       // transaction.add(R.id.mainLayout, this.mapFragment);
        transaction.add(R.id.mainLayout, animation);
        transaction.commit();
        //For map callBack
        this.mapFragment.getMapAsync(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_follow_one_main, menu);

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

    public void hideAppBar(){
       this.appBar.animate().translationY(-this.appBar.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
    }

    public void showAppBar(){
        this.appBar.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();
    }

/*
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this,"The Map is ready",Toast.LENGTH_SHORT).show();
        googleMap.setOnMapClickListener(this);
        googleMap.setMyLocationEnabled(true);
        MarkerOptions markerOptions;

        //googleMap.setInfoWindowAdapter(new FollowOneWindowAdapter());
        final Marker marker=  googleMap.addMarker(new MarkerOptions().position(new LatLng(0,-3)).title("it's a marquer"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).
                        title("FollowOneMarquer").
                        draggable(true).
                        snippet("marker").
                        icon(BitmapDescriptorFactory.fromResource(R.drawable.school)).flat(true)
        );




        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
    }

    @Override
    public void onMapClick(LatLng latLng) {

        MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("Latitude :" + latLng.latitude + " Longitude:" + latLng.longitude);
        this.mapFragment.getMap().addMarker(markerOptions);

    }
    */
}
