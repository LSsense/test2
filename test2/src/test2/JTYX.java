package test2;

public class JTYX {
	public static int Timeslice=2;//�ý��̵�����ʱ�䣬���������к�,ʱ���һ
	public static PCB temp_pcb;//Ŀǰ�������еĴ���,����pcb�Ĵ���
	public static int [][]a=new int [6][];//��ҵjob�ļ��洢������
	public JTYX() {//����JTYX�㷨�ĳ�ʼ�����������Ƕ�����ҵ�ļ��Ķ�ȡ
		String filepath="input1/jobs-input.txt";
		a=file.getSparseArrayFromFile(filepath);
	}
	public static void run1()//����JobRequest�̵߳���Ҫ�����߼��Ĵ���
	{
		worklist.Add_worklist(a, Time.time_now());//�Ӷ���������У��ҵ�����ʱ�����ҵ������work
		Shownum.show_worklist(a,Time.time_now());//��ҵ�󱸶�����ʾ��������
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
	public static void run2()//���е�������,ÿһ�����е���Ҫ���߼�
	{
		
		Shownum.show__textField();//��ʾʱ���ģ��
		Shownum.show_reReadyQueue();//��ʾ��������
		//��Ҫ�������߼�����
		if(temp_pcb==null) {//��Ŀǰ��PCBΪ�յ�ʱ��
			if(Control.Is_empty_RereadyQueue())//RereadQueue is empty
			{
				CPU.Run_cpu_null_temp_pcb();//CPU��ת
				return ;
			}
			else 
			{
				temp_pcb=Control.removeRead_sord();//RereadQueue ȡ����ͷPCB
				Timeslice=2;
			}
		}
		else //��Ŀǰ��PCB��Ϊ��
		{
			
			if(temp_pcb.flag==false)//temp_pcb ������ɣ�����pcb������������ӵ�endQueue��ȡ���������еĶ�ͷpcb��ˢ��ʱ��Ƭ
			{
				temp_pcb.finalize();
				Control.End_queue.add(temp_pcb);
				temp_pcb=Control.removeRead_sord();
				Timeslice=2;
				Shownum.show_End_queue();
			}
			else//temp_pcb δ�������
			{
				if(Timeslice==0)//ʱ��ƬΪ0��ȡ����ͷԪ�أ�ˢ��ʱ��Ƭ
				{
					Control.AddtoReady(temp_pcb);
					temp_pcb=Control.removeRead_sord();
					Timeslice=2;
					
				}
				else //ʱ��Ƭʣ�಻Ϊ0��û�в���
				{
					
				}
			}
			
		}		
		if(temp_pcb.RqNum[temp_pcb.IRIndex]==1)//��ǰָ�������Ϊ1ʱ������CPU run1����
		{
			CPU.Runcpu1(temp_pcb);
		}
		else if(temp_pcb.RqNum[temp_pcb.IRIndex]==0)//��ǰ��ָ������Ϊ0ʱ������CPU run0����
		{
			CPU.Runcpu0(temp_pcb);
		}
		else if(temp_pcb.RqNum[temp_pcb.IRIndex]==2)//��ǰ��ָ������Ϊ2ʱ������CPU Ȼ�󴴽�Inputthread�̣߳�����ǰpcb������������1��ȡ���µ�pcb��ˢ��ʱ��Ƭ
		{
			CPU.Runcpu0(temp_pcb);
			InputBlockthread temp_InBk=new InputBlockthread();
			System.out.println(Time.time_now()+":[��������: InputBlock_thread,"+temp_pcb.ProID+"]");
	        Statistics.Add_str(Time.time_now()+":[��������: InputBlock_thread,"+temp_pcb.ProID+"]");
	        Control.Block_the_queue1.add(temp_pcb);
	        Shownum.show_Block_the_queue1();
	        Statistics.InputBlock=Statistics.InputBlock.concat(Time.time_now()+","+temp_pcb.ProID+";");
	        temp_pcb=null;
	        Timeslice=2;
	        temp_InBk.Begin();
			return ;
		}
		else if(temp_pcb.RqNum[temp_pcb.IRIndex]==3)//��ǰ��ָ������Ϊ2ʱ������CPU Ȼ�󴴽�Outputthread�̣߳�����ǰpcb������������2��ȡ���µ�pcb��ˢ��ʱ��Ƭ
		{
			CPU.Runcpu0(temp_pcb);
			OutputBlockthread temp_OuBk=new OutputBlockthread();
			System.out.println(Time.time_now()+":[��������: OutputBlock_thread,"+temp_pcb.ProID+"]");
	        Statistics.Add_str(Time.time_now()+":[��������: OutputBlock_thread,"+temp_pcb.ProID+"]");
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
	public static void run3(String filepath)//ͳ����Ϣд��txt�ļ������к���
	{
		PCB temp_pcb;
		int i;
		
		Statistics.string.add("״̬ͳ����Ϣ��");
		for(i=0;i<Control.End_queue.size();i++)//ͳ�ƽ�������PCB����Ϣ
		{
			temp_pcb=Control.End_queue.get(i);
			Statistics.string.add(temp_pcb.EndTimes+":["+temp_pcb.ProID+":"+temp_pcb.Job_request_time+"+"+temp_pcb.InTimes+"+"+(temp_pcb.EndTimes-temp_pcb.InTimes)+"]");
		}
		Statistics.InputBlock=Statistics.InputBlock.concat("]");//InputBlock��Ϣ
		Statistics.OutputBlock=Statistics.OutputBlock.concat("]");//OutputBlock��Ϣ
		Statistics.string.add(Statistics.InputBlock);
		Statistics.string.add(Statistics.OutputBlock);
		file.writer_to_file(Statistics.string, filepath);
	}
}
