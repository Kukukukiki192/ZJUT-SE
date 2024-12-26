package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import com.dao.UserDao;
import com.model.*;

@WebServlet("/Code")
public class Code extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static void createCode(String encoderContent,String imgPath, String color) {
		TwoDimensionCode handler = new TwoDimensionCode();
		handler.encoderQRCode(encoderContent, imgPath, "png",color);
		System.out.println("Encoder success");//测试
    }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
		int type=Integer.parseInt(request.getParameter("type"));
		String num = request.getParameter("num"), phone = request.getParameter("phone"), name , institute, type1;
		request.setAttribute("type",type);
		request.setAttribute("num", num);
		
		String a1 = request.getParameter("a1");
		String a2 = request.getParameter("a2");
		String a3 = request.getParameter("a3");
		String a4 = request.getParameter("a4");
		String a6 = request.getParameter("a6");
		System.out.println(a1+a2+a3+a4+a6);//测试	
		String[] a5 = request.getParameterValues("a5");
		if(a5!= null){
			for(int i=0;i<a5.length;i++) {
				System.out.println(a5[i]);//测试				
			}
		}
		//二维码颜色
		String color,color1;
		if(a3.equals("是")||a4.equals("是")||a5.length>=2) { color="r"; color1="红码"; }
		else if(a1.equals("是")||a2.equals("是")||a5.length==1&& !(a5[0].equals("无异常")) ) { color="y"; color1="黄码"; }
		else { color="g"; color1="绿码"; }
		//二维码路径 D:\Web应用\健康码管理系统\WebContent\file
//		String imgPath = "C:/Users/E470/Desktop/"+num+".png";//以学号作图片名
		String imgPath = "D:/Web应用/健康码管理系统/WebContent/file/"+num+".png";//以学号作图片名
//		request.setAttribute("imgPath", imgPath);//转发路径,因为需要从路径获得二维码图片
		
		UserDao dao = new UserDao();	
		if(type==1) {//学生打卡
			type1="学生";
			Student student = dao.findSByNum(num);
			name=student.getName();
			institute=student.getInstitute();
			student.setClockin(1);//今日打卡更新为已完成
			student.setPhone(phone);//更新手机号
			String info = "姓名:"+name+" 身份:"+type1+" 学号:"+num+" 学院:"+institute+"学院";//二维码信息
			String codeColor=student.getCode();//获得健康码颜色
			Date date = new Date();//获得本次打卡时间
			if(codeColor.equals("无")) {//暂未申领
				student.setDay(1);//连续 天数从0变1 
				createCode(info, imgPath, color);//申领二维码
				student.setCode(color1);//更新二维码颜色						
				student.DateToString(date);//更新打卡日期  原值为null
			}
			int day=student.getDay();//获得连续打卡天数
			Date lastTime=student.StringtoDate();//获得上次打卡时间	
			long days=( date.getTime()-lastTime.getTime()) / (1000 * 60 * 60 * 24);//和上次打卡相差天数 <=1则连续打卡						
			student.DateToString(date);//更新打卡日期						
				//天数、颜色
			if(codeColor.equals("绿码")) {
				if(color=="g") {//今天是绿码	保持绿码				
					if(days<=1) { student.setDay(++day); }//连续           			           		
            		else { student.setDay(1); }//不连续 天数归1 
				}else { //今天是黄码或红码
					student.setDay(1); 
					createCode(info, imgPath, color);//变为黄码或红码
					student.setCode(color1);//更新二维码颜色	
				}				
			}else if(codeColor.equals("黄码")) {
				if(color=="g") {//今天是绿码					
					if(days<=1) { 
						student.setDay(++day); //连续
						if(day==7) { 
							createCode(info, imgPath, color); //变为绿码
							student.setCode(color1);//更新二维码颜色	
							student.setDay(1);//天数置1
						}
						//未满7天 保持黄码
					}    			           		
            		else { student.setDay(1); }//不连续 天数归1  保持黄码
				}
				else if(color=="y"){ student.setDay(1); }//今天是黄码 保持黄码
				else {//今天是红码
					student.setDay(1);
					createCode(info, imgPath, color);//变为红码
					student.setCode(color1);//更新二维码颜色	
				}				
			}else if(codeColor.equals("红码")){//红码
				if(color=="g") {//今天是绿码					
					if(days<=1) { 
						student.setDay(++day); //连续
						if(day==7) { 
							createCode(info, imgPath, "y"); //变为黄码
							student.setCode("黄码");//更新二维码颜色	
							student.setDay(1);//天数置1
						}
						//未满7天 保持黄码
					}    			           		
            		else { student.setDay(1); }//不连续 天数归1  保持红码
				}
				else { student.setDay(1); }//今天是黄码或红码
			}
			//更新日期、打卡、天数、手机号、二维码颜色
			if(dao.S5(student)) {
				System.out.println("更新学生日期、打卡、天数、手机号、二维码颜色成功");//测试
			}else {
				System.out.println("更新学生日期、打卡、天数、手机号、二维码颜色失败");//测试
			}
		} else {	//教师打卡
			type1="教师";
			Teacher teacher = dao.findTByNum(num);
			name=teacher.getName();
			institute=teacher.getInstitute();
			teacher.setClockin(1);//今日打卡更新为已完成
			teacher.setPhone(phone);//更新手机号			
			String info = "姓名:"+name+" 身份:"+type1+" 工号:"+num+" 学院:"+institute+"学院";//二维码信息
			String codeColor=teacher.getCode();//获得健康码颜色
			Date date = new Date();//获得本次打卡时间
			if(codeColor.equals("无")) {
				teacher.setDay(1);//连续 天数从0变1 
				createCode(info, imgPath, color);//申领二维码
				teacher.setCode(color1);//更新二维码颜色	
				teacher.DateToString(date);//更新打卡日期
			}
			int day=teacher.getDay();//获得连续打卡天数
			Date lastTime=teacher.StringtoDate();//获得上次打卡时间
			long days=( date.getTime()-lastTime.getTime()) / (1000 * 60 * 60 * 24);//和上次打卡相差天数 <=1则连续打卡
			teacher.DateToString(date);//更新打卡日期
				//天数、颜色
			if(codeColor.equals("绿码")) {
				if(color=="g") {//今天是绿码	保持绿码				
					if(days<=1) { teacher.setDay(++day); }//连续           			           		
            		else { teacher.setDay(1); }//不连续 天数归1 
				}else { //今天是黄码或红码
					teacher.setDay(1); 
					createCode(info, imgPath, color);//变为黄码或红码
					teacher.setCode(color1);//更新二维码颜色	
				}				
			}else if(codeColor.equals("黄码")) {
				if(color=="g") {//今天是绿码					
					if(days<=1) { 
						teacher.setDay(++day); //连续
						if(day==7) { 
							createCode(info, imgPath, color); //变为绿码
							teacher.setCode(color1);//更新二维码颜色	
							teacher.setDay(1);//天数置1
						}
						//未满7天 保持黄码
					}    			           		
            		else { teacher.setDay(1); }//不连续 天数归1  保持黄码
				}
				else if(color=="y"){ teacher.setDay(1); }//今天是黄码 保持黄码
				else {//今天是红码
					teacher.setDay(1);
					createCode(info, imgPath, color);//变为红码
					teacher.setCode(color1);//更新二维码颜色	
				}				
			}else if(codeColor.equals("红码")){//红码
				if(color=="g") {//今天是绿码					
					if(days<=1) { 
						teacher.setDay(++day); //连续
						if(day==7) { 
							createCode(info, imgPath, "y"); //变为黄码
							teacher.setCode("黄码");//更新二维码颜色	
							teacher.setDay(1);//天数置1
						}
						//未满7天 保持黄码
					}    			           		
            		else { teacher.setDay(1); }//不连续 天数归1  保持红码
				}
				else { teacher.setDay(1); }//今天是黄码或红码
			}
			//更新日期、打卡、天数、手机号、二维码颜色
			if(dao.T5(teacher)) {
				System.out.println("更新教师日期、打卡、天数、手机号、二维码颜色成功");//测试
			}else {
				System.out.println("更新教师日期、打卡、天数、手机号、二维码颜色失败");//测试
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/code.jsp"); 		
		rd.forward(request, response);						
	}
}
