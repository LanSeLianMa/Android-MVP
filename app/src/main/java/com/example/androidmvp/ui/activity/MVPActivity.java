package com.example.androidmvp.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.example.androidmvp.R;
import com.example.androidmvp.databinding.ActivityMvpBinding;
import com.example.androidmvp.mvp.model.IModel;
import com.example.androidmvp.mvp.model.IModelImp;
import com.example.androidmvp.mvp.presenter.IPresenter;
import com.example.androidmvp.mvp.presenter.IPresenterImp;
import com.example.androidmvp.mvp.view.IView;

public class MVPActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private ActivityMvpBinding binding;
    private IModel iModel;
    private IPresenter iPresenter;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMvpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iPresenter = new IPresenterImp();
        iModel = new IModelImp();

        // 注意一下，写的顺序

        iModel.setPresenter(iPresenter); // 持有 Presenter
        setPresenter(iPresenter); // 持有 Presenter

        iPresenter.setModel(iModel); // 持有 Model
        iPresenter.setView(this); // 持有 View

        init();
    }

    @Override
    public void onClick(View v) {
        if (v == binding.submitBtn) {
            iPresenter.submitFromData();
        } else if (v == binding.clearBtn) {
            iPresenter.clearData();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.removeHandlerMsgAndCallback();
    }

    private void init() {
        binding.editMsg.setText("normal");
        binding.edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                iPresenter.onDataChanged(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.submitBtn.setOnClickListener(this);
        binding.clearBtn.setOnClickListener(this);
    }

    @Override
    public void onDataChangedUpdateText(String data) {
        binding.editMsg.setText(data);
    }

    @Override
    public void showSubmitFromLoading(String data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView textView = new TextView(this);
        if (TextUtils.isEmpty(data)) {
            data = "normal";
        }
        textView.setText("正在提交：" + data);
        builder.setCancelable(false);
        builder.setView(textView);
        dialog = builder.show();
    }

    @Override
    public void hideSubmitFromLoading() {
        dialog.dismiss();
    }

    @Override
    public void clearFromData() {
        binding.edit.setText("");
        binding.editMsg.setText("normal");
    }

}