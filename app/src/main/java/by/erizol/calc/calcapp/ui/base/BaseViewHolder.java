package by.erizol.calc.calcapp.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    private int currentPosition;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void onBind(int position) {
        currentPosition = position;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
