package followone.followone;

import android.app.Application;
import android.content.Context;

/**
 * Created by Yazid on 06/09/2015.
 */
public class FollowOneApplication extends Application {
    private static FollowOneApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }

    public static FollowOneApplication getInstance(){
            return application;
    }

    public static Context getContext(){
        return application.getApplicationContext();
    }

}
