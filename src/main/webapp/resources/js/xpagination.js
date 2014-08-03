(function($) {
	$.fn.xPagination = function(options) {
		var defaults = {
			page:'1',
			total:'5',
			orderBy:'#',
			order:'ASC',
			url:'#',
			pageKey:'page',
			orderByKey:'orderBy',
			orderKey:'order',
			ascVal:'ASC',
			descVal:'DESC',
			clicked : function (settings){},
			headers:{}
		};
			
		var settings = $.extend({}, defaults, options);
		
		var marginBottom = 10;
	   		
		return this.each(function() {
			var pageControl = $(this).children('div.xPagination');
			var pageTable = $(this).children('table.xPagination');
			
			if(pageTable.size() > 0){
	    		if(pageControl.size() > 0){
		    		pageControl.each(function() {
		    			$(this).html(
		    					'<a href="#" class="first" data-action="first">&laquo;</a>\
				    		    <a href="#" class="previous" data-action="previous">&lsaquo;</a>\
				    		    <input type="text" readonly="readonly" data-max-page="40" />\
				    		    <a href="#" class="next" data-action="next">&rsaquo;</a>\
				    		    <a href="#" class="last" data-action="last">&raquo;</a>'
		    			);
		    			$(this).css("margin-bottom", marginBottom+"px");
		    			$(this).addClass("pagination");
		    		});
	    		} else {
	    			$(this).prepend(
	    				'<div class="xPagination pagination" style="margin-bottom: '+marginBottom+'px;">\
			    		    <a href="#" class="first" data-action="first">&laquo;</a>\
			    		    <a href="#" class="previous" data-action="previous">&lsaquo;</a>\
			    		    <input type="text" readonly="readonly" data-max-page="40" />\
			    		    <a href="#" class="next" data-action="next">&rsaquo;</a>\
			    		    <a href="#" class="last" data-action="last">&raquo;</a>\
			    		</div>'
		    		);
	    		}
	    		
	    		$(this).children('div.xPagination').jqPagination({
		   	 		current_page: settings.page,
		   	 		max_page: settings.total,
		   	    	paged: function(pno) {
		   	    		settings.page = pno;
		   	    		loadData();
		   	    	}
		   		}); 
			
				pageTable.each(function() {
					var table = $(this);
					table.css("clear", "both");
	    			
					$.each(settings.headers, function(key, element) {
						var th = table.children('thead').children('tr').children('th:eq('+key+')');
						if(th.length > 0){
	    					th.addClass('pageHeader');
	    					th.removeClass('pageHeaderSortUp').removeClass('pageHeaderSortDown');
	    					th.click(function(){
	    						th.click(clickHandler(key));
	    					});
	    					
	    					if(settings.orderBy != '' && settings.orderBy == element){
		    		   			if(settings.order == settings.ascVal){
		    		   				th.addClass('pageHeaderSortDown');
		    		   			} else {
		    		   				th.addClass('pageHeaderSortUp');
		    		   			}
		    		   		}
	    				}
					});
				});
			}
		});
	    	
		function loadData(){
			settings.clicked(settings);
			
			var fullUrl = settings.url;
			if(settings.url.indexOf('?') === -1){
				fullUrl += '?';
			} else {
				fullUrl += '&';
			}
			var fullUrl = fullUrl+settings.pageKey+'='+settings.page+'&'+settings.orderByKey+'='+settings.orderBy+'&'+settings.orderKey+'='+settings.order;
	   		window.location.replace(fullUrl);
	   	}
		
		function clickHandler(key){
			var temp = settings.headers[key];
			if(temp !='#'){
				if(temp == settings.orderBy){
					if(settings.order == settings.ascVal){
						settings.order = settings.descVal;
					} else {
						settings.order = settings.ascVal;
					}
				} else {
					settings.order = settings.ascVal;
					settings.orderBy = temp;
				}
				
				loadData();
	 		}
		}
  	};
})(jQuery);