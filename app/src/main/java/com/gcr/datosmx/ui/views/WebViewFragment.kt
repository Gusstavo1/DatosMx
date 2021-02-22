package com.gcr.datosmx.ui.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.gcr.datosmx.R
import com.gcr.datosmx.utils.NetWorkCheck
import kotlinx.android.synthetic.main.fragment_internet_home.webViewLoadind
import kotlinx.android.synthetic.main.fragment_internet_home.webViewNews
import kotlinx.android.synthetic.main.fragment_web_view.*


class WebViewFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(NetWorkCheck.isNetworkAvailable(requireContext())){
            Log.d("WEB", "Tiene internet: ")
            errorWebview.visibility = View.GONE
            webViewNews.webChromeClient = object: WebChromeClient(){
            }
            webViewNews.webViewClient = object: WebViewClient(){
            }
            webViewNews.settings.javaScriptEnabled = true
            webViewNews.loadUrl("https://www.datos.gob.mx/")

            webViewNews.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView, progress: Int) {
                    webViewLoadind.visibility = View.VISIBLE
                    if (progress == 100) {
                        webViewLoadind.visibility = View.GONE
                        webViewNews.visibility = View.VISIBLE
                    } else {
                        webViewLoadind.visibility = View.VISIBLE
                    }
                }
            }
        }else{
            Log.d("WEB", ":C ")
            webViewLoadind.visibility = View.GONE
            errorWebview.visibility = View.VISIBLE
        }
    }
}