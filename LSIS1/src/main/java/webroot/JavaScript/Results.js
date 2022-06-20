/* global fetch */

function botaoCompetitionList() {
    var xH = document.getElementById("h2CompetitionList");
    var xP = document.getElementById("pCompetitionList");
    var xI = document.getElementById("tCompetitionList");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }

    fetch('/obterCompeticoes', {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                if (data.length > 0) {
                    document.getElementById("tHeaderId").style.display = 'flex';
                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idCompeticao + '</td><td>' + data[i].nomeCompeticao + '</td><td>' +
                                data[i].dataCriacaoString + '</td></tr>';
                    }
                    document.getElementById("listaCompeticoes").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}

function botaoRoundSearch() {
    var xH = document.getElementById("h2CompetitionRoundList");
    var xP = document.getElementById("pCompetitionRoundList");
    var xI = document.getElementById("tCompetitionRoundList");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
    var idAEnviar = document.getElementById("inputIdCompeticao").value;

    fetch('/obterRondasCompeticao?id=' + idAEnviar, {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                if (data.length > 0) {
                    document.getElementById("tHeaderRondasId").style.display = 'flex';

                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idRonda + '</td><td>' + data[i].idCompeticao + '</td><td>' + data[i].tipoRonda + '</td></tr>';
                    }
                    document.getElementById("listaRondas").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}

function botaoRoundInfo() {
    var xH = document.getElementById("h2RoundResults");
    var xP = document.getElementById("pRoundResults");
    var xI = document.getElementById("tRoundResults");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
    var idAEnviar = document.getElementById("inputIdRound").value;

    fetch('/obterResultadosRonda?id=' + idAEnviar, {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                if (data.length > 0) {
                    document.getElementById("tHeaderResultadosRondaId").style.display = 'flex';

                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idAssociacaoRobotRonda + '</td><td>' + data[i].idRobot + '</td><td>' + data[i].idRonda + '</td><td>' + data[i].tempo + '</td><td>' + data[i].velocidade + '</td></tr>';
                    }
                    document.getElementById("listaResultadosRonda").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}


function botaoRobotResult() {
    var xH = document.getElementById("h2RobotResult");
    var xP = document.getElementById("pRobotResult");
    var xI = document.getElementById("fRobotResult");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
    var idAEnviar = document.getElementById("inputIdRound").value;
    var idAEnviarRobot = document.getElementById("inputIdRobot").value;

    fetch('/obterResultadosRobotRonda?id=' + idAEnviar + '&idRobot=' + idAEnviarRobot, {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                document.getElementById("associationId").value = data.idAssociacaoRobotRonda;
                document.getElementById("roundId").value = data.idRonda;
                document.getElementById("robotId").value = data.idRobot;
                document.getElementById("tempoId").value = data.tempo;
                document.getElementById("velocidadeId").value = data.velocidade;
            })
            .catch((err) => console.log(err));
}
function alterarDados() {
    var inputAssociacaoRobotRonda = document.getElementById("associationId").value;
    var inputRobotId = document.getElementById("robotId").value;
    var inputTempoId = document.getElementById("tempoId").value;
    var inputVelocidadeId = document.getElementById("velocidadeId").value;

//    if (isNaN(inputAssociacaoRobotRonda.value) || inputAssociacaoRobotRonda.value === "") {
//        alert("Insira um ID válido");
//    }
//    if (isNaN(inputRobotId.value) || inputRobotId.value === "") {
//        alert("Insira um ID válido");
//    }

//    if (!isDouble(inputTempoId.value) || inputTempoId.value === "") {
//        alert("Insira um tempo válido");
//    }
//    if (!isDouble(inputVelocidadeId.value) || inputVelocidadeId.value === "") {
//        alert("Insira uma velociade válida");
//    }

    let form = document.getElementById("fRobotResult");
    let formdata = new FormData(form);

    fetch('/atualizarResultados', {
        method: 'POST',
        body: formdata
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Resultados alterados com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na alteração dos dados!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}