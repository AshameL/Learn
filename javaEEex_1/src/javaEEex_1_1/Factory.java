package javaEEex_1_1;

import java.lang.reflect.Method;

public class Factory {
	@SuppressWarnings("unchecked")
	public static <T extends Printer> T  getOutputImpInstance(Class<T> c){
		T pri = null;
		try {
			//这个不是单例
			//pri = (T)Class.forName(c.getName()).newInstance(); 
			//Class<T>clazz =  (Class<T>) Class.forName(c.getName());
			//Method m = clazz.getMethod("getInstance", Hp.class);
			//System.out.println(m);
           // pri = m.invoke(obj, args)
			Method m = c.getMethod("getInstance");
			System.out.println(m);
			pri = (T) m.invoke(c);
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	//还会有什么问题呢
            e.printStackTrace();
        }
		return pri;
	}
}
