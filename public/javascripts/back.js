/**
 * Created with IntelliJ IDEA.
 * User: yifan
 * Date: 13-2-12
 * Time: 上午9:42
 * To change this template use File | Settings | File Templates.
 */
function startBackJobs(){
    $.ajax({
        url:'/startBackJobs',
        success:function(){

        }
    });
}


function reloadCountryInfo(){
    $.ajax({
        url:"/startReloadCountryInfo",
        success:function(){
//            alert("suc");
        }
    });
}