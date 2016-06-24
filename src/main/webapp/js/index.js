var begin = 0;
var sum = 7;

$(document).ready(function() {
	loadItem();
	loadPageViews();
	isLogin();
	login();
	
	$('.footer-load-button').click(function() {
		ifLoginDo(loadMoreItem, notLogin);
	});

	$('.nav-brand').click(function() {
		location.href = 'index.html';
	});

	$('.nav-intro').click(function() {
		ifLoginDo(showEditor, notLogin);
	});
	
	$('.nav-dropdown-container').mouseover(function () {
		if (null != $('.nav-id').html() && '' != $('.nav-id').html().trim()) {
			$('.nav-dropdown').css({
				'display': 'block'
			});
		}
	});
	
	$('.nav-dropdown-container').mouseout(function() {
		if (null != $('.nav-id').html() && '' != $('.nav-id').html().trim()) {
			$('.nav-dropdown').css({
				'display': 'none'
			});
		}
	});
	
	$('.nav-dropdown-logout').click(logout);
});

function loadPageViews() {
	$.ajax({
		url: 'login/pageviews.do',
		type: 'get',
		dataType: 'json',
		success: function(json) {
			if (json.success) {
				$('.saysomething-content').html(json.result);
			} else {
				$('.saysomething-content').html('0');
			}
		}
	});
}

function logout() {
	$.ajax({
		url: 'login/logout.do',
		type: 'get',
		dateType: 'json',
		success: function(json) {
			if (json.success) {
				location.href = 'index.html';
			} else {
				alert('Log out failed!');
			}
		}
	});
}

function ifLoginDo(doSuccess, doFail) {
	$.ajax({
		url: 'login/isLogin.do',
		type: 'get',
		dataType: 'json',
		success: function(json) {
			if (json.success) {
				doSuccess();
			} else {
				doFail();
			}
		}
	});
}

function notLogin() {
	alert("Please sign in!");
}

function showEditor() {
	var isShow = $('.editor-container').css('display');
	if (isShow == 'none') {
		$('.editor-container').css({
			'display': 'block'
		});
		$('.profile-container').css({
			'display': 'none'
		});
		$('.outest-container').css({
			'display': 'none'
		});
		$('.footer-container').css({
			'display': 'none'
		});
	} else {
		$('.editor-container').css({
			'display': 'none'
		});
		$('.profile-container').css({
			'display': 'none'
		});
		$('.outest-container').css({
			'display': 'block'
		});
		$('.footer-container').css({
			'display': 'block'
		});
	}
}

function loadMoreItem() {
	if (sum < 7) {
		$('.item-container').append('<div class="item-tip">No more ~</div>');
		$('.footer-container').css({
			'visibility': 'hidden'
		});
	} else {
		loadItem();
	}
}

function login() {
	$('.nav-username').click(function() {
		if ($('.nav-username').text().trim() == 'Sign in') {
			location.href = 'login.html';
		} else if (null != $('.nav-id').html() && '' != $('.nav-id').html().trim()) {
			showProfile();
		}
	});
}

function showProfile() {
	var isShow = $('.profile-container').css('display');
	if (isShow == 'none') {
		$('.profile-container').css({
			'display': 'block'
		});
		$('.editor-container').css({
			'display': 'none'
		});
		$('.outest-container').css({
			'display': 'none'
		});
		$('.footer-container').css({
			'display': 'none'
		});
	} else {
		$('.profile-container').css({
			'display': 'none'
		});
		$('.editor-container').css({
			'display': 'none'
		});
		$('.outest-container').css({
			'display': 'block'
		});
		$('.footer-container').css({
			'display': 'block'
		});
	}
}

function isLogin() {
	$.ajax({
		url: 'login/isLogin.do',
		type: 'get',
		dataType: 'json',
		success: function(json) {
			if (json.success) {
				$('.nav-username').text(json.result[0].username);
				$('.nav-id').text(json.result[0].id);
				$('.avatar-container img').attr('src', json.result[0].avatarPath);
				$('.username-input').val(json.result[0].username);
				$('.password-input').val(json.result[0].password);
				$('.birthdate-input').val(json.result[0].brithdate);
				$('.location-input').val(json.result[0].location);
				$('.aboutme-input').val(json.result[0].aboutMe);
			}
		}
	});
}

function loadItem() {
    $.ajax({
        url: 'secret/queryBy.do',
        type: 'get',
        data: {
        	begin: begin,
        	sum: sum
        },
        success: function(json) {
    		var i = 0;
    		for(; i < json.result.length; i++) {
    			createItem(json.result[i]);
    		}
    		if (i < 7) {
    			sum = i;
    		}
    		begin += sum;
        },
        dataType: 'json'
    });
}

function createItem(item) {
    var itemDiv = $('<div class="item"><div class="item-avatar"><img alt="avatar" src="' +
    item.user.avatarPath +
    '" /></div><div class="item-content-container"><div class="item-username">' +
    item.user.username +
    '</div><div class="item-title">' +
    item.title +
    '</div><div class="item-content">' +
    item.content +
    '</div><div class="item-footer">' +
    item.pubdate +
    '</div></div></div>');
    $('.item-container').append(itemDiv);
}
