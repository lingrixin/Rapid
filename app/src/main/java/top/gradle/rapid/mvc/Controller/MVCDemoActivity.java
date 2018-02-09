/*
 *
 *  * Copyright © 2014 Phantom.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package top.gradle.rapid.mvc.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import top.gradle.rapid.R;
import top.gradle.rapid.base.BaseBackActivity;
import top.gradle.rapid.mvc.Model.IDataModel;
import top.gradle.rapid.mvc.Model.SampleDataModel;

/**
 * <pre>
 *     @author: Created by Phantom
 *     @eamil : phantom@gradle.top‍
 *     @time  : 2018/2/9.
 *     @desc  : MVCDemoActivity
 * </pre>
 */
public class MVCDemoActivity extends BaseBackActivity implements IDataResult {

    public static void start(Context context) {
        context.startActivity(new Intent(context, MVCDemoActivity.class));
    }

    private Button btGet;
    private TextView tvData;
    private IDataModel dataModel;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_mvc;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getClass().getSimpleName());
        btGet = findViewById(R.id.bt_get);
        tvData = findViewById(R.id.tv_data);
    }

    @Override
    public void doBusiness() {
        tvData.setText("init");
        dataModel = new SampleDataModel();
        btGet.setOnClickListener(this);
    }

    @Override
    public void onWidgetClick(View view) {
        dataModel.getData("go to google", this);
    }

    @Override
    public void onStartData() {
        tvData.setText("start google dataing");
    }

    @Override
    public void getDataSuccess(String resule) {
        tvData.setText(resule);
    }

    @Override
    public void getDataFailed(String reason) {
        tvData.setText(reason);
    }
}
