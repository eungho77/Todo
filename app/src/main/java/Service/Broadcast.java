package Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.gwangtae.todo.MainActivity;

public class Broadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // 서비스 종료시 다시 부활하게 만듬
        if(intent.getAction().equals("android.intent.action.PACKAGE_RESTARTED")){

            Log.i("000 RestartService" ,"ACTION.RESTART.PersistentService " );
            Toast.makeText(context, "Service restart!", Toast.LENGTH_SHORT).show();
            Intent restart = new Intent(context,MainActivity.class);
            context.startActivity(restart);
        }

        // 폰 재부팅하면 알아서 앱 실행
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {   // 재부팅 완료되면
            Toast.makeText(context, "재부팅 완료", Toast.LENGTH_SHORT).show();
            Intent i= new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
