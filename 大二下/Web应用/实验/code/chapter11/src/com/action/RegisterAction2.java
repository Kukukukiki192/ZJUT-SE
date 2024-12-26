package com.action; 
import java.util.ArrayList; 
import com.model.City; 
import com.opensymphony.xwork2.ActionSupport; 

public class RegisterAction2 extends ActionSupport { 
       private String username;             // 用户名
       private String password;             // 口令
       private String gender;              // 性别
      private String resume;              // 简历
        private String city;                 // 存放在页面中选中的城市
        private String[] language;           // 存放在页面中选中的语言
        private Boolean  marry;            // 婚否
        private ArrayList<City> cityList;      //城市列表
        private ArrayList<String> langList;   // 语言列表
      // 省略属性的setter和getter方法
         public String populate() { 
               cityList = new ArrayList<City>(); 
               cityList.add(new City(1, "北京")); 
               cityList.add(new City(2, "上海")); 
               cityList.add(new City(3, "广州")); 

               langList = new ArrayList<String>(); 
               langList.add("Java"); 
               langList.add(".Net"); 
               langList.add("Object C"); 
               langList.add("C++"); 
               marry = false; 
               return "populate"; 
          } 
         public String execute() { 
              return SUCCESS; 
         }
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getResume() {
			return resume;
		}
		public void setResume(String resume) {
			this.resume = resume;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String[] getLanguage() {
			return language;
		}
		public void setLanguage(String[] language) {
			this.language = language;
		}
		public Boolean getMarry() {
			return marry;
		}
		public void setMarry(Boolean marry) {
			this.marry = marry;
		}
		public ArrayList<City> getCityList() {
			return cityList;
		}
		public void setCityList(ArrayList<City> cityList) {
			this.cityList = cityList;
		}
		public ArrayList<String> getLangList() {
			return langList;
		}
		public void setLangList(ArrayList<String> langList) {
			this.langList = langList;
		}
        
         
}

