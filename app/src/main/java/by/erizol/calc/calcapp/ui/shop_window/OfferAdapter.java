package by.erizol.calc.calcapp.ui.shop_window;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import by.erizol.calc.calcapp.R;
import by.erizol.calc.calcapp.ui.base.BaseViewHolder;

public class OfferAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<OffersModel> offers = new ArrayList<>();
    private Callback callback;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OfferAdapter.AddressViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_offers, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    private Context context;

    public void setItems(List<OffersModel> offers) {
        this.offers.addAll(offers);
        notifyDataSetChanged();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback{

        void goBrowser(String url);

    }

    public class AddressViewHolder extends BaseViewHolder {

        @BindView(R.id.textView_description)
        TextView textViewDescription;
        @BindView(R.id.imageViewLogo)
        ImageView imageViewLogo;
        @BindView(R.id.textView_name)
        TextView textViewName;
        @BindView(R.id.layout_rv)
        RelativeLayout relativeLayout;


        public AddressViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();

        }

        @Override
        public void onBind(int position) {
            textViewName.setText(offers.get(position).getName());
            textViewDescription.setText(offers.get(position).getSummary());
            Glide.with(context)
                    .load(offers.get(position).getPic())
                    .into(imageViewLogo);
            relativeLayout.setOnClickListener(v -> {
                callback.goBrowser(offers.get(position).getLink());
            });

        }

    }
}
