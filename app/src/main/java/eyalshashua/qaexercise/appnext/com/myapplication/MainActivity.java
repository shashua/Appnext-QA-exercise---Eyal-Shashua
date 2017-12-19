package eyalshashua.qaexercise.appnext.com.myapplication;
import com.appnext.ads.interstitial.InterstitialConfig;
import android.support.v7.app.AppCompatActivity;
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnAdOpened;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.appnext.ads.interstitial.InterstitialConfig;
import com.appnext.base.Appnext;
import com.appnext.core.Ad;


public class MainActivity extends AppCompatActivity {

    public Interstitial interstitial_Ad;
    public InterstitialConfig config;
    public Button AppnextBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        config = new InterstitialConfig();
        config.setOrientation(Ad.ORIENTATION_AUTO);
        config.setBackButtonCanClose(true);
        Appnext.init(this);
        interstitial_Ad = new Interstitial(this, "24233eba-345a-4128-a6af-48e14d9dd858", config);
        AppnextBtn = (Button) findViewById(R.id.AppnextBtn);
        AppnextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interstitial_Ad.loadAd();
                interstitial_Ad.showAd();
            }
        });
        // Get callback for ad loaded
        interstitial_Ad.setOnAdLoadedCallback(new OnAdLoaded() {
            @Override
            public void adLoaded(String bannerID) {
                Toast.makeText(MainActivity.this, "Ad Loaded - " + bannerID, Toast.LENGTH_SHORT).show();
            }
        });
        // Get callback for ad opened
        interstitial_Ad.setOnAdOpenedCallback(new OnAdOpened() {
            @Override
            public void adOpened() {
                Toast.makeText(MainActivity.this, "Ad Opened",Toast.LENGTH_SHORT).show();
            }
        });
        // Get callback for ad clicked
        interstitial_Ad.setOnAdClickedCallback(new OnAdClicked() {
            @Override
            public void adClicked() {
                Toast.makeText(MainActivity.this, "Ad Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        // Get callback for ad closed
        interstitial_Ad.setOnAdClosedCallback(new OnAdClosed() {
            @Override
            public void onAdClosed() {
                Toast.makeText(MainActivity.this, "Ad Closed", Toast.LENGTH_SHORT).show();
            }
        });
        // Get callback for ad error
        interstitial_Ad.setOnAdErrorCallback(new OnAdError() {
            @Override
            public void adError(String error) {
                Toast.makeText(MainActivity.this,"Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Toast.makeText(this, "Closing app", Toast.LENGTH_SHORT).show();
        finish();
    }
}

