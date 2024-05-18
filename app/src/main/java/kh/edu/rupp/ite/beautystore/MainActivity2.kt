package kh.edu.rupp.ite.beautystore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.beautystore.controller.ProductController
import kh.edu.rupp.ite.beautystore.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var productController: ProductController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
//      button()
        appBar()
//        val adapter = AppointmentListViewPagerAdapter(supportFragmentManager)
//        var categories = arrayOf("blush", "bronzer", "eyebrow", "eyeliner", "eyeshadow", "foundation", "lip_liner", "lipstick", "mascara", "nail_polish")
//        productController = ProductController(ApiClient.create())
//        for (category in categories) {
//            productController.getProducts(category) { products ->
//                if (products != null) {
//                    adapter.addFragments(MakeUpComingFragment.newInstance(products), category)
//                    adapter.notifyDataSetChanged();
//                }
//            }
//        }
//
//        binding.appointmentDetailsViewpager.adapter = adapter
//        binding.tabsLayout.setupWithViewPager(binding.appointmentDetailsViewpager)

//        binding.bottomNavigationView.setOnItemSelectedListener{
//            when(it.itemId){
//
//                R.id.navigation_home -> setCurrFragment(notifications_fragment)
//                R.id.navigation_cart ->
//                    setCurrFragment(home_fragment)
//                R.id.navigation_order -> setCurrFragment(history_fragment)
//                R.id.navigation_account -> setCurrFragment()
//            }
//            true
//        }

        setCurrFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    setCurrFragment(HomeFragment())
                    true
                }
                R.id.navigation_cart -> {
                    setCurrFragment(CartFragment())
                    true
                }
                R.id.navigation_order -> {
                    setCurrFragment(CartFragment())
                    true
                }
                R.id.navigation_account -> {
                    setCurrFragment(CartFragment())
                    true
                }
                else -> {
                    setCurrFragment(HomeFragment())
                    true
                }
            }
        }
    }


    private fun setCurrFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }

    }


    private fun appBar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}

