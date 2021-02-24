package ru.ndevelop.mechetapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.ndevelop.mechetapp.R
import ru.ndevelop.mechetapp.adapters.MechetAdapter
import ru.ndevelop.mechetapp.adapters.OnMechetClickListener
import ru.ndevelop.mechetapp.ui.mechet.MechetInfoActivity


class DashboardFragment : Fragment(), OnMechetClickListener {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var rvMechets: RecyclerView
    private val mechetAdapter = MechetAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        rvMechets = root.findViewById(R.id.rv_mechet)
        with(rvMechets){
            adapter = mechetAdapter
            layoutManager = LinearLayoutManager(requireContext())

        }

        return root
    }

    override fun onMechetClicked(mechetId: Int) {
        val intent = Intent(requireContext(), MechetInfoActivity::class.java)
        val b = Bundle()
        b.putInt("mechetId", mechetId) //Your id
        intent.putExtras(b) //Put your id to your next Intent
        startActivity(intent)
    }
}