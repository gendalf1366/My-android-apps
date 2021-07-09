package ru.gendalf13666.moonshiner.Main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_book_main.*
import ru.gendalf13666.moonshiner.R

class BookMainFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_main, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bookFruitTable.setOnClickListener(this)
        bookHopTable.setOnClickListener(this)
        bookFermentsBrew.setOnClickListener(this)
        bookYeastTable.setOnClickListener(this)
        bookFertman.setOnClickListener(this)
        bookFruitwater.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.bookFruitTable -> {
                val webView: WebView? = getView()?.findViewById(R.id.webView)

                webView?.loadUrl("file:///android_asset/yeasttable.html")
                if (webView != null) {
                    webView.webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView,
                            request: WebResourceRequest
                        ): Boolean {
                            return super.shouldOverrideUrlLoading(view, request)
                        }
                    }
                }
            }
            R.id.bookHopTable -> {
                val webView: WebView? = getView()?.findViewById(R.id.webView)

                webView?.loadUrl("file:///android_asset/fruittable.html")
                if (webView != null) {
                    webView.webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView,
                            request: WebResourceRequest
                        ): Boolean {
                            return super.shouldOverrideUrlLoading(view, request)
                        }
                    }
                }
            }
            R.id.bookFermentsBrew -> {
                val webView: WebView? = getView()?.findViewById(R.id.webView)

                webView?.loadUrl("file:///android_asset/hoptable.html")
                if (webView != null) {
                    webView.webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView,
                            request: WebResourceRequest
                        ): Boolean {
                            return super.shouldOverrideUrlLoading(view, request)
                        }
                    }
                }
            }
            R.id.bookYeastTable -> {
                val webView: WebView? = getView()?.findViewById(R.id.webView)

                webView?.loadUrl("file:///android_asset/ferments_brew.html")
                if (webView != null) {
                    webView.webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView,
                            request: WebResourceRequest
                        ): Boolean {
                            return super.shouldOverrideUrlLoading(view, request)
                        }
                    }
                }
            }
            R.id.bookFertman -> {
                val webView: WebView? = getView()?.findViewById(R.id.webView)

                webView?.loadUrl("file:///android_asset/fertman.html")
                if (webView != null) {
                    webView.webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView,
                            request: WebResourceRequest
                        ): Boolean {
                            return super.shouldOverrideUrlLoading(view, request)
                        }
                    }
                }
            }
            R.id.bookFruitwater -> {
                val webView: WebView? = getView()?.findViewById(R.id.webView)

                webView?.loadUrl("file:///android_asset/fruitwater.html")
                if (webView != null) {
                    webView.webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView,
                            request: WebResourceRequest
                        ): Boolean {
                            return super.shouldOverrideUrlLoading(view, request)
                        }
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance() = BookMainFragment()
    }
}
