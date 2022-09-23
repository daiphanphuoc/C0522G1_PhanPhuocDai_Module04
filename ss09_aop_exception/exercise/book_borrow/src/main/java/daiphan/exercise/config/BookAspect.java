package daiphan.exercise.config;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class BookAspect {
    private static int count =0;
    private static int update =0;

    @Pointcut("execution(* daiphan.exercise.controller.BookController.*(..))")
    public void callPointCutMethod(){

    }
    @Pointcut("execution(* daiphan.exercise.controller.BookController.update*(..))")
    public void callPointCutUpdate(){

    }

    @Before("callPointCutMethod()")
    public void beforeCall(){
        System.out.println("Started method time "+ new Date());
    }

    @AfterReturning("callPointCutMethod()")
    public void afterCall(){
        count++;
        System.out.println("times visit book =" + count);
    }

    @AfterReturning("callPointCutUpdate()")
    public void afterCallUpdate(){
        update++;
        System.out.println("times update =" + update);
    }
}
