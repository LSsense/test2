package test2;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class worklist {
	static ArrayList<work> sites = new ArrayList<work>();//��ҵ����
	static public void Add_worklist(int [][]a,int time_now) {//��ʱ����ϵĶ��м���󱸶�����
		for(int i=0;i<a.length;i++)
		{ 
			int time_old=time_now-10;
			if((time_old<a[i][2])&&(a[i][2]<=time_now))
			{
				work temp=new work(a,i);
				sites.add(temp);
				System.out.println(time_now+":[������ҵ:"+a[i][0]+", "+a[i][2]+", "+a[i][3]+"]");
				Statistics.Add_str(time_now+":[������ҵ:"+a[i][0]+", "+a[i][2]+", "+a[i][3]+"]");
			}
		}
	}
	static public work Return_work(int Index) {//����Index����ҵ
		return sites.get(Index);
	}

}
