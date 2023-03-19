package test2;

import java.util.ArrayList;

public class PCB implements Comparable<PCB>{
	public int ProID;//���̱��
	public int Priority;//����������
	public int Job_request_time;
	public int InTimes;//���̴���ʱ��
	public int EndTimes;//���̽���ʱ��
	public enum PSW{//����״̬
		running,ready,wait,ending
	};
	public PSW psw;//�����̵�״̬
	public int []RunTimes=new int [50];//��������ʱ���б�
	public int TurnTimes;//������תʱ��ͳ��
	public int [][]Instruct;//���̰�����ָ��
	public int IRIndex;//��ǰָ�������
	//public int []PC=new int[3];//��һ��ָ����Ϣ
	public int []IR=new int [3];//����ָ�����Ϣ
	public int []RqNum;//����������Ϣͳ�Ʊ�
	public int []BqNum1=new int [50];//��������1��Ϣͳ�Ʊ�
	public int []BqNum2=new int [50];//��������2��Ϣͳ�Ʊ�
	public int StartAlllocation;//PCBռ�õ���ʼ��ַ
	public boolean flag;//�Ƿ���ɵ�״̬λ
	public PCB(work wk,int src)//PCB����ԭ��
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
//		System.out.println("��ַ:"+StartAlllocation);
		IR[0]=Instruct[IRIndex][0];
		IR[1]=Instruct[IRIndex][1];
		IR[2]=Instruct[IRIndex][2];
//		PC[0]=Instruct[IRIndex+1][0];
//		PC[1]=Instruct[IRIndex+1][1];
//		PC[2]=Instruct[IRIndex+1][2];
		RqNum=new int[Instruct.length];
		readRdnum();
		System.out.println(src+":[��������:PCB "+ProID+","+(StartAlllocation-1)*5+", 1"+"]");
//		System.out.println("����"+Instruct.length);
		Statistics.Add_str(src+":[��������:PCB "+ProID+","+(StartAlllocation-1)*5+", 1]");
	}
	public int Instruct_num()//PCB����ָ������
	{
		return Instruct.length;
	}
	public boolean Is_PCB_ok()//PCB�Ƿ��������
	{
		if(IRIndex==Instruct_num())
		{
			return true;
		}
		else 
			return false;
	}
	public void readRdnum() {//��ָ�����͸�����־λ
		int i;
		for(i=0;i<Instruct.length;i++)
		{
			RqNum[i]=Instruct[i][1];
		}
		
	}
	public void Refresh_IR_PC(int Index) {//����PC��IR�Ĵ���
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
	protected void finalize() {//PCB��������
		//PC=IR;
		psw=PCB.PSW.ending;
		EndTimes=Time.time_now();
		Memory.Reclaim_memory(this);
		System.out.println(Time.time_now()+":[��ֹ���̣�"+ProID+"]");	
		Statistics.Add_str(Time.time_now()+":[��ֹ���̣�"+ProID+"]");
			Shownum.show_Memory();
	}
	public int MemoryofPCB() {//�������ĵ�ַ
		int maxnum=Instruct[0][2];
		for(int i=1;i<Instruct.length;i++)
		{
			if(maxnum<Instruct[i][2])
				maxnum=Instruct[i][2];
		}
		return maxnum;
	}
	@Override
	public int compareTo(PCB pcb) {//��д�ȽϺ���
		// TODO Auto-generated method stub
		return this.Priority-pcb.Priority;
	}
	
}
