/*时间显示*/
window.onload=function(){
    var oDt=new Date();
    var iMonth=parseInt(oDt.getMonth())+1;
    var t=oDt.getFullYear()+"-"+iMonth+"-"+oDt.getDate()+"&nbsp;&nbsp;";
    document.getElementById("displaydate").innerHTML=t;
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
    document.getElementById("displaytime").innerHTML=sTime;
}