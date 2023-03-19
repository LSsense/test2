package test2;

public class work {
	public int JobsID;//作业序号（JobsID）
	public int Priority;//作业优先级
	public int InTimes;//作业请求时间（InTimes）
	public int InstrucNum;//作业包含的程序指令数目（InstrucNum）
	public work(int[][]a,int num) {//创建work
		JobsID=a[num][0];
		Priority=a[num][1];
		InTimes=a[num][2];
		InstrucNum=a[num][3];
		//System.out.println("work"+JobsID+"创立");
	}
}
