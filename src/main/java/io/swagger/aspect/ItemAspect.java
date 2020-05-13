package io.swagger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ItemAspect {
    private Map<String, Integer> functionsCalls = new HashMap<>();

    public ItemAspect(){
        this.functionsCalls.put("ItemApiController.addItem()", 0);
        this.functionsCalls.put("ItemApiController.getItemById()", 0);
        this.functionsCalls.put("ItemApiController.getItems()", 0);
        this.functionsCalls.put("ItemApiController.updateItemWithForm()", 0);
        this.functionsCalls.put("ItemApiController.deleteItem()", 0);
        this.functionsCalls.put("ItemApiController.findItemByCategories()", 0);
        this.functionsCalls.put("ItemApiController.findItemByStatus()", 0);
        this.functionsCalls.put("ItemApiController.uploadFile()", 0);
        this.functionsCalls.put("ItemApiController.findItemByStatusAndCategories()", 0);
    }

    @Pointcut("execution(* io.swagger.api.ItemApiController.*(..))")
    private void itemApiControllerEx(){ }

    @After("itemApiControllerEx()")
    public void doAfterItemApiControllerEx (JoinPoint joinPoint) {
        this.functionsCalls.put(joinPoint.getSignature().toString(), this.functionsCalls.get(joinPoint.getSignature().toString())+1);
    }

    public Map<String, Integer> getFunctionsCalls () {
        return functionsCalls; }
}
