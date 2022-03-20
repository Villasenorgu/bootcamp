class Calculadora {
  constructor(operandoAnterior, operandoActual) {
    this.operandoAnterior = operandoAnterior
    this.operandoActual = operandoActual
    this.resetear()
  }

  resetear() {
    this.operandoActual = ''
    this.operandoAnterior = ''
    this.operacion = undefined
  }

  borrar() {
    this.operandoActual = this.operandoActual.toString().slice(0, -1)
  }

  anadirNumero(numero) {
    if (numero === ',' && this.operandoActual.includes(',')) return
    this.operandoActual = this.operandoActual.toString() + numero.toString()
  }

  elijeOperacion(operacion) {
    if (this.operandoActual === '') return
    if (this.operandoAnterior !== '') {
      this.calcula()
    }
    this.operacion = operacion
    this.operandoAnterior = this.operandoActual
    this.operandoActual = ''
  }

  calcula() {
    let calculo
    let actual;
    if(this.operandoActual.includes(",")){
       actual = parseFloat(this.operandoActual.replace(",","."))
    }else{
       actual = parseFloat(this.operandoActual)
    }
    const anterior = parseFloat(this.operandoAnterior)
    if (isNaN(anterior) || isNaN(actual)) return
    switch (this.operacion) {
      case '+':
        calculo = anterior + actual
        break
      case '-':
        calculo = anterior - actual
        break
      case '*':
        calculo = anterior * actual
        break
      case '÷':
        calculo = anterior / actual
        break
      default:
        return
    }
    this.operandoActual = calculo
    this.operacion = undefined
    this.operandoAnterior = ''
  }

  leerNumeroPantalla(numero) {
    const cadenaNumero = numero.toString()
    const parteEntera = parseFloat(cadenaNumero.split(',')[0])
    const parteDecimal = cadenaNumero.split(',')[1]
    let enteroPantalla
    if (isNaN(parteEntera)) {
      enteroPantalla = ''
    } else {
      enteroPantalla = parteEntera.toLocaleString('es', { maximumFractionDigits: 4 })
    }
    if (parteDecimal != null) {
      return `${enteroPantalla},${parteDecimal}`
    } else {
      return enteroPantalla
    }
  }

  actualizarPantalla() {
    this.operandoActualPantalla =
      this.leerNumeroPantalla(this.operandoActual)
    if (this.operacion != null) {
    return `${this.leerNumeroPantalla(this.operandoAnterior)} ${this.operacion}`
    } else {
    return ''
    }
  }
}