package kh.edu.rupp.ite.beautystore

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kh.edu.rupp.ite.beautystore.adapter.ProductAdapter
import kh.edu.rupp.ite.beautystore.model.Product


class MakeUpComingFragment : Fragment(){
    private lateinit var rvMakeUp: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private var products: ArrayList<Product> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_make_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMakeUp = view.findViewById(R.id.rv_make_up)
        val layoutManager = GridLayoutManager(view.context, 2)

        rvMakeUp.layoutManager = layoutManager
       // productAdapter = ProductAdapter(products , )
        productAdapter = ProductAdapter(products) { product ->
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("id", product.id)
            intent.putExtra("image_link",product.api_featured_image)
            intent.putExtra("brand",product.brand)
            intent.putExtra("name",product.name)
            intent.putExtra("price",product.price.toString())
            intent.putExtra("description",product.description)
            context?.startActivity(intent)
        }
        rvMakeUp.adapter = productAdapter

    }

    companion object {
        fun newInstance(products: ArrayList<Product>): MakeUpComingFragment {
            val fragment = MakeUpComingFragment()
            fragment.products = products;
            return fragment
        }
    }
}