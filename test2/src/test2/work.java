package test2;

public class work {
	public int JobsID;//��ҵ��ţ�JobsID��
	public int Priority;//��ҵ���ȼ�
	public int InTimes;//��ҵ����ʱ�䣨InTimes��
	public int InstrucNum;//��ҵ�����ĳ���ָ����Ŀ��InstrucNum��
	public work(int[][]a,int num) {//����work
		JobsID=a[num][0];
		Priority=a[num][1];
		InTimes=a[num][2];
		InstrucNum=a[num][3];
		//System.out.println("work"+JobsID+"����");
	}
}
