package test2;

public class Memory {
	static int [][]memory=new int [16][10];//�ڴ�չʾ��100Bһ��λ��
	static int []flag=new int [32];//�ڴ�ı�ʾ��15��λΪһ��λ��
	static int Allocatememory(PCB temp) {//�����ڴ溯��
		int i,j;
		int instruct_num=temp.MemoryofPCB()/5;
		for(i=0;i<flag.length;i++)
		{
			if(flag[i]==0)
			{
				break;
			}
		}
		for(j=0;j<instruct_num;j++)
		{
			flag[i+j]=1;
			if((i+j)%2==0)
			{
				memory[(i+j)/2][0]=1;
				memory[(i+j)/2][1]=1;
				memory[(i+j)/2][2]=1;
				memory[(i+j)/2][3]=1;
				memory[(i+j)/2][4]=1;
			
			}
			else
			{
				memory[(i+j)/2][5]=1;
				memory[(i+j)/2][6]=1;
				memory[(i+j)/2][7]=1;
				memory[(i+j)/2][8]=1;
				memory[(i+j)/2][9]=1;
			}
		}
		return (i+1);
	}
	public static void Reclaim_memory(PCB temp)//�����ڴ�ĺ���
	{
		int i=temp.StartAlllocation,j;
		int instruct_num=temp.MemoryofPCB()/5;
		for(j=0;j<instruct_num;j++)
		{
			flag[i+j]=0;
			if((i+j)%2==0)
			{
				memory[(i+j)/2][0]=0;
				memory[(i+j)/2][1]=0;
				memory[(i+j)/2][2]=0;
				memory[(i+j)/2][3]=0;
				memory[(i+j)/2][4]=0;
			
			}
			else
			{
				memory[(i+j)/2][5]=0;
				memory[(i+j)/2][6]=0;
				memory[(i+j)/2][7]=0;
				memory[(i+j)/2][8]=0;
				memory[(i+j)/2][9]=0;
			}
		}
	}

	
}
