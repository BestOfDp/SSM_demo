<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jsp/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script>
	/*$(function(){
		$("input[name='ename']").bind("focus keydown",function(){
			var $ename=$("input[name='ename']")
			var value=$ename.val();
			if(value==""||value.length>10){
				$("#sp2").html("<font color = 'red'>请输入10位以下字符</font>")
			}
			else(value!=""||value.length<10){
				$("#sp2").html("<font color = 'green'>输入姓名满足条件</font>")
			}
		});
	});
	$(function(){
		$("input[name='ecode']").bind("focus keydown",function(){
			var $ecode=$("input[name='ecode']")
			var value=$ecode.val();
			if(value==""||value.length>10){
				$("#sp1").html("<font color = 'red'>请输入1-8位以下字符</font>")
			}
		});
	});
	$(function(){
		$("input[name='etelephone']").bind("focus keydown",function(){
			var $etelephone=$("input[name='etelephone']")
			var value=$etelephone.val();
			if(value==""||value.length>10){
				$("#sp3").html("<font color = 'red'>请输入11位号码</font>")
			}
		});
	});
	$(function(){
		$("input[name='eemail']").bind("focus keydown",function(){
			var $etelephone=$("input[name='eemail']")
			var value=$eemail.val();
			if(value==""||value.length>10){
				$("#sp4").html("<font color = 'red'>请输xxxx@xx.com字符</font>")
			}
		});
	});*/
	
	function checkValidate(){
		var $ecode=$("input[name='ecode']");
		var value=$ecode.val();
		var $ename=$("input[name='ename']");
		var value1=$ename.val();
		var $etelephone=$("input[name='etelephone']");
		var value2=$etelephone.val();
		var $eemail=$("input[name='eemail']");
		var value3=$eemail.val();
		
		if(value==""||value.length>10){
			$("#sp1").html("<font color = 'red'>请输入10位以下字符</font>")
			return false;
		}
		if(value1==""||value1.length>10){
			$("#sp2").html("<font color = 'red'>请输入10位以下字符</font>")
			return false;
		}
		if(value2==""||value2.length!=11){
			$("#sp3").html("<font color = 'red'>请输入11位手机号码</font>")
			return false;
		}
		if(value3==""||value3.indexOf('@')==-1&&value3.indexOf('.com')==-1){
			$("#sp4").html("<font color = 'red'>邮箱错误</font>")
			return false;
	    }
		
	}
	
	function checkSucess(){
		
		var $ecode=$("input[name='ecode']");
		var value=$ecode.val();
		var $ename=$("input[name='ename']");
		var value1=$ename.val();
		var $etelephone=$("input[name='etelephone']");
		var value2=$etelephone.val();
		var $eemail=$("input[name='eemail']");
		var value3=$eemail.val();
		
		if(value!=""&&value.length<10){
			$("#sp1").html("<font color = 'green'>满足条件</font>")
	    }else{
	    	$("#sp1").html("<font color = 'red'>请输入10位以下字符</font>")
			return false;
	    }
		if(value1!=""&&value1.length<10){
			$("#sp2").html("<font color = 'green'>满足条件</font>")

	    }else{
	    	$("#sp2").html("<font color = 'red'>请输入10位以下字符</font>")
			return false;
	    }
		if(value2!=""&&value2.length==11){
			$("#sp3").html("<font color = 'green'>满足条件</font>")

	    }else{
	    	$("#sp3").html("<font color = 'red'>请输入11位手机号码</font>")
			return false;
	    }
		if(value3!=""&&value3.indexOf('@')!=-1 && value3.indexOf('.com')!=-1){
			$("#sp4").html("<font color = 'green'>邮箱正确</font>")
			return true;
	    }else{
	    	$("#sp4").html("<font color = 'red'>邮箱错误</font>")
			return false;
	    }
	}
</script>
</head>
<body>
   <div>
   	<form action="insertEmp.do" method="post" onsubmit="return checkValidate()">
   		<table>
   			<tr>
   				<td>员工编号</td>
   				<td><input type="text" name="ecode" onfocus="checkValidate()" onblur="checkSucess()"></td>
   				<td><span id="sp1"></span></td>
   				
   			</tr>
   			<tr>
   				<td>员工姓名</td>
   				<td><input type="text" name="ename" onfocus="checkValidate()" onblur="checkSucess()"></td>
   				<td><span id="sp2"></span></td>
   			</tr>
   			<tr>
   				<td>员工性别</td>
   				<td><input type="radio" name="sex" value="男" checked="checked"/>男
   				<input type="radio" name="sex" value="女" />女</td>
   				
   			</tr>
   			<tr>
   				<td>员工出生日期</td>
   				<td><input type="text" name="birthday" onclick="WdatePicker()"></td>
   				
   			</tr>
   			<tr>
   				<td>员工手机号码</td>
   				<td><input type="text" name="etelephone" onfocus="checkValidate()" onblur="checkSucess()"></td>
   				<td><span id="sp3"></span></td>
   			</tr>
   			<tr>
   				<td>员工邮箱</td>
   				<td><input type="text" name="eemail" onfocus="checkValidate()" onblur="checkSucess()"></td>
   				<td><span id="sp4"></span></td>
   			</tr>
   			<tr>
   				
   				<td><input type="submit" value="保存" ><input type="reset" value="重置"></td>
   			</tr>
   		</table>
   	</form>
   </div>

</body>
</html>