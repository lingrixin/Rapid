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

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.view.View;

import top.gradle.rapid.R;
import top.gradle.rapid.base.BaseBackActivity;

/**
 * <pre>
 *     @author: Created by Phantom
 *     @eamil : phantom@gradle.top‍
 *     @time  : 3/19/2018.
 *     @desc  : NotificationTestActivity
 * </pre>
 */
public class NotificationTestActivity extends BaseBackActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, NotificationTestActivity.class));
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_notification;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        f(R.id.bt_send_notification).setOnClickListener(this);
    }

    @Override
    public void doBusiness() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onWidgetClick(View view) {
        if (view.getId() == R.id.bt_send_notification) {
            //发送一个通知
//            sendNotification();
            baseNotify();

        }
    }

    private NotificationManager manager;
    public static final String PRIMARY_CHANNEL = "default";
    public static final String SECONDARY_CHANNEL = "second";

    public void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), PRIMARY_CHANNEL)
                .setContentTitle("setContentTitle")
                .setContentText("setContentText")
                .setSmallIcon(R.drawable.ic_launcher)
                //                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0x01, builder.build());
    }

    private void baseNotify() {
        //获取NotificationManager实例
        NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //实例化NotificationCompat.Builder并设置相关属性
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                //设置小图标
                .setSmallIcon(R.mipmap.ic_launcher)
                //设置通知标题
                .setContentTitle("最简单的Notification")
                //设置通知内容
                .setContentText("只有小图标、标题、内容");
        //通过builder.build()方法生成Notification对象,并发送通知,id=1
        if (notifyManager != null) {
            notifyManager.notify(1, builder.build());
        }
    }

}
