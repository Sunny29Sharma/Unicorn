  var stompClient = null;
            var privateStompClient = null;

            var socket = new SockJS('/ws');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
				 console.log(frame);
                
                stompClient.subscribe('/topic/Order', function(result) {
					var parsedMsg = JSON.parse(result.body);
					 console.log(parsedMsg);
					displayToastNotification(parsedMsg.content, "fa-check", '#27ae60', "slide-in-slide-out");
                  
                });
                
                
                 stompClient.subscribe('/topic/Promotional', function(result) {
                    var parsedMsg = JSON.parse(result.body);
                    console.log(parsedMsg);
					displayToastNotification(parsedMsg.content, "fa-info", '#2980b9', "slide-in-slide-out");
                  
                });
                
                 stompClient.subscribe('/topic/Reminder', function(result) {
                    var parsedMsg = JSON.parse(result.body);
                    console.log(parsedMsg);
					displayToastNotification(parsedMsg.content, "fa-xmark", '#c0392b', "slide-in-fade-out");
                  
                });
            });

      
            function sendEvent(eventType, content){
            	eventType = "Order";
            	stompClient.send("/app/send/"+eventType, {}, JSON.stringify({'type': eventType, 'content':content}));
            }
            
            
            // $('[data-toggle="tooltip"]').tooltip();

    //Toggle User profile
    $('.logged-in-user .user-btn').click(function(){
        $('.user-details-sec').toggle();
    });

    $(document).mouseup(function (e) {
        var profileContainer = $(".logged-in-user .user-btn, .user-details-sec");
        if (!profileContainer.is(e.target) && profileContainer.has(e.target).length === 0) {
            $('.user-details-sec').hide();
        }
    });


    var toastCounter = 1;

$('.toast-btn').on('click', function() {
	var msg = $(this).attr('msg');
	var icon = $(this).attr('icon');
	var icon_color = $(this).attr('icon-color');
	var animation = $(this).attr('animation');

	displayToastNotification(msg, icon, icon_color, animation);
});


function displayToastNotification( msg, icon, icon_color, animation ) {
	var class_name = 'toast-'+toastCounter;
	var new_node;

	new_node = $('.master-toast-notification').clone().appendTo('.toasts').addClass(class_name + ' toast-notification').removeClass('master-toast-notification');
	new_node.find('.toast-msg').text(msg);
	new_node.find('.toast-icon i').addClass(icon);
	new_node.find('.toast-icon').addClass('wiggle-me').css('background-color', icon_color);
	new_node.removeClass('hide-toast').addClass(animation);
	setTimeout(function() {
		new_node.remove();
	}, 10000);

	toastCounter++;

    $('.alert-close').click(function(){
        $(this).parents('.toast-notification').remove();
    });
}
            
            $('#logoutBtn').on('click', function() {
			stompClient.disconnect();
			});
            
            function displayToastNotification( msg, icon, icon_color, animation ) {
			var class_name = 'toast-'+toastCounter;
			var new_node;
		
			new_node = $('.master-toast-notification').clone().appendTo('.toasts').addClass(class_name + ' toast-notification').removeClass('master-toast-notification');
			new_node.find('.toast-msg').text(msg);
			new_node.find('.toast-icon i').addClass(icon);
			new_node.find('.toast-icon').addClass('wiggle-me').css('background-color', icon_color);
			new_node.removeClass('hide-toast').addClass(animation);
			setTimeout(function() {
				new_node.remove();
			}, 10000);
		
			toastCounter++;
		
		    $('.alert-close').click(function(){
		        $(this).parents('.toast-notification').remove();
   		 });
}