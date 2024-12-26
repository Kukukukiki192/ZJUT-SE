  function check(){
    var custName = document.getElementById("custName");
    var email = document.getElementById("email");
    var phone = document.getElementById("phone");
    if(custName.value==""){
      alert("客户名不能为空!");
      return false;
    }else if(email.value.indexOf("@")==-1){
       alert("电子邮件中应包含@字符!");
       return false;
    }else if(phone.value.length!=8){
       alert("电话号码应是8位数字!");
       return false;
    }
  }