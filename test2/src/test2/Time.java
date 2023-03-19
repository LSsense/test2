package test2;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;

public class Time {
	private static int src=0;//时钟的记录 
	private static boolean flag=true;//用来屏蔽时钟,如果为true时钟正常启动，如果为false时钟被屏蔽
	public static ScheduledExecutorService JobRequest = Executors.newSingleThreadScheduledExecutor();
	public static ScheduledExecutorService ProcessScheduling = Executors.newSingleThreadScheduledExecutor();
	public static void Continue()//时间继续流动
	{
		flag=true;
	}
	public static void Begin_time()//时钟开启，内置ProcessScheduling线程
	{
		//ScheduledExecutorService ProcessScheduling = Executors.newSingleThreadScheduledExecutor();
		ProcessScheduling.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
            //System.out.println("run "+ System.currentTimeMillis());
         	if(flag)//信号判断是否运行
             {
         		src++;
//         		if(Time.time_now()==97)
//        		{
//        			System.out.println("time_now "+Time.time_now());
//        		}
         		JTYX.run2();
             }
         }
     }, 0, 1000, TimeUnit.MILLISECONDS);
	}
	static public int time_now() {//返回当前时间
		return src;
	}
	public static void JobRequest()//作业请求线程（10秒每次）
	{
		//ScheduledExecutorService JobRequest = Executors.newSingleThreadScheduledExecutor();
		JobRequest.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
            if(flag)
            {
            	//System.out.println("JobRequest");
            	JTYX.run1();
            }
         }
     }, 0, 10000, TimeUnit.MILLISECONDS);
	}
	public static void Stop_time()//暂停标志位
	{
		flag=false;
	}
}

