function Ejercicio1(cad, cad2) {
  let ran = Math.floor(Math.random() * (cad - cad2)) + parseInt(cad2);
  return ran;
}

function Ejercicio2() {
  let ran = Ejercicio1(100, 0);
  let introducido;
  console.log(ran);

  for (var i = 10; i > 0; i--) {
    if (i == 10) {
      introducido = window.prompt("Intenta adivinar el numero entre 100 y 0");
    }

    if (introducido == ran) {
      return "Felicidades has acertado :)";
    } else {
      if (introducido > ran) {
        console.log("El número introducido es mayor que el buscado");
      } else {
        console.log("El número introducido es menor que el buscado");
      }
    }
  }
  return "Te quedaste sin intentos :(";
}
