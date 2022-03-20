function Ejercicio1(cad, cad2) {
  let ran = Math.floor(Math.random() * (cad - cad2)) + parseInt(cad2);
  return ran;
}

function Ejercicio2() {
  let ran = Ejercicio1(100, 0);
  let introducido;
  console.log(ran);

  for (let i = 10; i > 0; i--) {
    if (i == 10) {
      introducido = window.prompt("Intenta adivinar el numero entre 100 y 0");
    }
    if (parseInt(introducido) == parseInt(ran)) {
      return "Felicidades has acertado :)";
    } else {
      if (parseInt(introducido) > parseInt(ran)) {
        introducido = window.prompt(
          "El número introducido es mayor que el buscado, intentalo de nuevo"
        );
      } else {
        introducido = window.prompt(
          "El número introducido es menor que el buscado, intentalo de nuevo"
        );
      }
    }
  }
  return "Te quedaste sin intentos :(";
}

function Ejercicio3(vs, a) {
  let b = [];
  for (let i = 0; i < a; i++) {
    b[i] = vs;
  }
  console.log(b);
  return b;
}

function Ejercicio4(n) {
  let i = 2;
  let pAdded = 0;
  let np = [];
  while (pAdded < n) {
    if (esPrimo(i)) {
      np[pAdded] = i;
      pAdded++;
    }
    i++;
  }

  return np;

  function esPrimo(numero) {
    for (var i = 2; i < numero; i++) {
      if (numero % i === 0) {
        return false;
      }
    }
    return numero !== 1;
  }
}

function Ejercicio5(nif) {
  if (nif.length != 9) {
    return "Esto no es un nif, no tiene el número de caracteres adecuado.", false;
  }
  for (let i = 0; i < nif.length - 1; i++) {
    if (isNaN(nif[i])) {
      return (
        "Esto no es un nif, el carácter " +
        nif[i] +
        " no es un número. Los primeros 8 caracteres deben ser números.", false
      );
    }
  }
  if (typeof nif[8] == "number") {
    return "El último carácter debe ser una letra.", false;
  }
  nif = nif.toUpperCase();
  if (
    "TRWAGMYFPDXBNJZSQVHLCKE".charAt(
      parseInt(nif.substring(0, nif.length - 1)) % 23
    ) != nif.charAt(nif.length - 1)
  ) {
    return "El último carácter no es el que le corresponde a este NIF", false;
  }

  return "Felicidades, tu NIF es válido", true;
}

function Ejercicio6(s) {
  s = s.toLowerCase();
  s = s.trim();
  s = s.replace(/ /g, "").match(/[a-z]/gi).reverse();
  if (s.join("") !== s.reverse().join("")) {
    return "No es un palíndromo", false;
  }
  return "Felicidades, es un palíndromo", true;
}

function FuncionConstructora() {
  this.inicializar = function () {
    this.numeroBuscado = Ejercicio1(10, 0);
    this.intentos = 0;
    this.encontrado = false;
    this.resultado = "Pendiente de empezar";
  };

  this.jugada = function (numeroIntroducido) {
    if (this.getFinalizado()) {
      throw new Error("El juego a finalizado");
    }
    this.intentos += 1;
    if (this.numeroBuscado == numeroIntroducido) {
      this.encontrado = true;
      this.resultado = "Bieeen!!! Acertaste.";
    } else if (this.intentos >= 10) {
      this.resultado =
        "Upsss! Se acabaron los intentos, el número era el " +
        this.numeroBuscado;
    } else if (this.numeroBuscado > numeroIntroducido) {
      this.resultado = "Mi número es mayor.";
    } else {
      this.resultado = "Mi número es menor.";
    }
  };

  this.getResultado = function () {
    return this.resultado;
  };

  this.getFinalizado = function () {
    return this.intentos >= 10 || this.encontrado;
  };

  this.getJugada = function () {
    return this.intentos;
  };
}

class AdivinaNumero {
  constructor() {
    this.numeroBuscado = Ejercicio1(10, 0);
    this.intentos = 0;
    this.encontrado = false;
    this.resultado = "Pendiente de empezar";
  }

  jugada(movimiento) {
    jugada(Integer.parseInt(movimiento));
  }

  jugada(numeroIntroducido) {
    if (this.getFinalizado()) {
      console.log("El juego a finalizado");
    }
    this.intentos += 1;
    if (this.numeroBuscado == numeroIntroducido) {
      this.encontrado = true;
      this.resultado = "Bieeen!!! Acertaste.";
    } else if (this.intentos >= 10) {
      this.resultado =
        "Upsss! Se acabaron los intentos, el número era el " +
        this.numeroBuscado;
    } else if (this.numeroBuscado > numeroIntroducido) {
      this.resultado = "Mi número es mayor.";
    } else {
      this.resultado = "Mi número es menor.";
    }
  }

  getResultado() {
    return this.resultado;
  }

  getFinalizado() {
    return this.intentos >= 10 || this.encontrado;
  }

  getJugada() {
    return this.intentos;
  }
}
