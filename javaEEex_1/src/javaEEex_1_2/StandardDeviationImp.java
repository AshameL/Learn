package javaEEex_1_2;

public class StandardDeviationImp implements ICommand {

	@Override
	public Double handle(Double arr[]) {
		// TODO Auto-generated method stub
		// ƽ����
		Double sum = 0.0;
		
		for(Double i: arr){
			sum += i;
		}
		double ave = sum / arr.length;
		//��׼��
		sum = 0.0;
		for(Double i : arr){
			sum += (Math.sqrt(i) - ave) * (i - ave);
			
		}
		return (sum / ( arr.length - 1));
	}
}
