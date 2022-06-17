/* global fetch */

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
    var idAEnviar = document.getElementById("inputIdCompetition").value;

    fetch('/selecionarCompeticao?id=' + idAEnviar, {
        method: 'GET',
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                document.getElementById("competitionId").value = data.idCompeticao;
                document.getElementById("competitionNameId").value = data.nomeCompeticao;
                document.getElementById("creationDateId").value = data.dataCriacaoString;
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
function submeterDadosCompeticao() {
    let form = document.getElementById("fCompetitionDetails");
    let formData = new FormData(form);

    for (var pair of formData.entries()) {
        console.log(pair[0] + ', ' + pair[1]);
    }

    fetch('/atualizarCompeticao', {
        method: 'POST',
        body: formData
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Competição alterada com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na alteração da competição!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

function submeterDadosRonda() {
    let form = document.getElementById("fRoundDetails");
    let formData = new FormData(form);

    for (var pair of formData.entries()) {
        console.log(pair[0] + ', ' + pair[1]);
    }

    fetch('/atualizarRonda', {
        method: 'POST',
        body: formData
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Ronda alterada com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na alteração da ronda!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

function submeterDadosEquipa() {
    let form = document.getElementById("fCompetitionTeamDetails");
    let formData = new FormData(form);

    for (var pair of formData.entries()) {
        console.log(pair[0] + ', ' + pair[1]);
    }

    fetch('/atualizarEquipaCompetitionManagement', {
        method: 'POST',
        body: formData
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Equipa alterada com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na alteração da equipa!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

function botaoDeleteCompetition() {
    var idAEnviar = document.getElementById("inputIdCompetition").value;

    fetch('/eliminarCompeticao?id=' + idAEnviar, {
        method: 'POST'
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Competição  eliminada com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na eliminação da Competição!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}
function botaoDeleteRound() {
    var idAEnviar = document.getElementById("inputIdRound").value;

    fetch('/eliminarRonda?id=' + idAEnviar, {
        method: 'POST'
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Competição  eliminada com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na eliminação da Competição!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

function botaoDeleteTeamOfCompetition() {
    var idAEnviar = document.getElementById("inputIdTeam").value;

    fetch('/eliminarEquipa?id=' + idAEnviar, {
        method: 'POST'
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Equipa  eliminada da competição com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na eliminação da equipa da competição!</div>";
                    return res.json();
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

    fetch('/selecionarRonda?id=' + idAEnviar, {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                document.getElementById("roundId").value = data.idRonda;
                document.getElementById("competitionIdround").value = data.idCompeticao;
                document.getElementById("RoundTypeId").value = data.tipoRonda;
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

    fetch('/obterEquipasDeUmaCompeticao', {
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
                    document.getElementById("tHeaderEquipasCompeticaoId").style.display = 'flex';

                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idAssociacaoEquipaCompeticao + '</td><td>' + data[i].idEquipa + '</td><td>' + data[i].idCompeticao + '</td></tr>';
                    }
                    document.getElementById("listaEquipasCompeticao").innerHTML = li;
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
    var idAEnviar = document.getElementById("inputIdTeam").value;

    fetch('/selecionarEquipa?id=' + idAEnviar, {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                document.getElementById("competitionTeamId").value = data.idEquipa;
                document.getElementById("competitionTeamNameId").value = data.nomeEquipa;
            })
            .catch((err) => console.log(err));
}

