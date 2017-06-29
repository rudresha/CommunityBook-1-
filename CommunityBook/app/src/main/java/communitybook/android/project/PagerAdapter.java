package communitybook.android.project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by rudresha on 22/06/17.
 */

public class PagerAdapter  extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TimeLineFragment tab1 = new TimeLineFragment();
                return tab1;
            case 1:
                FriendRequestFragment tab2 = new FriendRequestFragment();
                return tab2;
            case 2:
                NotificationsFragment tab3 = new NotificationsFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}