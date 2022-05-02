Kakao.init('ab12bbe8791d0e0c3924b5d898a18f6a'); //발급받은 키 중 javascript키를 사용해준다.
//console.log(Kakao.isInitialized()); // sdk초기화여부판단

window.onload = function() {
	document.getElementById("signin").addEventListener("click", function() {
		const uid = document.getElementById("uId").value;
		const upw = document.getElementById("uPw").value;

		if (uid.length > 0 && uid != undefined) {
			if (upw.length > 0 && upw != undefined) {
				const url = "/ch/users/user/" + uid;
				const data = "upw=" + upw;
				postAjax(url, data, function() {
					if (this.response == "s") {
						alert("로그인에 성공하셨습니다");
						location.href = "/ch";
					} else if (this.response == "f") {
						alert("아이디, 혹은 비밀번호가 틀렸습니다");
					} else {
						alert("해당 아이디가 존재하지 않습니다");
					}
				});
			} else {
				return alert("비밀번호 입력을 확인해주세요");
			}
		} else {
			return alert("아이디 입력을 확인해주세요");
		}
	})

	document.getElementById("klogin").addEventListener("click", function() {
		//카카오로그인	
		Kakao.Auth.login({
			success: function(response) {
				Kakao.API.request({
					url: '/v2/user/me',
					success: function(response) {
						console.log(response) // T or F
						console.log(response.id)
						console.log(response.kakao_account.email)
						console.log(response.kakao_account.gender)
						console.log(response.kakao_account.age_range)

						const url = "/ch/users/user/" + response.kakao_account.email;
						const data = "upw=";

						postAjax(url, data, function() {
							if (this.response == "s") {
								alert("로그인에 성공하셨습니다");
								location.href = "/ch";
							} else if (this.response == "f") {
								alert("아이디, 혹은 비밀번호가 틀렸습니다");
							} else {
								if (confirm("회원가입을 하시겠습니까?")) {
									alert("회원가입 페이지로 이동합니다.");
									location.href = "/ch/newcomer";
								}
								else {
									alert("취소하셨습니다.");
								}
							}
						});

					},
					fail: function(error) {
						console.log(error)
						alert("아이디와 비밀번호를 확인해주세요.")
					},
				})
			},
			fail: function(error) {
				console.log(error)
			},
		})
	});
	

		
	/*
	document.getElementById("klogout").addEventListener("click", function() {
		//카카오로그아웃  
		if (Kakao.Auth.getAccessToken()) {
			Kakao.API.request({
				url: '/v1/user/unlink',
				success: function(response) {
					console.log(response)
				},
				fail: function(error) {
					console.log(error)
				},
			})
			Kakao.Auth.setAccessToken(undefined)
		}
	});
	*/
	
	//console.log(naverLogin);
	/*
	function setLoginStatus() {

		const message_area = document.getElementById('message');
		message_area.innerHTML = `
		      <h3> Login 성공 </h3>
		      <div>user Nickname : ${naverLogin.user.nickname}</div>
		      <div>user Age(범위) : ${naverLogin.user.age}</div>
		      <div>user Birthday : ${naverLogin.user.birthday}</div>
		      `;

		const button_area = document.getElementById('button_area');
		button_area.innerHTML = "<button id='btn_logout'>로그아웃</button>";

		const logout = document.getElementById('btn_logout');
		logout.addEventListener('click', (e) => {
			naverLogin.logout();
			location.href = "/ch";
		})
	}
	*/
	/*
	document.getElementById("glogin").addEventListener("click", function() {
		function onSignIn(googleUser) {
			var profile = googleUser.getBasicProfile();
			console.log('ID: ' + profile.getId());
			console.log('Name: ' + profile.getName());
			console.log('Image URL: ' + profile.getImageUrl());
			console.log('Email: ' + profile.getEmail());

			if (confirm("회원가입을 하시겠습니까?")) {
				signOut();
				alert("회원가입 페이지로 이동하겠습니다.");
				location.href = "/ch/newcomer";
			}
			else {
				signOut();
				alert("취소하셨습니다.")
			}
		}
		function onFailure(error) {
			console.log(error);
		}

		function signOut() {
			if (gapi.auth2 != undefined) {
				var auth2 = gapi.auth2.getAuthInstance();
				auth2.signOut().then(function() {
					console.log('User signed out.');
				});
			}
			auth2.disconnect();
		}
	});
	*/

};

