package kh.edu.rupp.ite.beautystore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kh.edu.rupp.ite.beautystore.controller.ProductController
import kh.edu.rupp.ite.beautystore.utility.ApiClient

class HomeFragment : Fragment() {
    private lateinit var  appointmentDetailsViewpager: ViewPager
    private lateinit var tabsLayout :TabLayout
    private lateinit var productController: ProductController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabsLayout = view.findViewById(R.id.tabsLayout)
        appointmentDetailsViewpager = view.findViewById(R.id.appointmentDetails_viewpager)

        val adapter = AppointmentListViewPagerAdapter(this.parentFragmentManager)
        var categories = arrayOf("blush", "bronzer", "eyebrow", "eyeliner", "eyeshadow", "foundation", "lip_liner", "lipstick", "mascara", "nail_polish")
        productController = ProductController(ApiClient.create())
        for (category in categories) {
            productController.getProducts(category) { products ->
                if (products != null) {
                    adapter.addFragments(MakeUpComingFragment.newInstance(products), category)
                    adapter.notifyDataSetChanged();
                }
            }
        }

        appointmentDetailsViewpager.adapter = adapter
        tabsLayout.setupWithViewPager(appointmentDetailsViewpager)
    }

    class AppointmentListViewPagerAdapter(fragment: FragmentManager) :
        FragmentPagerAdapter(fragment) {
        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()
        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        fun addFragments(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}