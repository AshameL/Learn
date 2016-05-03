package javaEEex_1_2;

import org.junit.Test;

public class MaxImp implements IHandle{

	@Override
	public Double handle(ICommand command, Double[] arr) {
		// TODO Auto-generated method stub
		return command.handle(arr);
	}
	
	@Test
	public void main(){
		Double arr[] = { 1.0, 2.0, 3.0 };
		Double result = handle(new ICommand() {

			@Override
			public Double handle(Double[] arr) {
				// TODO Auto-generated method stub
				Double max = arr[0];
				for (Double i : arr) {
					if(max < i){
						max = i;
					}
				}

				return max;
			}
		}, arr);
		System.out.println("×î´óÖµ:"+result);
	}
}
