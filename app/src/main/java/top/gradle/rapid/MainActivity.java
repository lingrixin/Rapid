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

package top.gradle.rapid;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import top.gradle.baselib.BaseActivity;

/**
 * <pre>
 *     @author: Created by Phantom
 *     @eamil : phantom@gradle.top‍
 *     @time  : 2018/1/24.
 *     @desc  : MainActivity
 * </pre>
 */
public class MainActivity extends BaseActivity {

    TextView textView;

    private String str= "{\"name\":\"phantom\",\"age\":\"24\",\"emailAddress\":\"lingrixin@live.cn\"}";

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        textView = f(R.id.tv_hello);
        textView.setText(str);
        TextView textView1 = f(R.id.tv_hello1);
//        Student student = new Gson().fromJson(str,Student.class);
        Student student = JSON.parseObject(str,new TypeReference<Student>(){});
        textView1.setText(student.toString());
        textView.setOnClickListener(this);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        Toast.makeText(MainActivity.this, "hello github", Toast.LENGTH_SHORT).show();
    }
}
