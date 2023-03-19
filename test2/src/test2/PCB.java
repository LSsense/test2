package test2;

import java.util.ArrayList;

public class PCB implements Comparable<PCB>{
	public int ProID;//进程编号
	public int Priority;//进程优先数
	public int Job_request_time;
	public int InTimes;//进程创建时间
	public int EndTimes;//进程结束时间
	public enum PSW{//进程状态
		running,ready,wait,ending
	};
	public PSW psw;//本进程的状态
	public int []RunTimes=new int [50];//进程运行时间列表
	public int TurnTimes;//进程周转时间统计
	public int [][]Instruct;//进程包含的指令
	public int IRIndex;//当前指令的索引
	//public int []PC=new int[3];//下一条指令信息
	public int []IR=new int [3];//本条指令的信息
	public int []RqNum;//就绪队列信息统计表
	public int []BqNum1=new int [50];//阻塞队列1信息统计表
	public int []BqNum2=new int [50];//阻塞队列2信息统计表
	public int StartAlllocation;//PCB占用的起始地址
	public boolean flag;//是否完成的状态位
	public PCB(work wk,int src)//PCB创建原语
	{
		IRIndex=0;
		flag=true;
		ProID=wk.JobsID;
		Priority=wk.Priority;
		Job_request_time=wk.InTimes;
		InTimes=src;
		psw=PSW.ready;
		String num_temp=String.valueOf(ProID);
		String filepath="input1/"+num_temp+".txt";
		
//		System.out.println(filepath);
		int line_num=file.getFileLineNum(filepath)-1;
//		System.out.println(line_num);
		Instruct=new int [line_num][3];
		Instruct=file.getSparseArrayFromFile2(filepath);
//		System.out.println(filepath);
//		for(int i=0;i<Instruct.length;i++)
//		{
//			for(int j=0;j<Instruct[0].length;j++)
//				System.out.print(Instruct[i][j]+" ");
//			System.out.print("\n");	
//		}
		StartAlllocation=Memory.Allocatememory(this);
		Shownum.show_Memory();
//		System.out.println("地址:"+StartAlllocation);
		IR[0]=Instruct[IRIndex][0];
		IR[1]=Instruct[IRIndex][1];
		IR[2]=Instruct[IRIndex][2];
//		PC[0]=Instruct[IRIndex+1][0];
//		PC[1]=Instruct[IRIndex+1][1];
//		PC[2]=Instruct[IRIndex+1][2];
		RqNum=new int[Instruct.length];
		readRdnum();
		System.out.println(src+":[创建进程:PCB "+ProID+","+(StartAlllocation-1)*5+", 1"+"]");
//		System.out.println("长度"+Instruct.length);
		Statistics.Add_str(src+":[创建进程:PCB "+ProID+","+(StartAlllocation-1)*5+", 1]");
	}
	public int Instruct_num()//PCB含有指令条数
	{
		return Instruct.length;
	}
	public boolean Is_PCB_ok()//PCB是否运行完成
	{
		if(IRIndex==Instruct_num())
		{
			return true;
		}
		else 
			return false;
	}
	public void readRdnum() {//将指令类型赋给标志位
		int i;
		for(i=0;i<Instruct.length;i++)
		{
			RqNum[i]=Instruct[i][1];
		}
		
	}
	public void Refresh_IR_PC(int Index) {//更新PC，IR寄存器
			IR[0]=Instruct[Index][0];
			IR[1]=Instruct[Index][1];
			IR[2]=Instruct[Index][2];
//		if(Is_PCB_ok()==false)
//		{
//			PC[0]=Instruct[Index+1][0];
//			PC[1]=Instruct[Index+1][1];
//			PC[2]=Instruct[Index+1][2];
//		}
		IRIndex=Index;
		
	}
	protected void finalize() {//PCB析构函数
		//PC=IR;
		psw=PCB.PSW.ending;
		EndTimes=Time.time_now();
		Memory.Reclaim_memory(this);
		System.out.println(Time.time_now()+":[终止进程："+ProID+"]");	
		Statistics.Add_str(Time.time_now()+":[终止进程："+ProID+"]");
			Shownum.show_Memory();
	}
	public int MemoryofPCB() {//返回最大的地址
		int maxnum=Instruct[0][2];
		for(int i=1;i<Instruct.length;i++)
		{
			if(maxnum<Instruct[i][2])
				maxnum=Instruct[i][2];
		}
		return maxnum;
	}
	@Override
	public int compareTo(PCB pcb) {//重写比较函数
		// TODO Auto-generated method stub
		return this.Priority-pcb.Priority;
	}
	
}
