package tun.kt.baseprojectroxwin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val itemCount: Int,
    private val listFragment: List<Fragment>
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = itemCount

    override fun createFragment(position: Int): Fragment {
        return listFragment[position]
    }
}