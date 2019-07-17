package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.Student;

public class Test1 {
	public static void main(String[] args) throws IOException {
		//加载核心配置文件
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//SqlSessionFactory接口 	SqlSessionFactoryBuilder是构建sqlSessionFactory的入口类
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		//SqlSession	SqlSessionFactory是创建SqlSession的工厂
		SqlSession session = sf.openSession(); //手动提交事务
//		SqlSession session = sf.openSession(true); //开启自动提交
		//增删改查
//		Student s = (Student)session.selectOne("stu.selectStu", 100);
//		System.out.println(s);
//		System.out.println("-------------");
//		
//		List<Student> st = session.selectList("stu.selectStuByName","李");
//		for (Student student : st) {
//			System.out.println(student);
//		}
//		System.out.println("===============");
//		
//		List<Student> all = session.selectList("stu.selectall");
//		for (Student student : all) {
//			System.out.println(student);
//		}
		
		Student s = (Student)session.selectOne("stu.selectStu", 100);
		System.out.println(s);
		System.out.println("-------------");
		
		Student stu = new Student();
		stu.setStuid(100);
		stu.setAge(26);
		stu.setName("李曹飞");
		
		session.update("stu.updateStu", stu);
//		session.commit();  //提交事务
		List<Student> st = session.selectList("stu.selectStuByName","李曹飞");
		for (Student student : st) {
			System.out.println(student);
		}
		is.close();
		
	}
}
