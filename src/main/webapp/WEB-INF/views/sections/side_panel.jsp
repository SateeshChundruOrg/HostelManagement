<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- <script type="text/javascript">
	$(function() {
		
	    $( "#aeProgressbar" ).progressbar({
	    	create: function( event, ui ) {
	    		var selector = "#" + this.id + " > div";
		        var value = this.getAttribute( "aria-valuenow" );
		        if (value > 90){
		            $(selector).css({ 'background': 'Red'});
		        } else if (value > 70){
		            $(selector).css({ 'background': 'Orange'});
		        } else if (value > 50){
		            $(selector).css({ 'background': 'Yellow'});
		        } else{
		            $(selector).css({ 'background': 'Green'});
		        }
	    	},
	        value: ${sessionData.companyInfo.activeEmployeePercentage}
	    });
	    
	    $( "#sProgressbar" ).progressbar({
	    	create: function( event, ui ) {
	    		var selector = "#" + this.id + " > div";
		        var value = this.getAttribute( "aria-valuenow" );
		        if (value > 90){
		            $(selector).css({ 'background': 'Red'});
		        } else if (value > 70){
		            $(selector).css({ 'background': 'Orange'});
		        } else if (value > 50){
		            $(selector).css({ 'background': 'Yellow'});
		        } else{
		            $(selector).css({ 'background': 'Green'});
		        }
	    	},
	        value: ${sessionData.companyInfo.storagePercentage}
	    });
	    
	    $.get("${pageContext.servletContext.contextPath}/web/ajax/comapny/subscription/" + new Date().getTimezoneOffset(), function(data){
	    	var result = eval(data);
	    	if(result.length > 0){
	    		$("#expiry").html(result[0]);
	    		if(result[2] == 1){
	    			$("#expiry-elapse").html('Account expires in '+result[1]);
	    			$("#expiry-elapse").css('color','#00662e');
	    		} else {
	    			$("#expiry-elapse").html('Account expired '+result[1]+' ago');
	    			$("#expiry-elapse").css('color','#f00');
	    		}
	    	}
	    });
	    
	});
</script>
<div style="padding-left: 2px; padding:10px; padding-bottom: 30px;">
<table>
	<tr>
		<td>Active Employees:</td>
		<td style="text-align: right; font-weight: bold;">${sessionData.companyInfo.activeEmployees} / ${sessionData.companyInfo.allowedActiveEmployees}</td>
	</tr>
	<tr>
		<td colspan="2"><div id="aeProgressbar" style="width: 100%;"></div></td>
	</tr>
	<tr>
		<td>Storage:</td>
		<td style="text-align: right; font-weight: bold;">${sessionData.companyInfo.usedStorageText} / ${sessionData.companyInfo.allocatedStorageText}</td>
	</tr>
	<tr>
		<td colspan="2"><div id="sProgressbar"></div></td>
	</tr>
	<tr>
		<td>Expiry:</td>
		<td style="text-align: right; font-weight: bold;"><span id="expiry"></span></td>
	</tr>
	<tr>
		<td colspan="2"><span id="expiry-elapse"></span></td>
	</tr>
</table>
</div>
 --%>