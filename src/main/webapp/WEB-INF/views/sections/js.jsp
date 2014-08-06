<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/jquery/jquery-1.8.2.js"></script>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/jquery/ui/1.9.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.timepicker.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.ui.spinner.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.numeric.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/hoverIntent.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/superfish.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.jqpagination.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/xpagination.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".Date").each(function(index){
		applyDate($( this ).attr('id'));
	});
	//$("#first").hide();
});

function applyDate(id){
	$("#"+id).datepicker({ 
        /* minDate: new Date, */
        dateFormat: 'yy-mm-dd',
        showOn: 'button',
        buttonText: 'Pick Date',
    buttonImageOnly: true, 
    buttonImage: '${pageContext.servletContext.contextPath}/resources/img/calendar_picker.png'
});
}
</script>