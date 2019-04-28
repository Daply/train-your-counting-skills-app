package com.dariapro.traincounting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.dariapro.traincounting.fragment.CategoryListFragment;
import com.dariapro.traincounting.fragment.ExampleStartFragment;

import java.util.UUID;

public class CategoryActivity extends SingleFragmentActivity {

    public static final String EXTRA_CATEGORY_ID = "com.dariapro.traincounting.category_id";
    public static final String MODE = "com.dariapro.traincounting.mode";

    @Override
    protected Fragment createFragment() {
        String value = getIntent().getExtras().getString(MODE);
        Bundle bundle = new Bundle();
        bundle.putString(MODE, value);
        Fragment fragment = new CategoryListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static Intent newIntent(Context packegeContext, UUID categoryId){
        Intent intent = new Intent(packegeContext, LevelListActivity.class);
        intent.putExtra(EXTRA_CATEGORY_ID, categoryId);
        return intent;
    }
}