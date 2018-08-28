package by.erizol.calc.calcapp.ui.Start_screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
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
import by.erizol.calc.calcapp.ui.calc_page.MainActivity;
import by.erizol.calc.calcapp.ui.shop_window.FireBasePojo;
import by.erizol.calc.calcapp.ui.shop_window.Screen_ShopWindow;
import by.erizol.calc.calcapp.ui.base.BaseActivity;

public class StartActivity extends BaseActivity implements StartMvpView {

    @Inject
    StartMvpPresenter<StartMvpView> presenter;

    private static final String TAG = "FireBase";

    private List<String> countries = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.onAttach(this);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("8P14Lu09QNSDn0yJmfWJvog0TGC3");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FireBasePojo model = dataSnapshot.getValue(FireBasePojo.class);
                if (model != null) {
                    countries.addAll(model.getCountries());
                    presenter.checkCountry();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.start_activity;
    }

    @Override
    public void onCountryChecked(ResponseCountry responseCountry) {
        for (String items : countries) {
            if (items.equals(responseCountry.getCountry())){
                Intent intent = new Intent(this, Screen_ShopWindow.class);
                startActivity(intent);
                break;
            } else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
