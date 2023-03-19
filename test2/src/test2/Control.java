package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Control {//对于就绪队列，阻塞队列1，阻塞队列2，结束队列的调度算法
	public static ArrayList<PCB> Block_the_queue1=new ArrayList<PCB>();//阻塞队列1
	public static ArrayList<PCB> Block_the_queue2=new ArrayList<PCB>();//阻塞队列2
	public static ArrayList<PCB> reReady_queue=new ArrayList<PCB>();//就绪队列
	public static ArrayList<PCB>End_queue=new ArrayList<PCB>();//结束队列
	public static boolean Is_empty_RereadyQueue() {//判断就绪队列是否为空
		if(reReady_queue.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void AddtoReady(PCB pcb)//加入就绪队列（不排序）
	{
		int instructnum=pcb.Instruct_num()-pcb.IRIndex;
		reReady_queue.add(pcb);
		System.out.println(Time.time_now()+":[重新进入就绪队列:"+pcb.ProID+", "+instructnum+"]");
		Statistics.Add_str(Time.time_now()+":[重新进入就绪队列:"+pcb.ProID+", "+instructnum+"]");
	}
	public static void AddtoReady_sored(PCB pcb)//加入就绪队列（排序）
	{
		int instructnum=pcb.Instruct_num()-pcb.IRIndex;
		reReady_queue.add(pcb);
		Collections.sort(reReady_queue);
		System.out.println(Time.time_now()+":[进入就绪队列:"+pcb.ProID+", "+instructnum+"]");
		Statistics.Add_str(Time.time_now()+":[进入就绪队列:"+pcb.ProID+", "+instructnum+"]");
	}
	
	public static PCB removeRead_sord()//将就绪队列的队头元素取出，并排序
	{
		PCB temp=reReady_queue.remove(0);
		Collections.sort(reReady_queue);
		return temp;
	}
	
}
