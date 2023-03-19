package test2;

import java.util.Timer;
import java.util.TimerTask;

public class OutputBlockthread {
	public  void Begin() {//启动OutputBlockthread线程
        //创建一个新的定时器对象
        Timer timer = new Timer();

        //void schedule(TimerTask task, long delay)
        // 在指定的delay延迟时间后，执行task任务
        timer.schedule(new MyTask2(timer),3000); //这里的3000是3000毫秒，即3秒

        //timer.cancel();终止计时语句不能写在这里
        /*
            因为timer和TimerTask的对象，都是线程，会抢夺资源
            如果timer.cancel()先抢到资源，那么定时器就会立刻终止，任务也不会运行
            因此这里选择的是将定时器对象传入到TimerTask对象中，在任务执行结束后，调用cancel()终止计时器
         */

        timer.schedule(new MyTask2(timer),5000);//这里不会有结果，因为定时器已经停止			
    }

}

 class MyTask2 extends TimerTask{//位于OutputBlock内的一个类
	
    private Timer timer;
    public MyTask2(){}
    public MyTask2(Timer t){
        this.timer = t;
    }

    @Override
    public void run() {//运行的主要逻辑
    	PCB temp_pcb=Control.Block_the_queue2.remove(0);//将PCB从阻塞队头移除
    	 Shownum.show_Block_the_queue2();//显示阻塞队列2
    	if((temp_pcb.IRIndex+1)<temp_pcb.Instruct_num())//pcb未结束
    		Control.AddtoReady(temp_pcb);//加入就绪队列
    	else
    	{
    		temp_pcb.finalize();//pcb析构函数
    		Control.End_queue.add(temp_pcb);//end队列加入pcb
    		Shownum.show_End_queue();//显示end队列
    	}
        timer.cancel();
    }
}
