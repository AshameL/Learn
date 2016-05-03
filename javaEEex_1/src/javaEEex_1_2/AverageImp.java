package javaEEex_1_2;

import org.junit.Test;

public class AverageImp implements IHandle {

	@Override
	public Double handle(ICommand command, Double[] arr) {
		// TODO Auto-generated method stub
		return command.handle(arr);

	}

	@Test
	public void main() {
		Double arr[] = { 1.0, 2.0, 3.0 };
		Double result = handle(new ICommand() {

			@Override
			public Double handle(Double[] arr) {
				// TODO Auto-generated method stub
				Double sum = 0.0;
				for (Double i : arr) {
					sum += i;

				}

				return sum / arr.length;
			}
		}, arr);
		System.out.println("Æ½¾ùÊı:"+result);
	}
}
