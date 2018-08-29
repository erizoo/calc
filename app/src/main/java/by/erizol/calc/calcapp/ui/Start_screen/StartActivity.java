package by.erizol.calc.calcapp.ui.Start_screen;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.erizol.calc.calcapp.R;
import by.erizol.calc.calcapp.data.ResponseModel.ResponseCountry;
import by.erizol.calc.calcapp.ui.base.BaseActivity;
import by.erizol.calc.calcapp.ui.calc_page.MainActivity;
import by.erizol.calc.calcapp.ui.models.FireBasePojo;
import by.erizol.calc.calcapp.ui.shop_window.Screen_ShopWindow;

public class StartActivity extends BaseActivity implements StartMvpView {

    @Inject
    StartMvpPresenter<StartMvpView> presenter;

    private String appName;
    private static final String TAG = "FireBase";

    private List<String> countries = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.onAttach(this);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("8P14Lu09QNSDn0yJmfWJvog0TGC3");

        if (isNetworkConnected()){
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    FireBasePojo model = dataSnapshot.getValue(FireBasePojo.class);
                    if (model != null) {
                        appName = model.getName();
                        countries.addAll(model.getCountries());
                        presenter.checkCountry();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else {
            Toast.makeText(this, "Нужно подключить интернет!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected int getContentView() {
        return R.layout.start_activity;
    }

    @Override
    public void onCountryChecked(ResponseCountry responseCountry) {
        for (String items : countries) {
            if (items.equals(responseCountry.getCountry())){
                if (isNetworkConnected()){
                    Intent intent = new Intent(this, Screen_ShopWindow.class);
                    intent.putExtra("LABEL", appName);
                    startActivity(intent);
                    break;
                } else {
                    Toast.makeText(this, "Нужно подключить интернет!", Toast.LENGTH_LONG).show();
                }
            } else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
