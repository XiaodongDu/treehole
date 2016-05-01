$(document).ready(function() {
	$('.signin-signin').click(function() {
		$.ajax({
			url: 'login/signin.do',
			type: 'post',
			data: {
				id: $('.signin-username-input').val(),
				password: $('.signin-password-input').val(),
			},
			dataType: 'json',
			success: function(json) {
				if (json.success) {
					location.href = 'index.html';
				} else {
					alert('username or password error!');
				}
			}
		});
	});
	
	$('.signup-reset').click(function() {
		$('input[class^=signup]').val('');
	});
	
	$('.signup-signup').click(function() {
		$.ajax({
			url: 'user/insert.do',
			type: 'post',
			data: {
				username: $('.signup-username-input').val(),
				password: $('.signup-password-input').val(),
			},
			dataType: 'json',
			success: function(json) {
				if (json.success) {
					alert('sign up success!');
				}
			}
		});
	});
});
