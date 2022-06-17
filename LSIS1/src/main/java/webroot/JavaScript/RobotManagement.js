/* global fetch */

function botaoRobotList() {
    var xH = document.getElementById("h2RobotList");
    var xP = document.getElementById("pRobotList");
    var xI = document.getElementById("tRobotList");
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

    fetch('/selecionarRobotsEquipa?id=' + idAEnviar, {
        method: 'GET',
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                if (data.length > 0) {
                    document.getElementById("tHeaderRobotsId").style.display = 'flex';

                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idRobot + '</td><td>' + data[i].idEquipa + '</td><td>' +
                                data[i].nomeRobot + '</td><td>' + data[i].macAdress + '</td></tr>';
                    }
                    document.getElementById("listaRobots").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}

function botaoRobotInfo() {
    var xH = document.getElementById("h2RobotInfo");
    var xP = document.getElementById("pRobotInfo");
    var xI = document.getElementById("fRobotInfo");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
    var idAEnviar = document.getElementById("inputIdRobot").value;

    fetch('/selecionarRobot?id=' + idAEnviar, {
        method: 'GET',
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                document.getElementById("robotId").value = data.idRobot;
                document.getElementById("teamNameId").value = data.idEquipa;
                document.getElementById("robotNameId").value = data.nomeRobot;
                document.getElementById("macAddressId").value = data.macAdress;
            })
            .catch((err) => console.log(err));
}

function botaoEliminarRobot() {
    var txt;
    if (confirm("Pretende eliminar o robô?")) {
        txt = "Robô eliminado";
    } else {
        txt = "Eliminação cancelada";
    }
    document.getElementById("demo").value = txt;
    console.log(txt);

    var idAEnviar = document.getElementById("inputIdRobot").value;

    fetch('/eliminarRobot?id=' + idAEnviar, {
        method: 'POST'
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Robô eliminado com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na eliminação do Robô!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

function alterarDados() {

    var nomeRobotInput = document.getElementById("robotNameId");
    var macAddressInput = document.getElementById("macAddressId");

    if (nomeRobotInput.value === "") {
        alert("Insira um nome válido");
    }
    var filterMacAddress = /^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$/i;
    if (!filterMacAddress.test(macAddressInput.value)) {
        alert("Insira um Mac Address válido");
        macAddressInput.focus;
    }

    let form = document.getElementById("fRobotInfo");
    let formdata = new FormData(form);

    fetch('/atualizarRobot', {
        method: 'POST',
        body: formdata
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Robô inserida com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na criação do Robô!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}
