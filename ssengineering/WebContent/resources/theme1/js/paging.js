(function($) {
    $(function() {
        $.widget("sse.paging", {
            options: {
                limit: 5,
                activePage: 0,
                data: [],
                rows: []       
            },
            _create: function() {            	                
                this._getNavBar(0);                
                this.showPage(0);
                this.fillGotoPage();
            },
            showPageInfo: function(startIndex, endIndex, total){
            	startIndex = total == 0 ? startIndex : startIndex + 1;
            	endIndex = endIndex > total ? total : endIndex;
            	console.log(startIndex+"->"+endIndex);
            	$(".jtable-page-info").html("Showing "+startIndex+"-"+endIndex+" of "+total);
            },
            fillGotoPage: function(){
            	$('#gotoPage').empty();
            	var data = this.options.data;
            	for (var i = 0; i < Math.ceil(data.length / this.options.limit); i++) {
            		var pageNum = i + 1;
            	    $('#gotoPage').append($('<option>', {
            	 	   value: (pageNum-1),
            	 	   text: pageNum+""
            	    }));
                }
            },
            _getNavBar: function(dayNo) {
            	$('.jtable-page-list').empty();
                var data = this.options.data;
                var nav = $('.jtable-page-list');
                var pages = Math.ceil(data.length / this.options.limit);
                pages = pages <= 10 ? pages : 10; 
                for (var i = dayNo; i < pages; i++) {
                    this._on($('<a>', {
                        href: '#',
                        text: (i + 1),
                        class: 'jtable-page-number',
                        "data-page": (i)
                    }).appendTo(nav),
                            {click: "pageClickHandler"});
                }
                
                //create previous link
                this._on($('<a>', {
                    href: '#',
                    text: '<',
                    class: 'jtable-page-number',
                    "data-direction": -1
                }).prependTo(nav),
                        {click: "pageStepHandler"});
                
                //create first link
                this._on($('<a>', {
                    href: '#',
                    text: '<<',
                    class: 'jtable-page-number',
                    "data-direction": 'first'
                }).prependTo(nav),
                        {click: "firstPageHandler"});
                
                //create next link
                this._on($('<a>', {
                    href: '#',
                    text: '>',
                    class: 'jtable-page-number',
                    "data-direction": +1
                }).appendTo(nav),
                        {click: "pageStepHandler"});
                
                //create last link
                this._on($('<a>', {
                    href: '#',
                    text: '>>',
                    class: 'jtable-page-number',
                    "data-direction": 'last'
                }).appendTo(nav),
                        {click: "lastPageHandler"});
                
                return nav;
            },
            showPage: function(pageNum) {
            	$("#jtable tbody").empty();   
            	
            	//changing class of prevoous page no
            	$($(".jtable-page-list").children().eq(parseInt(pageNum)+2)).siblings().attr('class', "jtable-page-number");
            	
            	//changing class of current page no
            	$($(".jtable-page-list").children().eq(parseInt(pageNum)+2)).attr('class', "jtable-page-number jtable-page-number-active jtable-page-number-disabled");
            	
                var num = parseInt(pageNum * 1); //it has to be numeric
                this.options.activePage = num;
                var data = this.options.data;
                var limit = parseInt(this.options.limit);
                var startItem = num * limit;
                var endItem = startItem + limit;
                console.log(startItem+"-"+endItem);
                this.showPageInfo(startItem, endItem, data.length);	
                data = data.slice(startItem, endItem);
               
                setData(data);
            },
            pageClickHandler: function(event) {
                event.preventDefault();
                $(event.target).siblings().attr('class', "jtable-page-number");
                $(event.target).attr('class', "jtable-page-number jtable-page-number-active jtable-page-number-disabled");
                var pageNum = $(event.target).attr('data-page');
                this.showPage(pageNum);
            },
            pageStepHandler: function(event) {
                event.preventDefault();
                //get the direction and ensure it's numeric
                var dir = $(event.target).attr('data-direction') * 1;
                var pageNum = this.options.activePage + dir;
                //if we're in limit, trigger the requested pages link
                if (pageNum >= 0 && pageNum < this.options.data.length) {
                    $("a[data-page=" + pageNum + "]", $(event.target).parent()).click();
                }
                
                this._getNavBar(pageNum);
            },
            firstPageHandler: function(event) {
            	event.preventDefault();               
            	$($(".jtable-page-list").children().eq(2)).click();
            	$(event.target).attr('class', "jtable-page-number jtable-page-number-active jtable-page-number-disabled");
            }
            ,
            lastPageHandler: function(event) {
            	event.preventDefault();               
            	$($(".jtable-page-list").children().eq($(".jtable-page-list").children().length-3)).click();
            	$(event.target).attr('class', "jtable-page-number jtable-page-number-active jtable-page-number-disabled");
            },            
            updatePaging: function (limit, data) {
            	this.options.data = data;
            	this.options.limit = limit;            	
            	this._create();
            },
            searchData: function (limit, data){
            	this.options.data = data;
            	this.options.limit = limit;            	
            	this._create();
            }
        });
    });
})(jQuery);
