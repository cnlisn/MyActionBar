package com.lisn.myactionbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
/**
 * @author LiShan
 * @date 2019/10/24
 */
public class TestInFragmentActivity extends AppCompatActivity {

    private int type = 1;

    private TestInOneFragment mTestInOneFragment = null;
    private TestInTwoFragment mTestInTwoFragment = null;
    private Fragment mCurrentFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_in_fragment);
        mTestInOneFragment = new TestInOneFragment();
        mTestInTwoFragment = new TestInTwoFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transactionTo(transaction, mTestInOneFragment);
    }

    public void switchFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (type == 1) {
            type = 2;
            transaction.setCustomAnimations(R.anim.right_in, R.anim.left_out);
            transactionTo(transaction, mTestInTwoFragment);
        } else if (type == 2) {
            type = 1;
            transaction.setCustomAnimations(R.anim.left_in, R.anim.right_out);
            transactionTo(transaction, mTestInOneFragment);
        }
    }

    private void transactionTo(FragmentTransaction transaction, Fragment fragment){
        if (mCurrentFragment != null){
            transaction.hide(mCurrentFragment);
        }
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl_fragment, fragment, fragment.getClass().getName());
        } else {
            transaction.show(fragment);
        }
        mCurrentFragment = fragment;
        transaction.commit();
    }
}
