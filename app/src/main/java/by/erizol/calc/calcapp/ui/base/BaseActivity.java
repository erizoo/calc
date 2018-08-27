package by.erizol.calc.calcapp.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.erizol.calc.calcapp.Calc;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    @Inject
    CompositeDisposable compositeDisposable;

    private Unbinder unbinder;

    protected RelativeLayout leftDrawer;
    protected DrawerLayout drawerLayout;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        unbinder = ButterKnife.bind(this);


    }

    protected abstract int getContentView();



    @Override
    public Context getContext() {
        return getApplicationContext();
    }


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        super.onDestroy();
    }

    @Override
    public void startScreen(Class activity, boolean isClearTop) {
        startActivity(new Intent(this, activity));
        if (isClearTop) finishAffinity();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

}
