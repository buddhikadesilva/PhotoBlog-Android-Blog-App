package in.tvac.bevylabs.photoblog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {


    private WebView myWebView;

    public NotificationFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        myWebView = (WebView)view.findViewById(R.id.webview_frame);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        myWebView.loadUrl("https://python-eeb82.firebaseapp.com/");
        //myWebView.setLongClickable(false);
        //myWebView.setHapticFeedbackEnabled(false);
        //  myWebView.setWebViewClient(new WebViewClient());


        myWebView.setWebViewClient(new WebViewClient(){

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                myWebView.loadUrl("file:///android_asset/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                //  swipe.setRefreshing(false);
            }

        });
        return view;
    }

//    @Override
//    public void onBackPressed() {
//        if(myWebView.canGoBack()) {
//            myWebView.goBack();
//        } else {
//           // super.onBackPressed();
//        }
//    }

    private class MyWebViewClient extends WebViewClient {
        private MyWebViewClient() {
        }

        // $FF: synthetic method
        MyWebViewClient(Object var2) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            var1.loadUrl(var2);
            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
           // onBackPressed();
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

}
