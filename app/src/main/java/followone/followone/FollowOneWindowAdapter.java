package followone.followone;

import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Yazid on 06/09/2015.
 */
public class FollowOneWindowAdapter implements GoogleMap.InfoWindowAdapter
{
    @Override
    public View getInfoWindow(Marker marker) {
        return  LayoutInflater.from(FollowOneApplication.getContext()).inflate(R.layout.info_window,null);
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
