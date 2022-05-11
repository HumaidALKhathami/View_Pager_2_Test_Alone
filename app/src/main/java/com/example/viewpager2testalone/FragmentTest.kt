package com.example.viewpager2testalone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FragmentTest : Fragment() {

    private val outerList: List<String> = listOf(
        "tab#1",
        "tab#2",
        "tab#3",
        "tab#4",
        "tab#5",
        "tab#6"
    )

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.test_fragment, container, false)

        viewPager = view.findViewById(R.id.view_pager)
        tabLayout = view.findViewById(R.id.tab_layout)

        val viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(requireActivity(), outerList)

        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "tab #${position + 1}"
        }.attach()

        return view
    }

}


class ViewPagerAdapter(fa: FragmentActivity, private val outerList: List<String>) :
    FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = outerList.size

    override fun createFragment(position: Int): Fragment = PostsFragment()
}