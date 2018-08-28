package by.erizol.calc.calcapp.ui.shop_window;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.erizol.calc.calcapp.R;

public class CalcFragment extends Fragment {

    private Unbinder unbinder;

    EditText creditSummEditText;
    EditText rateEditText;
    EditText dateEditText;

    Button countButton;

    TextView interestPerMonthTextView;
    TextView bodyCreditTextView;
    TextView monthlyPaymentTextView;
    TextView totalSumTextView;
    TextView overpaymentTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this, Objects.requireNonNull(getActivity()));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        creditSummEditText = view.findViewById(R.id.editText_credit_summ);
        rateEditText = view.findViewById(R.id.editText_rate);
        dateEditText = view.findViewById(R.id.editText_date);

        countButton = view.findViewById(R.id.count_button);

        interestPerMonthTextView = view.findViewById(R.id.textView_interest_per_month);
        bodyCreditTextView = view.findViewById(R.id.textView_body_credit);
        monthlyPaymentTextView = view.findViewById(R.id.textView_monthly_payment);
        totalSumTextView = view.findViewById(R.id.textView_total_sum);
        overpaymentTextView = view.findViewById(R.id.textView_overpayment);

        countButton.setOnClickListener(v -> {
            interestPerMonthTextView.setText(R.string.interest_per_month);
            bodyCreditTextView.setText(R.string.body_credit);
            monthlyPaymentTextView.setText(R.string.monthly_payment);
            totalSumTextView.setText(R.string.total_sum);
            overpaymentTextView.setText(R.string.overpayment);
            CreditModel creditModel = new CreditModel();
            creditModel.setSummCredit(Double.parseDouble(creditSummEditText.getText().toString()));
            creditModel.setRate(Double.parseDouble(rateEditText.getText().toString()) / 100);
            creditModel.setDate(Double.parseDouble(dateEditText.getText().toString()));
            double interestPerMonth = getInterestPerMonth(creditModel);
            double bodyCredit = getBodyCredit(creditModel);
            double monthlyPaymen = getMonthlyPaymen(bodyCredit, interestPerMonth);
            double totalSum = getTotalSum(monthlyPaymen, creditModel);
            double overpayment = getOverpayment(totalSum, creditModel);

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
        });
    }

    private double getOverpayment(double totalSum, CreditModel creditModel) {
        double result = totalSum - creditModel.getSummCredit();
        return Math.round(result * 100) / 100.0d;
    }

    private double getTotalSum(double monthlyPaymen, CreditModel creditModel) {
        double result = monthlyPaymen * creditModel.getDate();
        return Math.round(result * 100) / 100.0d;
    }

    private double getMonthlyPaymen(double bodyCredit, double interestPerMonth) {
        double result = bodyCredit + interestPerMonth;
        return Math.round(result * 100) / 100.0d;
    }

    private double getBodyCredit(CreditModel creditModel) {
        double result = creditModel.getSummCredit() / creditModel.getDate();
        return Math.round(result * 100) / 100.0d;
    }

    private double getInterestPerMonth(CreditModel creditModel) {
        double result = (creditModel.getSummCredit() * creditModel.getRate() * 30) / 365;
        return Math.round(result * 100) / 100.0d;
    }


}