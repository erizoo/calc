package by.erizol.calc.calcapp.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import by.erizol.calc.calcapp.Calc;
import by.erizol.calc.calcapp.R;
import by.erizol.calc.calcapp.di.component.ApplicationComponent;
import by.erizol.calc.calcapp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> presenter;

    @BindView(R.id.editText_credit_summ)
    EditText creditSummEditText;
    @BindView(R.id.editText_rate)
    EditText rateEditText;
    @BindView(R.id.editText_date)
    EditText dateEditText;
    @BindView(R.id.count_button)
    Button countButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.sendMessage();
    }

    @OnClick(R.id.count_button)
    public void count(){
        CreditModel creditModel = new CreditModel();
        creditModel.setSummCredit(creditSummEditText.getText().toString());
        creditModel.setRate(rateEditText.getText().toString());
        creditModel.setDate(dateEditText.getText().toString());
        presenter.count(creditModel);
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
