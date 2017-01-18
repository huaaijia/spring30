package com.gege.tool.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class LastInsertIdPlugin extends PluginAdapter{
    
    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
    
        XmlElement selectKeyElement = new XmlElement("selectKey"); //$NON-NLS-1$     
        selectKeyElement.addAttribute(new Attribute("resultType", "java.lang.Integer"));// 自己针对id类型转换
                                                                                        // java.lang.Integer
        selectKeyElement.addAttribute(new Attribute("keyProperty", "id"));
        TextElement sqlTextElement = new TextElement("SELECT LAST_INSERT_ID()");
        selectKeyElement.addElement(sqlTextElement);
        element.getElements().add(selectKeyElement);
        return super.sqlMapInsertElementGenerated(element, introspectedTable);
    }
    
    public boolean validate(List<String> warnings) {
    
        return true;
    }
    
}
