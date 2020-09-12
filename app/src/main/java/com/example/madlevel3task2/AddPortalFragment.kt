package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add_portal.view.*
import kotlinx.android.synthetic.main.item_portal.*
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*

const val ARG_PORTAL_TITLE = "arg_portal_name"
const val ARG_PORTAL_URL = "arg_portal_url"

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPortalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.edit_portal_url.setText("http://")

        view.btn_add_portal.setOnClickListener {
            onAddPortal()
        }
    }

    private fun onAddPortal() {
        val portalTitle = edit_portal_title.text.toString()
        val portalUrl = edit_portal_url.text.toString()
        if (portalTitle.isNotBlank() || portalUrl.isNotBlank()) {
            val args = Bundle()
            args.putString(ARG_PORTAL_TITLE, portalTitle)
            args.putString(ARG_PORTAL_URL, portalUrl)
            findNavController().navigate(R.id.action_AddPortalFragment_to_PortalsFragment, args)
        } else {
            Toast.makeText(activity, R.string.blank_text_error, Toast.LENGTH_LONG).show()
        }

    }

}