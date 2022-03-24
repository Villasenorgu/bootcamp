import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ng-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css'],
})
export class CalculadoraComponent implements OnInit {
  public operandoAnterior: string = '0';
  public operandoActual: string = '0';
  operacion: string = '';
  operandoActualPantalla: string = '0';

  constructor() {
    // this.operandoAnterior = operandoAnterior
    // this.operandoActual = operandoActual
    // this.resetear()
  }

  resetear() {
    this.operandoActual = '0';
    this.operandoActualPantalla = '0';
    this.operandoAnterior = '0';
    this.operacion = '';
  }

  negar() {
    let negado = this.operandoActualPantalla.replace(',','.');
    negado = (parseFloat(negado)* -1).toString();
    this.operandoActual = negado.replace('.',',');


    this.operandoActualPantalla = this.operandoActual;
  }

  borrar() {
    this.operandoActual = this.operandoActualPantalla.toString().slice(0, -1);
    this.operandoActualPantalla = this.operandoActual;
    console.log(this.operandoActualPantalla)
    if (this.operandoActualPantalla === '' || this.operandoActualPantalla === '+' || this.operandoActualPantalla === '-' || this.operandoActualPantalla ===  '*' ||this.operandoActualPantalla ===  '÷') {
      this.operandoActual = '0';
      this.operandoActualPantalla = '0';
    }
  }

  anadirNumero(numero: number) {
    if (
      numero.toString() === ',' &&
      this.operandoActual.toString().includes(',')
    ) {
      return;
    }
    if (this.operandoActual === '0') {
      this.operandoActual = numero.toString();
    } else {
      this.operandoActual = this.operandoActual.toString() + numero.toString();
    }
    this.operandoActualPantalla = this.operandoActual;
  }

  anadirComa() {
    if (!this.operandoActual.toString().includes(','))
      this.operandoActual = this.operandoActual + ',';
    this.operandoActualPantalla = this.operandoActual;
  }

  elijeOperacion(operacion: string) {
    if (this.operandoActual.toString() === '') return;
    if (this.operandoAnterior.toString() !== '') {
      this.operandoActual = this.operandoActualPantalla;
      this.calcula();
    }
    this.operacion = operacion;
    this.operandoAnterior = this.operandoActual;
    this.operandoActual = '0';
  }

  calcula() {
    let calculo: number;
    let actual;
    if (this.operandoActual.toString().includes(',')) {
      actual = parseFloat(this.operandoActual.toString().replace(',', '.'));
    } else {
      actual = parseFloat(this.operandoActual.toString().replace(',', '.'));
    }
    const anterior = parseFloat(
      this.operandoAnterior.toString().replace(',', '.')
    );
    if (isNaN(anterior) || isNaN(actual)) return;
    switch (this.operacion) {
      case '+':
        calculo = anterior + actual;
        break;
      case '-':
        calculo = anterior - actual;
        break;
      case '*':
        calculo = anterior * actual;
        break;
      case '÷':
        calculo = anterior / actual;
        break;
      default:
        return;
    }
    this.operandoActual = calculo.toString();
    this.operandoActual = this.operandoActual.replace('.', ',');
    this.operacion = '';
    this.operandoAnterior = '0';
    this.operandoActualPantalla = this.operandoActual;
  }

  ngOnInit(): void {}
}
