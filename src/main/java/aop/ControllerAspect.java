package aop;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ControllerAspect {
	private final int MaxSid=3;
	@Around(value = "execution(* controller.StuController.findOne(..))")
	public Object checkSid(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		System.out.println(args[0].getClass().getName());
		System.out.println(args[2].getClass().getName());
		
		long sid=(Long)args[0];
		HttpServletResponse response= (HttpServletResponse)args[2];
		if (sid<MaxSid) {
			Object obj=joinPoint.proceed();
			return obj;
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("�����sid������Χ");
			response.getWriter().close();
			return null;
		}
	}
	/*@Around(value = "execution(* controller.TestController.testAop(..))")
	public void testAop(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("����aop");
		Object[] args = joinPoint.getArgs();
		System.out.println("����������"+args.length);
		System.out.println("����ֵ"+args[0]);
		System.out.println("��������");
		joinPoint.proceed();
	}*/
}
