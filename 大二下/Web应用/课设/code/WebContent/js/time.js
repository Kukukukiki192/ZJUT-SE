/*时间显示*/
window.onload=function(){
    var oDt=new Date();
    var sWd="";
    var iWeekDay=oDt.getDay();
    switch(iWeekDay){
        case 0:sWd="周日"; break;
        case 1:sWd="周一"; break;
        case 2:sWd="周二"; break;
        case 3:sWd="周三"; break;
        case 4:sWd="周四"; break;
        case 5:sWd="周五"; break;
        case 6:sWd="周六"; break;
    }
    var iMonth=parseInt(oDt.getMonth())+1;
    document.getElementById("displaydate").innerHTML
        ="<h4>"+oDt.getFullYear()+"年"+iMonth+"月"+oDt.getDate()+"日"+sWd+"</h4>";
    var iTimerid=window.setInterval("showtime()",1000);
}
function showtime(){
    var oDt=new Date();
    var iTimerid;
    var sTime="";
    if(oDt.getHours()<10){
        sTime+="0"+oDt.getHours()+":";
    }else{
        sTime+=oDt.getHours()+":";
    }
    if(oDt.getMinutes()<10){
        sTime+="0"+oDt.getMinutes()+":";
    }else{
        sTime+=oDt.getMinutes()+":";
    }
    if(oDt.getSeconds()<10){
        sTime+="0"+oDt.getSeconds();
    }else{
        sTime+=oDt.getSeconds();
    }
//    if(sTime.equals("15:24:00")){
//    	innerHTML="<% UserDao dao = new UserDao(); " +
//    			"if(Tinput0()&&Sinput0()){ System.out.println(\"清零成功\"); }" +
//    			"else { System.out.println(\"清零失败\"); } %>";
//    }
    
    document.getElementById("displaytime").innerHTML="<h4>"+sTime+"</h4>";
}