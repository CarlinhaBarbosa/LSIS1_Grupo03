function login() {
    var type = location.search.split("type=")[1];
//    var userName = document.getElementById("userLogin");
//    var password = document.getElementById("password");
//
//    fetch("/login", {
//        method: GET,
//        body: formdata
//    })
//            .then((res) => {
//                if (res.status === 200) {
//                    return res.json();
//                } else {
//                    return res.json();
//                }
//            })
//            .then((data) => {
//                for (let i = 0; i < data.length; i++) {
//                    if (data[i].nomeEquipa.equals(userName) && data[i].password.equals(password)){
//                        var resposta = document.getElementById("resposta");
//                        resposta.innerHTML = "<div> Login efetuado com sucesso!</div>";
//                        window.location.href = "Juri.html";
//                }else{
//                    resposta.innerHTML = "<div>Credências erradas!</div>";
//                    window.location.href = "Login.html";
//                }
//                }
//            })
//
//            .catch((err) => console.log(err));

    alert(type);
    if (type == 1) {
        location.href = "Juri.html";
    } else if (type == 2) {
        location.href = "Team.html";
    }
    localStorage.setItem("userLoggado", "joao")
    alert("Login efectuado com sucesso");
}