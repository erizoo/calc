package by.erizol.calc.calcapp.ui.shop_window;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

import by.erizol.calc.calcapp.R;
import by.erizol.calc.calcapp.ui.base.BaseActivity;
import by.erizol.calc.calcapp.ui.shop_window.fragments.CalcFragment;
import by.erizol.calc.calcapp.ui.shop_window.fragments.CardFragment;
import by.erizol.calc.calcapp.ui.shop_window.fragments.CashFragment;
import by.erizol.calc.calcapp.ui.shop_window.fragments.CreditFragment;

public class Screen_ShopWindow extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected int getContentView() {
        return R.layout.shop_window_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        this.setTitle(intent.getStringExtra("LABEL"));

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(v -> {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        });

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CashFragment(), "ЗАЙМЫ");
        adapter.addFragment(new CardFragment(), "КРЕДИТНЫЕ КАРТЫ");
        adapter.addFragment(new CreditFragment(), "КРЕДИТЫ");
        adapter.addFragment(new CalcFragment(), "КАЛЬКУЛЯТОР");
        viewPager.setAdapter(adapter);
    }
}
