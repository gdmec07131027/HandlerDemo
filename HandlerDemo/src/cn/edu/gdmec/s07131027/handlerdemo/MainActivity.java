package cn.edu.gdmec.s07131027.handlerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private ImageView imageView;
	private Handler handler;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        
        handler = new Handler(){
        	public void handleMessage(android.os.Message msg) {
        		int imageResource = (Integer) msg.obj;
        		imageView.setImageResource(imageResource);
        	};
        };
    }
    
    public void doClick(View v){
    	//1.在工作线程中执行下载
    	new Thread(){
    		
    		public void run() {
    			try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			Message msg = Message.obtain();
    			msg.obj = R.drawable.ic_launcher;
    			//子线程中发送图片到主线程中
    			handler.sendMessage(msg);
    			
    			
    		};
    		
    	}.start();
    	
    }
    
}
