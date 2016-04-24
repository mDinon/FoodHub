package hr.mc2.foodhub;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    AboutFragment tab1 = new AboutFragment();
                    return tab1;
                case 1:
                    FoodFragment tab2 = new FoodFragment();
                    return tab2;
                case 2:
                    ReviewFragment tab3 = new ReviewFragment();
                    return tab3;
                default:
                    AboutFragment tab4 = new AboutFragment();
                    return tab4;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

