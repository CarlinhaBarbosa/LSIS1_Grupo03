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
//                let li = '<tr><th>Nome</th><th>Data de Nascimento</th><th>Número Fiscal</th><th>Telefone</th><th>E-mail</th><th>Morada</th></tr>';
//                li = li + '<tr><td>' + data.nome + '</td><td>' + data.dataNas + '</td><td>' +
//                        data.nrFiscal + '</td><td>' + data.telefone + '</td><td>' + data.email + '</td> <td>' + data.morada + '</td></tr>';
//                document.getElementById("tClientInfoDB").innerHTML = li;
                document.getElementById("robotId").value = data.idRobot;
                document.getElementById("teamNameId").value = data.idEquipa;
                document.getElementById("robotNameId").value = data.nomeRobot;
                document.getElementById("macAddressId").value = data.macAddress;
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
//                let li = '<tr><th>Nome</th><th>Data de Nascimento</th><th>Número Fiscal</th><th>Telefone</th><th>E-mail</th><th>Morada</th></tr>';
//                li = li + '<tr><td>' + data.nome + '</td><td>' + data.dataNas + '</td><td>' +
//                        data.nrFiscal + '</td><td>' + data.telefone + '</td><td>' + data.email + '</td> <td>' + data.morada + '</td></tr>';
//                document.getElementById("tClientInfoDB").innerHTML = li;
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
//        body: formdata
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Competição inserida com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na criação da Competição!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

function alterarDados() {

    var nomeRobotInput = document.getElementById("robotNameId");
    var macAddressInput = document.getElementById("macAddressId")

    if (nomeRobotInput.value === "") {
        alert("Insira um nome válido");
    }
    var filterMacAddress = /^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$/i;
    if (!filterMacAddress.test(macAddressInput.value)) {
        alert("Insira um Mac Address válido");
        macAddressInput.focus;
        return false;
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
                    infoPanel.innerHTML = "<div>Equipa inserida com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na criação da Equipa!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}
