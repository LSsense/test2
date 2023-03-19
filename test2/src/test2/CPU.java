package test2;

import test2.PCB.PSW;

public class CPU {
	public static int []PC=new int [3];//��һ��
	public static int []IR=new int [3];//����ָ��
	public static  PSW psw_cpu;//cpu״̬
	
	public static void Runcpu0(PCB temp)//cpu����0��ָ��
	{
		int Index=temp.IRIndex;
			IR[0]=temp.IR[0];IR[1]=temp.IR[1];IR[2]=temp.IR[2];
//		PC[0]=temp.PC[0];PC[1]=temp.PC[1];PC[2]=temp.PC[2];
			temp.psw=PCB.PSW.running;
			psw_cpu=PCB.PSW.running;
			System.out.println(Time.time_now()+":[����ָ��:"+temp.ProID+","+IR[0]+","+IR[1]+","+IR[2]+","+Mmu.Translation(temp)+"]");
			Statistics.Add_str(Time.time_now()+":[����ָ��:"+temp.ProID+","+IR[0]+","+IR[1]+","+IR[2]+","+Mmu.Translation(temp)+"]");
			Index++;
		//System.out.println(temp.ProID+"   IRIndex:"+"  "+Index+"   pcb.IRIndex:");
		//System.out.println("Index"+Index);
			if(Index<temp.Instruct_num())
				temp.Refresh_IR_PC(Index);
			else 
				temp.flag=false;
	}
	public static void Runcpu1(PCB temp)//cpu����1��ָ��
	{
		int Index=temp.IRIndex;
		IR[0]=temp.IR[0];IR[1]=temp.IR[1];IR[2]=temp.IR[2];
		//PC[0]=temp.PC[0];PC[1]=temp.PC[1];PC[2]=temp.PC[2];
		temp.psw=PCB.PSW.running;
		psw_cpu=PCB.PSW.running;
		System.out.println(Time.time_now()+":[����ָ��:"+temp.ProID+","+IR[0]+","+IR[1]+","+IR[2]+","+Mmu.Translation(temp)+"]");
		Statistics.Add_str(Time.time_now()+":[����ָ��:"+temp.ProID+","+IR[0]+","+IR[1]+","+IR[2]+","+Mmu.Translation(temp)+"]");
		temp.RqNum[Index]--;
	}
	public static void Run_cpu_null_temp_pcb()//û��ָ��ʱ��cpu��ת
	{
		psw_cpu=PCB.PSW.running;
		System.out.println(Time.time_now()+":[CPU����]");
		Statistics.Add_str(Time.time_now()+":[CPU����]");
	}
}
