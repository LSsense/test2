package test2;

import java.util.Timer;
import java.util.TimerTask;

public class InputBlockthread {
	 public  void Begin() {//����InputBlockthread�߳�
	        //����һ���µĶ�ʱ������
	        Timer timer = new Timer();

	        //void schedule(TimerTask task, long delay)
	        // ��ָ����delay�ӳ�ʱ���ִ��task����
	        timer.schedule(new MyTask(timer),2000); //�����2000��2000���룬��2��

	        //timer.cancel();��ֹ��ʱ��䲻��д������
	        /*
	            ��Ϊtimer��TimerTask�Ķ��󣬶����̣߳���������Դ
	            ���timer.cancel()��������Դ����ô��ʱ���ͻ�������ֹ������Ҳ��������
	            �������ѡ����ǽ���ʱ�������뵽TimerTask�����У�������ִ�н����󣬵���cancel()��ֹ��ʱ��
	         */

	        timer.schedule(new MyTask(timer),5000);//���ﲻ���н������Ϊ��ʱ���Ѿ�ֹͣ			
	    }

	}

 	class MyTask extends TimerTask{
		public PCB temp_pcb;
	    private Timer timer;
	    public MyTask(){}
	    public MyTask(Timer t){
	        this.timer = t;
	    }

	    @Override
	    public void run() {//���е���Ҫ�߼�
	        PCB temp_pcb=Control.Block_the_queue1.remove(0);//��PCB��������ͷ�Ƴ�
	        Shownum.show_Block_the_queue1();//��ʾ��������1
	        if((temp_pcb.IRIndex+1)<temp_pcb.Instruct_num())//pcbδ����
	        	Control.AddtoReady(temp_pcb);//�����������
	        else
	        {
	        	temp_pcb.finalize();//pcb��������
	        	Control.End_queue.add(temp_pcb);//end���м���pcb
	        	Shownum.show_End_queue();//��ʾend����
	        }
	        timer.cancel();
	    }
	}



