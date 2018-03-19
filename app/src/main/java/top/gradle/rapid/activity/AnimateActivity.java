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

package top.gradle.rapid.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import top.gradle.rapid.R;
import top.gradle.rapid.base.BaseBackActivity;
import top.gradle.rapid.widget.AnimateHorizontalProgressBar;

/**
 * <pre>
 *     @author: Created by Phantom
 *     @eamil : phantom@gradle.top‍
 *     @time  : 3/19/2018.
 *     @desc  : AnimateActivity
 * </pre>
 */
public class AnimateActivity extends BaseBackActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, AnimateActivity.class));
    }

    AnimateHorizontalProgressBar pb_loading;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_animate;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        pb_loading =  f(R.id.pb_loading);
        f(R.id.bt_send_notification).setOnClickListener(this);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        pb_loading.setMax(1000);
        pb_loading.setProgress(100);
        pb_loading.setProgressWithAnim(1000);
    }
}
