package by.erizol.calc.calcapp.ui.calc_page;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import by.erizol.calc.calcapp.R;
import by.erizol.calc.calcapp.ui.models.CreditModel;
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

    @BindView(R.id.textView_interest_per_month)
    TextView interestPerMonthTextView;
    @BindView(R.id.textView_body_credit)
    TextView bodyCreditTextView;
    @BindView(R.id.textView_monthly_payment)
    TextView monthlyPaymentTextView;
    @BindView(R.id.textView_total_sum)
    TextView totalSumTextView;
    @BindView(R.id.textView_overpayment)
    TextView overpaymentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.onAttach(this);
    }


    @OnClick(R.id.count_button)
    public void count() {
        CreditModel creditModel = new CreditModel();
        creditModel.setSummCredit(Double.parseDouble(creditSummEditText.getText().toString()));
        creditModel.setRate(Double.parseDouble(rateEditText.getText().toString()) / 100);
        creditModel.setDate(Double.parseDouble(dateEditText.getText().toString()));
        presenter.count(creditModel);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void sendMessage(double interestPerMonth, double bodyCredit, double monthlyPaymen, double totalSum, double overpayment) {
        interestPerMonthTextView.setText(R.string.interest_per_month);
        bodyCreditTextView.setText(R.string.body_credit);
        monthlyPaymentTextView.setText(R.string.monthly_payment);
        totalSumTextView.setText(R.string.total_sum);
        overpaymentTextView.setText(R.string.overpayment);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(interestPerMonthTextView.getText()).append(" ").append(String.valueOf(interestPerMonth));
        interestPerMonthTextView.setText(stringBuilder);
        stringBuilder.setLength(0);
        stringBuilder.append(bodyCreditTextView.getText()).append(" ").append(String.valueOf(bodyCredit));
        bodyCreditTextView.setText(stringBuilder);
        stringBuilder.setLength(0);
        stringBuilder.append(monthlyPaymentTextView.getText()).append(" ").append(String.valueOf(monthlyPaymen));
        monthlyPaymentTextView.setText(stringBuilder);
        stringBuilder.setLength(0);
        stringBuilder.append(totalSumTextView.getText()).append(" ").append(String.valueOf(totalSum));
        totalSumTextView.setText(stringBuilder);
        stringBuilder.setLength(0);
        stringBuilder.append(overpaymentTextView.getText()).append(" ").append(String.valueOf(overpayment));
        overpaymentTextView.setText(stringBuilder);
    }


    @Override
    protected void onStart() {
        super.onStart();

    }
}
