package test2;

import test2.PCB.PSW;

public class CPU {
	public static int []PC=new int [3];//下一条
	public static int []IR=new int [3];//本条指令
	public static  PSW psw_cpu;//cpu状态
	
	public static void Runcpu0(PCB temp)//cpu运行0型指令
	{
		int Index=temp.IRIndex;
			IR[0]=temp.IR[0];IR[1]=temp.IR[1];IR[2]=temp.IR[2];
//		PC[0]=temp.PC[0];PC[1]=temp.PC[1];PC[2]=temp.PC[2];
			temp.psw=PCB.PSW.running;
			psw_cpu=PCB.PSW.running;
			System.out.println(Time.time_now()+":[运行指令:"+temp.ProID+","+IR[0]+","+IR[1]+","+IR[2]+","+Mmu.Translation(temp)+"]");
			Statistics.Add_str(Time.time_now()+":[运行指令:"+temp.ProID+","+IR[0]+","+IR[1]+","+IR[2]+","+Mmu.Translation(temp)+"]");
			Index++;
		//System.out.println(temp.ProID+"   IRIndex:"+"  "+Index+"   pcb.IRIndex:");
		//System.out.println("Index"+Index);
			if(Index<temp.Instruct_num())
				temp.Refresh_IR_PC(Index);
			else 
				temp.flag=false;
	}
	public static void Runcpu1(PCB temp)//cpu运行1型指令
	{
		int Index=temp.IRIndex;
		IR[0]=temp.IR[0];IR[1]=temp.IR[1];IR[2]=temp.IR[2];
		//PC[0]=temp.PC[0];PC[1]=temp.PC[1];PC[2]=temp.PC[2];
		temp.psw=PCB.PSW.running;
		psw_cpu=PCB.PSW.running;
		System.out.println(Time.time_now()+":[运行指令:"+temp.ProID+","+IR[0]+","+IR[1]+","+IR[2]+","+Mmu.Translation(temp)+"]");
		Statistics.Add_str(Time.time_now()+":[运行指令:"+temp.ProID+","+IR[0]+","+IR[1]+","+IR[2]+","+Mmu.Translation(temp)+"]");
		temp.RqNum[Index]--;
	}
	public static void Run_cpu_null_temp_pcb()//没有指令时，cpu空转
	{
		psw_cpu=PCB.PSW.running;
		System.out.println(Time.time_now()+":[CPU空闲]");
		Statistics.Add_str(Time.time_now()+":[CPU空闲]");
	}
}
