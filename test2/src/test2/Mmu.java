package test2;

public class Mmu {//MMU��ַת������
	public static int Translation(PCB temp) {//���߼���ַת��Ϊ�����ַ
		int pysical_address=0;
		pysical_address=(temp.StartAlllocation-1)*5+temp.IR[2];
		return pysical_address;
	}
}
