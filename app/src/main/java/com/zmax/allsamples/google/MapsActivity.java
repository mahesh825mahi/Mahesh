package com.zmax.allsamples.google;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.zmax.allsamples.R;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng MainGate = new LatLng(19.125198, 72.916485);
        LatLng KV = new LatLng(19.129052, 72.918499);
        LatLng SAC = new LatLng(19.135548, 72.913830);
        LatLng NCCgrounds = new LatLng(19.133261, 72.913397);
        LatLng Gullu = new LatLng(19.129792, 72.915188);
        LatLng LHC1 = new LatLng(19.130825, 72.916673);
        LatLng LHC2 = new LatLng(19.130805, 72.917469);
        LatLng PhyWoods = new LatLng(19.129903, 72.917013);
        LatLng GG = new LatLng(19.131670, 72.916527);
        LatLng Convo = new LatLng(19.132022, 72.914401);
        LatLng Civil = new LatLng(19.132691, 72.916498);
        LatLng PCSA = new LatLng(19.132415, 72.915800);
        LatLng SOM = new LatLng(19.131629, 72.915682);
        LatLng FCK = new LatLng(19.130643, 72.916032);
        LatLng GymkGr = new LatLng(19.134301, 72.912194);
        LatLng MBlawns = new LatLng(19.132974, 72.915836);
        LatLng IITB = new LatLng(19.131177, 72.916024);
        mMap.addMarker(new MarkerOptions().position(MainGate).title("Main Gate"));
        mMap.addMarker(new MarkerOptions().position(KV).title("Kendriya Vidyalaya (KV)"));
        mMap.addMarker(new MarkerOptions().position(SAC).title("Student Acctivity Centre (SAC)"));
        mMap.addMarker(new MarkerOptions().position(NCCgrounds).title("N.C.C. Grounds"));
        mMap.addMarker(new MarkerOptions().position(Gullu).title("Gulmohar Cafeteria"));
        mMap.addMarker(new MarkerOptions().position(LHC1).title("Lecture Hall Complex (LHC)").snippet("Contains all LC, LH, LT rooms"));
        mMap.addMarker(new MarkerOptions().position(LHC2).title("Lecture Hall Complex (LHC)").snippet("Contains all LA rooms"));
        mMap.addMarker(new MarkerOptions().position(GG).title("Girish Gaitonde Building"));
        mMap.addMarker(new MarkerOptions().position(SOM).title("Shailesh J Mehta School of Management"));
        mMap.addMarker(new MarkerOptions().position(Civil).title("Civil Engineering Department"));
        mMap.addMarker(new MarkerOptions().position(PhyWoods).title("Physics Woods"));
        mMap.addMarker(new MarkerOptions().position(Convo).title("Convocation Hall"));
        mMap.addMarker(new MarkerOptions().position(PCSA).title("P.C. Saxena Auditorium (PCSA)"));
        mMap.addMarker(new MarkerOptions().position(FCK).title("F.C. Kohli Auditorium"));
        mMap.addMarker(new MarkerOptions().position(GymkGr).title("Gymkhana Grounds"));
        mMap.addMarker(new MarkerOptions().position(MBlawns).title("Main Building Lawns"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(IITB));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16),2000,null);
    }
}
