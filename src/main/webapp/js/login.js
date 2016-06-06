$(document).ready(function() {
	$('.signin-signin').click(function() {
		login();
	});
	
	$('.signin-password-input').keyup(function(event) {
		if (event.keyCode == 13) {
			login();
		}
	});
	
	$('.signup-reset').click(function() {
		reset();
	});
	
	$('.signup-signup').click(function() {
		signup();
	});
	
	$('.nav-brand').click(function() {
		location.href = 'index.html';
	});
});

function login() {
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
}

function reset() {
	$('input[class^=signup]').val('');
}

function signup() {
	$.ajax({
		url: 'user/insert.do',
		type: 'post',
		data: {
			id: $('.signup-username-input').val(),
			username: $('.signup-username-input').val(),
			password: $('.signup-password-input').val(),
		},
		dataType: 'json',
		success: function(json) {
			if (json.success) {
				alert('sign up success!');
				location.href = 'index.html';
			}
		}
	});
}
