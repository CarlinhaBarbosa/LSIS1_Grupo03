/* global fetch */

function botaoTeamInfo() {
    var xH = document.getElementById("h2TeamInfo");
    var xP = document.getElementById("pTeamInfo");
    var xI = document.getElementById("fTeamInfo");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
    var idAEnviar = document.getElementById("inputTeamId").value;

    fetch('/selecionarEquipa?id=' + idAEnviar, {
        method: 'GET',
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
//                let li = '<tr><th>Nome</th><th>Data de Nascimento</th><th>Número Fiscal</th><th>Telefone</th><th>E-mail</th><th>Morada</th></tr>';
//                li = li + '<tr><td>' + data.nome + '</td><td>' + data.dataNas + '</td><td>' +
//                        data.nrFiscal + '</td><td>' + data.telefone + '</td><td>' + data.email + '</td> <td>' + data.morada + '</td></tr>';
//                document.getElementById("tClientInfoDB").innerHTML = li;
                document.getElementById("teamId").value = data.idEquipa;
                document.getElementById("teamNameId").value = data.nomeEquipa;
            })
            .catch((err) => console.log(err));
}

function alterarDados() {
    var idEquipaInput = document.getElementById("teamId")
    var nomeEquipaInput = document.getElementById("teamNameId");

    if (nomeEquipaInput.value === "") {
        alert("Insira um nome válido");
    }
    if (isNaN(idEquipaInput.value) || idEquipaInput.value === "") {
        alert("Insira um ID válido");
    }

    let form = document.getElementById("fTeamInfo");
    let formdata = new FormData(form);

    fetch('/atualizarEquipa', {
        method: 'POST',
        body: formdata
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Equipa inserida com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na criação da Equipa!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

