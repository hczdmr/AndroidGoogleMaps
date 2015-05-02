package com.hczdmr.GoogleMapsExample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MyActivity extends Activity {
    private GoogleMap map;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (map == null) {
            map = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
            if (map != null) {
                //İstanbul, Kız Kulesi olsun.
                LatLng istanbulKoordinat = new LatLng(39.783229,30.511018);
                //marker olusturduk
                MarkerOptions marker = new MarkerOptions().position(istanbulKoordinat).title("Eskisehir Espark Avm");
                //marker rengini degistirdik
                marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
                //custom marker olusturmak icin
                //marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.my_marker_icon)));
                map.addMarker(marker);
                //kamerayi belirli zoom orani ile berlirli noktaya yonlendrdik
                //map.moveCamera(CameraUpdateFactory.newLatLngZoom(istanbulKoordinat, 13));
                //usttekinden daha iyi animasyon ekliyor.
                CameraPosition cameraPosition = new CameraPosition.Builder().target(
                        new LatLng(39.783229, 30.511018)).zoom(12).build();
                map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                // lokasyonumu goster butonu ekledik.
                map.setMyLocationEnabled(true);
                //zoom butonlarini olusturduk.
                map.getUiSettings().setZoomControlsEnabled(true);
            }
        }

    }

}
