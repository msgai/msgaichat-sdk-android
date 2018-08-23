package ai.msg.demo;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ai.msg.msgaichat.model.User;
import ai.msg.msgaichat.utils.MsgaiChat;
import ai.msg.msgaichat.utils.MsgaiChatListener;
import ai.msg.msgaichat.utils.Settings;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getName();

    TextView fistName, lastName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fistName = (TextView)findViewById(R.id.text_first_name);
        lastName = (TextView)findViewById(R.id.text_last_name);

        Settings settings = new Settings("#MSGAIBotKey", "#SecretKey");
        settings.setBrandName("#BrandName");
        settings.setBrandLogoImage(BitmapFactory.decodeResource(getResources(), R.drawable.msgaichat_icon));
/*
        settings.setReceiverBubbleColor("#" + Integer.toHexString (getResources().getColor(R.color.colorChatSenderClient)));
        settings.setSenderBubbleColor("#" + Integer.toHexString (getResources().getColor(R.color.colorChatReceiverClient)));
*/

        MsgaiChat.init(MainActivity.this, settings, new MsgaiChatListener() {
            @Override
            public void userMessagePosted(String messageJson) {
                Log.i(TAG, "User posted message: "+messageJson);
            }

            @Override
            public void botPostedMessage(String messageJson) {
                Log.i(TAG, "Bot posted message: "+messageJson);
            }
        });

        User user = User.currentUser();
        user.setCrmId("user0");
        user.setFirstName(fistName.getText().toString());
        user.setLastName(lastName.getText().toString());
        user.setGender(User.GenderMale);
        user.setLocation("New York");

        // Add your own custom properties
        final Map<String, Object> customProperties = new HashMap<>();
        customProperties.put("Last Seen", new Date());
        customProperties.put("isFirstTime", false);
        customProperties.put("Reuqest ID", 1337);
        user.addProperties(customProperties);



        Button chatButton = (Button)findViewById(R.id.start_chat);

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MsgaiChat.startChat();
           }
        });

    }
}
