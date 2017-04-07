package com.marcus.activiti.table;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class ActivitiTest01 {

    /**
     * 生成activiti所需的25张表
     */
    @Test
    public void testCreatTable() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver")
                                   .setJdbcUrl("jdbc:mysql://114.215.47.235/activiti")
                                   .setJdbcUsername("chuangshi")
                                   .setJdbcPassword("Chuangshi123!");
        //配置模式true 自动创建和更新表
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        
        //获取流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    }
    
    /**
     * 使用配置文件创建流程引擎
     */
    @Test
    public void testCreatTableWithXml() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        
        //获取流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    }

}
