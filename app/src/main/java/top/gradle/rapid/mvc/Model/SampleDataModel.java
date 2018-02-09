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

package top.gradle.rapid.mvc.Model;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

import java.lang.ref.WeakReference;

import top.gradle.rapid.mvc.Controller.IDataResult;

/**
 * <pre>
 *     @author: Created by Phantom
 *     @eamil : phantom@gradle.top‍
 *     @time  : 2018/2/9.
 *     @desc  : SampleDataModel
 * </pre>
 */
public class SampleDataModel implements IDataModel{

    public static class MyHandler extends Handler {
        private WeakReference<IDataResult> reference;
        public MyHandler(IDataResult response){
            reference = new WeakReference<IDataResult>(response);
        }

        @Override
        public void handleMessage(Message msg) {
            IDataResult response = reference.get();
            if(response==null){
                return;
            }
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    response.onStartData();
                    break;
                case 1:
                    response.getDataSuccess("数据成功返回");
                    break;
                case 2:
                    response.getDataFailed("数据加载失败");
                    break;
            }
        }
    }

    @Override
    public void getData(String request, IDataResult response) {
        final MyHandler a= new MyHandler(response);
        new Thread(new Runnable() {
            @Override
            public void run() {
                a.sendEmptyMessage(0);
                SystemClock.sleep(3000);
                a.sendEmptyMessage(1);
            }
        }).start();
    }
}
