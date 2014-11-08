
    $("#login-action").click(function() {
        var boxhide = $('#login');
        var boxshow = $('#forget-pass');

        boxhide.addClass('visuallyhidden');  
      
        boxhide.one('transitionend', function(e) {  
      
          boxhide.addClass('hidden');  
      
        }); 

        setTimeout(function () { 
        boxshow.removeClass('hidden');  
        setTimeout(function () {  
          boxshow.removeClass('visuallyhidden');  
        }, 200);
        }, 200);

    });

    $("#cancel-action").click(function() {
        var boxhide = $('#forget-pass');
        var boxshow = $('#login');

        boxhide.addClass('visuallyhidden');  
      
        boxhide.one('transitionend', function(e) {  
      
          boxhide.addClass('hidden');  
      
        }); 

        setTimeout(function () { 
        boxshow.removeClass('hidden');  
        setTimeout(function () {  
          boxshow.removeClass('visuallyhidden');  
        }, 200);
        }, 200);

    });
    $("#sign-action").click(function() {
        var boxhide = $('#login');
        var boxshow = $('#inscription');

        boxhide.addClass('visuallyhidden');  
      
        boxhide.one('transitionend', function(e) {  
      
          boxhide.addClass('hidden');  
      
        }); 

        setTimeout(function () { 
        boxshow.removeClass('hidden');  
        setTimeout(function () {  
          boxshow.removeClass('visuallyhidden');  
        }, 200);
        }, 200);

    });
    $("#sign-in-action").click(function() {
        var boxhide = $('#inscription');
        var boxshow = $('#login');

        boxhide.addClass('visuallyhidden');  
      
        boxhide.one('transitionend', function(e) {  
      
          boxhide.addClass('hidden');  
      
        }); 

        setTimeout(function () { 
        boxshow.removeClass('hidden');  
        setTimeout(function () {  
          boxshow.removeClass('visuallyhidden');  
        }, 200);
        }, 200);

    });