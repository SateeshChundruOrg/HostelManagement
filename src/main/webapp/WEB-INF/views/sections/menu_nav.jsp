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
	    
			  if(url.indexOf('${pageContext.servletContext.contextPath}/web/hostler/current/payers') != -1
	    		) {
	    	$('#home').addClass('current');
			$('#hostler-current-payers').addClass('current');
	    }
			  else if(url.indexOf('${pageContext.servletContext.contextPath}/web/hostler') != -1
	    		|| url.indexOf('${pageContext.servletContext.contextPath}/web/form/hostler') != -1) {
	    	
			$('#hostler').addClass('current');
			
			if(url.indexOf('create') != -1){
				$('#hostler-create').addClass('current');
			} 
			else if(url.indexOf('all') != -1){
				$('#hostler-all').addClass('current');
			}
			else if(url.indexOf('hostler/unpaid/search') != -1){
				$('#hostler-unpaid-search').addClass('current');
			}
	    }
	    
	    else if(url.indexOf('${pageContext.servletContext.contextPath}/web/hostel') != -1
	    		|| url.indexOf('${pageContext.servletContext.contextPath}/web/form/hostel') != -1) {
	    	
			$('#hostel').addClass('current');
			
			if(url.indexOf('hostel/create') != -1){
				$('#hostel-create').addClass('current');
			} 
			else if(url.indexOf('hostel/all') != -1){
				$('#hostel-all').addClass('current');
			}
			else if(url.indexOf('room/create') != -1){
				$('#room-create').addClass('current');
			}
			else if(url.indexOf('room/all') != -1){
				$('#room-all').addClass('current');
			}
	    }
	    else if(url.indexOf('${pageContext.servletContext.contextPath}/web/expense') != -1
	    		|| url.indexOf('${pageContext.servletContext.contextPath}/web/from/expense') != -1) {
	    	
			$('#expense').addClass('current');
			
			if(url.indexOf('expense/create') != -1){
				$('#expense-create').addClass('current');
			} 
			else if(url.indexOf('expense/all') != -1){
				$('#expense-all').addClass('current');
			}
	    
	    }
	   
	    else {
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
			<a href="${pageContext.servletContext.contextPath}/web/hostler/current/payers">Home</a>
			<ul><li id="hostler-current-payers">
					<a href="${pageContext.servletContext.contextPath}/web/hostler/current/payers">current payers</a>
				</li>
				</ul>
		</li>
		<li id="hostler">
			<a href="${pageContext.servletContext.contextPath}/web/hostler/all">Hostler</a>
			<ul>
				<li id="hostler-create">
					<a href="${pageContext.servletContext.contextPath}/web/hostler/create">Create Hostler</a>
				</li>
				<li id="hostler-all">
					<a href="${pageContext.servletContext.contextPath}/web/hostler/all">All Hostlers</a>
				</li>
				<li id="hostler-unpaid-search">
					<a href="${pageContext.servletContext.contextPath}/web/hostler/unpaid/search">Unpaid Hostler Search</a>
				</li>
				<li id="hostler-search">
					<a href="${pageContext.servletContext.contextPath}/web/hostler/search">Search</a>
				</li>
				<li id="hostler-history">
					<a href="${pageContext.servletContext.contextPath}/web/hostler/payment/history">Payment History</a>
				</li>
				
					
			</ul>
		</li>
		<li id="hostel">
			<a href="${pageContext.servletContext.contextPath}/web/hostel/all">Hostel</a>
			<ul>
				<li id="hostel-create">
					<a href="${pageContext.servletContext.contextPath}/web/hostel/create">Create Hostel</a>
				</li>
				<li id="hostel-all">
					<a href="${pageContext.servletContext.contextPath}/web/hostel/all">All Hostelss</a>
				</li>
				<li id="room-create">
					<a href="${pageContext.servletContext.contextPath}/web/hostel/room/create">create room</a>
				</li>
				<li id="room-all">
					<a href="${pageContext.servletContext.contextPath}/web/hostel/room/all">All Rooms</a>
				</li>	
				<li id="room-search">
					<a href="${pageContext.servletContext.contextPath}/web/hostel/room/search">Search</a>
				</li>	
			</ul>
		</li>
		<li id="expense">
			<a href="${pageContext.servletContext.contextPath}/web/expense/all">Expense</a>
			<ul>
				<li id="expense-create">
					<a href="${pageContext.servletContext.contextPath}/web/expense/create">Enter Expense</a>
				</li>
				<li id="expense-all">
					<a href="${pageContext.servletContext.contextPath}/web/expense/all">All Expensess</a>
				</li>
				<li id="expense-amount">
					<a href="${pageContext.servletContext.contextPath}/web/hostel/expense/amount1">Expensed amount</a>
				</li>
				
					
			</ul>
		
		<li id="setting">
			<a href="#">Settings</a>
			<ul></ul>
		</li>
		<li id="contact">
			<a href="#">Contact Us</a>
			<ul>
			<li id="contact-us">
					<a href="${pageContext.servletContext.contextPath}/web/contact">Contact Us</a>
				</li>
			</ul>
		</li>
	</ul>
	</div>
</div>

