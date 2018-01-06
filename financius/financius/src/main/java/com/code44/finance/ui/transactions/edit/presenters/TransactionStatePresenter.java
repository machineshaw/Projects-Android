package com.code44.finance.ui.transactions.edit.presenters;

import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.code44.finance.R;
import com.code44.finance.common.model.TransactionState;
import com.code44.finance.ui.common.activities.BaseActivity;
import com.code44.finance.ui.common.presenters.Presenter;

public class TransactionStatePresenter extends Presenter {
    private final CheckBox confirmedCheckBox;
    private final CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    public TransactionStatePresenter(BaseActivity activity, CompoundButton.OnCheckedChangeListener checkedChangeListener) {
        confirmedCheckBox = findView(activity, R.id.confirmedCheckBox);

        onCheckedChangeListener = checkedChangeListener;
        confirmedCheckBox.setOnCheckedChangeListener(checkedChangeListener);
    }

    public void setTransactionState(TransactionState transactionState) {
        confirmedCheckBox.setOnCheckedChangeListener(null);
        confirmedCheckBox.setChecked(transactionState == TransactionState.Confirmed);
        confirmedCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
