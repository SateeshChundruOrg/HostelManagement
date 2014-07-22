<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
	$(function() {
	    var url = $(location).attr('href');
	    
	    
	 
			$('.tzoLink').each(function() {
	   	    	try{
	   	    		var href = $(this).attr('href');
	   	    		href = href + '?tzo=' + new Date().getTimezoneOffset();
	   	    		$(this).attr('href', href);
	   	    	} catch (error){
	   	    		
	   	    	}
	   	    });
	    
	    if(url.indexOf('${pageContext.servletContext.contextPath}/web/') != -1
	    		|| url.indexOf('${pageContext.servletContext.contextPath}/web/from/') != -1) {
	    	
			$('#hostler').addClass('current');
			
			if(url.indexOf('createHostlerLand') != -1){
				$('#company-create').addClass('current');
			} 
			else if(url.indexOf('live/all') != -1){
				$('#company-live-all').addClass('current');
			}
			 else if(url.indexOf('all') != -1){
				$('#company-all').addClass('current');
			}
			 
			
			
			else if(url.indexOf('/employee/detail') != -1){
				$('#company-emp-detail').addClass('current');
			}
	    } else if(url.indexOf('${pageContext.servletContext.contextPath}/web/invoice') != -1
	    		|| url.indexOf('${pageContext.servletContext.contextPath}/web/from/invoice') != -1) {
	    	
			$('#invoice').addClass('current');
			
			if(url.indexOf('create') != -1){
				$('#invoice-create').addClass('current');
			} else if(url.indexOf('companys/all')!=-1){
				
				$('#invoice-comapnys-all').addClass('current');
			}
			
			else if(url.indexOf('all') != -1){
				$('#invoice-all').addClass('current');
			}
	    } 
	    
	    
	    
	    else if(url.indexOf('${pageContext.servletContext.contextPath}/web/purchase') != -1
	    		|| url.indexOf('${pageContext.servletContext.contextPath}/web/from/purchase') != -1) {
	    	
			$('#purchase').addClass('current');
			
			if(url.indexOf('create') != -1){
				$('#purchase-create').addClass('current');
			} else if(url.indexOf('all') != -1){
				$('#purchase-all').addClass('current');
			}
	    } else {
	    	$('#home').addClass('current');
	    }
	    
	    
	    $('#nav-menu').superfish({ 
            pathClass:  'current' 
        });

	});
</script>

<div class="navbar-main">
	<div class="navbar-patch1"></div>
	<div class="navbar-patch2"></div>
	<div class="navbar-body">
	<ul id="nav-menu" class="sf-menu sf-navbar">
		<li id="home">
			<a href="${pageContext.servletContext.contextPath}">Home</a>
			<ul></ul>
		</li>
		<li id="hostler">
			<a href="${pageContext.servletContext.contextPath}/web/allHostlers">All Hostlers</a>
			<ul>
				<li id="company-create">
					<a href="${pageContext.servletContext.contextPath}/web/createHostlerLand">Create Hostler</a>
				</li>
				<li id="company-all">
					<a href="${pageContext.servletContext.contextPath}/web/company/all">All Companies</a>
				</li>
				<li id="company-live-all">
					<a href="${pageContext.servletContext.contextPath}/web/company/live/all">Live Companies</a>
				</li>
				<li id="company-emp-detail">
					<a href="${pageContext.servletContext.contextPath}/web/company/land/employee/detail">Company Employee Detail</a>
				</li>
				
				
				
			</ul>
		</li>
		<li id="invoice">
			<a href="${pageContext.servletContext.contextPath}/web/invoice/land/all">Invoices</a>
			<ul>
				<li id="invoice-create">
					<a href="${pageContext.servletContext.contextPath}/web/invoice/land/create">Create Invoice</a>
				</li>
				<li id="invoice-all">
					<a href="${pageContext.servletContext.contextPath}/web/invoice/land/all">Invoices</a>
				</li>
				
				<li id="invoice-comapnys-all">
					<a class="tzoLink" href="${pageContext.servletContext.contextPath}/web/invoice/companys/all">All Invoices</a>
				</li>
			</ul>
		</li>
		<li id="purchase">
			<a href="${pageContext.servletContext.contextPath}/web/purchase/land/all">Payments</a>
			<ul>
				<li id="purchase-all">
					<a href="${pageContext.servletContext.contextPath}/web/purchase/land/all">Purchases</a>
				</li>
			</ul>
		</li>
		<li id="setting">
			<a href="#">Settings</a>
			<ul></ul>
		</li>
	</ul>
	</div>
</div>

