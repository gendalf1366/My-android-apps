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
                webView?.loadUrl("file:///android_asset/yeasttable.html")
                webViewClient()
            }
            R.id.bookHopTable -> {
                webView?.loadUrl("file:///android_asset/fruittable.html")
                webViewClient()
            }
            R.id.bookFermentsBrew -> {
                webView?.loadUrl("file:///android_asset/hoptable.html")
                webViewClient()
            }
            R.id.bookYeastTable -> {
                webView?.loadUrl("file:///android_asset/ferments_brew.html")
                webViewClient()
            }
            R.id.bookFertman -> {
                webView?.loadUrl("file:///android_asset/fertman.html")
                webViewClient()
            }
            R.id.bookFruitwater -> {
                webView?.loadUrl("file:///android_asset/fruitwater.html")
                webViewClient()
            }
        }
    }

    fun webViewClient() {
        if (webView != null) {
            webView!!.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
                ): Boolean {
                    return super.shouldOverrideUrlLoading(view, request)
                }
            }
        }
    }

    companion object {
        fun newInstance() = BookMainFragment()
    }
}
