(function($) {
    $(function() {
        var jcarousel = $('.jcarousel').jcarousel();

        $('.jcarousel-control-prev')
            .on('jcarouselcontrol:active', function() {
                $(this).removeClass('inactive');
            })
            .on('jcarouselcontrol:inactive', function() {
                $(this).addClass('inactive');
            })
            .jcarouselControl({
                target: '-=1'
            });

        $('.jcarousel-control-next')
            .on('jcarouselcontrol:active', function() {
                $(this).removeClass('inactive');
            })
            .on('jcarouselcontrol:inactive', function() {
                $(this).addClass('inactive');
            })
            .jcarouselControl({
                target: '+=1'
            });

        CarouselPicturesAjax.getPicturesFromEvents({
        	  callback:function(data) { 
                  var html = '<ul>';                  
                  $.each(JSON.parse(data),function(i,item) {
                      html += '<li><img src="' + item.src + '" alt="' + item.title + '" /></li>';
                  });

                  html += '</ul>';
                  // Append items
                  jcarousel
                      .html(html);

                  // Reload carousel
                  jcarousel
                      .jcarousel('reload');
        	  }});        
    });
})(jQuery);