function login() {
    var userName = document.getElementById("userLogin");
    var password = document.getElementById("password");

    fetch("/login", {
        method: GET,
        body: formdata
    })
            .then((res) => {
                if (res.status === 200) {
                    return res.json();
                } else {
                    return res.json();
                }
            })
            .then((data) => {
                for (let i = 0; i < data.length; i++) {
                    if (data[i].nomeEquipa.equals(userName) && data[i].password.equals(password)){
                        var resposta = document.getElementById("resposta");
                        resposta.innerHTML = "<div> Login efetuado com sucesso!</div>";
                        window.location.href = "Juri.html";
                }else{
                    resposta.innerHTML = "<div>Credências erradas!</div>";
                    window.location.href = "Login.html";
                }
                }
            })

            .catch((err) => console.log(err));
}


