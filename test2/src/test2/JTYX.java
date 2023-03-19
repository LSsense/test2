package test2;

public class JTYX {
	public static int Timeslice=2;//该进程的运行时间，当进程运行后,时间减一
	public static PCB temp_pcb;//目前正在运行的代码,运行pcb的代码
	public static int [][]a=new int [6][];//作业job文件存储的数组
	public JTYX() {//对于JTYX算法的初始化，本质上是对于作业文件的读取
		String filepath="input1/jobs-input.txt";
		a=file.getSparseArrayFromFile(filepath);
	}
	public static void run1()//对于JobRequest线程的主要运行逻辑的代码
	{
		worklist.Add_worklist(a, Time.time_now());//从读入的数组中，找到符合时间的作业，创建work
		Shownum.show_worklist(a,Time.time_now());//作业后备队列显示到界面上
//D_bug
//		for(i=0;i<a.length;i++)
//		{
//			for(j=0;j<a[0].length;j++)
//				System.out.print(a[i][j]+" ");
//			System.out.print("\n");	
//		}
//      wlist.Add_worklist(a, 0);
//		PCB p1=new PCB(worklist.Return_work(0),2);
//      PCB p2=new PCB(wlist.Return_work(1),2);
//      PCB p3=new PCB(wlist.Return_work(2),2);
//      PCB p4=new PCB(wlist.Return_work(3),2);
//      PCB p5=new PCB(wlist.Return_work(4),2);
//      PCB p6=new PCB(wlist.Return_work(4),2);
	}
	public static void run2()//运行的主代码,每一秒运行的主要的逻辑
	{
		
		Shownum.show__textField();//显示时间的模块
		Shownum.show_reReadyQueue();//显示就绪队列
		//主要的运行逻辑所在
		if(temp_pcb==null) {//当目前的PCB为空的时候
			if(Control.Is_empty_RereadyQueue())//RereadQueue is empty
			{
				CPU.Run_cpu_null_temp_pcb();//CPU空转
				return ;
			}
			else 
			{
				temp_pcb=Control.removeRead_sord();//RereadQueue 取出队头PCB
				Timeslice=2;
			}
		}
		else //当目前的PCB不为空
		{
			
			if(temp_pcb.flag==false)//temp_pcb 运行完成，调用pcb结束函数，添加到endQueue，取出就绪队列的队头pcb，刷新时间片
			{
				temp_pcb.finalize();
				Control.End_queue.add(temp_pcb);
				temp_pcb=Control.removeRead_sord();
				Timeslice=2;
				Shownum.show_End_queue();
			}
			else//temp_pcb 未运行完成
			{
				if(Timeslice==0)//时间片为0，取出队头元素，刷新时间片
				{
					Control.AddtoReady(temp_pcb);
					temp_pcb=Control.removeRead_sord();
					Timeslice=2;
					
				}
				else //时间片剩余不为0，没有操作
				{
					
				}
			}
			
		}		
		if(temp_pcb.RqNum[temp_pcb.IRIndex]==1)//当前指令的类型为1时，运行CPU run1函数
		{
			CPU.Runcpu1(temp_pcb);
		}
		else if(temp_pcb.RqNum[temp_pcb.IRIndex]==0)//当前的指令类型为0时，运行CPU run0函数
		{
			CPU.Runcpu0(temp_pcb);
		}
		else if(temp_pcb.RqNum[temp_pcb.IRIndex]==2)//当前的指令类型为2时，运行CPU 然后创建Inputthread线程，将当前pcb放入阻塞队列1，取出新的pcb，刷新时间片
		{
			CPU.Runcpu0(temp_pcb);
			InputBlockthread temp_InBk=new InputBlockthread();
			System.out.println(Time.time_now()+":[阻塞进程: InputBlock_thread,"+temp_pcb.ProID+"]");
	        Statistics.Add_str(Time.time_now()+":[阻塞进程: InputBlock_thread,"+temp_pcb.ProID+"]");
	        Control.Block_the_queue1.add(temp_pcb);
	        Shownum.show_Block_the_queue1();
	        Statistics.InputBlock=Statistics.InputBlock.concat(Time.time_now()+","+temp_pcb.ProID+";");
	        temp_pcb=null;
	        Timeslice=2;
	        temp_InBk.Begin();
			return ;
		}
		else if(temp_pcb.RqNum[temp_pcb.IRIndex]==3)//当前的指令类型为2时，运行CPU 然后创建Outputthread线程，将当前pcb放入阻塞队列2，取出新的pcb，刷新时间片
		{
			CPU.Runcpu0(temp_pcb);
			OutputBlockthread temp_OuBk=new OutputBlockthread();
			System.out.println(Time.time_now()+":[阻塞进程: OutputBlock_thread,"+temp_pcb.ProID+"]");
	        Statistics.Add_str(Time.time_now()+":[阻塞进程: OutputBlock_thread,"+temp_pcb.ProID+"]");
	        Control.Block_the_queue2.add(temp_pcb);
	        Shownum.show_Block_the_queue2();
	        Statistics.OutputBlock=Statistics.OutputBlock.concat(Time.time_now()+","+temp_pcb.ProID+";");
	        temp_pcb=null;
	        Timeslice=2;
			temp_OuBk.Begin();
			return ;
		}
		Timeslice--;
		
	}
	public static void run3(String filepath)//统计信息写入txt文件的运行函数
	{
		PCB temp_pcb;
		int i;
		
		Statistics.string.add("状态统计信息：");
		for(i=0;i<Control.End_queue.size();i++)//统计结束队列PCB的信息
		{
			temp_pcb=Control.End_queue.get(i);
			Statistics.string.add(temp_pcb.EndTimes+":["+temp_pcb.ProID+":"+temp_pcb.Job_request_time+"+"+temp_pcb.InTimes+"+"+(temp_pcb.EndTimes-temp_pcb.InTimes)+"]");
		}
		Statistics.InputBlock=Statistics.InputBlock.concat("]");//InputBlock信息
		Statistics.OutputBlock=Statistics.OutputBlock.concat("]");//OutputBlock信息
		Statistics.string.add(Statistics.InputBlock);
		Statistics.string.add(Statistics.OutputBlock);
		file.writer_to_file(Statistics.string, filepath);
	}
}
