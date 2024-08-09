$(document).ready(function() {
	$('#them').click(function(event) {
		alert("Chúng tôi xin chân thành cảm ơn vì bạn đã tin tưởng chúng tôi! ");
	});
	$('img').click(function(event) {
		alert("Bạn có chắc chắn muốn mua hàng! ");
	});
    $('input.input-qty').each(function() {
		var $this = $(this),
		  qty = $this.parent().find('.is-form'),
		  min = Number($this.attr('min')),
		  max = Number($this.attr('max'))
		if (min == 0) {
		  var d = 0
		} else d = min
		$(qty).on('click', function() {
		  if ($(this).hasClass('minus')) {
			if (d > min) d += -1
		  } else if ($(this).hasClass('plus')) {
			var x = Number($this.val()) + 1
			if (x <= max) d += 1
		  }
		  $this.attr('value', d).val(d)
		})
	  });    
	  (function() {
		var cx = '004904461424527752354:gzt39ubicru';
		var gcse = document.createElement('script');
		gcse.type = 'text/javascript';
		gcse.async = true;
		gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
			'//www.google.com/cse/cse.js?cx=' + cx;
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(gcse, s);
	  })();    

	var autoLoad= setInterval(function(){
		$('#btn-next').trigger('click');
	},3000);

	$('#btn-next').click(function(event) {
		clearInterval(autoLoad);
		var slide_sau = $('.active').next();
		var vi_tri_hien_tai = $('.active_nut').index()+1;
		if(slide_sau.length!=0){
			$('.active').addClass('bien-mat-ben-trai').one('webkitAnimationEnd', function(event) {
				$('.bien-mat-ben-trai').removeClass('bien-mat-ben-trai').removeClass('active');
			});
			slide_sau.addClass('active').addClass('di-vao-ben-phai').one('webkitAnimationEnd', function(event) {
				$('.di-vao-ben-phai').removeClass('di-vao-ben-phai');
			});
			// xử lý nút 
			$('.nut-slide ul li').removeClass('active_nut');
			$('.nut-slide ul li:nth-child('+(vi_tri_hien_tai+1)+')').addClass('active_nut');
		}else{
			$('.active').addClass('bien-mat-ben-trai').one('webkitAnimationEnd', function(event) {
				$('.bien-mat-ben-trai').removeClass('bien-mat-ben-trai').removeClass('active');
			});
			$('.slide:first-child').addClass('active').addClass('di-vao-ben-phai').one('webkitAnimationEnd', function(event) {
				$('.di-vao-ben-phai').removeClass('di-vao-ben-phai');
			});
			// xử lý nút 
			$('.nut-slide ul li').removeClass('active_nut');
			$('.nut-slide ul li:nth-child(1)').addClass('active_nut');
		}
	});
	$('#btn-prev').click(function(event) {
		clearInterval(autoLoad);
		var slide_truoc = $('.active').prev();
		var vi_tri_hien_tai = $('.active_nut').index()+1;
		if(slide_truoc.length!=0){
			$('.active').addClass('bien-mat-ben-phai').one('webkitAnimationEnd', function(event) {
				$('.bien-mat-ben-phai').removeClass('bien-mat-ben-phai').removeClass('active');
			});
			slide_truoc.addClass('active').addClass('di-vao-ben-trai').one('webkitAnimationEnd', function(event) {
				$('.di-vao-ben-trai').removeClass('di-vao-ben-trai');
			});
			// xử lý nút 
			$('.nut-slide ul li').removeClass('active_nut');
			$('.nut-slide ul li:nth-child('+(vi_tri_hien_tai-1)+')').addClass('active_nut');
		}else{
			$('.active').addClass('bien-mat-ben-phai').one('webkitAnimationEnd', function(event) {
				$('.bien-mat-ben-phai').removeClass('bien-mat-ben-phai').removeClass('active');
			});
			$('.slide:last-child').addClass('active').addClass('di-vao-ben-trai').one('webkitAnimationEnd', function(event) {
				$('.di-vao-ben-trai').removeClass('di-vao-ben-trai');
			});
						// xử lý nút 
			$('.nut-slide ul li').removeClass('active_nut');
			$('.nut-slide ul li:last-child').addClass('active_nut');
		}
	});

	$('.nut-slide ul li').click(function(event) {
		clearInterval(autoLoad);
		var vi_tri_hien_tai = $('.active_nut').index()+1;
		var vi_tri_click = $(this).index()+1;
		$('.nut-slide ul li').removeClass('active_nut');
		$(this).addClass('active_nut');
		if(vi_tri_click>vi_tri_hien_tai){
			$('.active').addClass('bien-mat-ben-trai').one('webkitAnimationEnd', function(event) {
				$('.bien-mat-ben-trai').removeClass('bien-mat-ben-trai').removeClass('active');
			});
			$('.slide:nth-child('+vi_tri_click+')').addClass('active').addClass('di-vao-ben-phai').one('webkitAnimationEnd', function(event) {
				$('.di-vao-ben-phai').removeClass('di-vao-ben-phai');
			});
		}
		if(vi_tri_click<vi_tri_hien_tai){
			$('.active').addClass('bien-mat-ben-phai').one('webkitAnimationEnd', function(event) {
				$('.bien-mat-ben-phai').removeClass('bien-mat-ben-phai').removeClass('active');
			});
			$('.slide:nth-child('+vi_tri_click+')').addClass('active').addClass('di-vao-ben-trai').one('webkitAnimationEnd', function(event) {
				$('.di-vao-ben-trai').removeClass('di-vao-ben-trai');
			});
		}

	});

});