package kh.edu.rupp.ite.beautystore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kh.edu.rupp.ite.beautystore.adapter.SkinCareAdapter
import kh.edu.rupp.ite.beautystore.model.SkinCareModel


class SkinCareUpComingFragment : Fragment() {
    private lateinit var rvSkinCare: RecyclerView
    private lateinit var skinCareAdapter: SkinCareAdapter
    private var skinCareList: ArrayList<SkinCareModel> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skin_care, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvSkinCare = view.findViewById(R.id.rv_skin_care)
        val layoutManager = GridLayoutManager(view.context, 2)

        rvSkinCare.layoutManager = layoutManager
        skinCareAdapter = SkinCareAdapter(skinCareList)
        rvSkinCare.adapter = skinCareAdapter
    }
}
