package com.marcus.activiti.table;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class HelloWorldProcess {
    
    //获取默认流程引擎实例，会自动读取activiti.cfg.xml
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    
    
    /**
     * 部署流程定义
     */
    @Test
    public void deploy() {
        Deployment deployment = processEngine.getRepositoryService() //获取部署相关service
                   .createDeployment() //创建部署
                   .addClasspathResource("diagrams/HelloWorld.bpmn") //加载资源文件
                   .addClasspathResource("diagrams/HelloWorld.png") //加载资源文件
                   .name("HelloWorld") //流程名称
                   .deploy(); //执行部署动作
        
        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }
    
    /**
     * 启动流程实例
     */
    @Test
    public void start() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myFirstocess");
        
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getProcessDefinitionId());
        
    }
    
    /**
     * 查看任务
     */
    @Test
    public void findTask() {
        List<Task> taskList = processEngine.getTaskService() //任务相关service
                    .createTaskQuery() //创建任务查询
                    .taskAssignee("marcus") //指定某个人
                    .list();
        
        for (Task task : taskList) {
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getCreateTime());
            System.out.println(task.getAssignee());
            System.out.println(task.getProcessDefinitionId());
            System.out.println(task.getProcessInstanceId());
        }
    }
    
    /**
     * 完成任务
     */
    @Test
    public void completeTask() {
        processEngine.getTaskService()
                    .complete("2504");
    }
}
