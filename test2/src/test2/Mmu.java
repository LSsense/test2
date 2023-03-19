package test2;

public class Mmu {//MMU地址转换函数
	public static int Translation(PCB temp) {//将逻辑地址转化为物理地址
		int pysical_address=0;
		pysical_address=(temp.StartAlllocation-1)*5+temp.IR[2];
		return pysical_address;
	}
}
