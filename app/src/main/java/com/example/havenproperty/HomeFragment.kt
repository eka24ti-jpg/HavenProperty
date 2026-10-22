

package com.example.havenproperty


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_home,
            container,
            false
        )
    }


    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button?>(R.id.btnProperty)
            ?.setOnClickListener {
                startActivity(
                    Intent(requireContext(), Property_ListActivity::class.java)
                )
            }


        view.findViewById<Button?>(R.id.btnAbout)
            ?.setOnClickListener {
                startActivity(
                    Intent(requireContext(), AboutActivity::class.java)
                )
            }


        view.findViewById<Button?>(R.id.btnWebsite)
            ?.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.rumah123.com")
                    )
                )
            }


        view.findViewById<Button?>(R.id.btnProfile)
            ?.setOnClickListener {
                startActivity(
                    Intent(requireContext(), ProfileActivity::class.java)
                )
            }
    }
}



