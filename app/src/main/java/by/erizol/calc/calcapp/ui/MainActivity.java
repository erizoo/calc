package by.erizol.calc.calcapp.ui;

import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import by.erizol.calc.calcapp.R;
import by.erizol.calc.calcapp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.sendMessage();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void sendMessage() {
        Toast.makeText(this, "готово", Toast.LENGTH_LONG).show();
    }
}
