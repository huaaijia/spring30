package com.gege.tool.plugin;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class MySqlLimitPlugin extends PluginAdapter{
    
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    
        addLimit(topLevelClass, introspectedTable);
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }
    
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
    
        XmlElement parentElement = document.getRootElement();
        XmlElement paginationElement = new XmlElement("sql");
        paginationElement.addAttribute(new Attribute("id", "MySql_Pagination"));
        XmlElement limitElement = new XmlElement("if");
        limitElement.addAttribute(new Attribute("test", "limit[0] != -1 &amp;&amp; limit[1] != -1"));
        limitElement.addElement(new TextElement("limit #{limitValue1}, #{limitValue2}"));
        paginationElement.addElement(limitElement);
        parentElement.addElement(6, paginationElement);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }
    
    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
            IntrospectedTable introspectedTable) {
    
        sqlMapSelectByExample(element, introspectedTable);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }
    
    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element,
            IntrospectedTable introspectedTable) {
    
        sqlMapSelectByExample(element, introspectedTable);
        return super.sqlMapUpdateByExampleWithBLOBsElementGenerated(element, introspectedTable);
    }
    
    /**
     * 增加limit语句
     * 
     * @param element
     * @param introspectedTable
     * @return
     */
    private void sqlMapSelectByExample(XmlElement element, IntrospectedTable introspectedTable) {
    
        XmlElement limitElement = new XmlElement("include"); //$NON-NLS-1$     
        limitElement.addAttribute(new Attribute("refid", "MySql_Pagination"));
        element.getElements().add(limitElement);
    }
    
    /**
     * 添加limit模型字段
     * 
     * @param topLevelClass
     * @param introspectedTable
     */
    private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("int[]"));
        field.setName("limit");
        field.setInitializationString("new int[] {-1, -1}");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        Method set1 = new Method();
        set1.setVisibility(JavaVisibility.PUBLIC);
        set1.setName("setLimitValue1");
        set1.addParameter(new Parameter(new FullyQualifiedJavaType("int"), "val"));
        set1.addBodyLine("this.limit[0] = val;");
        commentGenerator.addGeneralMethodComment(set1, introspectedTable);
        topLevelClass.addMethod(set1);
        Method set2 = new Method();
        set2.setVisibility(JavaVisibility.PUBLIC);
        set2.setName("setLimitValue2");
        set2.addParameter(new Parameter(new FullyQualifiedJavaType("int"), "val"));
        set2.addBodyLine("this.limit[1] = val;");
        commentGenerator.addGeneralMethodComment(set2, introspectedTable);
        topLevelClass.addMethod(set2);
        Method get1 = new Method();
        get1.setVisibility(JavaVisibility.PUBLIC);
        get1.setName("getLimitValue1");
        get1.setReturnType(new FullyQualifiedJavaType("int"));
        get1.addBodyLine("return this.limit[0];");
        commentGenerator.addGeneralMethodComment(get1, introspectedTable);
        topLevelClass.addMethod(get1);
        Method get2 = new Method();
        get2.setVisibility(JavaVisibility.PUBLIC);
        get2.setName("getLimitValue2");
        get2.setReturnType(new FullyQualifiedJavaType("int"));
        get2.addBodyLine("return this.limit[1];");
        commentGenerator.addGeneralMethodComment(get2, introspectedTable);
        topLevelClass.addMethod(get2);
    }
    
    public boolean validate(List<String> warnings) {
    
        return true;
    }
}
