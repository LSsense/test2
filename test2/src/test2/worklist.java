package test2;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class worklist {
	static ArrayList<work> sites = new ArrayList<work>();//作业队列
	static public void Add_worklist(int [][]a,int time_now) {//将时间符合的队列加入后备队列中
		for(int i=0;i<a.length;i++)
		{ 
			int time_old=time_now-10;
			if((time_old<a[i][2])&&(a[i][2]<=time_now))
			{
				work temp=new work(a,i);
				sites.add(temp);
				System.out.println(time_now+":[新增作业:"+a[i][0]+", "+a[i][2]+", "+a[i][3]+"]");
				Statistics.Add_str(time_now+":[新增作业:"+a[i][0]+", "+a[i][2]+", "+a[i][3]+"]");
			}
		}
	}
	static public work Return_work(int Index) {//返回Index的作业
		return sites.get(Index);
	}

}
