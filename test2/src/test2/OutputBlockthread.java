package test2;

import java.util.Timer;
import java.util.TimerTask;

public class OutputBlockthread {
	public  void Begin() {//����OutputBlockthread�߳�
        //����һ���µĶ�ʱ������
        Timer timer = new Timer();

        //void schedule(TimerTask task, long delay)
        // ��ָ����delay�ӳ�ʱ���ִ��task����
        timer.schedule(new MyTask2(timer),3000); //�����3000��3000���룬��3��

        //timer.cancel();��ֹ��ʱ��䲻��д������
        /*
            ��Ϊtimer��TimerTask�Ķ��󣬶����̣߳���������Դ
            ���timer.cancel()��������Դ����ô��ʱ���ͻ�������ֹ������Ҳ��������
            �������ѡ����ǽ���ʱ�������뵽TimerTask�����У�������ִ�н����󣬵���cancel()��ֹ��ʱ��
         */

        timer.schedule(new MyTask2(timer),5000);//���ﲻ���н������Ϊ��ʱ���Ѿ�ֹͣ			
    }

}

 class MyTask2 extends TimerTask{//λ��OutputBlock�ڵ�һ����
	
    private Timer timer;
    public MyTask2(){}
    public MyTask2(Timer t){
        this.timer = t;
    }

    @Override
    public void run() {//���е���Ҫ�߼�
    	PCB temp_pcb=Control.Block_the_queue2.remove(0);//��PCB��������ͷ�Ƴ�
    	 Shownum.show_Block_the_queue2();//��ʾ��������2
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
