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
                let li = '<tr><th>Id Competicao</th><th>Nome Competicao</th><th>Data Criacao</th></tr>';
                li = li + '<tr><td>' + data.idCompeticao + '</td><td>' + data.nomeCompeticao + '</td><td>' +
                        data.dataCriacao + '</td></tr>';
                document.getElementById("tCompetitionTableInfo").innerHTML = li;
            })
            .catch((err) => console.log(err));
}

function botaoCompetitionSearch() {
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
                let li = '<tr><th>Id Competicao</th><th>Nome Competicao</th><th>Data Criacao</th></tr>';
                li = li + '<tr><td>' + data.idCompeticao + '</td><td>' + data.nomeCompeticao + '</td><td>' +
                        data.dataCriacao + '</td></tr>';
                document.getElementById("tCompetitionTableInfo").innerHTML = li;
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
                let li = '<tr><th>Id Competicao</th><th>Nome Competicao</th><th>Data Criacao</th></tr>';
                li = li + '<tr><td>' + data.idCompeticao + '</td><td>' + data.nomeCompeticao + '</td><td>' +
                        data.dataCriacao + '</td></tr>';
                document.getElementById("tCompetitionTableInfo").innerHTML = li;
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
                let li = '<tr><th>Id Competicao</th><th>Nome Competicao</th><th>Data Criacao</th></tr>';
                li = li + '<tr><td>' + data.idCompeticao + '</td><td>' + data.nomeCompeticao + '</td><td>' +
                        data.dataCriacao + '</td></tr>';
                document.getElementById("tCompetitionTableInfo").innerHTML = li;
            })
            .catch((err) => console.log(err));
}