package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Control {//���ھ������У���������1����������2���������еĵ����㷨
	public static ArrayList<PCB> Block_the_queue1=new ArrayList<PCB>();//��������1
	public static ArrayList<PCB> Block_the_queue2=new ArrayList<PCB>();//��������2
	public static ArrayList<PCB> reReady_queue=new ArrayList<PCB>();//��������
	public static ArrayList<PCB>End_queue=new ArrayList<PCB>();//��������
	public static boolean Is_empty_RereadyQueue() {//�жϾ��������Ƿ�Ϊ��
		if(reReady_queue.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void AddtoReady(PCB pcb)//����������У�������
	{
		int instructnum=pcb.Instruct_num()-pcb.IRIndex;
		reReady_queue.add(pcb);
		System.out.println(Time.time_now()+":[���½����������:"+pcb.ProID+", "+instructnum+"]");
		Statistics.Add_str(Time.time_now()+":[���½����������:"+pcb.ProID+", "+instructnum+"]");
	}
	public static void AddtoReady_sored(PCB pcb)//����������У�����
	{
		int instructnum=pcb.Instruct_num()-pcb.IRIndex;
		reReady_queue.add(pcb);
		Collections.sort(reReady_queue);
		System.out.println(Time.time_now()+":[�����������:"+pcb.ProID+", "+instructnum+"]");
		Statistics.Add_str(Time.time_now()+":[�����������:"+pcb.ProID+", "+instructnum+"]");
	}
	
	public static PCB removeRead_sord()//���������еĶ�ͷԪ��ȡ����������
	{
		PCB temp=reReady_queue.remove(0);
		Collections.sort(reReady_queue);
		return temp;
	}
	
}
