package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Employee;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Employee emp = ctx.getBean("emp",Employee.class);
        System.out.println(emp);
    }
}
