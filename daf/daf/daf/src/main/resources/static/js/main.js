function GerarId(){
	var txt = "";
	var aleatorio = Math.floor(Math.random() * 999999);
	document.getElementById('IdUsuario').value =(txt + aleatorio);
}