package test2;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;

public class Time {
	private static int src=0;//ʱ�ӵļ�¼ 
	private static boolean flag=true;//��������ʱ��,���Ϊtrueʱ���������������Ϊfalseʱ�ӱ�����
	public static ScheduledExecutorService JobRequest = Executors.newSingleThreadScheduledExecutor();
	public static ScheduledExecutorService ProcessScheduling = Executors.newSingleThreadScheduledExecutor();
	public static void Continue()//ʱ���������
	{
		flag=true;
	}
	public static void Begin_time()//ʱ�ӿ���������ProcessScheduling�߳�
	{
		//ScheduledExecutorService ProcessScheduling = Executors.newSingleThreadScheduledExecutor();
		ProcessScheduling.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
            //System.out.println("run "+ System.currentTimeMillis());
         	if(flag)//�ź��ж��Ƿ�����
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
	static public int time_now() {//���ص�ǰʱ��
		return src;
	}
	public static void JobRequest()//��ҵ�����̣߳�10��ÿ�Σ�
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
	public static void Stop_time()//��ͣ��־λ
	{
		flag=false;
	}
}

