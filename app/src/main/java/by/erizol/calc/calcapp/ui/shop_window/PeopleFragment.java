package by.erizol.calc.calcapp.ui.shop_window;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import by.erizol.calc.calcapp.R;

public class PeopleFragment extends Fragment implements OfferAdapter.Callback {

    private OfferAdapter offerAdapter;

    RecyclerView recyclerViewOffer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

        myRef.child("8P14Lu09QNSDn0yJmfWJvog0TGC3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FireBasePojo model = dataSnapshot.getValue(FireBasePojo.class);
                if (model != null) {
                    offerAdapter.setItems(model.getOffers());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.peoplefragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewOffer = view.findViewById(R.id.recyclerView_offer);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewOffer.setLayoutManager(layoutManager);

        offerAdapter = new OfferAdapter();
        offerAdapter.setCallback(this);
        recyclerViewOffer.setAdapter(offerAdapter);
    }

    @Override
    public void goBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
