package kh.edu.rupp.ite.beautystore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kh.edu.rupp.ite.beautystore.controller.ProductController
import kh.edu.rupp.ite.beautystore.databinding.ProductDetailBinding

class ProductDetailActivity : AppCompatActivity(){
    private lateinit var binding: ProductDetailBinding
    private lateinit var productController: ProductController
    private var id: Int? = null
    private var name: String? =null
    private var brand: String? = null
    private var price: String? = null
    private var imageLink: String? =null
    private var description: String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getIntExtra("id",1)
        name = intent.getStringExtra("name")
        brand = intent.getStringExtra("brand")
        imageLink = intent.getStringExtra("image_link")
        description = intent.getStringExtra("description")
        price = intent.getStringExtra("price")

        binding.tvProductDetailName.text = name
        binding.priceProduct.text = "$ $price"
        binding.brandProduct.text = "Brand: $brand"
        binding.descriptionProduct.text = description
        Glide.with(binding.imageProduct.context)
            .load("https:" + imageLink)
            .into(binding.imageProduct)

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}