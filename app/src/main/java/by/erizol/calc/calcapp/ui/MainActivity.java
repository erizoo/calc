package by.erizol.calc.calcapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import by.erizol.calc.calcapp.R;
import by.erizol.calc.calcapp.data.ResponseModel.ResponseCountry;
import by.erizol.calc.calcapp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView {

    private static final String TAG = "FireBase";
    private static final String EMAIL = "alexboiko1993@gmail.com";
    private static final String PASSWORD = "Alex209688";

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

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        mAuth = FirebaseAuth.getInstance();
        presenter.onAttach(this);
    }

    @OnClick(R.id.count_button)
    public void count(){
        mAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();

                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                    }
                });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void sendMessage(double interestPerMonth, double bodyCredit, double monthlyPaymen, double totalSum, double overpayment) {
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
    public void onCountrtChecked(ResponseCountry responseCountry) {
        System.out.println(responseCountry);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
