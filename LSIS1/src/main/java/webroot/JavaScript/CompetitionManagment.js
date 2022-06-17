function botaoCompetitionList() {
    var xH = document.getElementById("h2CompetitionTableInfo");
    var xP = document.getElementById("pCompetitionTableInfo");
    var xI = document.getElementById("tCompetitionTableInfo");
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

function botaoCompetitionShowDetails() {
    var xH = document.getElementById("h2CompetitionDetails");
    var xP = document.getElementById("pCompetitionDetails");
    var xI = document.getElementById("fCompetitionDetails");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
}
function submeterDados() {
    let form = document.getElementById("fCompetitionSubscription");
    let formData = new FormData(form);

    for (var pair of formData.entries()) {
        console.log(pair[0] + ', ' + pair[1]);
    }

    fetch('/inscreverEquipaCompeticao', {
        method: 'POST',
        body: formData
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Inscrição inserida com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na inscrição!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

function botaoRoundList() {
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

function botaoRoundShowDetails() {
    var xH = document.getElementById("h2RoundDetails");
    var xP = document.getElementById("pRoundDetails");
    var xI = document.getElementById("fRoundDetails");
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

function botaoCompetitionListTeams() {
    var xH = document.getElementById("h2CompetitionListTeams");
    var xP = document.getElementById("pCompetitionListTeams");
    var xI = document.getElementById("tCompetitionListTeams");
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

function botaoCompetitionListTeams() {
    var xH = document.getElementById("h2CompetitionListTeams");
    var xP = document.getElementById("pCompetitionListTeams");
    var xI = document.getElementById("tCompetitionListTeams");
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

function botaoCompetitionListTeamDetails() {
    var xH = document.getElementById("h2CompetitionTeamDetails");
    var xP = document.getElementById("pCompetitionTeamDetails");
    var xI = document.getElementById("fCompetitionTeamDetails");
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

